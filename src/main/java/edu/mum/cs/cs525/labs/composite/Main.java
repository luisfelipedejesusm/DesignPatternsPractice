package edu.mum.cs.cs525.labs.composite;

public class Main {
    public static void main(String[] args) {
        AbstractFile cDrive = FileUtil.createNewDrive("C:");

        AbstractFile appDir = FileUtil.createNewDirectory("applications");
        AbstractFile dataDir = FileUtil.createNewDirectory("my data");
        AbstractFile courseDir = FileUtil.createNewDirectory("cs525");

        AbstractFile excelFile = FileUtil.createNewFile("ms_excel.exe", 2353256);
        AbstractFile wordFile = FileUtil.createNewFile("ms_word.exe", 3363858);
        AbstractFile studentsFile = FileUtil.createNewFile("students.doc", 34252);

        AbstractFile dataDirShortcut = FileUtil.createShortcut(dataDir);
        AbstractFile wordFileShortcut = FileUtil.createShortcut(wordFile);

        cDrive.addFileOrFolder(appDir);
        cDrive.addFileOrFolder(dataDir);
        dataDir.addFileOrFolder(courseDir);
        appDir.addFileOrFolder(excelFile);
        appDir.addFileOrFolder(wordFile);
        courseDir.addFileOrFolder(studentsFile);

        courseDir.addFileOrFolder(dataDirShortcut);
        dataDirShortcut.addFileOrFolder(wordFileShortcut);

        cDrive.print();

    }
}
