package controller;

import controller.Validation;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ImageRenderer;
import model.ImageResizer;
import model.candidate;
import model.candidateDAO;

public class CtrlCandidate {

    candidateDAO candidateDAO = new candidateDAO();
    private int id;
    private JTable table;
    private JScrollPane scrollPane;
    private JLabel lblImage;
    private File selectedImageFile;

    public CtrlCandidate() {
        table = new JTable();
        scrollPane = new JScrollPane(table);
        this.candidateDAO = new candidateDAO();

    }

    public void initUI(JLabel lblImage) {
        this.lblImage = lblImage;
    }

    public void loadCandidatesData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<candidate> candidates = candidateDAO.readCandidates();

        // Agregar un renderizador de imagen para la columna de imagen (suponiendo que la columna de la imagen es la 5ª columna)
        table.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());

        for (candidate candidate : candidates) {
            int id = candidate.getId();
            String name = candidate.getName();
            int idNumber = candidate.getIdNumber();
            int age = candidate.getAge();
            String politicParty = candidate.getPoliticParty();
            byte[] imageBytes = candidate.getImageBytes();

            // Redimensionar la imagen al tamaño deseado
            ImageResizer resizer = new ImageResizer();
            byte[] resizedImageBytes = null;
            try {
                resizedImageBytes = resizer.resizeImage(imageBytes, 200, 200); // Cambiar al tamaño deseado
            } catch (IOException e) {
                // Manejo del error si la redimensión falla
                e.printStackTrace();
            }

            // Crear un ImageIcon con los bytes de la imagen redimensionada
            ImageIcon resizedImageIcon = new ImageIcon(resizedImageBytes);

            Object[] row = {id, name, idNumber, age, politicParty, resizedImageIcon};
            model.addRow(row);
        }

        // Ajustes de la tabla
        table.setRowHeight(200);
        for (int i = 0; i < 6; i++) {
            table.getColumnModel().getColumn(i).setMaxWidth(180); // Por ejemplo, ajusta el ancho de las primeras 6 columnas
        }
        table.getColumnModel().getColumn(5).setMaxWidth(140); // Ajusta el ancho de la columna de la imagen
    }

    public void loadCandidatesDataVoter(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<candidate> candidates = candidateDAO.readCandidatesVoter();

        // Agregar un renderizador de imagen para la columna de imagen (suponiendo que la columna de la imagen es la 5ª columna)
        table.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());

        for (candidate candidate : candidates) {
            String name = candidate.getName();
            String politicParty = candidate.getPoliticParty();
            byte[] imageBytes = candidate.getImageBytes();

            // Redimensionar la imagen al tamaño deseado
            ImageResizer resizer = new ImageResizer();
            byte[] resizedImageBytes = null;
            try {
                resizedImageBytes = resizer.resizeImage(imageBytes, 200, 200); // Cambiar al tamaño deseado
            } catch (IOException e) {
                // Manejo del error si la redimensión falla
                e.printStackTrace();
            }

            // Crear un ImageIcon con los bytes de la imagen redimensionada
            ImageIcon resizedImageIcon = new ImageIcon(resizedImageBytes);

            Object[] row = {name, politicParty, resizedImageIcon};
            model.addRow(row);
        }

        // Ajustes de la tabla
        table.setRowHeight(200);
        for (int i = 0; i < 3; i++) {
            table.getColumnModel().getColumn(i).setMaxWidth(180); // Por ejemplo, ajusta el ancho de las primeras 6 columnas
        }
        table.getColumnModel().getColumn(2).setMaxWidth(140); // Ajusta el ancho de la columna de la imagen
    }

    public void addCandidate(JTextField name, JTextField idNumber, JTextField age, JTextField politicParty, File imageFile) {
        try {
            if (idNumber.getText().length() != 9) {
                JOptionPane.showMessageDialog(null, "La longitud de la cédula no es válida, esta debe tener 9 dígitos.");
                return;
            }

            if (Validation.verifyCandidateExist(idNumber.getText())) {
                JOptionPane.showMessageDialog(null, "El candidato que desea registrar ya existe.");
            } else {
                byte[] imageBytes = Files.readAllBytes(imageFile.toPath()); // Lee la imagen como array de bytes

                candidate newCandidate = new candidate(
                        Integer.parseInt(idNumber.getText()),
                        name.getText(),
                        Integer.parseInt(age.getText()),
                        politicParty.getText(),
                        imageBytes); // Asigna el array de bytes a la instancia del candidato

                candidateDAO.createCandidate(newCandidate, imageBytes); // Llama al método con ambos argumentos

                clearFields(name, idNumber, age, politicParty);
                refreshTable(table);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al procesar los números. Asegúrate de ingresar números válidos en los campos correspondientes.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo leer la imagen: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el candidato, error: " + e.toString());
        }
    }

    public void examinarImagen() {
        if (lblImage == null) {
            System.out.println("lblImage es null");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedImageFile = fileChooser.getSelectedFile();

            try {
                // Convertir el archivo seleccionado a un array de bytes
                byte[] imageBytes = Files.readAllBytes(selectedImageFile.toPath());

                // Redimensionar la imagen
                ImageResizer resizer = new ImageResizer();
                byte[] resizedImageBytes = resizer.resizeImage(imageBytes, 200, 200); // Cambiar al tamaño deseado

                // Mostrar la imagen redimensionada en el JLabel
                lblImage.setIcon(new ImageIcon(ImageIO.read(new ByteArrayInputStream(resizedImageBytes))));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + e.getMessage());
            }
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
                        byte[] imageBytes = Files.readAllBytes(newImageFile.toPath());
                        candidate candidateToUpdate = new candidate(this.id, Integer.parseInt(idNumber.getText()), name.getText(),
                                Integer.parseInt(age.getText()), politicParty.getText(), imageBytes);
                        candidateDAO.updateCandidate(candidateToUpdate, newImageFile);
                        clearFields(name, idNumber, age, politicParty);
                        refreshTable(table);
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
        refreshTable(table);
    }

    // Método para limpiar los campos del formulario
    public void clearFields(JTextField name, JTextField idNumber, JTextField age, JTextField politicParty) {
        name.setText("");
        idNumber.setText("");
        age.setText("");
        politicParty.setText("");
    }

    // Método para actualizar la tabla de candidatos
    public void refreshTable(JTable table) {
        List<candidate> candidates = candidateDAO.readCandidates();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (candidate candidate : candidates) {
            model.addRow(new Object[]{
                candidate.getId(),
                candidate.getName(),
                candidate.getIdNumber(),
                candidate.getAge(),
                candidate.getPoliticParty()
            });
        }
    }

    public File getSelectedImageFile() {
        return selectedImageFile;
    }

}
