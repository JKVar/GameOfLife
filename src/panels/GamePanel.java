package panels;

import game.*;
import mediators.Mediator;
import state.*;
import strategy.OriginalStrategy;
import strategy.StrategyEnum;
import strategy.DayAndNightStrategy;
import strategy.HighLifeStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    private final GridInterface grid;
    private final Mediator mediator;
    private final int rows;
    private final int cols;
    private final Timer timer;
    private MouseAdapter mouseAdapter;
    private int cellSize;
    private int delay = 503;

    public GamePanel(Mediator mediator, int rows, int cols) {
        setBackground(Color.black);
        setVisible(true);
        this.rows = rows;
        this.cols = cols;
        this.mediator = mediator;
        cellSize = Math.min(getWidth()/cols, getHeight()/rows);

        grid = new ProxyGrid(rows, cols);
        if (cellSize > 0) {
            mouseAdapter = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int row = e.getY() / cellSize;
                    int col = e.getX() / cellSize;
                    if (row < grid.getRows() && col < grid.getColumns())
                        grid.placePatternOnGrid(row, col);
                    repaint();
                }
            };
            addMouseListener(mouseAdapter);
        }

        this.timer = new Timer(delay, _ -> nextGeneration());
    }

    public void calculateCellSize() {
        cellSize = Math.min(getWidth()/cols, getHeight()/rows);
        removeMouseListener(mouseAdapter);
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = e.getY() / cellSize;
                int col = e.getX() / cellSize;
                if (row < grid.getRows() && col < grid.getColumns())
                    grid.placePatternOnGrid(row, col);
                repaint();
            }
        };
        addMouseListener(mouseAdapter);
    }

    public void start() {
        timer.start();
        grid.setStarted(true);
    }

    public void stop() {
        timer.stop();
        grid.setStarted(false);
    }

    public void clear() {
        timer.stop();
        grid.setStarted(false);
        grid.clearGrid();
        mediator.displayGeneration(0);
        repaint();
    }

    public void nextGeneration() {
        if (grid.nextGeneration()) {
            int generation = grid.getGeneration();
            mediator.displayGeneration(generation);
            repaint();
        } else {
            timer.stop();
            grid.setStarted(false);
        }
    }

    public void changeDelay(int speed) {
//        this.delay =  1005 - speed*10;
        this.delay = (int) (1005 - Math.log(speed+1)/Math.log(Math.pow(100, 1.0/1000)));
        timer.stop();
        timer.setDelay(delay);
        if (grid.isStarted()) {
            timer.restart();
        }
    }

    public void changeStrategy(StrategyEnum strategyType) {
        switch (strategyType) {
            case HIGH_LIFE:
                grid.setStrategy(new HighLifeStrategy());
                break;
            case DAY_AND_NIGHT:
                grid.setStrategy(new DayAndNightStrategy());
                break;
            default:
                grid.setStrategy(new OriginalStrategy());
                break;
        }

        this.clear();
    }

    public void changePattern(StateEnum patternType) {
        switch (patternType) {
            case CELL:
                grid.setPatternState(new CellState());
                break;
            case GLIDER:
                grid.setPatternState(new GliderState());
                break;
            case REPLICATOR:
                grid.setPatternState(new ReplicatorState());
                break;
            case PREDECESSOR:
                grid.setPatternState(new RocketPredecessorState());
                break;
            case BUTTERFLY:
                grid.setPatternState(new ButterflyState());
                break;
            case ERASER1:
                grid.setPatternState(new EraserState(1));
                break;
            case ERASER2:
                grid.setPatternState(new EraserState(2));
                break;
            case ERASER3:
                grid.setPatternState(new EraserState(3));
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getColumns(); j++) {
                if (grid.getCellState(i, j)) {
                    g.setColor(Color.lightGray);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                }
            }
        }

        if (cellSize > 5) {
            g.setColor(Color.darkGray);
            for (int i = 0; i < Math.max(grid.getColumns(), grid.getRows()); i++) {
                if (i < grid.getRows())
                    g.drawLine(0, (i+1)*cellSize, grid.getColumns()*cellSize, (i+1)*cellSize);
                if (i < grid.getColumns())
                    g.drawLine((i+1)*cellSize, 0, (i+1)*cellSize, grid.getRows()*cellSize);
            }
        }
    }
}
