package utils;

import data.Pengiriman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Base {

    protected static Scanner scanner = new Scanner(System.in);
    protected static List<Pengiriman> shipments = new ArrayList<>();

    protected static int getValidInteger(String errorMessage) {
        while (!scanner.hasNextInt()) {
            System.out.print(errorMessage);
            scanner.nextLine();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    protected static int getValidIntegerWithPredicate(String errorMessage, Predicate<Integer> isValid) {
        int number;
        while (true) {
            number = getValidInteger(errorMessage);
            if (isValid.test(number)) {
                break;
            }
            System.out.print(errorMessage);
        }
        return number;
    }
}
