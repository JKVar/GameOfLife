package frame;

import mediators.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    public MainFrame(Mediator mediator) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        JFrame frame = this;
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = frame.getWidth();
                int height = frame.getHeight();
                mediator.resizePanels(width, height);
            }
        });

        setMinimumSize(new Dimension(800, 700));
        setTitle("Game of life");
        setLayout(new BorderLayout());
        setVisible(true);
        setBackground(Color.BLACK);
        setResizable(true);
    }
}
