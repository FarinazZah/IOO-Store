/
import java.util.Scanner;
public class Store {
    public static void main(String[] args) {
        System.out.print("Welcome to the CS 1331 Store! Please enter your name here: "); // Prompt
        Scanner input = new Scanner(System.in); // Create Scanner object
        String name = input.nextLine(); // Take in user input
        String newName = "";
        if (name.isEmpty()) { // Checks if we get any input
            newName = "User"; // If we don't get an input, set the user's name as "User"
            //System.out.print(newName); // Testing line
        } else {
            name = name.toLowerCase(); // Make the entire string lowercase
            newName = name.substring(0, 1).toUpperCase() + name.substring(1); // 1st Letter is up.

        }
        // Portion above prints our first statement and edits the user's name. This part works with the test cases.





        System.out.printf("\nHello %s, which product are you buying today?\n"
                + "CS 1331 Pencil - $2.25\n" + "CS 1331 Pen - $3.00\n" + "CS 1331 T-Shirt - $10.50\n"
                + "CS 1331 Calculator - $30.00\n" + "Enter Product: ", newName); // Listing products/prices
        // Portion above prints identical statement to prompt

        String product = input.nextLine(); // Tells us which product case we are going to look at
        double price = 0;

        // Product is always read correctly

        int quant = 1;  // Initialize quant with a default value
        String pluralProduct = ""; // Initialize pluralProduct with a default value

        switch (product) {
        case "CS 1331 Pencil":
        case "CS 1331 Pen":
            System.out.print("Would you be interested in taking the CS 1331 Pencil and Pen Bundle ($4.75)? ");
            String response = input.nextLine();
            boolean yesBundle = response.substring(0, 1).equalsIgnoreCase("Y");
            if (yesBundle) {
                System.out.print("\nHow many CS 1331 Pencil and Pen Bundles would you like? ");
                price = 4.75;
                product = "CS 1331 Pencil and Pen Bundle";
                pluralProduct = "CS 1331 Pencil and Pen Bundles";
            } else {
                System.out.print("\nHow many CS 1331 " + (product.equals("CS 1331 Pencil") ? "Pencils" : "Pens")
                        + " would you like? ");
                price = product.equals("CS 1331 Pencil") ? 2.25 : 3.00;
                pluralProduct = product.equals("CS 1331 Pencil") ? "CS 1331 Pencils" : "CS 1331 Pens";
            }
            quant = input.hasNextInt() ? input.nextInt() : -1;
            if (quant <= 0) {
                System.out.print("That is not a valid quantity. We will assume you want 1.\n");
                quant = 1;
            }
            break;
        case "CS 1331 T-Shirt":
            System.out.print("\nHow many CS 1331 T-Shirts would you like? ");
            price = 10.50;
            pluralProduct = "CS 1331 T-Shirts";
            quant = input.hasNextInt() ? input.nextInt() : -1;
            if (quant <= 0) {
                System.out.print("That is not a valid quantity. We will assume you want 1.\n");
                quant = 1;
            }
            break;
        case "CS 1331 Calculator":
            System.out.print("\nHow many CS 1331 Calculators would you like? ");
            price = 30.00;
            pluralProduct = "CS 1331 Calculators";
            quant = input.hasNextInt() ? input.nextInt() : -1;
            if (quant <= 0) {
                System.out.print("That is not a valid quantity. We will assume you want 1.\n");
                quant = 1;
            }
            break;
        case "CS 1331 Homework Solution":
            System.out.print("That is not for sale!\n");
            System.exit(0);
        default:
            System.out.print("We do not have that product. Sorry.\n");
            System.exit(0);
        }

        input.nextLine(); // Consume the leftover newline
        System.out.print("\nEnter discount code (empty for no code): ");
        String discountCode = input.nextLine();
        double discount = 0;

        if (discountCode.equalsIgnoreCase("JAVA1331")) {
            discount = 0.1;
        } else if (discountCode.equalsIgnoreCase("OOP")) {
            discount = 0.15;
        } else if (!discountCode.isEmpty()) {
            System.out.print("That discount code does not exist.\n");
        }

        double totalPrice = (price * quant) * (1 - discount);
        System.out.printf("\n%s, thank you for buying the %s. The total is $%.2f.\n", newName, quant > 1
                ? pluralProduct : product, totalPrice);
    }
}