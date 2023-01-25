import java.util.ArrayList;

// Country Class
public class Country {
    // Stores all the instane fields
    private String countryName;
    private int countryPopulation;
    private int popNotInCities;
    private boolean checkForMegacity;
    private ArrayList<City> cities;

    // Constructor method which takes in the name of the country and population 
    public Country(String nameOfCountry, int populationOfCountry) {
        countryName = nameOfCountry;
        countryPopulation = populationOfCountry;
        cities = new ArrayList<>(); // Array list storing cities, there population and time zone
        checkForMegacity = false; // Initially setting megacity to false
        // If statement to ensure population not in cities is not negative
        if (countryPopulation > 0) {
            popNotInCities = countryPopulation;
        } else {
            popNotInCities = 0;
        }

        // When legal data returns false the population of the country will be set to zero
        if (!this.isLegalData()) {
            countryPopulation = 0;           
        }
    }

    // Add city methos which takes the city name, its population and time zone
    public void addCity(String cityName, int cityPopulation, int cityTimeZone) {
        // Adds each city to array list
        City city = new City(cityName, cityPopulation, cityTimeZone);
        cities.add(city);
        if (city.getMegacity()) { // Checks if city is a megacity or not 
            checkForMegacity = true;
        }
        // Takes away population of people in cities from country's total population
        popNotInCities -= city.getPopulation(); 
    }

    // toString prints the string in a readable way avoiding hex outputs
    public String toString() {
        String output = countryName 
        + ": total population: " 
        + countryPopulation 
        + ", population outside listed cities: " 
        + popNotInCities 
        + ", with cities";
        // for loop iteraates through all the cities and there properties in the arraylist
        for (City city : cities){
            output += "\n" + city.toString();
        }
        return output + "\n";
    }

    // getCityByName method to retrieve cities from a country
    public City getCityByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }

    // deleteCity method that will iterate through the cities array and delete selected city
    public boolean deleteCity(String cityName) {
        for (int i = 0; i< cities.size(); i++) {
            if (cities.get(i).getName().equals(cityName)) {
                popNotInCities += cities.get(i).getPopulation();
                cities.remove(i);
                return true;
            }
        }
        return false;
        
    }

    // isLegalData method returns true if the countries population is greater than zero
    public boolean isLegalData() {
        if (countryPopulation > 0) {
            return true;
        }
        return false;
    }

}   
