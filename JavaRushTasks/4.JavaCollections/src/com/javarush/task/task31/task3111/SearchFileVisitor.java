package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> foundFiles = new ArrayList<>();
    private String partOfName;
    private String partOfContent;
    private int minSize = 0;
    private int maxSize = 0;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*" + partOfName + "*");
        FileVisitResult fileVisitResult = super.visitFile(file, attrs);
        if (minSize > 0)
            if (content.length < minSize)
                return fileVisitResult;
        if (maxSize > 0)
            if (content.length > maxSize)
                return fileVisitResult;
        if (partOfName != null)
            if (!matcher.matches(file.getFileName()))
                return fileVisitResult;
        if (partOfContent != null)
            if (!new String(content, StandardCharsets.UTF_8).contains(partOfContent))
                return fileVisitResult;

        foundFiles.add(file);
        return fileVisitResult;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
