package com.theelearninghub.controllers;

import com.theelearninghub.beans.*;
import com.theelearninghub.temp.JmsMessage;
import com.theelearninghub.temp.JmsService;
import com.theelearninghub.managers.*;
import com.theelearninghub.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserController userController;
    @Autowired
    private RoomController roomController;

    private static int PAGE_SIZE=6;


    @RequestMapping("/wishlist")
    public String wishlistPage(Model model) {
        User currentUser = userController.getCurrentUser();
        List<AbstractMap.SimpleEntry> wishlist = new ArrayList<>();
        List<Course> wishlistList = currentUser.getWishes();
        for(Course course : wishlistList){
            String base64 = course.getPhotoBinary() ==null? "":"data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(course.getPhotoBinary());
            wishlist.add(new AbstractMap.SimpleEntry(course, base64));
        }
        model.addAttribute("wishlist", wishlist);
        return "wishlistPage";
    }

    @RequestMapping("/addToWishlist")
    public String addToWishlist(@RequestParam() int idCourse, Model model){
        User currentUser = userController.getCurrentUser();
        List<Course> wishlist = currentUser.getWishes();
        Course currentCourse = courseRepository.getOne(idCourse);
        if(!wishlist.contains(currentCourse)) {
            wishlist.add(currentCourse);
            currentUser.setWishes(wishlist);
            userController.setAuthUser(userRepository.save(currentUser));
        }
        return showCoursePage(idCourse, model);
    }

    @RequestMapping("/removeFromWishlist")
    public String removeFromWishlist(@RequestParam() int idCourse, Model model){
        User currentUser = userController.getCurrentUser();
        List<Course> wishlist = currentUser.getWishes();
        wishlist.remove(courseRepository.getOne(idCourse));
        currentUser.setWishes(wishlist);
        userController.setAuthUser(userRepository.save(currentUser));
        return showCoursePage(idCourse, model);
    }

    @RequestMapping(value="/advanceSearch", method = RequestMethod.GET)
    public String advanceSearch(@RequestParam(value = "page", required = false) String pageStr,
                                Model model, SearchBean sb) {

        String category = sb.getCategory();
        String level = sb.getLevel();
        List<AbstractMap.SimpleEntry> pairs = new ArrayList<>();
        List<AbstractMap.SimpleEntry> highlighted = new ArrayList<>();
        List<Course> highlightedCourses = courseRepository.findByHighlightedAndIsPrivateFalseAndValidatedTrue(true);
        int page = (pageStr==null || pageStr.equals(""))?0:Integer.parseInt(pageStr);

        if(!sb.isRoomChecked()) {
            if (StringUtils.isEmpty(sb.getCategory()) || sb.getCategory().equals("Any") || sb.getCategory()==null) {
                sb.setCategory("Any");
                category = "%";
            }
            if (StringUtils.isEmpty(sb.getLevel()) || sb.getLevel().equals("Any") || sb.getLevel()==null) {
                sb.setLevel("Any");
                level = "%";
            }
            List<Course> courses = courseRepository.findByCategoryLikeAndLevelLikeAndTitleContainingAndIsPrivateFalseAndValidatedTrue(category, level, sb.getPhrase());
            List<Course> pagedCourses = getPagedCourses(courses, page, model);

            for(Course course : pagedCourses){
                String base64 =

                        course.getPhotoBinary() ==null? "":"data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(course.getPhotoBinary());

                pairs.add(new AbstractMap.SimpleEntry(course, base64));
            }
        }else{
            List<Room> rooms = roomRepository.findByTitleContainingAndIsPrivateFalse(sb.getPhrase());
            List<Room> pagedRooms = getPagedRooms(rooms, page, model);

            for(Room room : pagedRooms) {
                String base64 = room.getPhotoBinary() ==null? "":"data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(room.getPhotoBinary());
                pairs.add(new AbstractMap.SimpleEntry(room, base64));
            }
        }

        for(Course highlightedCourse : highlightedCourses){
            String base64 = highlightedCourse.getPhotoBinary() ==null? "":"data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(highlightedCourse.getPhotoBinary());
            highlighted.add(new AbstractMap.SimpleEntry(highlightedCourse, base64));
        }


        model.addAttribute("page", page);
        model.addAttribute("searchBean", sb);
        model.addAttribute("pairs", pairs);
        model.addAttribute("highlighted", highlighted);
        return "searchPage";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showCoursePage(@PathVariable("id") int courseId, Model model){

        Course currentCourse = courseRepository.findById(courseId).orElseGet(null);
        User currentUser = userController.getCurrentUser();
        model.addAttribute("currentCourse", currentCourse);

        String base64 =

                currentCourse.getPhotoBinary() ==null? "":"data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(currentCourse.getPhotoBinary());
        model.addAttribute("currentPhoto", base64);
        List<Material> userMaterials = currentUser.getMaterials();
        model.addAttribute("userMaterials", userMaterials);

        if(currentUser.getAttends().contains(currentCourse)||currentUser.getCreatedCourses().contains(currentCourse)){
            StatisticBean sb = new StatisticBean();
            sb.setNrOfEnrolled(currentCourse.getIsAttendedBy()==null?0:currentCourse.getIsAttendedBy().size());
            sb.setEarned((float)(currentCourse.getPrice()*(currentCourse.getIsAttendedBy()==null?0:currentCourse.getIsAttendedBy().size())));
            sb.setNrOfWished(currentCourse.getIsWishedBy()==null?0:currentCourse.getIsWishedBy().size());
            sb.setPopularAmongEnrolled(courseRepository.getPopularCategoryAmongEnrolled(currentCourse.getIdcourse()));
            model.addAttribute("statistics", sb);
            return "coursePage";
        }

        String base64Teacher =currentCourse.getCreator().getPhotoBinary() ==null ? "":
                "data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(currentCourse.getCreator().getPhotoBinary());
        boolean inWishlist = currentUser.getWishes().contains(currentCourse);
        model.addAttribute("currentTeacher",currentCourse.getCreator());
        model.addAttribute("currentTeacherPhoto", base64Teacher);
        model.addAttribute("currentLessonId", 0);
        model.addAttribute("inWishlist", inWishlist);

        return "enrollCoursePage";
    }

    @RequestMapping("/create")
    public String createCourse(RoomCourseBean rcBean, Model model) throws IOException {
        User user = userRepository.getOne(rcBean.getCreatorId());

        Course course = Course.builder().admin(adminRepository.getOne(1))
                .title(rcBean.getTitle())
                .description(rcBean.getDescription())
                .level(rcBean.getLevel())
                .category(rcBean.getCategory())
                .syllabus(rcBean.getSyllabus())
                .price(rcBean.getPrice())
                .photoBinary(rcBean.getPhotoBinary())
                .creator(user)
                .validated(true)
                .isPrivate(rcBean.getIsPrivate())
                .build();
        courseRepository.save(course);

        return showCoursePage(course.getIdcourse(), model);
    }

    @RequestMapping("{id}/addLesson")
    public String addLesson(@PathVariable("id") int courseId, Model model, HttpServletResponse res) throws IOException {
        User currentUser = userController.getCurrentUser();
        Course currentCourse =  courseRepository.getOne(courseId);
        if(currentUser.getIduser() != currentCourse.getCreator().getIduser())
            res.sendError(401);

        Lesson newLesson = Lesson.builder().title("Example title")
                .course(currentCourse)
                .number(currentCourse.getLessons().size()+1)
                .build();
        lessonRepository.save(newLesson);

        currentCourse.getLessons().add(newLesson);
        courseRepository.save(currentCourse);
        List<Material> userMaterials = currentUser.getMaterials();
        model.addAttribute("userMaterials", userMaterials);
        return showCoursePage(courseId, model);
    }

    @RequestMapping("{id}/enroll")
    public String enrollStudent(@PathVariable("id") int courseId, Model model){
        User currentUser = userController.getCurrentUser();
        Course currentCourse = courseRepository.getOne(courseId);
        currentUser.getAttends().add(currentCourse);
        currentUser.getWishes().remove(currentCourse);
        userController.setAuthUser(userRepository.save(currentUser));

        return showCoursePage(courseId, model);
    }

    @RequestMapping(value = "/{id}/chatRoom", method = RequestMethod.GET)
    public String chatRoom(@PathVariable("id") int courseId, Model model){
        Course currentCourse = courseRepository.getOne(courseId);
        User currentUser = userController.getCurrentUser();
        model.addAttribute("currentCourse", currentCourse);
        String base64 =currentCourse.getPhotoBinary() ==null ? "":
                "data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(currentCourse.getPhotoBinary());
        model.addAttribute("currentPhoto", base64);

        if(currentUser.getAttends().contains(currentCourse)||currentUser.getCreatedCourses().contains(currentCourse)){
            JmsService jmsService = new JmsService();
            List<JmsMessage> chat = jmsService.receiveAllFrom(String.valueOf(currentCourse.getIdcourse()));
            model.addAttribute("chat", chat);
            model.addAttribute("principalId", currentUser.getIduser());
            return "courseChatPage";
        }

        String base64Teacher =currentCourse.getCreator().getPhotoBinary() ==null ? "":
                "data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(currentCourse.getCreator().getPhotoBinary());
        model.addAttribute("currentTeacher",currentCourse.getCreator());
        model.addAttribute("currentTeacherPhoto", base64Teacher);

        return "enrollCoursePage";
    }

    @RequestMapping(value = "/{id}/chatRoom", method = RequestMethod.POST)
    public String chatRoomMsgPost(@PathVariable("id") int courseId, String message, Model model){
        User currentUser = userController.getCurrentUser();

        JmsService jmsService = new JmsService();
        JmsMessage jmsMessage = JmsMessage.builder()
                    .iduser(currentUser.getIduser())
                    .author(currentUser.getFirstName()+" "+currentUser.getLastName())
                    .message(message)
                    .build();
        jmsService.sendTo(String.valueOf(courseId),jmsMessage);

        return chatRoom(courseId,model);
    }

    @RequestMapping("/addMaterial")
    public String addMaterial(int lessonId, MaterialBean mBean, String type, Model model,
                              HttpServletResponse res, String path, String title) throws IOException {
        User currentUser = userController.getCurrentUser();
        Lesson currentLesson = lessonRepository.getOne(lessonId);
        if(currentUser.getIduser() != currentLesson.getCourse().getCreator().getIduser())
            res.sendError(401);

        Material newMaterial = Material.builder().title(title)
                .description(mBean.getDescription())
                .path(path)
                .type(type)
                .creator(currentUser)
                .build();
        newMaterial = materialRepository.save(newMaterial);

        currentLesson.getMaterials().add(newMaterial);
        lessonRepository.save(currentLesson);
        currentUser.getMaterials().add(newMaterial);
        userController.setAuthUser(userRepository.save(currentUser));

        List<Material> userMaterials = currentUser.getMaterials();
        model.addAttribute("userMaterials", userMaterials);
        return showCoursePage(currentLesson.getCourse().getIdcourse(), model);
    }

    @RequestMapping("{idlesson}/{idmaterial}/removeMaterial")
    public String removeMaterial(@PathVariable("idlesson") int lessonId,@PathVariable("idmaterial") int materialId, Model model){
        Lesson currentLesson = lessonRepository.getOne(lessonId);
        Material material = materialRepository.getOne(materialId);
        User currentUser = userController.getCurrentUser();
        currentLesson.getMaterials().remove(material);
        lessonRepository.save(currentLesson);

        List<Material> userMaterials = currentUser.getMaterials();
        model.addAttribute("userMaterials", userMaterials);
        return showCoursePage(currentLesson.getCourse().getIdcourse(), model);
    }

    @RequestMapping("{idlesson}/{idmaterial}/addExistingMaterial")
    public String addExistingMaterial(@PathVariable("idlesson") int lessonId,@PathVariable("idmaterial") int materialId,
                                      Model model, HttpServletResponse res) throws IOException{
        User currentUser = userController.getCurrentUser();
        Lesson currentLesson = lessonRepository.getOne(lessonId);
        if(currentUser.getIduser() != currentLesson.getCourse().getCreator().getIduser())
            res.sendError(401);

        Material material = materialRepository.getOne(materialId);

        currentLesson.getMaterials().add(material);
        lessonRepository.save(currentLesson);

        List<Material> userMaterials = currentUser.getMaterials();
        model.addAttribute("userMaterials", userMaterials);
        return showCoursePage(currentLesson.getCourse().getIdcourse(), model);
    }

    @RequestMapping("{idcourse}/{idlesson}/deleteLesson")
    public String deleteLesson(@PathVariable("idcourse") int idcourse, @PathVariable("idlesson") int lessonId,
                                      Model model, HttpServletResponse res) throws IOException{
        User currentUser = userController.getCurrentUser();
        Course currentCourse =  courseRepository.getOne(idcourse);
        if(currentUser.getIduser() != currentCourse.getCreator().getIduser())
            res.sendError(401);
        Lesson currentLesson = lessonRepository.getOne(lessonId);

        int i = currentCourse.getLessons().indexOf(currentLesson);
        currentCourse.getLessons().remove(currentLesson);
        for(; i<currentCourse.getLessons().size();i++ ) {
            currentCourse.getLessons().get(i).setNumber(currentCourse.getLessons().get(i).getNumber()-1);
            lessonRepository.save(currentCourse.getLessons().get(i));
        }
        courseRepository.save(currentCourse);
        lessonRepository.delete(currentLesson);

        List<Material> userMaterials = currentUser.getMaterials();
        model.addAttribute("userMaterials", userMaterials);
        return showCoursePage(idcourse, model);
    }

    @RequestMapping("{idcourse}/updateDetails")
    public String updatedDetails(@PathVariable int idcourse, String title, String description, Model model){
        Course currentCourse = courseRepository.getOne(idcourse);
        currentCourse.setTitle(title);
        currentCourse.setDescription(description);
        courseRepository.save(currentCourse);
        return showCoursePage(idcourse, model);
    }

    @RequestMapping("{idcourse}/updatePhoto")
    public String updatedDetails(@PathVariable int idcourse, MultipartFile photoBinary, Model model) throws IOException {
        Course currentCourse = courseRepository.getOne(idcourse);
        currentCourse.setPhotoBinary(photoBinary.getBytes());
        courseRepository.save(currentCourse);
        return showCoursePage(idcourse, model);
    }

    @RequestMapping("myCourses")
    public String myCoursePage(Model model){
        User user = userController.getCurrentUser();
        model.addAttribute("attendedCourses", user.getAttends());
        model.addAttribute("createdCourses", user.getCreatedCourses());
        return "myCoursesPage";
    }

    @RequestMapping("{idcourse}/updateLesson")
    public String updateLessonsTitle(@PathVariable("idcourse") int idcourse, int idlesson, String title, Model model){

        Lesson lesson = lessonRepository.getOne(idlesson);
        lesson.setTitle(title);
        lessonRepository.save(lesson);
        return showCoursePage(idcourse, model);
    }

    private List<Course> getPagedCourses(List<Course> allCourses, int page, Model model){
        int from = (page)*PAGE_SIZE;
        int to = (page+1)*PAGE_SIZE;
        model.addAttribute("endOfList", false);

        if (to>=allCourses.size()){
            to=allCourses.size();
            model.addAttribute("endOfList", true);
        }
        return allCourses.subList(from, to);
    }

    private List<Room> getPagedRooms(List<Room> allRooms, int page, Model model){
        int from = (page)*PAGE_SIZE;
        int to = (page+1)*PAGE_SIZE;
        model.addAttribute("endOfList", false);

        if (to>=allRooms.size()){
            to=allRooms.size();
            model.addAttribute("endOfList", true);
        }
        return allRooms.subList(from, to);
    }

    public List<Course> getPopularCourses(int userId){
        return courseRepository.findPopularCourses(userId);
    }
    public List<Course> getSuggestedCourses(int userId){
        String category = courseRepository.findMostFrequentCategory(userId);
        if(category == null || category.isEmpty()){
            category = "*";
        }
       List<Course> suggested = courseRepository.findSugestedCourses(userId, category);
        if(suggested.size() < 1){
            suggested = courseRepository.findPopularCourses(userId);
        }
        return suggested;
    }
    @RequestMapping("adminPage")
    public String showAdminPage(Model model){
        model.addAttribute("isAdmin", true);
        model.addAttribute("courses", courseRepository.findAll());
        return "adminPage";
    }
    @RequestMapping("/setValidated")
    public String setPrivacy(@RequestParam() int idCourse,@RequestParam() String isValidated, Model model){
        Course currentCourse = courseRepository.getOne(idCourse);
        String s = "true";
        currentCourse.setValidated(s.equals(isValidated));
        courseRepository.save(currentCourse);
        return showAdminPage(model);
    }
    @RequestMapping("/setHighlighted")
    public String setHighlighted(@RequestParam() int idCourse,@RequestParam() String isHighlighted, Model model){
        Course currentCourse = courseRepository.getOne(idCourse);
        String s = "true";
        currentCourse.setHighlighted(s.equals(isHighlighted));
        courseRepository.save(currentCourse);
        return showAdminPage(model);
    }

}
