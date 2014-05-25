/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.GUI;

import bookstore.Bill;
import bookstore.InventoryItem;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Vassily
 */
public class billWindow extends JFrame {

    JTable mainTable;
    Bill bill;

    public billWindow(Bill bill) {

        ImageIcon[] icons = new imageIconLoader().getImages();

        this.bill = bill;
        String[] columns = {
            "Quantity",
            "ISBN number",
            "Book Title",
            "Author",
            "Price/book",
            "Total Price"
        };

        setTitle("Customer's bill");

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(content);

        mainTable = new JTable(new DefaultTableModel(new Object[][]{}, columns));
        mainTable.getTableHeader().setReorderingAllowed(false);

        JLabel mainIcon = new JLabel(icons[4]);
        mainIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(mainIcon);

        JLabel billText = new JLabel("BILL");
        billText.setFont(new Font("Helvetica", Font.BOLD, 35));
        billText.setBorder(BorderFactory.createEmptyBorder(-5, 0, 0, 0));
        billText.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(billText);
        add(mainTable.getTableHeader());
        add(mainTable);

        mainTable.setEnabled(false);
        mainTable.setDefaultRenderer(Object.class, new customCell());
        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        fillTable();

        JLabel cName = new JLabel("Customer: " + bill.customer);
        cName.setFont(new Font("Helvetica", Font.PLAIN, 25));
        cName.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(cName);
        JLabel total = new JLabel("Total cost: $" + String.format("%.2f", bill.getTotalCost()));
        total.setFont(new Font("Helvetica", Font.PLAIN, 25));
        total.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(total);
        this.setResizable(false);
        pack();
        setLocationRelativeTo(null);


    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        for (InventoryItem item : bill.getList()) {
            model.addRow(new String[]{
                Integer.toString(item.getQuantity()),
                item.getID(),
                item.getName(),
                item.getCreator(),
                "$" + String.format("%.2f", item.getPrice()),
                "$" + String.format("%.2f", item.getQuantity() * item.getPrice())
            });
            mainTable.doLayout();
            for (int i = 0; i < 6; i++) {
                int max = 0;
                TableColumn mode = mainTable.getColumnModel().getColumn(i);
                for (int j = 0; j < mainTable.getRowCount(); j++) {
                    Component rend = mainTable.getCellRenderer(j, i).getTableCellRendererComponent(mainTable, mainTable.getValueAt(j, i), false, false, 0, 0);
                    max = Math.max(max, rend.getPreferredSize().width);
                }
                max = Math.max(max, mode.getPreferredWidth());
                mode.setMaxWidth(max + 5);
                mode.setMinWidth(max + 5);

            }

            ArrayList<TableColumn> columns = Collections.list(mainTable.getTableHeader().getColumnModel().getColumns());
        }
    }

    private class customCell extends DefaultTableCellRenderer {

        public customCell() {
            setHorizontalAlignment(JLabel.CENTER);
        }

    }

}
