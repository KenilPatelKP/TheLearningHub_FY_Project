package com.theelearninghub.managers;


import com.theelearninghub.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {}
