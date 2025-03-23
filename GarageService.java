import java.util.*;

public class GarageService {
    private Map<String, Customer> customerMap;
    private List<Service> availableServices;
    private Scanner sc;

    public GarageService() {
        this.customerMap = new HashMap<>();
        this.availableServices = new ArrayList<>();
        this.sc = new Scanner(System.in);
        loadServices();
    }

    public void loadServices() {
        availableServices.add(new Service("Washing", 500));
        availableServices.add(new Service("Oil Change", 700));
        availableServices.add(new Service("Wheel alignment and balancing", 800));
        availableServices.add(new Service("Air filter replacement", 1000));
        availableServices.add(new Service("Oil filter change", 1000));
        availableServices.add(new Service("Coolant top-up", 300));
        availableServices.add(new Service("Brake fluid change", 800));
    }

    public void addCustomer(String name, String phone, String carNum, String model) {
        Car car = new Car(carNum, model);
        Customer customer = new Customer(name, phone, car);
        customerMap.put(carNum, customer);
        System.out.println("Customer added successfully!");
    }

    public void createInvoice(String carNum) {
        if (!customerMap.containsKey(carNum)) {
            System.out.println("No customer found with car number " + carNum);
            return;
        }

        Customer customer = customerMap.get(carNum);
        List<Service> selectedServices = new ArrayList<>();
        double totalAmount = 0;

        System.out.println("\nAvailable Services:");
        for (int i = 0; i < availableServices.size(); i++) {
            System.out.println((i + 1) + ". " + availableServices.get(i).getName() + " - ₹" + availableServices.get(i).getPrice());
        }

        while (true) {
            System.out.print("Enter service number to add or 0 to finish: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice >= 1 && choice <= availableServices.size()) {
                Service selectedService = availableServices.get(choice - 1);
                selectedServices.add(selectedService);
                totalAmount += selectedService.getPrice();
                System.out.println(selectedService.getName() + " added.");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        if (selectedServices.isEmpty()) {
            System.out.println("No services selected. Invoice not generated.");
            return;
        }

        Invoice invoice = new Invoice(customer, selectedServices, totalAmount);
        invoice.printInvoice();
    }
}
