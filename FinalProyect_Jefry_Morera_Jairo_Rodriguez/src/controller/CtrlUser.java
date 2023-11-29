package controller;

import controller.Validation;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.user;
import model.userDAO;

public class CtrlUser {

    userDAO user = new userDAO();
    int id;

    public void loadUserData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        List<user> users = user.readUser();

        for (user user : users) {
            // Get the name of the entity and the corresponding role

            Object[] row = {user.getId(), user.getName(), user.getPassword()};
            model.addRow(row);
        }
    }

    //Method to add new user
    public void addUser(JTextField name, JTextField password) {

        try {
            if (!Validation.validateLetters(name.getText())) {
                JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
            } else {
                this.user.createUser(new user(name.getText(), password.getText()));
                clearFields(name, password);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el usuario, error: " + e.toString());
        }
    }

    //Method to update the users from the table 
    public void updateUser(JTextField name, JTextField password) {
        try {
            if (!Validation.validateLetters(name.getText())) {
                JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
            } else {
                this.user.updateUser(new user(name.getText(), password.getText()));
                clearFields(name, password);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el usuario, error: " + e.toString());
        }
    }
//Method to select and access a table row 

    public void selectedRow(JTable table, JTextField name, JTextField password) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                password.setText(table.getValueAt(row, 2).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    //Method to remove an user from the table
    public void deleteUser() {
        this.user.deleteUser(id);
    }

    //Method to clean the table fields 
    public void clearFields(JTextField name, JTextField password) {
        name.setText("");
        password.setText("");
    }
}
