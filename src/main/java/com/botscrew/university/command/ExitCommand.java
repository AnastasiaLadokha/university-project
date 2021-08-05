package com.botscrew.university.command;

import org.springframework.stereotype.Component;

@Component
public class ExitCommand implements ConsoleCommand {

    private static final String NAME = "6";

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
