package controller;

import Controller.Validation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.candidate;
import model.candidateDAO;

public class CtrlCandidate {

    private candidateDAO candidateDAO = new candidateDAO();
    private int id;
    private JTable table;
    private JScrollPane scrollPane;

    public CtrlCandidate() {
        table = new JTable();
        scrollPane = new JScrollPane(table);
    }

    // Método para agregar un nuevo candidato
    public void addCandidate(JTextField name, JTextField idNumber, JTextField age, JTextField politicParty, File imageFile) {
        try {
            if (idNumber.getText().length() == 9) {
                if (Validation.verifyCandidateExist(idNumber.getText())) {
                    JOptionPane.showMessageDialog(null, "El candidato que desea registrar ya existe.");
                } else {
                    if (Validation.validateNumbers(idNumber.getText()) && Validation.validateNumbers(age.getText())
                            && Validation.validateLetters(name.getText()) && Validation.validateLetters(politicParty.getText())) {
                        candidateDAO.createCandidate(new candidate(Integer.parseInt(idNumber.getText()),name.getText(), 
                                Integer.parseInt(age.getText()), politicParty.getText()), imageFile);
                        clearFields(name, idNumber, age, politicParty);
                        refreshTable(table, scrollPane);
                    } else {
                        JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "La longitud de la cédula no es válida, esta debe tener 9 dígitos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el candidato, error: " + e.toString());
        }
    }

    // Método para actualizar un candidato
    public void updateCandidate(JTextField name, JTextField idNumber, JTextField age, JTextField politicParty, File newImageFile) {
        try {
            if (idNumber.getText().length() == 9) {
                if (Validation.verifyCandidateExist(idNumber.getText())) {
                    JOptionPane.showMessageDialog(null, "El candidato que desea registrar ya existe en la base de datos.");
                } else {
                    if (Validation.validateNumbers(idNumber.getText()) && Validation.validateNumbers(age.getText())
                            && Validation.validateLetters(name.getText()) && Validation.validateLetters(politicParty.getText())) {
                        candidateDAO.updateCandidate(new candidate(id, Integer.parseInt(idNumber.getText()), name.getText(),
                                Integer.parseInt(age.getText()), politicParty.getText()), newImageFile);
                        clearFields(name, idNumber, age, politicParty);
                        refreshTable(table, scrollPane);
                    } else {
                        JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "La longitud de la cédula no es válida, esta debe tener 9 dígitos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el candidato, error: " + e.toString());
        }
    }

    // Método para eliminar un candidato
    public void deleteCandidate() {
        candidateDAO.deleteCandidate(id);
        refreshTable(table, scrollPane);
    }

    // Método para limpiar los campos del formulario
    public void clearFields(JTextField name, JTextField idNumber, JTextField age, JTextField politicParty) {
        name.setText("");
        idNumber.setText("");
        age.setText("");
        politicParty.setText("");
    }

    // Método para actualizar la tabla de candidatos
    public void refreshTable(JTable table, JScrollPane scrollPane) {
        List<candidate> candidates = candidateDAO.readCandidates();
        displayCandidates(candidates, scrollPane);
    }

    // Método para mostrar los candidatos en la interfaz
    private void displayCandidates(List<candidate> candidates, JScrollPane scrollPane) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Cedula");
        model.addColumn("Edad");
        model.addColumn("Partido Politico");

        for (candidate candidate : candidates) {
            model.addRow(new Object[]{
                candidate.getId(),
                candidate.getName(),
                candidate.getIdNumber(),
                candidate.getAge(),
                candidate.getPoliticParty()
            });
        }

        table.setModel(model);
        scrollPane.setViewportView(table);
    }

}
