package item.impl;

import item.ItemSearch;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;

public class ItemText implements ItemSearch {

    private final String allowedExtension = "txt";

    public HashSet<String> getValue(File file) {
        return readFile(file);
    }

    private HashSet<String> readFile(File file){
        if(isValidFile(file)){
            return getText(file);
        }
        return new HashSet<>();
    }

    private HashSet<String> getText(File file) {
        HashSet<String> texts = new HashSet<>();
        try {
            List<String> fileLines = Files.readAllLines(file.toPath());
            fileLines.parallelStream().forEach(texts::add);
        } catch (IOException e) {
            System.out.println("Error to read file: "+file.getPath());
            e.printStackTrace();
        }
        return texts;
    }

    private boolean isValidFile(File file){
        String fileExtension = FilenameUtils.getExtension(file.getName());
        return allowedExtension.equalsIgnoreCase(fileExtension);
    }
}
