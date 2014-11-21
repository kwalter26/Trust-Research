import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Kyle Walter
 * Project: TrustFuctionTesting
 * Data Created: Nov 21, 2014
 */
public class TestStuff {

	public static void main(String[] args) {
		String[] strs2Check = {"1","0.0","0.0"};
		double d = 0.0325;
		
		System.out.println(round(d));
		
		System.out.println(doubleChecker(strs2Check));
		
		
	}
	public static boolean doubleChecker(String[] strs2Check){
		String regex = "[A-Za-z\\s]";
		
		Pattern checkRegex = Pattern.compile(regex);
		
		for(int i = 0; i < strs2Check.length;i++){
		Matcher regexMatcher = checkRegex.matcher(strs2Check[i]);
			if(regexMatcher.find())
				return false;
		}
		return true;
	}
	public static double round(double d) {
		d = d *1000;
		d = Math.round(d);
		d = d/1000;
		return d;
		
	}
}

