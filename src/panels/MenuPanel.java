package panels;

import game.Grid;
import mediators.Mediator;

import javax.swing.*;
import java.util.Objects;

public class MenuPanel extends JPanel {
    public MenuPanel(Mediator mediator) {
        JButton newGrid = new JButton("New grid");
        JButton randomGrid = new JButton("Random grid");
        JButton loadGrid = new JButton("Load grid");
        JTextArea rowsInput = new JTextArea();
        JTextArea colsInput = new JTextArea();
        rowsInput.setColumns(3);
        colsInput.setColumns(3);

        newGrid.addActionListener(_ -> {
            mediator.closeMenu();
            int rows, cols;

            if (Objects.equals(rowsInput.getText(), "")) rows = 20;
            else rows = Integer.parseInt(rowsInput.getText());
            if (Objects.equals(colsInput.getText(), "")) cols = 20;
            else cols = Integer.parseInt(colsInput.getText());

            mediator.createGrid(Grid.EMPTY, rows, cols);
        });

        randomGrid.addActionListener(_ -> {
            mediator.closeMenu();
            int rows, cols;

            if (Objects.equals(rowsInput.getText(), "")) rows = 20;
            else rows = Integer.parseInt(rowsInput.getText());
            if (Objects.equals(colsInput.getText(), "")) cols = 20;
            else cols = Integer.parseInt(colsInput.getText());

            mediator.createGrid(Grid.RANDOM, rows, cols);
        });

        loadGrid.addActionListener(_ -> {
            mediator.closeMenu();
            mediator.createGrid(Grid.FROM_FILE, 0, 0);
        });

        add(newGrid);
        add(rowsInput);
        add(colsInput);
        add(randomGrid);
        add(loadGrid);
    }
}
