import java.text.DecimalFormat;

public class TrustFunctionOne {
	private double testTable[][];
	private double alpha;
	private double beta;

	public TrustFunctionOne(double[][] table, double a, double b) {
		testTable = table;
		alpha = a;
		beta = b;
	}

	public void run() {
		double previousValue;
		double newValue = 0.0;
		for (int r = 0; r < testTable.length; r += 2) {
			previousValue = testTable[r + 1][0];
			for (int c = 1; c < testTable[r].length; c++) {
				if (check(testTable[r][c], previousValue) == "ig")
					newValue = increaseGoodTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "in")
					newValue = increaseNeutralTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "ib")
					newValue = increaseBadTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "dg")
					newValue = decreaseGoodTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "dn")
					newValue = decreaseNeutralTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "db")
					newValue = decreaseBadTrust(previousValue);
				testTable[r + 1][c] = newValue;
				previousValue = newValue;
				// System.out.print(previousValue+":"+check(testTable[r][c],
				// previousValue)+":"+socialComparison[c]+":"+testTable[r][c]+"\t");
			}
			// System.out.println();

		}
	}

	public String check(double change, double previousValue) {
		if (change == 1 && previousValue > 0)
			return "ig";
		else if (change == 1 && previousValue == 0)
			return "in";
		else if (change == 1 && previousValue < 0)
			return "ib";
		else if (change == 0 && previousValue > 0)
			return "dg";
		else if (change == 0 && previousValue == 0)
			return "dn";
		else
			return "db";
	}

	public double increaseGoodTrust(double previousValue) {
		return round(previousValue + (alpha * (1 - previousValue)));
	}

	public double increaseNeutralTrust(double previousValue) {
		return round(alpha);
	}

	public double increaseBadTrust(double previousValue) {
		
		return round((previousValue + alpha)
				/ (1 - (Math.min(Math.abs(previousValue), Math.abs(alpha)))));
	}

	public double decreaseGoodTrust(double previousValue) {
		return round((previousValue + beta)
				/ (1 - (Math.min(Math.abs(previousValue), Math.abs(beta)))));
	}

	public double decreaseNeutralTrust(double previousValue) {

		
		return round(beta);
	}

	public double decreaseBadTrust(double previousValue) {

		return round(previousValue + (beta * (1 + previousValue)));
	}

	public double[][] getTable() {
		return testTable;
	}

	public double round(double d) {
		d = d *1000;
		d = Math.round(d);
		d = d/1000;
		return d;
	}
}
