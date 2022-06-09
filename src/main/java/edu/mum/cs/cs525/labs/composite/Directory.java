package edu.mum.cs.cs525.labs.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static edu.mum.cs.cs525.labs.composite.FileType.DIRECTORY;

public class Directory extends AbstractFile {

    private final List<AbstractFile> files = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void addFileOrFolder(AbstractFile file){
        files.add(file);
    }

    @Override
    public List<AbstractFile> getFiles() {
        return Collections.unmodifiableList(files);
    }

    @Override
    public long getSizeInBytes() {
        return getFiles().stream().mapToLong(AbstractFile::getSizeInBytes).sum();
    }

    @Override
    protected long print(String parentURI) {
        String currFileName = FileUtil.formatURI(parentURI, getName() + "/");
        long size = getFiles().stream().mapToLong(file -> file.print(currFileName)).sum();
        FileUtil.printToConsole(currFileName, DIRECTORY, size);

        return size;
    }
}
