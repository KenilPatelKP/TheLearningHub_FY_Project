package com.theelearninghub.initializers;

import com.theelearninghub.managers.AdminRepository;
import com.theelearninghub.managers.RoomRepository;
import com.theelearninghub.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//@Service
//@DependsOn({"adminInitializer"})
public class RoomInitializer {

    @Autowired
    public RoomInitializer(RoomRepository roomRepository, AdminRepository adminRepository) throws IOException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("static/images/courseDefault.jpg").getFile());
        byte[] photoBinary = Files.readAllBytes(Paths.get(file.toURI()));

        Stream.of(Room.builder().title("Room1")
                        .admin(adminRepository.getOne(1))
                        .description("Description1")
                        .photoBinary(photoBinary)
                        .isPrivate(false)
                        .build(),
                Room.builder().title("Room2")
                        .admin(adminRepository.getOne(1))
                        .description("Description2")
                        .photoBinary(photoBinary)
                        .isPrivate(false)
                        .build(),
                Room.builder().title("Room3")
                        .admin(adminRepository.getOne(1))
                        .description("Description1")
                        .photoBinary(photoBinary)
                        .isPrivate(false)
                        .build(),
                Room.builder().title("Room4")
                        .admin(adminRepository.getOne(1))
                        .description("Description1")
                        .photoBinary(photoBinary)
                        .isPrivate(false)
                        .build()
        ).forEach(room -> roomRepository.save(room));
    }
}
