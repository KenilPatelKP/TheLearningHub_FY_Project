package com.theelearninghub.controllers;

import com.theelearninghub.beans.StatisticBean;
import com.theelearninghub.managers.AdminRepository;
import com.theelearninghub.managers.UserRepository;
import com.theelearninghub.model.Course;
import com.theelearninghub.model.Material;
import com.theelearninghub.model.User;
import com.theelearninghub.security.CurrentUser;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CourseController courseController;
    @Autowired
    private MainController mainController;

    @RequestMapping("/profile")
    public String profilePage(Model model) {
        User existingUser = getCurrentUser();
        String base64 =existingUser.getPhotoBinary()==null?"":
                "data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(existingUser.getPhotoBinary());
        List<Course> suggestedCourses = courseController.getSuggestedCourses(existingUser.getIduser());

        List<AbstractMap.SimpleEntry> suggested = new ArrayList<>();
        for(Course course : suggestedCourses){
            String base64Course =course.getPhotoBinary() ==null ? "":"data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(course.getPhotoBinary());
            suggested.add(new AbstractMap.SimpleEntry(course, base64Course));
        }
        model.addAttribute("currentPhoto", base64);
        model.addAttribute("suggested", suggested);
        return "profilePage";
    }
    @RequestMapping(value = "/loginredirect", method = RequestMethod.GET)
    public String showLoginPage(Model model){
        return "loginPage";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RedirectView createUser(@NonNull User user, Model model){
        try {
            if(user.getEmail().equals(adminRepository.getOne(1).getEmail())){
                throw new Exception();
            }
            ClassLoader classLoader = getClass().getClassLoader();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            user.setAdmin(adminRepository.getOne(1));
            user.setPhotoBinary(null);
            user.setPhoneNumber(0);
            User savedUser = userRepository.save(user);
            setAuthUser(savedUser);
            model.addAttribute("emailInUse", true);
            RedirectView rv = new RedirectView();
//            rv.setContextRelative(true);
            rv.setUrl("/login");
            return rv;
//            return mainController.loggingPage("",model);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("emailInUse", true);
            model.addAttribute("previousUser", user);
            RedirectView rv = new RedirectView();
            rv.setContextRelative(true);
            rv.setUrl("/signUpPage");
            return rv;
        }
//        return mainController.home(model);
    }

    @RequestMapping("/loginPage")
    public String redirectTologinPage(Model model){
        return "loginPage";
    }
    @RequestMapping("/edit")
    public String editProfile(User user, MultipartFile photo, Model model){
        User existingUser = getCurrentUser();
        try {
            if(userRepository.getByEmail(user.getEmail())!=null){
                throw new Exception();
            }
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setDescription(user.getDescription());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setNickName(user.getNickName());
            if(photo != null && photo.getSize()>0)
                existingUser.setPhotoBinary(photo.getBytes());

            existingUser = userRepository.save(existingUser);
        }catch (Exception e) {
            model.addAttribute("emailInUse", true);
            return profilePage(model);
        }
        setAuthUser(existingUser);
        return profilePage(model);
    }


    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try{

            CurrentUser currentUser = (CurrentUser)authentication.getPrincipal();
            return userRepository.getByIduser(currentUser.getId());
        }catch (Exception e){
            e.printStackTrace();
            return new User();
        }
    }

    public void setAuthUser(User user){
        UserDetails userDetails = new CurrentUser(user.getEmail(), user.getPassword(),
                user.getFirstName(), user.getLastName(), user.getNickName(),
                user.getDescription(), user.getPhoneNumber(), user.getIduser());
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
