package com.botscrew.university.command;

import com.botscrew.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ShowCountOfEmployeeCommand implements ConsoleCommand {

    private static final String NAME = "4";

    private final DepartmentService departmentService;

    @Autowired
    public ShowCountOfEmployeeCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter department name: ");
        String departmentName = scanner.next();

        System.out.println("Count of employees: " +
                departmentService.getCountOfEmployee(departmentName));
    }

    @Override
    public String getName() {
        return NAME;
    }
}
