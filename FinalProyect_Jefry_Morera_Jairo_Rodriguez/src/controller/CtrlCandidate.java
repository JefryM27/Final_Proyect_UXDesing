
package controller;

import Controller.Validation;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.candidate;
import model.candidateDAO;

/**
 *
 * @author jefry
 */
public class CtrlCandidate {
    candidateDAO candidate = new candidateDAO();
    int id;
    //Method to add new candidate
    public void addCandidate(JTextField name, JTextField idNumber, JTextField age, JTextField politicParty) {
       //Get the id number and validate if is equals to nine
        if (idNumber.getText().length() == 9) {
            //Get the id number and verify if the candidates is already 
            if (Validation.verificateCandidateExist(idNumber.getText())) {
                JOptionPane.showMessageDialog(null, "El candidato que desea registrar ya existe.");
            } else {
                try {
                    if (!Validation.validateNumbers(idNumber.getText()) || !Validation.validateNumbers(age.getText()) || !Validation.validateLyrics(name.getText()) || !Validation.validateLyrics(politicParty.getText())) {
                        JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
                    } else {
                        this.candidate.updateCandidate(new candidate(name.getText(), Integer.parseInt(idNumber.getText()), Integer.parseInt(age.getText()), politicParty.getText()));
                        clearFields(name, idNumber, age, politicParty);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el candidato, error: " + e.toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La longitud de la cédula  no es valido, esta debe tener 9 digitos.");
        }
    }
  //Method to update the candidaties from the table 
    public void updateCandidate(JTextField name, JTextField idNumber, JTextField age, JTextField politicParty) {
        //Get the id number and validate if is equals to nine
        if (idNumber.getText().length() == 9) {
            //Get the legal id and verify if the candidate is already 
            if (Validation.verificateCandidateExist(idNumber.getText())) {
                JOptionPane.showMessageDialog(null, "El candidato que desea registrar ya existe en la base de datos.");
            } else {
                try {
                    if (!Validation.validateNumbers(idNumber.getText()) || !Validation.validateNumbers(age.getText()) || !Validation.validateLyrics(name.getText()) || !Validation.validateLyrics(politicParty.getText())) {
                        JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
                    } else {
                        this.candidate.createCandidate(new candidate(name.getText(), Integer.parseInt(idNumber.getText()), Integer.parseInt(age.getText()), politicParty.getText()));
                        clearFields(name, idNumber, age, politicParty);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el candidato, error: " + e.toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La longitud de la cédula no es valido, esta debe tener 9 digitos.");
        }
    }
//Method to select and access a table row 
    public void selectedRow(JTable table, JTextField name, JTextField idNumber, JTextField age, JTextField politicParty) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                idNumber.setText(table.getValueAt(row, 2).toString());
                age.setText(table.getValueAt(row, 3).toString());
                politicParty.setText(table.getValueAt(row, 4).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }
 //Method to remove an candidate from the table
    public void deleteCandidate() {
        this.candidate.deleteCandidate(id);
    }
 //Method to clean the table fields 
    public void clearFields(JTextField name, JTextField idNumber, JTextField age, JTextField politicParty) {
        name.setText("");
        idNumber.setText("");
        age.setText("");
        politicParty.setText("");
    }
}