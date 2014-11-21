


/**
 * @author Kyle Walter
 * Project: TrustFuctionTesting
 * Data Created: Nov 21, 2014
 */
public class TrustFunctionTwo {

	private double[][] testTable = null;
	private double alpha, beta, epsilon, kappa, nu, theta;
	
	@SuppressWarnings("unused")
	private int ROW, COL;

	public TrustFunctionTwo(double[][] table, double a, double b, double e,
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
	}

	public void run() {
		System.out.println(testTable[0][0]);
		double previousValue;
		double newValue = 0.0;

		for (int r = 0; r < testTable.length; r += 2) {
			previousValue = testTable[r + 1][0];
			for (int c = 1; c < testTable[r].length; c++) {
				if (check(testTable[r][c], previousValue) == "igm")
					newValue = increaseAndGoodMaxTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "ig")
					newValue = increaseAndGoodTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "in")
					newValue = increaseAndNeutralTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "ib")
					newValue = increaseAndBadTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "dg")
					newValue = decreaseAndGoodTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "dn")
					newValue = decreaseAndNeutralTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "db")
					newValue = decreaseAndBadTrust(previousValue);
				else if (check(testTable[r][c], previousValue) == "dbm")
					newValue = decreaseAndBadMinTrust(previousValue);
				testTable[r + 1][c] = newValue;
				previousValue = newValue;
				//System.out.print(previousValue+":"+check(testTable[r][c], previousValue)+":"+socialComparison[c]+":"+testTable[r][c]+"\t");

			}
			//System.out.println();
		}
	}

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

	public double increaseAndGoodTrust(double previousValue) {
		return round(previousValue
				+ ((((kappa - theta) / (1 - epsilon - alpha)) * (previousValue - alpha)) + theta));
	}

	public double increaseAndGoodMaxTrust(double previousValue) {
		return round(previousValue
				+ (((kappa / epsilon) * (1 - previousValue - epsilon)) + kappa));
	}

	public double increaseAndNeutralTrust(double previousValue) {
		return round(previousValue + theta);
	}

	public double increaseAndBadTrust(double previousValue) {
		return round(previousValue
				+ ((((theta - nu) / (beta + 1)) * (previousValue + 1)) + nu));
	}

	public double decreaseAndGoodTrust(double previousValue) {

		return round(previousValue
				- ((((nu - theta) / (1 - alpha)) * (previousValue - alpha)) + theta));
	}

	public double decreaseAndNeutralTrust(double previousValue) {

		return round(previousValue - theta);
	}

	public double decreaseAndBadTrust(double previousValue) {

		return round(previousValue
				- ((((theta - kappa) / (beta - epsilon + 1)) * (previousValue
						- epsilon + 1)) + kappa));
	}

	public double decreaseAndBadMinTrust(double previousValue) {

		return round(previousValue - ((kappa / epsilon) * (previousValue + 1)));
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
