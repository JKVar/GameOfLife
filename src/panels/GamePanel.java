package panels;

import factory.EmptyGridFactory;
import factory.FileGridFactory;
import factory.GridFactory;
import factory.RandomGridFactory;
import game.*;
import mediators.Mediator;
import state.*;
import strategy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    private GridInterface grid;
    private final Mediator mediator;
    private final Timer timer;
    private MouseAdapter mouseAdapter;
    private int rows;
    private int cols;
    private int cellSize;
    private int delay = 503;

    public GamePanel(Mediator mediator) {
        setBackground(Color.black);
        setVisible(false);
        this.mediator = mediator;

        this.timer = new Timer(delay, _ -> nextGeneration());
    }

    public void calculateCellSize() {
        if (cols > 0 && rows > 0) {
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
            case WEIGHT_OF_LIFE:
                grid.setStrategy(new WeightOfLifeStrategy());
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

    public void createGrid(int gridType, int rows, int cols) {
        System.out.println("grid");
        GridFactory gridFactory = switch (gridType) {
            case Grid.RANDOM -> new RandomGridFactory(rows, cols);
            case Grid.FROM_FILE -> new FileGridFactory();
            default -> new EmptyGridFactory(rows, cols);
        };

        this.rows = rows;
        this.cols = cols;
        grid = new ProxyGrid(rows, cols);
        grid.setGrid(gridFactory.createGrid());

        calculateCellSize();
        setVisible(true);
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
