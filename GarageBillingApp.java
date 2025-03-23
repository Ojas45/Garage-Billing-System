import java.util.Scanner;

public class GarageBillingApp {
    public static void main(String[] args) {
        GarageService garageService = new GarageService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----------- Turbotune Service Center ----------");
            System.out.println("1. Add Customer");
            System.out.println("2. Create Invoice");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Car number: ");
                    String carNum = sc.nextLine();
                    System.out.print("Enter Car model: ");
                    String model = sc.nextLine();
                    garageService.addCustomer(name, phone, carNum, model);
                    break;

                case 2:
                    System.out.print("Enter Car Number: ");
                    String carNo = sc.nextLine();
                    garageService.createInvoice(carNo);
                    break;

                case 3:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
