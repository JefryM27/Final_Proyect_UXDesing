package controller;

import controller.Validation;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
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
        table.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());

        for (candidate candidate : candidates) {
            int candidateId = candidate.getId(); // Obtener el ID del candidato

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

            Object[] row = {candidateId, name, politicParty, resizedImageIcon};
            model.addRow(row);
        }

        // Ajustes de la tabla
        table.setRowHeight(200);
        for (int i = 0; i < 4; i++) {
            table.getColumnModel().getColumn(i).setMaxWidth(180); // Ajusta el ancho de las primeras 4 columnas
        }
        table.getColumnModel().getColumn(3).setMaxWidth(140); // Ajusta el ancho de la columna de la imagen
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

    public void updateCandidate(JTextField name, JTextField idNumber, JTextField age, JTextField politicParty, File newImageFile) {
        try {
            // Verificar si la longitud del número de identificación es correcta
            if (idNumber.getText().length() == 9) {
                // Validar los campos ingresados
                if (Validation.validateNumbers(idNumber.getText()) && Validation.validateNumbers(age.getText())
                        && Validation.validateLetters(name.getText()) && Validation.validateLetters(politicParty.getText())) {
                    // Leer el archivo de la nueva imagen como bytes
                    byte[] imageBytes = Files.readAllBytes(newImageFile.toPath());

                    // Crear un objeto candidate con la información actualizada
                    candidate candidateToUpdate = new candidate(
                            this.id,
                            Integer.parseInt(idNumber.getText()),
                            name.getText(),
                            Integer.parseInt(age.getText()),
                            politicParty.getText(),
                            imageBytes);

                    // Llamar al método en candidateDAO para actualizar el candidato
                    candidateDAO.updateCandidate(candidateToUpdate, newImageFile);

                    // Limpiar los campos y refrescar la tabla
                    clearFields(name, idNumber, age, politicParty);
                    refreshTable(table);
                } else {
                    JOptionPane.showMessageDialog(null, "Posible error de formato, por favor digite el formato correspondiente a su espacio.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La longitud de la cédula no es válida, esta debe tener 9 dígitos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el candidato, error: " + e.toString());
        }
    }

    public void selectedRow(JTable table, JTextField txtName, JTextField txtIdNumber, JTextField txtAge, JTextField txtPoliticParty, JLabel lblImage) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                txtName.setText(table.getValueAt(row, 1).toString());
                txtIdNumber.setText(table.getValueAt(row, 2).toString());
                txtAge.setText(table.getValueAt(row, 3).toString());
                txtPoliticParty.setText(table.getValueAt(row, 4).toString());
                ImageIcon imageIcon = (ImageIcon) table.getValueAt(row, 5);
                lblImage.setIcon(imageIcon);
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
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
