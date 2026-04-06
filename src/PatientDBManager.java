import java.sql.*;
 
public class PatientDBManager {
 
    // -----------------------------------------------
    private static final String URL      = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "postgres";
    // -----------------------------------------------
 
    // Manually load the PostgreSQL driver
    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL Driver not found: " + e.getMessage());
        }
    }
 
    // Getting a connection to the PostgreSQL database
    private static Connection getConnection() throws SQLException {
        loadDriver();
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
 
    // Insert a Patient into the patients table
    public static void savePatient(Patient patient) {
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";
 
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setInt(1, patient.getPatientId());
            stmt.setString(2, patient.getPatientFirstName());
            stmt.setString(3, patient.getPatientLastName());
            stmt.setString(4, patient.getPatientDOB());
 
            stmt.executeUpdate();
            System.out.println("The Patient was saved to database successfully!");
 
        } catch (SQLException e) {
            System.out.println("There was an error saving the patient to database: " + e.getMessage());
        }
    }
 
    // Retrieve and display all patients from the database
    public static void readAllPatients() {
        String sql = "SELECT * FROM patients";
 
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
 
            System.out.println("\n--- All of the Patients (from database) ---");
            int count = 0;
 
            while (rs.next()) {
                Patient p = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("dob")
                );
                System.out.println(p);
                count++;
            }
 
            if (count == 0) {
                System.out.println("There was no patient records found within the database.");
            } else {
                System.out.println("Total records: " + count);
            }
 
        } catch (SQLException e) {
            System.out.println("There was an error reading patients from database: " + e.getMessage());
        }
    }
}
