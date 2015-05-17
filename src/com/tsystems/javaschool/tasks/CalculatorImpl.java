package com.tsystems.javaschool.tasks;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Mokhail Nemenko on 16.05.2015.
 */
public class CalculatorImpl implements Calculator {
    /*В данной задаче применил алгоритм Обратной польской записи*/
    @Override
    public String evaluate(String statement) {
        try {
            LinkedList<Integer> st = new LinkedList<>(); // храним цифры
            LinkedList<Character> op = new LinkedList<Character>(); // замена стека храним операторы и цифры в порядке поступления
            for (int i = 0; i < statement.length(); i++) { // парсим строку с выражением и вычисляем
                char c = statement.charAt(i);
                if (isDelim(c))
                    continue;
                if (c == '(')
                    op.add('(');
                else if (c == ')') {
                    while (op.getLast() != '(')
                        processOperator(st, op.removeLast());
                    op.removeLast();
                } else if (isOperator(c)) {
                    while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                        processOperator(st, op.removeLast());
                    op.add(c);
                } else {
                    String operand = "";
                    while (i < statement.length() && Character.isDigit(statement.charAt(i)))
                        operand += statement.charAt(i++);
                    --i;
                    st.add(Integer.parseInt(operand));
                }
            }
            while (!op.isEmpty())
                processOperator(st, op.removeLast());
            return st.get(0).toString();  // возвращаем полученный результат
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    static boolean isDelim(char c) { // возвращаем true если пробел
        return c == ' ';
    }

    static boolean isOperator(char c) { // возвращяем true если символ присутствует
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    static int priority(char op) {
        switch (op) { // расставляем приоритет операций, при + или - возврат 1, при * / % 2 иначе -1
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }

    static void processOperator(LinkedList<Integer> st, char operation) {
        int first = st.removeLast(); // забираем 2 последних эллемента из листа и выполняем над ними операцию в зависимости от кейса
        int second = st.removeLast();
        switch (operation) {
            case '+':
                st.add(second + first);
                break;
            case '-':
                st.add(second - first);
                break;
            case '*':
                st.add(second * first);
                break;
            case '/':
                st.add(second / first);
                break;
            case '%':
                st.add(second % first);
                break;
        }
    }
}
