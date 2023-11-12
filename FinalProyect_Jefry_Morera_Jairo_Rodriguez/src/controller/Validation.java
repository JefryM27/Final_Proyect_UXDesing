
package controller;

import model.DBConnectionJava;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DBConnectionJava;


public class Validation {
    public static boolean validateLetters(String value) {
        String regex = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$";
        return value.matches(regex);
    }

    public static boolean validateNumbers(String value) {
        String regex = "^[0-9]+$";
        return value.matches(regex);
    }

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
}
