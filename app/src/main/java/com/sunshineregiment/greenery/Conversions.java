package com.sunshineregiment.greenery;

import com.sunshineregiment.greenery.CalculateStep.CalculateStep;

/**
 * Converts from steps and car type (petrol/diesel) to other information about journey
 * e.g. distance travelled, calories spent, co2 emissions saved
 *
 * @author Sunshine Regiment
 */

public class Conversions {

    private boolean diesel;//flag: true = diesel, false = petrol
    private int steps;//no units
    private double distance;//km
    private double fuel;//liter
    private double calories;//kcal
    private double co2;//gram
    private double treedays;//co2 absorbed by a tree in one day
    private BiometricProfile profile;//data about the person (age, height, weight, gender)

    /**
     * Method for filling in attribute values
     * <p>
     * Extrapolates from known data (i.e. steps) to estimate values for distance, co2 saved, etc.
     * Also acts as a wrapper for convertDiesel() and convertPetrol()
     */
    public void convert() {
        //estimate the number of steps taken to travel 1 km, based on height & gender
        double steps_per_km = CalculateStep.step(profile);
        distance = steps / steps_per_km;
		
		//estimate the number of calories used per step
		calories = steps * Calories.calsPerStep(profile, steps_per_km);

        //based on engine type, the other calculations
        if (diesel)
        {
            convertDiesel();
        }
        else
        {
            convertPetrol();
        }
    }

    /**
     * Diesel-based conversion extension
     * <p>
     * Converts from distance in km to fuel required, co2 emissions prevented and tree-days saved
     */
    private void convertDiesel() {
        //16.95km per liter for diesel engines, on average (cars manufactured in 2008)
        fuel = distance / 16.95;
        //2.68 kg of co2 per liter of diesel => 2680g of co2 per liter of diesel
        co2 = fuel * 2680;
        //60g of co2 per tree per day
        treedays = co2 / 60;
    }
    
    /**
	 * Petrol-based conversion extension
	 * 
	 * Converts from distance in km to fuel required, co2 emissions prevented and tree-days saved
	 */
	private void convertPetrol(){
		//14.3km per liter for petrol engines, on average (cars manufactured in 2008)
		fuel = distance/14.3;
		//2.68 kg of co2 per liter of diesel => 2680g of co2 per liter of diesel
		co2 = fuel * 2680;
		//60g of co2 per tree per day
		treedays = co2/60;
	}

    /**
     * Constructor for 'Converter'
     * <p>
     * Initialises values & runs 'convert()'
     *
     * @param stepsTaken total steps taken
     * @param dieselCar  type of car engine (true = diesel, false = petrol)
     */
    public Conversions(int stepsTaken, BiometricProfile profile, boolean dieselCar) {
        steps = stepsTaken;
        this.profile = profile;
        diesel = dieselCar;
        convert();
    }

    /**
     * Setter for 'steps'
     *
     * @param stepsTaken Number of steps taken
     */
    public void set(int stepsTaken) {
        steps = stepsTaken;
        convert();
    }

    /**
     * Getter for distance travelled
     *
     * @return Distance travelled (in km)
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Getter for steps taken
     *
     * @return Steps taken
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Getter for calories burnt
     *
     * @return Calories burnt (in kcal)
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Getter for fuel saved
     *
     * @return Fuel saved (in litres)
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * Getter for CO2 emissions prevented
     *
     * @return CO2 emissions prevented (in grams)
     */
    public double getCO2() {
        return co2;
    }

    /**
     * A tree captures ~60g of CO2 per day, so every 60g of emissions prevented is the
     * equivalent of a tree absorbing CO2 for that day.
     *
     * @return Number of trees worth of CO2 reduction you've done today.
     */
    public double getTreeDays() {
        return treedays;
    }

}


