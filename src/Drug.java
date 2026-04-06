public class Drug {
    private int drugId;
    private String drugName;
    private double drugCost;
    private String dosage;

    public Drug(int drugId, String drugName, double drugCost, String dosage) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCost = drugCost;
        this.dosage = dosage;
    }

    // Getters
    public int getDrugId() { return drugId; }
    public String getDrugName() { return drugName; }
    public double getDrugCost() { return drugCost; }
    public String getDosage() { return dosage; }

    // Format for saving to file (CSV-style)
    public String toFileString() {
        return drugId + "," + drugName + "," + drugCost + "," + dosage;
    }

    // Rebuild a Drug from a file line
    public static Drug fromFileString(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();
        double cost = Double.parseDouble(parts[2].trim());
        String dose = parts[3].trim();
        return new Drug(id, name, cost, dose);
    }

    @Override
    public String toString() {
        return String.format("Drug [ID: %d | Name: %s | Cost: $%.2f | Dosage: %s]",
                drugId, drugName, drugCost, dosage);
    }
}
