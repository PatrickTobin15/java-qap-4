import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===========================================");
        System.out.println("   Data Persistence Project - Java App    ");
        System.out.println("===========================================");

        while (running) {
            printMenu();
            System.out.print("What are you looking for?: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    saveDrugToFile(scanner);
                    break;
                case "2":
                    DrugFileManager.readAllDrugs();
                    break;
                case "3":
                    savePatientToDatabase(scanner);
                    break;
                case "4":
                    PatientDBManager.readAllPatients();
                    break;
                case "5":
                    System.out.println("Exiting program... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option... Please enter 1-5.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("-------------------------------------------");
        System.out.println("  1. Save a Drug to file");
        System.out.println("  2. Read all Drugs from file");
        System.out.println("  3. Save a Patient to database");
        System.out.println("  4. Read all Patients from database");
        System.out.println("  5. Exit");
        System.out.println("-------------------------------------------");
    }

    // Collect Drug info from the user and save it
    private static void saveDrugToFile(Scanner scanner) {
        System.out.println("\n--- Please Enter the Drugs Details ---");

        System.out.print("What is the Drug ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("What is the Drug Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("What is the Drug Cost: ");
        double cost = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("What is the Dosage (e.g., 500mg): ");
        String dosage = scanner.nextLine().trim();

        Drug drug = new Drug(id, name, cost, dosage);
        DrugFileManager.saveDrug(drug);
    }

    // Collects the Patients info from the user and save to DB
    private static void savePatientToDatabase(Scanner scanner) {
        System.out.println("\n--- Please Enter the Patient Details ---");

        System.out.print("What is the Patients ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Their First Name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Their Last Name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("And their Date of Birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine().trim();

        Patient patient = new Patient(id, firstName, lastName, dob);
        PatientDBManager.savePatient(patient);
    }
}
