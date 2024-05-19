import data.Item;
import utils.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Number3 extends Base {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();

        System.out.print("Enter the number of items: ");
        int itemCount = getValidInteger("Please enter a valid number of items: ");

        Predicate<String> isValidName = name -> name.length() >= 3 && name.length() <= 20;
        Predicate<Integer> isValidQuantity = quantity -> quantity >= 1 && quantity <= 100;
        Predicate<Integer> isValidWeight = weight -> weight >= 1 && weight <= 100;

        for (int i = 0; i < itemCount; i++) {
            System.out.printf("Enter item name [%d]: ", i + 1);
            String name = scanner.nextLine();
            while (!isValidName.test(name)) {
                System.out.println("Invalid name, must be 3-20 characters.");
                System.out.printf("Enter item name [%d]: ", i + 1);
                name = scanner.nextLine();
            }

            System.out.printf("Enter quantity [%d]: ", i + 1);
            int quantity = getValidIntegerWithPredicate("Invalid quantity. Enter a number between 1-100: ", isValidQuantity);

            System.out.printf("Enter weight [%d]: ", i + 1);
            int weight = getValidIntegerWithPredicate("Invalid weight. Enter a number between 1-100: ", isValidWeight);

            items.add(new Item(name, quantity, weight));
            System.out.println("Success Input data.Item " + (i + 1));
        }

        int totalWeight = items.stream()
                .mapToInt(item -> item.getQuantity() * item.getWeight())
                .sum();

        System.out.println("Total weight of all items: " + totalWeight + " kg");

        scanner.close();
    }


}