 import java.util.Scanner;

  public class CurrencyConverter {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Define conversion rates (example: 1 USD = 83.0 INR)
            double usdToInrRate = 83.0;
            double eurToInrRate = 88.5;

            System.out.println("Currency Converter");
            System.out.println("Choose the conversion option:");
            System.out.println("1. USD to INR");
            System.out.println("2. EUR to INR");
            System.out.print("Enter choice (1 or 2): ");
            int choice = scanner.nextInt();

            double rate = 0.0;
            String currency = "";

            switch (choice) {
                case 1:
                    rate = usdToInrRate;
                    currency = "USD";
                    break;
                case 2:
                    rate = eurToInrRate;
                    currency = "EUR";
                    break;
                default:
                    System.out.println("Invalid choice!");
                    scanner.close();
                    return;
            }

            System.out.print("Enter the amount in " + currency + ": ");
            double amount = scanner.nextDouble();
            double convertedAmount = amount * rate;

            System.out.printf("Converted amount in INR: %.2f\n", convertedAmount);
            scanner.close();
        }
    }


