package com.example.not_web.input;

import java.util.Scanner;

/** Класс, для пользовательского ввода. */
public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Запрос у пользователя ввода строки.
     *
     * @param question Запрос, отображаемый пользователю.
     * @return Введенные пользователем данные в виде строки. */
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Запрос у пользователя ввода целочисленного значения.
     * В данном методе обрабатывается ошибка ввода неверных символов(всех кроме цифр).
     *
     * @param question Запрос, отображаемый пользователю.
     * @return Введенные пользователем данные в виде целого числа. */
    public int askInt(String question) {
        while (true) {
            try {
                return Integer.parseInt(askStr(question));
            } catch (NumberFormatException e) {
                System.out.println("Введите цифры.");
            }
        }
    }

    /**
     * Запрос у пользователя выбрать один из двух символов.
     * Данный метод обрабатывает ошибку введения неверного символа.
     *
     * @param firstSymb Первый символ на выбор.
     * @param secondSymb Второй символ на выбор.
     * @param question Запрос, отображаемый пользователю.
     * @return Выбор пользователя в виде строки. */
    public String askTwoSymb(String firstSymb, String secondSymb, String question) {
        while (true) {
           String res = askStr(question);
            if (res.equalsIgnoreCase(firstSymb) || res.equalsIgnoreCase(secondSymb)) {
                return res;
            } else {
                System.out.println("Введите один из двух верных символов.");
            }
        }
    }
}



