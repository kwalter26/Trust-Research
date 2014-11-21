
/**
 * @author Kyle Walter
 * Project: TrustFuctionTesting
 * Data Created: Nov 21, 2014
 */
public interface TrustFunctionInterface {
	public void run();

	public String check(Double change, Double previousValue);

	public Double increaseAndGoodMaxTrust(Double previousValue,Double socialComp);

	public Double increaseAndGoodTrust(Double previousValue,Double socialComp);

	public Double increaseAndNeutralTrust(Double previousValue,Double socialComp);

	public Double increaseAndBadTrust(Double previousValue,Double socialComp);

	public Double decreaseAndGoodTrust(Double previousValue,Double socialComp);

	public Double decreaseAndNeutralTrust(Double previousValue,Double socialComp);

	public Double decreaseAndBadTrust(Double previousValue,Double socialComp);

	public Double decreaseAndBadMinTrust(Double previousValue,Double socialComp);

	public void setSocialTrustPercentages(Double[][] testTable);
	
	public Double[][] getTable();

}
