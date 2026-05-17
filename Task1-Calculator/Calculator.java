import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CALCULATOR =====");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Square Root");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            try {

                if (choice.equals("5")) {

                    System.out.print("Enter number: ");
                    double num = Double.parseDouble(sc.nextLine());

                    if (num < 0) {
                        System.out.println("Cannot calculate square root!");
                    } else {
                        System.out.println("Answer: " + Math.sqrt(num));
                    }

                } else {

                    System.out.print("Enter first number: ");
                    BigDecimal num1 = new BigDecimal(sc.nextLine());

                    System.out.print("Enter second number: ");
                    BigDecimal num2 = new BigDecimal(sc.nextLine());

                    BigDecimal result;

                    switch (choice) {

                        case "1":
                            result = num1.add(num2);
                            System.out.println("Answer: " + result);
                            break;

                        case "2":
                            result = num1.subtract(num2);
                            System.out.println("Answer: " + result);
                            break;

                        case "3":
                            result = num1.multiply(num2);
                            System.out.println("Answer: " + result);
                            break;

                        case "4":

                            if (num2.compareTo(BigDecimal.ZERO) == 0) {
                                System.out.println("Cannot divide by zero!");
                            } else {
                                result = num1.divide(num2, 2, RoundingMode.HALF_UP);
                                System.out.println("Answer: " + result);
                            }

                            break;

                        default:
                            System.out.println("Invalid choice");
                    }
                }

            } catch (Exception e) {
                System.out.println("Please enter valid numbers only!");
            }
        }

        sc.close();
    }
}