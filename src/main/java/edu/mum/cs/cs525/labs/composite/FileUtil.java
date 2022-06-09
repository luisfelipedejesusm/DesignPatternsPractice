package edu.mum.cs.cs525.labs.composite;

public class FileUtil {

    public static Directory createNewDirectory(String name){
        return new Directory(name);
    }

    public static Directory createNewDrive(String name){
        return createNewDirectory(name);
    }

    public static File createNewFile(String name, long size){
        return new File(name, size);
    }

    public static Link createShortcut(AbstractFile file){
        return new Link(file);
    }

    public static String formatURI(String parent, String filename){
        return parent + filename;
    }

    public static void printToConsole(String fileName, FileType fileType, long size){
        System.out.println(fileType.getName() + ": (" + fileName + ") size = " + size);
    }
}
