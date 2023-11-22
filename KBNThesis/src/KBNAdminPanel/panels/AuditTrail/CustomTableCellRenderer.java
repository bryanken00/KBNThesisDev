package KBNAdminPanel.panels.AuditTrail;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.Font;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Check if it's the desired column (e.g., Column 1)
        if (column == 1) {
            // Make the text in Column 1 bold
            Font boldFont = new Font("Arial", Font.BOLD, 14);
            rendererComponent.setFont(boldFont);
        }

        return rendererComponent;
    }
}
