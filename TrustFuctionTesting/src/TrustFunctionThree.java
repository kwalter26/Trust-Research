import java.text.DecimalFormat;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class TrustFunctionThree {

	private double[][] testTable = null;
	private double alpha, beta, epsilon, kappa, nu, theta;
	private int ROW, COL;
	private double[] socialComparison;

	public TrustFunctionThree(double[][] table, double a, double b, double e,
			double k, double n, double t) {
		testTable = table;
		alpha = a;
		beta = b;
		epsilon = e;
		kappa = k;
		nu = n;
		theta = t;
		ROW = testTable.length;
		COL = testTable[0].length;
		socialComparison = new double[COL];
	}

	/**
	 * Trust Function is run by first checking which function to use. This
	 * function will loop through each of the increment/decrement represented by
	 * 1 and 0 which are found in every other row starting at 0 and ending at
	 * 199. Then newValue us placed in testTable array in every other row 1-200
	 * underneath the increment/decrement value.
	 */
	public void run() {
		System.out.println(testTable[0][0]);
		double previousValue;
		double newValue = 0.0;
		setSocialTrustPercentages(testTable);
		System.out.println();
		for (int r = 0; r < testTable.length; r += 2) {
			previousValue = testTable[r + 1][0];
			for (int c = 1; c < testTable[r].length; c++) {
				if (check(testTable[r][c], previousValue) == "igm")
					newValue = increaseAndGoodMaxTrust(previousValue,
							socialComparison[c]);
				else if (check(testTable[r][c], previousValue) == "ig")
					newValue = increaseAndGoodTrust(previousValue,
							socialComparison[c]);
				else if (check(testTable[r][c], previousValue) == "in")
					newValue = increaseAndNeutralTrust(previousValue,
							socialComparison[c]);
				else if (check(testTable[r][c], previousValue) == "ib")
					newValue = increaseAndBadTrust(previousValue,
							socialComparison[c]);
				else if (check(testTable[r][c], previousValue) == "dg")
					newValue = decreaseAndGoodTrust(previousValue,
							socialComparison[c]);
				else if (check(testTable[r][c], previousValue) == "dn")
					newValue = decreaseAndNeutralTrust(previousValue,
							socialComparison[c]);
				else if (check(testTable[r][c], previousValue) == "db")
					newValue = decreaseAndBadTrust(previousValue,
							socialComparison[c]);
				else if (check(testTable[r][c], previousValue) == "dbm")
					newValue = decreaseAndBadMinTrust(previousValue,
							socialComparison[c]);
				//System.out.print(previousValue+":"+check(testTable[r][c], previousValue)+":"+socialComparison[c]+":"+testTable[r][c]+"\t");
				testTable[r + 1][c] = newValue;
				previousValue = newValue;
			}
			//System.out.println();
		}
	}

	/**
	 * Takes in change equal to 0 or 1 and previous value to check which
	 * function should be used on the overall trust value.
	 */
	public String check(double change, double previousValue) {
		if (change == 1.0) {
			if (previousValue > alpha && previousValue > (1 - epsilon))
				return "igm";
			else if (previousValue > alpha && previousValue <= (1 - epsilon))
				return "ig";
			else if (previousValue <= alpha && previousValue >= beta)
				return "in";
			else
				return "ib";
		} else {
			if (previousValue > alpha)
				return "dg";
			else if (previousValue <= alpha && previousValue >= beta)
				return "dn";
			else if (previousValue < beta && previousValue >= (epsilon - 1))
				return "db";
			else
				return "dbm";
		}
	}

	public double increaseAndGoodTrust(double previousValue, double socialComp) {
		return round(previousValue
				+ ((1 - socialComp)
						* ((((kappa - theta) / (1 - epsilon - alpha)) * (previousValue - alpha)) + theta)));
	}

	public double increaseAndGoodMaxTrust(double previousValue,
			double socialComp) {
		return round(previousValue
				+ ((1 - socialComp)
						* (((kappa / epsilon) * (1 - previousValue - epsilon)) + kappa)));
	}

	public double increaseAndNeutralTrust(double previousValue,
			double socialComp) {
		return round(previousValue + ((1 - socialComp) * theta));
	}

	public double increaseAndBadTrust(double previousValue, double socialComp) {
		return round(previousValue
				+ ((1 - socialComp)
						* ((((theta - nu) / (beta + 1)) * (previousValue + 1)) + nu)));
	}

	public double decreaseAndGoodTrust(double previousValue, double socialComp) {

		return round(previousValue
				- (socialComp
						* ((((nu - theta) / (1 - alpha)) * (previousValue - alpha)) + theta)));
	}

	public double decreaseAndNeutralTrust(double previousValue,
			double socialComp) {

		return round(previousValue - (socialComp * theta));
	}

	public double decreaseAndBadTrust(double previousValue, double socialComp) {

		return round(previousValue
				- (socialComp
						* ((((theta - kappa) / (beta - epsilon + 1)) * (previousValue
								- epsilon + 1)) + kappa)));
	}

	public double decreaseAndBadMinTrust(double previousValue, double socialComp) {

		return round(previousValue
				- (socialComp * ((kappa / epsilon) * (previousValue + 1))));
	}

	public void setSocialTrustPercentages(double[][] table) {
		System.out.println("Length of table " + table.length + " and "
				+ table[0].length);
		
		for (int col = 1; col < 1001; col++) {
			double counter = 0.0;
			for (int row = 0; row < 200; row += 2) {
				counter = counter + table[row][col];
			}
			socialComparison[col] = counter / (table.length/2);
		}
	}

	public double[][] getTable() {
		return testTable;
	}

	public double round(double d) {
		if(d > -0.032 && d < -0.033)
			System.out.println(d);
		d = d *1000;
		d = Math.round(d);
		d = d/1000;
		return d;
	}

}
