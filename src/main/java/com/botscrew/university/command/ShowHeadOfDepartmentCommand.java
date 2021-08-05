package com.botscrew.university.command;

import com.botscrew.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ShowHeadOfDepartmentCommand implements ConsoleCommand {

    private static final String NAME = "1";

    private final DepartmentService departmentService;

    @Autowired
    public ShowHeadOfDepartmentCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter department name: ");
        String departmentName = scanner.next();
        String headOfDepartment = departmentService.getHeadOfDepartmentName(departmentName);
        System.out.println("Head of " + departmentName + " department is " + headOfDepartment);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
