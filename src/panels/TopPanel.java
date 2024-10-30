package panels;

import mediators.Mediator;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TopPanel extends JPanel {
    private JLabel generationLabel;

    public TopPanel(Mediator mediator) {
        setBackground(new Color(8, 147, 82));
        setVisible(true);

        generationLabel = new JLabel("Number of generations: 0");
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton clear = new JButton("Clear");
        JButton next = new JButton("Next");
        JSlider slider = new JSlider();

        start.addActionListener(e -> mediator.start());
        stop.addActionListener(e -> mediator.stop());
        clear.addActionListener(e -> mediator.clear());
        next.addActionListener(e -> mediator.next());
        slider.addChangeListener(e -> mediator.setSpeed(slider.getValue()));

        add(start);
        add(stop);
        add(clear);
        add(next);
        add(generationLabel);
        add(slider);
    }

    public void displayGeneration(int generation) {
        generationLabel.setText("Number of generations: " + generation);
    }
}
