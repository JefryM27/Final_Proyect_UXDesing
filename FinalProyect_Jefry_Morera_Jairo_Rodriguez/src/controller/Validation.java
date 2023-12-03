package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.DBConnectionJava;

public class Validation {
    
    //Validates that the input string contains only letters, including spaces and accents.
    public static boolean validateLetters(String value) {
        String regex = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$";
        return value.matches(regex);
    }

    //Validates that the input string contains only numeric characters.
    public static boolean validateNumbers(String value) {
        String regex = "^[0-9]+$";
        return value.matches(regex);
    }

    //Verifies whether a candidate with the given ID number already exists in the database.
    public static boolean verifyCandidateExist(String idNumber) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "SELECT COUNT(*) FROM candidates WHERE id_number = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, idNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cedula en la base de datos");
        } finally {
            db.disconnect();
        }

        return false;
    }

    //Verifies whether a voter with the given ID number already exists in the database
    public static boolean verificateIdNumberVoter(String idNumber) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "SELECT COUNT(*) FROM voters WHERE id_number = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, idNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la cedula en la base de datos");
        } finally {
            db.disconnect();
        }

        return false;
    }

    //Validates the format of an email address using a regular expression.
    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
