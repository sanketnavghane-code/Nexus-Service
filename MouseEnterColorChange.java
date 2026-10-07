import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEnterColorChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Change Color on Mouse Enter");

        // Set the initial size and close operation
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add MouseListener to detect mouse entry
        frame.addMouseListener(new MouseAdapter() {
            // Override mouseEntered to change color when mouse enters the JFrame
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the background color of the frame when mouse enters
                frame.getContentPane().setBackground(Color.CYAN);  // Change color to cyan
            }

            // Override mouseExited to reset the color when mouse exits the JFrame
            @Override
            public void mouseExited(MouseEvent e) {
                // Reset the background color to white when mouse exits
                frame.getContentPane().setBackground(Color.WHITE);  // Reset to white
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
