package com.theelearninghub.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PopularCourse {
    String title;
    String description;
    Integer idcourse;
    String imageData;
}
