
public class CookieTester {
	public static void main(String[] args) {
		OptimalPath g = new OptimalPath("cookies.txt");
		g.read(g.getFile(), 12, 12);
		System.out.println(g);
		System.out.println(g.optimalPath(g.getRow() - 1, g.getCol() - 1));
	}

}
