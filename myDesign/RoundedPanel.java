package myDesign;
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class RoundedPanel extends JPanel {

    // Method to create a rounded panel
    public static void createRoundedPanel(JPanel panel, int radius) {
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder());

        panel.setUI(new javax.swing.plaf.PanelUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(panel.getBackground());
                g2.fillRoundRect(0, 0, panel.getWidth(), panel.getHeight(), radius, radius);
                g2.dispose();
                super.paint(g, c);
            }
        });
    }

    // Method to create a rounded button
    public static void createRoundedButton(JButton button, int radius) {
        button.setOpaque(false);
        button.setContentAreaFilled(false); // Prevents default background fill
        button.setBorderPainted(false);     // Removes default border

        button.setUI(new RoundedButtonUI(radius));
    }

    // Custom ButtonUI for rounded buttons
    private static class RoundedButtonUI extends BasicButtonUI {
        private int radius;

        public RoundedButtonUI(int radius) {
            this.radius = radius;
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            JButton button = (JButton) c;
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Determine background color based on button state
            ButtonModel model = button.getModel();
            Color bgColor = button.getBackground();
            if (model.isPressed()) {
                bgColor = bgColor.darker(); // Darken when pressed
            } else if (model.isRollover()) {
                bgColor = bgColor.brighter(); // Brighten on hover
            }

            // Draw the rounded background
            g2.setColor(bgColor);
            g2.fillRoundRect(0, 0, button.getWidth() - 1, button.getHeight() - 1, radius, radius);

            // Draw the text
            super.paint(g2, c); // Let BasicButtonUI handle text and icon painting

            g2.dispose();
        }

        @Override
        protected void paintButtonPressed(Graphics g, AbstractButton b) {
            // Override to ensure pressed state is handled correctly
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(b.getBackground().darker());
            g2.fillRoundRect(0, 0, b.getWidth() - 1, b.getHeight() - 1, radius, radius);
            g2.dispose();
            super.paintButtonPressed(g, b);
        }
    }

    // Override paintComponent for RoundedPanel itself (if used as a component)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Default radius of 20
        g2.dispose();
    }
}