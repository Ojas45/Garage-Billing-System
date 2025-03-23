import java.util.List;

public class Invoice {
    private Customer customer;
    private List<Service> services;
    private double totalAmount;
    private static final double CGST_RATE = 0.09; // 9%
    private static final double SGST_RATE = 0.09; // 9%

    public Invoice(Customer customer, List<Service> services, double totalAmount) {
        this.customer = customer;
        this.services = services;
        this.totalAmount = totalAmount;
    }

    public void printInvoice() {
        double cgst = totalAmount * CGST_RATE;
        double sgst = totalAmount * SGST_RATE;
        double finalAmount = totalAmount + cgst + sgst;

        System.out.println("\n----------- Invoice -----------");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Car: " + customer.getCar().getModel() + " (" + customer.getCar().getCarNumber() + ")");
        System.out.println("\nServices Availed:");

        for (Service service : services) {
            System.out.println("- " + service.getName() + " ₹" + service.getPrice());
        }

        System.out.println("\nSubtotal: ₹" + totalAmount);
        System.out.println("CGST (9%): ₹" + String.format("%.2f", cgst));
        System.out.println("SGST (9%): ₹" + String.format("%.2f", sgst));
        System.out.println("Total Payable: ₹" + String.format("%.2f", finalAmount));
        System.out.println("------------------------------");
    }
}
