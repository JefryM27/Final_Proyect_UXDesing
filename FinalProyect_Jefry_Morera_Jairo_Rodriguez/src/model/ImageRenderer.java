/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author jairo
 */
public class ImageRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof ImageIcon) {
            ImageIcon imageIcon = (ImageIcon) value;

            // Obtener la imagen del ImageIcon
            Image image = imageIcon.getImage();

            // Obtener las dimensiones originales de la imagen
            int width = image.getWidth(null);
            int height = image.getHeight(null);

            // Establecer el tamaño deseado (por ejemplo, 100x100)
            int newWidth = 100;
            int newHeight = 100;

            // Redimensionar la imagen al nuevo tamaño manteniendo la proporción
            Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            // Establecer la imagen redimensionada en el JLabel
            ImageIcon resizedImageIcon = new ImageIcon(newImage);
            label.setIcon(resizedImageIcon);
            label.setText(""); // Vaciar el texto para mostrar solo la imagen
        } else {
            label.setText("No image");
        }

        return label;

    }
}
