package numbers;

import java.util.*;

public class Main {
    private static final Integer BUZZ_NUMBER = 7;
    private static final Integer DUCK_NUMBER = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long number = 1L;

        printGreeting();
        performCalculations(scanner, number);
        printExit();
    }

    private static void performCalculations(Scanner scanner, Long number) {
        while (number != 0) {
            number = getInputNumber(scanner);

            if (number > 0) {
                LinkedHashMap<String, Boolean> properties = new LinkedHashMap<>();
                setProperties(number, properties);
                printResult(properties);
            } else if (number < 0) {
                System.out.println("The first parameter should be a natural number or zero");
            }
        }
    }

    private static long getInputNumber(Scanner scanner) {
        long number;
        System.out.println("Enter a request: ");
        number = scanner.nextLong();
        return number;
    }

    private static void printExit() {
        System.out.println("Goodbye!");
    }

    private static void printGreeting() {
        System.out.println("""
                Welcome to Amazing Numbers!

                Supported requests:
                - enter a natural number to know its properties;
                - enter 0 to exit.""");
    }

    private static void setProperties(long number, LinkedHashMap<String, Boolean> properties) {
        properties.put("even", isEven(number));
        properties.put("odd", !isEven(number));
        properties.put("buzz", isBuzz(number));
        properties.put("duck", isDuck(number));
        properties.put("palindromic", isPalindromic(number));
    }

    private static void printResult(LinkedHashMap<String, Boolean> properties) {
        System.out.println("Properties of 15");
        for (String key: properties.keySet()) {
            System.out.printf("%s: %s\n", key, properties.get(key));
        }
    }

    private static Boolean isDuck(Long number) {
        return number.toString().contains(DUCK_NUMBER.toString());
    }

    private static Boolean isBuzz(Long number) {
        return number % BUZZ_NUMBER == 0 || number % 10 == BUZZ_NUMBER;
    }

    private static Boolean isEven(Long number) {
        return number % 2 == 0;
    }
    private static Boolean isPalindromic(Long number) {
        Long reversed = 0L;
        Long temp = number;
        while (temp > 0) {
            reversed *= 10;
            reversed += temp % 10;
            temp /= 10;
        }

        return reversed.equals(number);
    }
}
