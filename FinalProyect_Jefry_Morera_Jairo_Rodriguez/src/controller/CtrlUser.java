package controller;

import controller.*;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.*;

public class CtrlUser {

    userDAO user = new userDAO();
    rolDAO rolDAO = new rolDAO();
    int id;
//Loads user data into the specified JTable, including user ID, name, password, and role.
    public void loadUserData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        List<user> users = user.readUser();

        for (user user : users) {
            String roleName = rolDAO.getRoleNameById(user.getRoleId());
            // Get the name of the entity and the corresponding role

            Object[] row = {user.getId(), user.getName(), user.getPassword(), roleName};
            model.addRow(row);
        }
    }

    //Adds a new user with the provided name, password, and role to the database.
    public void addUser(JTextField name, JTextField password, JComboBox<String> cbxRole) {

        try {
            if (!Validation.validateLetters(name.getText())) {
                JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
            } else {
                String roleName = (String) cbxRole.getSelectedItem();
                ctrlRol ctrlRol = new ctrlRol();
                int roleId = ctrlRol.getRoleIdByName2(roleName);
                this.user.createUser(new user(name.getText(), password.getText(), roleId));
                clearFields(name, password);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el usuario, error: " + e.toString());
        }
    }

    //Updates the user selected in the table with the provided name, password, and role.
    public void updateUser(JTextField name, JTextField password, JComboBox<String> cbxRole) {
        try {
            if (!Validation.validateLetters(name.getText())) {
                JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
            } else {
                ctrlRol ctrlRol = new ctrlRol();
                String roleName = (String) cbxRole.getSelectedItem();

                // Convert entity and role names into their respective IDs 
                int roleId = ctrlRol.getRoleIdByName(roleName);
                this.user.updateUser(new user(this.id, name.getText(), password.getText(), roleId));
                clearFields(name, password);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el usuario, error: " + e.toString());
        }
    }
    
   //Retrieves and populates the text fields and JComboBox with the data of the selected user in the table.
    public void selectedRow(JTable table, JTextField name, JTextField password, JComboBox<String> cbxRole) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                password.setText(table.getValueAt(row, 2).toString());
                String roleName = table.getValueAt(row, 3).toString();
                cbxRole.setSelectedItem(roleName);
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    //Deletes the user selected in the table from the database.
    public void deleteUser() {
        this.user.deleteUser(id);
    }

    //Clears the text fields of the user interface.
    public void clearFields(JTextField name, JTextField password) {
        name.setText("");
        password.setText("");
    }
}
