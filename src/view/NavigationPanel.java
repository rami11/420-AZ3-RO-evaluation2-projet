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

        init();
    }

    private void init() {
        firstButton = new JButton();
        nextButton = new JButton();
        previousButton = new JButton();
        lastButton = new JButton();

        setBorder(BorderFactory.createEtchedBorder());

        firstButton.setText("First");
        firstButton.addActionListener(event -> controller.showFirstItem());
        add(firstButton);

        nextButton.setText("Next");
        nextButton.addActionListener(event -> controller.showNextItem());
        add(nextButton);

        previousButton.setText("Previous");
        previousButton.addActionListener(event -> controller.showPreviousItem());
        add(previousButton);

        lastButton.setText("Last");
        lastButton.addActionListener(event -> controller.showLastItem());
        add(lastButton);

        setPanelEnabled(controller.getCurrentItem() != null);
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
