package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile){
        Path fileName = null;
        try {
            fileName = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(fileName),
                    Files.isExecutable(fileName),
                    Files.isDirectory(fileName),
                    Files.isWritable(fileName));
        } catch (Exception e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
