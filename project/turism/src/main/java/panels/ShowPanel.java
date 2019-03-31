package panels;

import model.Order;
import model.OrderModel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

public class ShowPanel extends JPanel {

    private JTable table;
    private  JScrollPane jScrollPane;
    private OrderModel model;

    public ShowPanel(OrderModel model){

        this.model = model;
        setLayout(new BorderLayout());
        intiComponent();
    }
    private void intiComponent() {
        table = new JTable(model);
        setColumnsWidth(table);
        jScrollPane=new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);
    }
    private static void setColumnsWidth(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTableHeader tableHeader = table.getTableHeader();
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int prefWidth = Math.round((float) tableHeader.getFontMetrics(tableHeader.getFont()).
                    getStringBounds(tableHeader.getTable().getColumnName(i),tableHeader.getGraphics()).getWidth());
            column.setPreferredWidth(prefWidth + 10);
        }
    }
}
