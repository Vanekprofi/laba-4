package ru.shul.utils;

import java.util.Scanner;

public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Пожалуйста, введите целое число.");
            }
        }
    }

    public static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Ошибка! Число должно быть от " + min + " до " + max);
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Пожалуйста, введите число.");
            }
        }
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static String readNonEmptyString(String prompt) {
        while (true) {
            String input = readString(prompt);
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Ошибка! Ввод не может быть пустым.");
        }
    }

    public static boolean readBoolean(String prompt) {
        while (true) {
            String input = readString(prompt + " (да/нет): ").toLowerCase();
            if (input.equals("да") || input.equals("д") || input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("нет") || input.equals("н") || input.equals("no") || input.equals("n")) {
                return false;
            }
            System.out.println("Ошибка! Пожалуйста, введите 'да' или 'нет'.");
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}
