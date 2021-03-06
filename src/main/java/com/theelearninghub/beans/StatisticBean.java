package com.theelearninghub.beans;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticBean {

    private int nrOfEnrolled;
    private int nrOfWished;
    private float earned;
    private int nrOfMessages;
    private String popularAmongEnrolled;
}
