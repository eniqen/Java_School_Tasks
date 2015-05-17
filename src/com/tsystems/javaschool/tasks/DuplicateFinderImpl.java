package com.tsystems.javaschool.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by root on 16.05.2015.
 */
public class DuplicateFinderImpl implements DuplicateFinder {

    @Override
    public boolean process(File sourceFile, File targetFile) {
        Map<String, Integer> map = new TreeMap<>();
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             FileWriter fw = new FileWriter(targetFile, true)) {
            if (!targetFile.exists()) {
                System.out.println("привет");
            }
            while ((line = br.readLine()) != null) {
                if (!map.containsKey(line)) {
                    map.put(line, 1);
                } else {
                    map.replace(line, map.get(line).intValue() + 1);
                }
            }
            for (Map.Entry<String, Integer> lines : map.entrySet()) {
                fw.write(lines.getKey() + "[" + lines.getValue() + "]\n");
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
