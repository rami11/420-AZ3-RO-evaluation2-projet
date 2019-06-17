package view;

import javax.swing.*;

public class NavigationPanel extends JPanel {

    private JButton firstButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton lastButton;

    public NavigationPanel() {
        init();
    }

    private void init() {
        firstButton = new JButton();
        nextButton = new JButton();
        previousButton = new JButton();
        lastButton = new JButton();

        setBorder(BorderFactory.createEtchedBorder());

        firstButton.setText("First");
        add(firstButton);

        nextButton.setText("Next");
        add(nextButton);

        previousButton.setText("Previous");
        add(previousButton);

        lastButton.setText("Last");
        add(lastButton);
    }

    public void setPanelEnabled(boolean isEnabled) {
        firstButton.setEnabled(isEnabled);
        nextButton.setEnabled(isEnabled);
        previousButton.setEnabled(isEnabled);
        lastButton.setEnabled(isEnabled);
    }

    public void disablePanel() {
        setPanelEnabled(false);
    }

    public void enablePanel() {
        setPanelEnabled(true);
    }

    public JButton getFirstButton() {
        return firstButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getLastButton() {
        return lastButton;
    }
}
