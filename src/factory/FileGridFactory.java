package factory;

import game.CellGrid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileGridFactory implements GridFactory {
    private final String fileName;

    public FileGridFactory() {
        fileName = "grid.dat";
    }

    @Override
    public CellGrid createGrid() {
        CellGrid grid = new CellGrid(10, 10);
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int rows, cols;
            String sizeLine = br.readLine();
            String[] sizeParts = sizeLine.trim().split("\\s+");
            rows = Integer.parseInt(sizeParts[0]);
            cols = Integer.parseInt(sizeParts[1]);
            grid = new CellGrid(rows, cols);

            String line;
            int currentRow = 0;
            while ((line = br.readLine()) != null && currentRow < rows) {
                String[] parts = line.trim().split("\\s+");
                for (int col = 0; col < cols; col++) {
                    grid.setState(currentRow, col, Integer.parseInt(parts[col]) > 0);
                }
                currentRow++;
            }
        } catch (IOException exception) {
            System.err.println("Error reading " + fileName + " file: " + exception.getMessage());
        }
        return grid;
    }
}
