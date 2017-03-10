/**
 * 
 */
package conversion;

public class CalculateStep {
	public CalculateStep() {
	
	}
	/**
	 * To calculate how many steps of a person per km                        
	 * according to their height and gender.
	 * 
	 * Based on the stride length(length of each step).
	 * Formula: Women .413 * height / Men .415 * height
	 * 
	 * @param  height, gender.         
	 * @return number of steps.
	 */
	public static int step (int height, boolean gender){
		int step = 0;
		double stride_length = 0;
		
		if (gender) {
			stride_length = 0.413 * height;
			//convert to km
			stride_length /= 100000;
			//System.out.println("stride_length: " + stride_length);
		} else {
			stride_length = 0.415 * height;
			//convert to km
			stride_length /= 100000;
			System.out.println("stride_length: " + stride_length);
		} 
		step = (int)Math.round(1/stride_length);
		
		return step;
	}
}

