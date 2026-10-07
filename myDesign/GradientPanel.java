package myDesign;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    private Color color1;
    private Color color2;

    public GradientPanel(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Create a gradient from top-left to bottom-right
        GradientPaint gradient = new GradientPaint(0, 0, color1, width, 0,color2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }

    // Method to return this panel
    public JPanel getPanel() {
		return (this);
    }
}