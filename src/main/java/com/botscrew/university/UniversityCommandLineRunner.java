package com.botscrew.university;

import com.botscrew.university.command.ConsoleCommand;
import com.botscrew.university.service.MenuPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class UniversityCommandLineRunner implements CommandLineRunner {

    private final Map<String, ConsoleCommand> nameToCommandMap;

    private final MenuPrinter menuPrinter;

    @Autowired
    public UniversityCommandLineRunner(List<ConsoleCommand> consoleCommands,
                                       MenuPrinter menuPrinter) {
        this.menuPrinter = menuPrinter;
        this.nameToCommandMap = new HashMap<>();
        consoleCommands.forEach(command -> this.nameToCommandMap.put(command.getName(), command));
    }

    @Override
    public void run(String... args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            menuPrinter.printMenu();
            String variant = scanner.next();
            nameToCommandMap.get(variant).execute();
        }
    }
}
