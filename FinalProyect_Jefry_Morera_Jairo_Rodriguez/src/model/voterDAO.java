package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class voterDAO {

    private int selectedCandidateId = -1;

    public voterDAO() {

    }

    public int getSelectedCandidateId() {
        return selectedCandidateId;
    }

    public int getVoterId(String idNumber) {
        String query = "SELECT id FROM voters WHERE id_number = ?";
        int voterId = -1; // Valor predeterminado si no se encuentra el votante
        DBConnectionJava dbConnection = new DBConnectionJava();

        try (Connection connection = dbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                voterId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.disconnect();
        }

        return voterId;
    }

    public boolean authenticateVoter(String idNumber) {
        DBConnectionJava db = new DBConnectionJava();
        boolean isAuthenticated = false;
        String sql = "SELECT * FROM voters WHERE id_number = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, idNumber);
            ResultSet resultSet = ps.executeQuery();

            // Si hay un resultado, el votante está autenticado
            isAuthenticated = resultSet.next();
        } catch (SQLException e) {
            System.err.println("Error al autenticar el votante: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return isAuthenticated;
    }

    public boolean checkVoterExistence(String idNumber) {
        String query = "SELECT id FROM voters WHERE id_number = ?";
        boolean voterExists = false;
        DBConnectionJava dbConnection = new DBConnectionJava();

        try (Connection connection = dbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Si el resultado contiene una fila, significa que el votante existe
                voterExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.disconnect();
        }

        return voterExists;
    }

    // Método para autenticar al votante
    public boolean authenticateVoter(String idNumber, String password) {
        String query = "SELECT id FROM voters WHERE id_number = ? AND password = ?";
        boolean isAuthenticated = false;
        DBConnectionJava dbConnection = new DBConnectionJava();

        try (Connection connection = dbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idNumber);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Si el resultado contiene una fila, significa que la autenticación fue exitosa
                isAuthenticated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.disconnect();
        }

        return isAuthenticated;
    }

    // Método para verificar si el votante ya ha votado
    public boolean hasVoted(String idNumber) {
        String query = "SELECT id FROM voters WHERE id_number = ? AND has_voted = 1";
        boolean hasVoted = false;
        DBConnectionJava dbConnection = new DBConnectionJava();

        try (Connection connection = dbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Si el resultado contiene una fila, significa que el votante ya ha votado
                hasVoted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.disconnect();
        }

        return hasVoted;
    }

    // Método para marcar al votante como que ha votado
    public void markAsVoted(String idNumber) {
        String query = "UPDATE voters SET has_voted = 1 WHERE id_number = ?";
        DBConnectionJava dbConnection = new DBConnectionJava();

        try (Connection connection = dbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.disconnect();
        }
    }

    // Method to create a new voter record in the database
    public void createVoter(voter voter) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO voters (id_number, name, age, email, phone_number) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, voter.getIdNumber());
            ps.setString(2, voter.getName());
            ps.setInt(3, voter.getAge());
            ps.setString(4, voter.getEmail());
            ps.setInt(5, voter.getPhoneNumber());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Votante insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el votante, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

// Method to retrieve a list of all voters from the database
    public List<voter> readVoters() {
        DBConnectionJava db = new DBConnectionJava();
        List<voter> voters = new ArrayList<>();
        String sql = "SELECT * FROM voters";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("id_number");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phone_number");
                voters.add(new voter(id, name, idNumber, age, email, phoneNumber));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return voters;
    }

    public void updateVoter(voter voter) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE voters SET id_number=?, name=?, age=?, email=?, phone_number=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, voter.getIdNumber());
            ps.setString(2, voter.getName());
            ps.setInt(3, voter.getAge());
            ps.setString(4, voter.getEmail());
            ps.setInt(5, voter.getPhoneNumber());
            ps.setInt(6, voter.getId());
            ps.execute(); // Usar executeUpdate para actualizaciones

            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el votante, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

// Method to delete a voter record from the database by ID
    public void deleteVoter(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM voters WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Votante eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el votante, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

}
