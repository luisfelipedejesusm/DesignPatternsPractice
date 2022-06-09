package edu.mum.cs.cs525.labs.composite;

import java.util.List;

import static edu.mum.cs.cs525.labs.composite.FileType.*;

public class File extends AbstractFile {

    private final long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public long getSizeInBytes() {
        return size;
    }

    @Override
    protected long print(String parentURI) {
        String currFileName = FileUtil.formatURI(parentURI, getName());
        FileUtil.printToConsole(currFileName, FILE, getSizeInBytes());
        return getSizeInBytes();
    }

    // ------------------- If Programming to Interfaces we need to do this --------------------- //

    @Override
    public List<AbstractFile> getFiles() {
        throw new UnsupportedOperationException("A file does not have files");
    }

    @Override
    public void addFileOrFolder(AbstractFile file) {
        throw new UnsupportedOperationException("You can't add a file to a file");
    }
}
