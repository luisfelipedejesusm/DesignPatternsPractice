package edu.mum.cs.cs525.labs.composite;

import java.util.List;

import static edu.mum.cs.cs525.labs.composite.FileType.LINK;

public class Link extends AbstractFile {
    private final AbstractFile referencedFile;

    public Link(AbstractFile referencedFile) {
        super(referencedFile.getName() + "_shortcut");
        this.referencedFile = referencedFile;
    }

    @Override
    long getSizeInBytes() {
        return 0;
    }

    @Override
    protected long print(String parentURI) {
        String currFileName = FileUtil.formatURI(parentURI, getName());
        FileUtil.printToConsole(currFileName, LINK, getSizeInBytes());
        return getSizeInBytes();
    }

    @Override
    public void addFileOrFolder(AbstractFile file) {
        referencedFile.addFileOrFolder(file);
    }

    @Override
    public List<AbstractFile> getFiles() {
        return referencedFile.getFiles();
    }
}
