package KBN.Module.Warehouse.AuditTrail;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;

public class CenteredTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == 0) {
            setHorizontalAlignment(SwingConstants.CENTER);
        }
        return rendererComponent;
    }
}