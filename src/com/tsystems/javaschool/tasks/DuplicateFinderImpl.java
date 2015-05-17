package com.tsystems.javaschool.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by root on 16.05.2015.
 */
public class DuplicateFinderImpl implements DuplicateFinder {

    @Override
    public boolean process(File sourceFile, File targetFile) {
        Map<String, Integer> map = new TreeMap<>(); //использовал TreeMap, так как он автоматом сортирует по ключу + позволяет хранить только уникальные значения ключа
        String line = null; //временная переменная для хранения строк из файла sourceFile
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile)); //использую try-with-resources для автозакрытия потоков
             FileWriter fw = new FileWriter(targetFile, true)) { //создаю 2 потока, на чтение и на запись с возможность дописывать файл
            if (!targetFile.exists()) { //проверяю существование файла targetFile, если его нету создаю новый
                System.out.println("привет");
            }
            while ((line = br.readLine()) != null) { //считываем построчно данные из sourceFile
                if (!map.containsKey(line)) { //проверяем не содержит ли мапка ключ со значением строки
                    map.put(line, 1); //так как данного ключа нет ложим в мапу и ставим value 1
                } else {
                    map.replace(line, map.get(line).intValue() + 1); // иначе берем нашу мапку с текущим ключом и инкрементируем value
                }
            }
            for (Map.Entry<String, Integer> lines : map.entrySet()) { //бежим по мапе и пишем в файл
                fw.write("\n" + lines.getKey() + "[" + lines.getValue() + "]");
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
