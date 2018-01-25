import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class OptimalPath {
	private int[][] grid;
	private String file;

	public OptimalPath(String s) {
		this.file = s;
	}

	public String getFile() {
		return file;
	}

	public int getRow() {
		return grid.length;

	}

	public int getCol() {
		return grid[0].length;
	}

	public void read(String fileName, int rows, int cols) {
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(new FileReader(fileName));
		} catch (IOException ex) {
			System.out.println("*** Cannot open " + fileName + " ***");
			System.exit(1);
		}

		int[][] newMap = new int[rows][cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				newMap[r][c] = inputFile.nextInt();
			}
			inputFile.nextLine();
		}
		inputFile.close();
		grid = newMap;
	}

	public int optimalPath(int row, int col) {
		if (row < 0 && col < 0) {// base case if arrived or if not possible
			return grid[row][col];
		}

		else {
			if (clearUp(row, col) >= 0)
				return grid[row][col] + optimalPath(row - 1, col);
			if (clearLeft(row, col) >= 0)
				return grid[row][col] + optimalPath(row, col - 1);
			return grid[row][col];
		}
	}

	public int clearLeft(int row, int col) {
		if (col >= 0 && grid[row - 1][col] >= 0)
			return grid[row][col];
		return -1;
	}

	public int clearUp(int row, int col) {
		if (grid[row][col - 1] >= 0)
			return grid[row][col];
		return -1;

	}

}
