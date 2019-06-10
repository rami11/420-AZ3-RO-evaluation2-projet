package view;

import javax.swing.*;

public class CrudPanel extends JPanel {

    private JButton addButton;
    private JButton updateButton;
    private JButton cancelButton;
    private JButton newButton;
    private JButton deleteButton;

    private ItemController controller;

    public CrudPanel(ItemController controller) {
        this.controller = controller;

        init();
    }

    private void init() {
        newButton = new JButton();
        addButton = new JButton();
        updateButton = new JButton();
        cancelButton = new JButton();
        deleteButton = new JButton();

        setBorder(BorderFactory.createEtchedBorder());

        newButton.setText("New");
        newButton.addActionListener(event -> {
          controller.newItemButtonClick();
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
                resetItemInfoValues();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Invalid value!", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Update failed!", JOptionPane.ERROR_MESSAGE);
            }*/
        });
        add(addButton);

        updateButton.setText("Update");
        updateButton.addActionListener(event -> {
           controller.updateButtonClick();
        });
        add(updateButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(event -> {
           controller.cancelButtonClick();
        });
        add(cancelButton);

        deleteButton.setText("Delete");
        add(deleteButton);

        setPanelEnabled(controller.getCurrentItem() != null);
    }

    private void setPanelEnabled(boolean isEnabled) {
        newButton.setEnabled(isEnabled);
        addButton.setEnabled(!isEnabled);
        updateButton.setEnabled(isEnabled);
        cancelButton.setEnabled(!isEnabled);
        deleteButton.setEnabled(isEnabled);
    }

    public void enablePanel() {
        setPanelEnabled(true);
    }

    public void disablePanel() {
        setPanelEnabled(false);
    }
}
