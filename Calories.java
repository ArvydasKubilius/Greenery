package conversion;

/**
 * Estimates calories spent per step, based on biometric data
 * 
 * @author Sunshine Regiment
 *
 */
public final class Calories {
	//base conversion factor
	private final static double steps_conv = 0.0000004f;
	
	/**
	 * Calculates various calories-related values for a given biometric profile
	 * @param profile Data about the person whose BMR we're calculating
	 * @return BMR
	 */
	public static double BaseMetabolicRate(BiometricProfile profile){
		//calculates Base Metabolic Rate, this is needed to calculate calories per step, and see how active the person is
		//gender: men = false, women = true
		//weight in kg
		//age in years
		//height in m
		double height = profile.getHeight();
		double weight = profile.getWeight();
		int age = profile.getAge();
		boolean gender = profile.getGender();
		double BMR;
		if (gender){
			//for women
			BMR = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
		  
		}
		else {
			//for men
			BMR = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
		}
		return BMR;
	}
  
	/**
	 * Calculates Recommended Daily Allowance of calories, based on personal data
	 * @param profile Data about the user that is used to make estimates
	 * @return RDA
	 */
	public static double dailyCalAllowed(BiometricProfile profile){
		//Sex men = true, women = false
		//weight in kg
		//age in years
		//height in metres
		//RDA estimate in kcals
		return 1.375 * BaseMetabolicRate(profile);
		
	}
	
	/**
	 * Calculates the approx. calories used per step taken by the user
	 * @param profile Personal data of the user
	 * @param steps_per_km Step length data
	 * @return Calroies per step taken
	 */
	public static double calsPerStep(BiometricProfile profile, double steps_per_km){
		return profile.getWeight() * steps_per_km * steps_conv;
	}
}