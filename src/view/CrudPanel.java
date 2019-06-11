package view;

import javax.swing.*;
import java.sql.SQLException;

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
            try {
                controller.addItem();

                JOptionPane.showMessageDialog(this, "Item added.", "Success!", JOptionPane.INFORMATION_MESSAGE);
                controller.newItemButtonClick();

            } catch (NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Update failed!", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(addButton);

        updateButton.setText("Update");
        updateButton.addActionListener(event -> {
            //controller.updateButtonClick();
            JOptionPane.showMessageDialog(this, "Handle update directly!");
        });
        add(updateButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(event -> {
            controller.cancelButtonClick();
        });
        add(cancelButton);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(event -> {
            try {
                controller.deleteItem();

                JOptionPane.showMessageDialog(this, "Item deleted.", "Success!", JOptionPane.INFORMATION_MESSAGE);
                controller.showCurrentItem();

            } catch (NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Update failed!", JOptionPane.ERROR_MESSAGE);
            }
        });
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
