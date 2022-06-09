package edu.mum.cs.cs525.labs.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractFile {

    private final String name;

    public AbstractFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void addFileOrFolder(AbstractFile file);
    public abstract List<AbstractFile> getFiles();
    abstract long getSizeInBytes();
    abstract long print(String parentURI);

    public void print(){
        print("");
    }
}
