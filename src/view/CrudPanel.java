package view;

import javax.swing.*;

public class CrudPanel extends JPanel {

    private JButton addButton;
    private JButton cancelButton;
    private JButton newButton;
    private JButton deleteButton;

    private ItemController controller;

    public CrudPanel(ItemController controller) {
        this.controller = controller;

        newButton = new JButton();
        addButton = new JButton();
        cancelButton = new JButton();
        deleteButton = new JButton();

        setBorder(BorderFactory.createEtchedBorder());

        newButton.setText("New");
        newButton.addActionListener(event -> {
          /*  resetItemViewValues();
            disablePanelNorth();
            enablePanelSouth();*/
        });
        add(newButton);

        addButton.setText("Add");
        addButton.addActionListener(event -> {
           /* try {
                int itemId = Integer.parseInt(itemIdField.getText());
                String name = itemNameField.getText();
                double unitPrice = Double.parseDouble(unitPriceField.getText());
                int categoryId = Integer.parseInt(catIdField.getText());

                item = new domain.bean.Item(itemId, name, unitPrice, categoryId);
                itemController.addItem(item);

                JOptionPane.showMessageDialog(this, "domain.bean.Item " + itemId + " added.", "Success!", JOptionPane.INFORMATION_MESSAGE);
                resetItemViewValues();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Invalid value!", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Update failed!", JOptionPane.ERROR_MESSAGE);
            }*/
        });
        add(addButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(event -> {
            /*enablePanelNorth();
            disablePanelSouth();
            setItemViewValues(itemController.getFirstItem());*/
        });
        add(cancelButton);

        deleteButton.setText("Delete");
        add(deleteButton);
    }

    private void setPanelEnabled(boolean isEnabled) {
        newButton.setEnabled(!isEnabled);
        addButton.setEnabled(isEnabled);
        cancelButton.setEnabled(isEnabled);
        deleteButton.setEnabled(!isEnabled);
    }

    private void enablePanel() {
        setPanelEnabled(true);
    }

    private void disablePanel() {
        setPanelEnabled(false);
    }
}
