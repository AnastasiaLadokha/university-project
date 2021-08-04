package com.botscrew.university.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticDto {

    private Long assistantsCount;
    private Long associateProfessorsCount;
    private Long professorsCount;
}
