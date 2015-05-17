package com.tsystems.javaschool.tasks;

import java.io.File;

public class TestMain {
    public static void main(String[] args) {
        /*Task Calculator*/
        Calculator c = new CalculatorImpl();
        System.out.println(c.evaluate("(1+38)*4-5")); // Результат: 151
        c = new CalculatorImpl();
        System.out.println(c.evaluate("7*6/2+8")); // Результат: 29
        c = new CalculatorImpl();
        System.out.println(c.evaluate("-12)1//(")); // Результат: null

        /*Task 2. DuplicateFinder*/
        DuplicateFinder d = new DuplicateFinderImpl();
        d.process(new File("C:/Users/1/Desktop/interfaces/src/com/tsystems/javaschool/tasks/a.txt"), new File("C:/Users/1/Desktop/interfaces/src/com/tsystems/javaschool/tasks/b.txt"));
    }
}
