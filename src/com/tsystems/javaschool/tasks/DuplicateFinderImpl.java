package com.tsystems.javaschool.tasks;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Mikhail Nemenko on 16.05.2015.
 */
public class DuplicateFinderImpl implements DuplicateFinder {
    public DuplicateFinderImpl() {
    }

    @Override
    public boolean process(File sourceFile, File targetFile) {
        Map<String, Integer> map = new TreeMap<>(); //использовал TreeMap, так как он автоматом сортирует по ключу + позволяет хранить только уникальные значения ключа
        String line = null; //временная переменная для хранения строк из файла sourceFile
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile)); //использую try-with-resources для автозакрытия потоков
             FileWriter fw = new FileWriter(targetFile, true)) { //создаю 2 потока, на чтение и на запись с возможность дописывать файл
            if (!sourceFile.exists())
                throw new FileNotFoundException(); //проверяю существование файла sourceFile, если его нету выбрасываю FileNotFoundException и возвращаю false
            if (!targetFile.exists())
                targetFile.createNewFile(); //проверяю существование файла targetFile, если его нету создаю новый

            while ((line = br.readLine()) != null) { //считываем построчно данные из sourceFile
                if (!map.containsKey(line)) { //проверяем не содержит ли мапка ключ со значением строки
                    map.put(line, 1); //так как данного ключа нет ложим в мапу и ставим value 1
                } else {
                    map.replace(line, map.get(line).intValue() + 1); // иначе берем нашу мапку с текущим ключом и инкрементируем value
                }
            }
            for (Map.Entry<String, Integer> lines : map.entrySet()) { //бежим по мапе и пишем в файл
                fw.write(lines.getKey() + "[" + lines.getValue() + "]\n");
            }
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Файла a.txt не существует!, проверьте директорию папки interfaces!");
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}
