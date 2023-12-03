package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.voter;
import model.voterDAO;

public class CtrlVoter {

    voterDAO voter = new voterDAO();
    int id;
//Loads voter data into the specified JTable, including voter ID, name, ID number, age, email, and phone number.
     
    public void loadVoterData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        List<voter> voters = voter.readVoters();

        for (voter voter : voters) {
            

            Object[] row = {voter.getId(), voter.getName(), voter.getIdNumber(), voter.getAge(), voter.getEmail(), voter.getPhoneNumber()};
            model.addRow(row);
        }
    }

    //Adds a new voter with the provided name, ID number, age, email, and phone number to the database.
    public void addVoter(JTextField name, JTextField idNumber, JTextField age, JTextField email, JTextField phoneNumber) {
        
        if (idNumber.getText().length() == 9) {
             
            if (Validation.verificateIdNumberVoter(idNumber.getText())) {
                JOptionPane.showMessageDialog(null, "El votante que desea registrar ya existe.");
            } else {
                try {
                    if (!Validation.validateNumbers(idNumber.getText()) || !Validation.validateNumbers(age.getText())
                            || !Validation.validateNumbers(phoneNumber.getText())
                            || !Validation.validateLetters(name.getText())) {
                        JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
                    } else {
                        this.voter.createVoter(new voter(name.getText(), Integer.parseInt(idNumber.getText()), Integer.parseInt(age.getText()), email.getText(), Integer.parseInt(phoneNumber.getText())));
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
    
    //Adds a new voter with the provided name, ID number, age, email, and phone number to the database.
    public void updateVoter(JTextField name, JTextField idNumber, JTextField age, JTextField email, JTextField phoneNumber) {
        
        if (idNumber.getText().length() == 9) {
            try {
                if (!Validation.validateNumbers(idNumber.getText()) || !Validation.validateNumbers(age.getText()) || !Validation.validateEmail(email.getText()) || !Validation.validateNumbers(phoneNumber.getText())) {
                    JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
                } else {
                    this.voter.updateVoter(new voter(this.id, name.getText(), Integer.parseInt(idNumber.getText()), Integer.parseInt(age.getText()), email.getText(), Integer.parseInt(phoneNumber.getText())));

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el votante, error: " + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "La longitud de la cédula no es válida, debe tener 9 dígitos.");
        }
    }

//Retrieves and populates the text fields with the data of the selected voter in the table.
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
    
    //Deletes the voter selected in the table from the database.
    public void deleteVoter() {
        this.voter.deleteVoter(id);
    }
    
    //Clears the text fields of the user interface.
    public void clearFields(JTextField name, JTextField idNumber, JTextField age, JTextField email, JTextField phoneNumber) {
        name.setText("");
        idNumber.setText("");
        age.setText("");
        email.setText("");
        phoneNumber.setText("");
    }
}
