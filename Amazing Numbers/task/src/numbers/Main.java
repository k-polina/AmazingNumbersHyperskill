package numbers;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    private static final Integer BUZZ_NUMBER = 7;
    private static final Integer DUCK_NUMBER = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int number = scanner.nextInt();

        if (number > 0) {
            LinkedHashMap<String, Boolean> properties = new LinkedHashMap<>();
            setProperties(number, properties);
            printResult(properties);
        } else {
            System.out.println("This number is not natural!");
        }
    }

    private static void setProperties(Integer number, LinkedHashMap<String, Boolean> properties) {
        properties.put("even", isEven(number));
        properties.put("odd", !isEven(number));
        properties.put("buzz", isBuzz(number));
        properties.put("duck", isDuck(number));
    }

    private static void printResult(LinkedHashMap<String, Boolean> properties) {
        System.out.println("Properties of 15");
        for (String key: properties.keySet()) {
            System.out.printf("%s: %s\n", key, properties.get(key));
        }
    }

    private static Boolean isDuck(Integer number) {
        return number.toString().contains(DUCK_NUMBER.toString());
    }

    private static Boolean isBuzz(Integer number) {
        return number % BUZZ_NUMBER == 0 || number % 10 == BUZZ_NUMBER;
    }

    private static Boolean isEven(Integer number) {
        return number % 2 == 0;
    }
}
