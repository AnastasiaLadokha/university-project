package com.botscrew.university.command;

import com.botscrew.university.domain.StatisticDto;
import com.botscrew.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ShowDepartmentStatisticsCommand implements ConsoleCommand {

    private static final String NAME = "2";

    private final DepartmentService departmentService;

    @Autowired
    public ShowDepartmentStatisticsCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter department name: ");
        String departmentName = scanner.next();

        StatisticDto statisticDto = departmentService.getStatistics(departmentName);

        String result = String.format("%s statistics.\n" +
                        "assistants - %s. \n" +
                        "associate professors - %s\n" +
                        "professors - %s\n",
                departmentName,
                statisticDto.getAssistantsCount(),
                statisticDto.getAssociateProfessorsCount(),
                statisticDto.getProfessorsCount()
        );
        System.out.println(result);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
