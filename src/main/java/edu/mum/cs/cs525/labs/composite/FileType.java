package edu.mum.cs.cs525.labs.composite;

public enum FileType {
    FILE("File"),
    DIRECTORY("Directory"),
    LINK("Link");

    private final String name;

    FileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
