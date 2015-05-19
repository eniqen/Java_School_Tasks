package com.tsystems.javaschool.tasks;

import java.util.*;

/**
 * Created by Mikhail Nemenko on 16.05.2015.
 */
public class SubsequenceImpl implements Subsequence {
    public SubsequenceImpl() {
    }

    @Override
    public boolean find(List x, List y) {
        int count = 0; //переменная проверяющая совпадает ли кол-во найденых элементов с кол-вом из 1 списка
        int marker = 0; //маркер от начала которого будем бегать если нашли какой-то эллемент в списке
        for (int i = 0; i < x.size(); i++) { //луп с первым листом
            if (count < i) { //проверяем стоит ли искать следующий эллемент если предыдущий не найден
                break;
            } else {
                for (int j = marker; j < y.size(); j++) { //с листом в котором проверяем последовательность эллементов
                    if (x.get(i).equals(y.get(j))) { //если эллементы совпадают инкрементим каунт и ставим маркер с данного места
                        count++;
                        marker = j++;
                        break;
                    }
                }
            }
        }
        return x.size() == count ? true : false; //тернарный оператор возвратит тру если кол-во найденых эллементов совпадет с кол-вом элементов в списке
    }
}
