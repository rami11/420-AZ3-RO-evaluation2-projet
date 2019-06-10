package view;

import javax.swing.*;

public class NavigationPanel extends JPanel {

    private JButton firstButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton lastButton;

    private ItemController controller;

    public NavigationPanel(ItemController controller) {
        this.controller = controller;

        firstButton = new JButton();
        nextButton = new JButton();
        previousButton = new JButton();
        lastButton = new JButton();

        setBorder(BorderFactory.createEtchedBorder());

        firstButton.setText("First");
        firstButton.addActionListener(event -> {
            controller.setItemViewValues(controller.getFirstItem());
        });
        add(firstButton);

        nextButton.setText("Next");
        nextButton.addActionListener(event -> {
            controller.setItemViewValues(controller.getNextItem());
        });
        add(nextButton);

        previousButton.setText("Previous");
        previousButton.addActionListener(event -> {
            controller.setItemViewValues(controller.getPreviousItem());
        });
        add(previousButton);

        lastButton.setText("Last");
        lastButton.addActionListener(event -> {
            controller.setItemViewValues(controller.getLastItem());
        });
        add(lastButton);
    }

    private void setPanelEnabled(boolean isEnabled) {
        firstButton.setEnabled(isEnabled);
        nextButton.setEnabled(isEnabled);
        previousButton.setEnabled(isEnabled);
        lastButton.setEnabled(isEnabled);
    }

    private void disablePanel() {
        setPanelEnabled(false);
    }

    private void enablePanel() {
        setPanelEnabled(true);
    }
}
