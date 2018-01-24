import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OptimalPath {
	private ArrayList<ArrayList<Integer>> grid;

	public OptimalPath(String s) {
		readIn(s);
	}

	public void readIn(String s) {
		File fileName = new File(s);
		Scanner input = null;
		int rowCounter = 0;

		try {
			input = new Scanner(fileName);
		} catch (FileNotFoundException ex) {
			System.out.print("Unable to Open File");
		}
		if (!input.hasNext()) {
			input.close();
			throw new IllegalArgumentException("File is empty");
		}

		while (input.hasNextLine()) {
			ArrayList<Integer> curRow = new ArrayList<Integer>();
			String curLine = input.nextLine();
			String[] values = curLine.split("\\w+");
			for (String v : values) {
				if (!v.isEmpty())
					curRow.add(Integer.parseInt(v));
			}
			grid.add(curRow);
			rowCounter++;
		}
		input.close();
	}

	public int optimalPath(int row, int col) {
		if (row < 0 && col < 0) {// base case if arrived
			return 0;
		}

		else {
			if (clearUp(row, col))
				return grid.get(row).get(col) + optimalPath(row - 1, col);
			if (clearLeft(row, col))
				return grid.get(row).get(col) + optimalPath(row, col - 1);
			else
				return grid.get(row).get(col);
		}
	}

	public boolean clearLeft(int row, int col) {
		return col >= 0 && grid.get(row - 1).get(col) >= 0;
	}

	public boolean clearUp(int row, int col) {
		return row >= 0 && grid.get(row).get(col - 1) >= 0;
	}

}
