
package model;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


public class ImageRenderer extends DefaultTableCellRenderer {
// Create a new JLabel as a rendering component, centered, displaying ImageIcon if available.
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        if (value instanceof ImageIcon) {
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setIcon((ImageIcon) value); 
        }
        return label;
    }
}
