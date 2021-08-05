package com.botscrew.university.command;

import com.botscrew.university.entity.Lector;
import com.botscrew.university.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class SearchByTemplateCommand implements ConsoleCommand {

    private static final String NAME = "5";

    private final LectorService lectorService;

    @Autowired
    public SearchByTemplateCommand(LectorService lectorService) {
        this.lectorService = lectorService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter template: ");
        String template = scanner.next();

        List<String> lectorsNames = lectorService.searchByTemplate(template)
                .stream()
                .map(Lector::getLectorFullName)
                .collect(Collectors.toList());

        String result = String.format(
                "Global search by %s\n",
                template
        );

        result = result + String.join(", ", lectorsNames);

        System.out.println(result);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
