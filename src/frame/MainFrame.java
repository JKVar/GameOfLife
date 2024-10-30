package frame;

import mediators.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private Mediator mediator;

    public MainFrame(Mediator mediator) {
        this.mediator = mediator;
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

        setMinimumSize(new Dimension(300, 400));
        setTitle("Game of life");
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setBackground(Color.BLACK);
        setResizable(true);

    }
}
