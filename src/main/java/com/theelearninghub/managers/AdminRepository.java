package com.theelearninghub.managers;

import com.theelearninghub.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public  interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Admin getByEmail(String email);
}
