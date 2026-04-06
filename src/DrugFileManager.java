import java.io.*;

public class DrugFileManager {

    private static final String FILE_NAME = "drugs.txt";

    // Save a Drug object to the text file (appends to existing file)
    public static void saveDrug(Drug drug) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(drug.toFileString());
            writer.newLine();
            System.out.println("This drug has been saved to the file successfully!");
        } catch (IOException e) {
            System.out.println("There was an error when saving drug to file: " + e.getMessage());
        }
    }

    // Read all Drug objects from the text file and display them
    public static void readAllDrugs() {
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("There was no drug records found in the file.");
            return;
        }

        System.out.println("\n--- All Drugs (from file) ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Drug drug = Drug.fromFileString(line);
                    System.out.println(drug);
                    count++;
                }
            }
            System.out.println("Total records: " + count);
        } catch (IOException e) {
            System.out.println("Error reading drug file: " + e.getMessage());
        }
    }
}
