package com.theelearninghub.managers;


import com.theelearninghub.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByTitleContainingAndIsPrivateFalse(String title);

    List<Room> findByIsPrivateFalse();
}
