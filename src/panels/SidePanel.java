package panels;

import mediators.Mediator;
import state.StateEnum;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    public SidePanel(Mediator mediator) {
        setVisible(true);
        setBackground(new Color(6, 182, 102));
        setPreferredSize(new Dimension(200, 0));
        JButton cell = new JButton("Cell");
        JButton glider = new JButton("Glider");
        JButton replicator = new JButton("Replicator");
        JButton predecessor = new JButton("Predecessor");
        JButton butterfly = new JButton("Butterfly");
        JButton eraser1 = new JButton("Erase 1x1");
        JButton eraser2 = new JButton("Erase 2x2");
        JButton eraser3 = new JButton("Erase 3x3");

        cell.addActionListener(_ -> mediator.changePattern(StateEnum.CELL));

        glider.addActionListener(_ -> mediator.changePattern(StateEnum.GLIDER));

        replicator.addActionListener(_ -> mediator.changePattern(StateEnum.REPLICATOR));

        predecessor.addActionListener(_ -> mediator.changePattern(StateEnum.PREDECESSOR));

        butterfly.addActionListener(_ -> mediator.changePattern(StateEnum.BUTTERFLY));

        eraser1.addActionListener(_ -> mediator.changePattern(StateEnum.ERASER1));

        eraser2.addActionListener(_ -> mediator.changePattern(StateEnum.ERASER2));

        eraser3.addActionListener(_ -> mediator.changePattern(StateEnum.ERASER3));

        setLayout(new GridLayout(8, 1));
        add(cell);
        add(glider);
        add(replicator);
        add(predecessor);
        add(butterfly);
        add(eraser1);
        add(eraser2);
        add(eraser3);
    }
}
