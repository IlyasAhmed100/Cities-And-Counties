// City class
public class City {
    // Stores all the instance fields and any final variables
    private String name;
    private int population;
    private int timezone;
    private boolean megacity;
    private final int timzoneLeast = -12;
    private final int timezoneGreatest = 11;
    private final int megacityValue = 10000000;

    // timeDifference method returns time difference between given cities
    public int timeDifference(City city1) {
        return this.timezone - city1.timezone;
    }
    
    // Constructor method whoch takes in the name of city, its population and time zone
    public City(String cityName, int cityPopulation, int cityTimeZone) {
        this.name = cityName;
        this.population = cityPopulation;
        this.timezone = cityTimeZone;

        // When legal data returns flase, the population and timezone of the city is set to zero
        if (!this.isLegalData()) {
            population = 0;
            timezone = 0;           
        }

        // If the city population is greater than 10 million megacity will be true
        if (this.population >= megacityValue) {
            megacity = true;
        } else {
            megacity = false;
        }
    }

    // toString prints the string in a readable way avoiding hex outputs
    public String toString() {
        return name 
        + ": has population " 
        + population 
        + " and is in time zone " 
        + Integer.toString(timezone) // Converts timezone integer to string to print in a string
        + ". It IS " 
        + ((megacity)? "": "NOT ") // If megacity is false, NOT is printed or its an empty string
        + "a megacity";
    }

    // Gets name from private name
    public String getName() {
        return name;
    }

    // Gets population from private population 
    public int getPopulation() {
        return population;
    }

    // Gets megacity from private megacity
    public boolean getMegacity() {
        return megacity;
    }

    // isLegalData returns true when requirements for population and timezone are met 
    public boolean isLegalData() {
        if (population > 0 && timezone >= timzoneLeast && timezone <= timezoneGreatest){
            return true;
        }
        return false;
    }
}
