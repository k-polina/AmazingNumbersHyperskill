package numbers;

import java.util.Scanner;

public class Main {
    private static Integer BUZZ_NUMBER = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        Integer number = scanner.nextInt();
        if (number > 0) {
            boolean isDivisible = number % BUZZ_NUMBER == 0;
            boolean doesEnd = number % 10 == BUZZ_NUMBER;
            String message = getMessage(number, isDivisible, doesEnd);
            System.out.print(message);
        } else {
            System.out.println("This number is not natural!");
        }
    }

    private static Boolean isBuzz(boolean isDivisible, boolean doesEnd) {
        return isDivisible || doesEnd;
    }

    private static String getMessage(Integer number, boolean isDivisible, boolean doesEnd) {
        boolean isBuzz = isBuzz(isDivisible, doesEnd);
        String isBuzzString = isBuzz ? "" : "not ";
        String explanation = getExplanation(number, isDivisible, doesEnd, isBuzz);
        return String.format("This number is %s.\n" +
                "It is %sa Buzz number.\n" +
                "Explanation:\n" +
                        "%s.",
                getType(number), isBuzzString, explanation);
    }

    private static String getExplanation(Integer number, boolean isDivisible, boolean doesEnd, boolean isBuzz) {
        String explanation = number.toString();
        if (!isBuzz) {
            explanation += String.format(" is neither divisible by %d nor does it end with %d", BUZZ_NUMBER, BUZZ_NUMBER);
        } else {
            if (isDivisible) {
                explanation += String.format(" is divisible by %d", BUZZ_NUMBER);
            } if (doesEnd) {
                explanation += String.format("%s ends with %d", isDivisible ? " and" : "", BUZZ_NUMBER);
            }
        }
        return explanation;
    }

    private static String getType(Integer number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

}
