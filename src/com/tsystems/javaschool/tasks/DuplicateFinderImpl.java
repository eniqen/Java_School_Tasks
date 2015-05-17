package com.tsystems.javaschool.tasks;

import java.io.File;

/**
 * Created by root on 16.05.2015.
 */
public class DuplicateFinderImpl implements DuplicateFinder {

    @Override
    public boolean process(File sourceFile, File targetFile) {
        try{
            return  true;
        }catch (Exception ex){
            return false;
        }
    }
}
