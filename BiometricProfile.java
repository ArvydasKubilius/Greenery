package conversion;

/**
 * Object that stores (but doesn't alter) a profile of someone's personal data, specifically
 * fitness-relevant data like age/height/weight/gender
 * 
 * @author Sunshine Regiment
 *
 */
public class BiometricProfile {
	private boolean gender;//false = male, true = female
	private int age;//in years
	private double weight;//in kg
	private double height;//in m
	
	/**
	 * Constructor for a biometric profile. Initialises a range of values.
	 * 
	 * @param age Sets age in years
	 * @param weight Sets weight in kilograms
	 * @param height Sets height in metres
	 * @param gender Sets gender (false = male, true = female)
	 */
	public BiometricProfile(int age, int weight, int height, boolean gender) {
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	/**
	 * Getter for gender
	 * 
	 * @return boolean gender - 0 = male, 1 = female
	 */
	public boolean getGender() {
		return gender;
	}
	
	/**
	 * Getter for age
	 * 
	 * @return age in years
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Getter for weight
	 * 
	 * @return weight in kilograms
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Getter for height
	 * 
	 * @return height in centimetres
	 */
	public double getHeight() {
		return height;
	}
}
