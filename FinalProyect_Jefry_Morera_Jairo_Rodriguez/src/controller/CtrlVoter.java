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
import model.voter;
import model.voterDAO;

/**
 *
 * @author jefry
 */
public class CtrlVoter {

    voterDAO voter = new voterDAO();
    int id;

    public void loadVoterData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        List<voter> voters = voter.readVoters();

        for (voter voter : voters) {
            // Get the name of the entity and the corresponding role

            Object[] row = {voter.getId(), voter.getName(), voter.getIdNumber(), voter.getAge(), voter.getEmail(), voter.getPhoneNumber()};
            model.addRow(row);
        }
    }

    //Method to add new voter
    public void addVoter(JTextField name, JTextField idNumber, JTextField age, JTextField email, JTextField phoneNumber) {
        //Get the id number and validate if is equals to nine
        if (idNumber.getText().length() == 9) {
            //Get the id number and verify if the voter is already 
            if (Validation.verificateIdNumberVoter(idNumber.getText())) {
                JOptionPane.showMessageDialog(null, "El votante que desea registrar ya existe.");
            } else {
                try {
                    if (!Validation.validateNumbers(idNumber.getText()) || !Validation.validateNumbers(age.getText())
                            || !Validation.validateNumbers(phoneNumber.getText())
                            || !Validation.validateLetters(name.getText())) {
                        JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
                    } else {
                        this.voter.updateVoter(new voter(name.getText(), Integer.parseInt(idNumber.getText()), Integer.parseInt(age.getText()), email.getText(), Integer.parseInt(phoneNumber.getText())));
                        clearFields(name, idNumber, age, email, phoneNumber);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el votante, error: " + e.toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La longitud de la cédula no es valido, esta debe tener 9 digitos.");
        }
    }
    //Method to update the voters from the table 

    public void updateVoter(JTextField name, JTextField idNumber, JTextField age, JTextField email, JTextField phoneNumber) {
        //Get the id number and validate if is equals to nine
        if (idNumber.getText().length() == 9) {
            //Get the legal id and verify if the voter is already 
            if (Validation.verifyCandidateExist(idNumber.getText())) {
                JOptionPane.showMessageDialog(null, "El votante que desea registrar ya existe en la base de datos.");
            } else {
                try {
                    if (!Validation.validateNumbers(idNumber.getText()) || !Validation.validateNumbers(age.getText())
                            || !Validation.verifyCandidateExist(name.getText()) || !Validation.validateNumbers(phoneNumber.getText())) {
                        JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
                    } else {
                        this.voter.updateVoter(new voter(name.getText(), Integer.parseInt(idNumber.getText()), Integer.parseInt(age.getText()), email.getText(), Integer.parseInt(phoneNumber.getText())));
                        clearFields(name, idNumber, age, email, phoneNumber);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el votante, error: " + e.toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La longitud de la cédula no es valido, esta debe tener 9 digitos.");
        }
    }
//Method to select and access a table row 

    public void selectedRow(JTable table, JTextField name, JTextField idNumber, JTextField age, JTextField email, JTextField phoneNumber) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                idNumber.setText(table.getValueAt(row, 2).toString());
                age.setText(table.getValueAt(row, 3).toString());
                email.setText(table.getValueAt(row, 4).toString());
                phoneNumber.setText(table.getValueAt(row, 5).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }
    //Method to remove an voter from the table

    public void deleteVoter() {
        this.voter.deleteVoter(id);
    }
    //Method to clean the table fields 

    public void clearFields(JTextField name, JTextField idNumber, JTextField age, JTextField email, JTextField phoneNumber) {
        name.setText("");
        idNumber.setText("");
        age.setText("");
        email.setText("");
        phoneNumber.setText("");
    }
}
