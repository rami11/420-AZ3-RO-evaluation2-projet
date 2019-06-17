package view;

import javax.swing.*;

public class CrudPanel extends JPanel {

    private JButton addButton;
    private JButton updateButton;
    private JButton cancelButton;
    private JButton newButton;
    private JButton deleteButton;

    public CrudPanel() {
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
        add(newButton);

        addButton.setText("Add");
        addButton.setEnabled(false);
        add(addButton);

        cancelButton.setText("Cancel");
        cancelButton.setEnabled(false);
        add(cancelButton);

        updateButton.setText("Update");
        add(updateButton);

        deleteButton.setText("Delete");
        add(deleteButton);
    }

    public void setPanelEnabled(boolean isEnabled) {
        newButton.setEnabled(isEnabled);
        addButton.setEnabled(!isEnabled);
        updateButton.setEnabled(isEnabled);
        cancelButton.setEnabled(!isEnabled);
        deleteButton.setEnabled(isEnabled);
    }

    public JButton getNewButton() {
        return newButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
