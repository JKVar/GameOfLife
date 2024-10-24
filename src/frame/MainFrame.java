package frame;

import panels.GamePanel;
import panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    public MainFrame() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });

        setTitle("Game of life");
        setResizable(false);
        setBounds(100, 100, 1000, 1100);
        setLayout(null);
        setVisible(true);
        setBackground(Color.BLACK);
//        setResizable(true);
    }
}
