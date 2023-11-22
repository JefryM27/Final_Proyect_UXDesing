package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class candidateDAO {

    public candidateDAO() {

    }
// Método para crear un nuevo registro de candidato en la base de datos con imagen

    public void createCandidate(candidate candidate, File imageFile) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "INSERT INTO candidates (id_number, name, age, politic_party, image) VALUES (?, ?, ?, ?, ?)";
        try {
            FileInputStream fis = new FileInputStream(imageFile);

            try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
                ps.setInt(1, candidate.getIdNumber());
                ps.setString(2, candidate.getName());
                ps.setInt(3, candidate.getAge());
                ps.setString(4, candidate.getPoliticParty());
                ps.setBinaryStream(5, fis, (int) imageFile.length());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Candidato insertado correctamente");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el candidato, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    // Método para recuperar una lista de todos los candidatos de la base de datos
    public List<candidate> readCandidates() {
        DBConnectionJava db = new DBConnectionJava();
        List<candidate> candidates = new ArrayList<>();
        String sql = "SELECT id, id_number, name, age, politic_party FROM candidates";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql); ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("id_number");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String politicParty = resultSet.getString("politic_party");
                candidates.add(new candidate(id, idNumber, name, age, politicParty));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return candidates;
    }

    public void updateCandidate(candidate candidate, File newImageFile) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "UPDATE candidates SET id_number=?, name=?, age=?, politic_party=?, image=? WHERE id=?";

        try {
            try (FileInputStream fis = new FileInputStream(newImageFile); PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
                ps.setInt(1, candidate.getIdNumber());
                ps.setString(2, candidate.getName());
                ps.setInt(3, candidate.getAge());
                ps.setString(4, candidate.getPoliticParty());
                ps.setBinaryStream(5, fis, (int) newImageFile.length());
                ps.setInt(6, candidate.getId());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Modificación Exitosa");
            }
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el candidato, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    // Método para eliminar un registro de candidato de la base de datos por ID
    public void deleteCandidate(int id) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "DELETE FROM candidates WHERE id=?";

        try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql)) {
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
