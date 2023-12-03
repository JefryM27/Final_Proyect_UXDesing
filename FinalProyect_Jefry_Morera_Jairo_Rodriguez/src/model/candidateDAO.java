package model;

import java.io.ByteArrayInputStream;
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
// Creates a new candidate record in the database with an associated image.

    public void createCandidate(candidate candidate, byte[] imageBytes) {
        DBConnectionJava db = new DBConnectionJava();
        String sql = "INSERT INTO candidates (id_number, name, age, politic_party, image) VALUES (?, ?, ?, ?, ?)";

        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);

            try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
                ps.setInt(1, candidate.getIdNumber());
                ps.setString(2, candidate.getName());
                ps.setInt(3, candidate.getAge());
                ps.setString(4, candidate.getPoliticParty());
                ps.setBinaryStream(5, inputStream, imageBytes.length);
                ps.execute();
                JOptionPane.showMessageDialog(null, "Candidato insertado correctamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el candidato, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
//Retrieves a list of all candidates from the database.
    public List<candidate> readCandidates() {
        DBConnectionJava db = new DBConnectionJava();
        List<candidate> candidates = new ArrayList<>();
        String sql = "SELECT id, id_number, name, age, politic_party, image FROM candidates";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql); ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("id_number");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String politicParty = resultSet.getString("politic_party");
                byte[] imageBytes = resultSet.getBytes("image");

                candidates.add(new candidate(id, idNumber, name, age, politicParty, imageBytes));
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        } finally {
            db.disconnect();
        }
        return candidates;
    }
//Retrieves a list of candidates from the database suitable for voter display.
    public List<candidate> readCandidatesVoter() {
        DBConnectionJava db = new DBConnectionJava();
        List<candidate> candidates = new ArrayList<>();
        String sql = "SELECT id, name, politic_party, image FROM candidates"; // Agrega la columna 'id' a la consulta SQL

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql); ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // Obtiene el ID del candidato
                String name = resultSet.getString("name");
                String politicParty = resultSet.getString("politic_party");
                byte[] imageBytes = resultSet.getBytes("image");

                candidates.add(new candidate(id, name, politicParty, imageBytes)); // Pasa el ID al constructor
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        } finally {
            db.disconnect();
        }
        return candidates;
    }
//Updates an existing candidate record in the database with new information and image.
    public void updateCandidate(candidate candidate, File newImageFile) {
        if (candidate == null || newImageFile == null) {
            JOptionPane.showMessageDialog(null, "Los datos del candidato o la imagen son nulos.");
            return;
        }

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
            // Considera también registrar el error en un archivo de registro para un seguimiento detallado.
        } finally {
            db.disconnect();
        }
    }

    // Deletes a candidate record from the database based on the provided ID.
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
