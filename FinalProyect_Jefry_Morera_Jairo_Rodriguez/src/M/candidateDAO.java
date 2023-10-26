/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package M;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class candidateDAO {

    public candidateDAO() {

    }

    // Method to create a new candidate record in the database
    public void createCandidate(candidate candidate) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO candidates (id_number, name, age, politic_party) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, candidate.getIdNumber());
            ps.setString(2, candidate.getName());
            ps.setInt(3, candidate.getAge());
            ps.setString(4, candidate.getPoliticParty());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Candidato insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el candidato, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

// Method to retrieve a list of all candidates from the database
    public List<candidate> readCandidates() {
        DBConnectionJava db = new DBConnectionJava();
        List<candidate> candidates = new ArrayList<>();
        String sql = "SELECT * FROM candidates";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("id_number");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String politicParty = resultSet.getString("politic_party");
                candidates.add(new candidate(id, name, idNumber, age, politicParty));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return candidates;
    }

// Method to update an existing candidate record in the database
    public void updateCandidate(candidate candidate) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE candidates SET id_number=?, name=?, age=?, politic_party=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, candidate.getIdNumber());
            ps.setString(2, candidate.getName());
            ps.setInt(3, candidate.getAge());
            ps.setString(4, candidate.getPoliticParty());
            ps.setInt(5, candidate.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el candidato, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

// Method to delete a candidate record from the database by ID
    public void deleteCandidate(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM candidates WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Candidato eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el candidato, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

}
