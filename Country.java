/**
 * Represents a country and manages its collection of cities.
 * Provides functionality for city management, statistical calculations,
 * and geographical comparisons between cities.
 *
 * @author Shimon.Esterkin207972258
 * @version Maman14.2023b
 */
public class Country {
    
    // ------------------ Constants ------------------
    private static final int MAX_NUM_CITIES = 1000;

    // ------------------ Instance Variables ------------------
    private String _countryName;
    private City[] _cities;
    private int _noOfCities;

    // ------------------ Constructors ------------------
    /**
     * Constructs a new Country with the given name.
     *
     * @param countryName the name of the country
     */
    public Country(String countryName) {
        this._countryName = new String(countryName);
        this._cities = new City[MAX_NUM_CITIES];
        this._noOfCities = 0;
    }

    // ------------------ Basic Getters ------------------
    /**
     * Gets the name of the country.
     *
     * @return the country name
     */
    public String getCountryName() {
        return this._countryName;
    }

    /**
     * Gets the number of cities in the country.
     *
     * @return the number of cities
     */
    public int getNumCities() {
        return this._noOfCities;
    }

    /**
     * Returns a deep copy of the cities array containing only populated elements.
     *
     * @return array of cities in this country
     */
    public City[] getCities() {
        City[] citiesCopy = new City[this._noOfCities];
        for (int i = 0; i < this._noOfCities; i++) {
            citiesCopy[i] = new City(this._cities[i]);
        }
        return citiesCopy;
    }

    // ------------------ City Management Methods ------------------
    /**
     * Adds a new city to the country if space is available.
     *
     * @param cityName city name
     * @param cityCenterX x-coordinate of city center
     * @param cityCenterY y-coordinate of city center
     * @param centralStationX x-coordinate of central station
     * @param centralStationY y-coordinate of central station
     * @param numOfResidents number of residents
     * @param noOfNeighborhoods number of neighborhoods
     * @return true if city was added successfully, false if country is at capacity
     */
    public boolean addCity(String cityName, int cityCenterX, int cityCenterY, 
                         int centralStationX, int centralStationY, 
                         long numOfResidents, int noOfNeighborhoods) {
        if (this._noOfCities < MAX_NUM_CITIES) {
            City newCity = new City(cityName, cityCenterX, cityCenterY,
                                  centralStationX, centralStationY,
                                  numOfResidents, noOfNeighborhoods);
            this._cities[this._noOfCities++] = new City(newCity);
            return true;
        }
        return false;
    }

    /**
     * Unifies two cities into a new merged city.
     * The merged city will:
     * - Combine the names of both cities
     * - Sum the populations and neighborhoods
     * - Average the city centers
     * - Use the leftmost central station
     * - Remove the second city from the array
     *
     * @param cityName1 name of first city
     * @param cityName2 name of second city
     * @return the unified city, or null if either city not found
     */
    public City unifyCities(String cityName1, String cityName2) {
        // Find indices of both cities
        int index1 = -1;
        int index2 = -1;

        // Validate input
        if (cityName1 == null || cityName2 == null) {
            return null;
        }

        // Single pass to find both cities
        for (int i = 0; i < this._noOfCities; i++) {
            if (this._cities[i].getCityName().equals(cityName1)) {
                index1 = i;
            } else if (this._cities[i].getCityName().equals(cityName2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                break;
            }
        }

        // Return null if either city not found
        if (index1 == -1 || index2 == -1) {
            return null;
        }

        // Determine which index to keep based on population or position
        int keepIndex, removeIndex;
        if (this._cities[index1].getNumOfResidents() == this._cities[index2].getNumOfResidents()) {
            keepIndex = index1;
            removeIndex = index2;
        } else {
            keepIndex = Math.min(index1, index2);
            removeIndex = Math.max(index1, index2);
        }

        // Create a new city for the unified result
        City unifiedCity = new City(this._cities[keepIndex]);

        // Update unified city properties
        unifiedCity.setCityName(cityName1 + "-" + cityName2);
        unifiedCity.setNumOfResidents(this._cities[index1].getNumOfResidents() + 
                                     this._cities[index2].getNumOfResidents());
        unifiedCity.setNoOfNeighborhoods(this._cities[index1].getNoOfNeighborhoods() + 
                                        this._cities[index2].getNoOfNeighborhoods());

        // Calculate and set new city center
        Point newCenter = this._cities[index1].getCityCenter().middle(
                         this._cities[index2].getCityCenter());
        unifiedCity.setCityCenter(newCenter);

        // Determine and set central station location
        if (this._cities[removeIndex].getCentralStation().isLeft(
            this._cities[keepIndex].getCentralStation())) {
            unifiedCity.setCentralStation(this._cities[removeIndex].getCentralStation());
        }

        // Update the cities array by removing the second city
        for (int i = removeIndex; i < this._noOfCities - 1; i++) {
            this._cities[i] = this._cities[i + 1];
        }
        this._cities[this._noOfCities - 1] = null; // Clear the last reference
        this._noOfCities--;

        // Return a copy of the unified city
        return unifiedCity;
    }

    // ------------------ Statistical Methods ------------------
    /**
     * Calculates the total number of residents in all cities.
     *
     * @return total number of residents in the country
     */
    public long getNumOfResidents() {
        long totalResidents = 0;
        for (int i = 0; i < this._noOfCities; i++) {
            totalResidents += this._cities[i].getNumOfResidents();
        }
        return totalResidents;
    }
    
    /**
     * Finds the longest distance between any two city centers in the country.
     *
     * @return the maximum distance between any two cities, 0 if less than 2 cities exist
     */
    public double longestDistance() {
        if (this._noOfCities < 2) {
            return 0;
        }

        double maxDistance = 0;
        int left = 0;
        int right = this._noOfCities - 1;

        while (left <= right) {
            maxDistance = this._cities[left].getCityCenter().distance(this._cities[right].getCityCenter());

            double leftNextDistance = this._cities[left + 1].getCityCenter().distance(this._cities[right].getCityCenter());
            if (maxDistance < leftNextDistance) {
                maxDistance = leftNextDistance;
                left++;
            }

            double rightPrevDistance = this._cities[left].getCityCenter().distance(this._cities[right - 1].getCityCenter());
            if (maxDistance < rightPrevDistance) {
                maxDistance = rightPrevDistance;
                right--;
            }
        }
        return maxDistance;
    }
    
    // ------------------ Geographical Methods ------------------
    /**
     * Finds all cities that are north of the specified city.
     *
     * @param cityName name of the reference city
     * @return formatted string listing all cities north of the specified city
     */
    public String citiesNorthOf(String cityName) {
        StringBuilder result = new StringBuilder();
        int targetCityIndex = -1;

        // Find target city
        for (int i = 0; i < this._noOfCities; i++) {
            if (this._cities[i].getCityName().equals(cityName)) {
                targetCityIndex = i;
                break;
            }
        }

        if (targetCityIndex == -1) {
            return "There is no city with the name " + cityName;
        }

        Point targetCenter = this._cities[targetCityIndex].getCityCenter();
        boolean foundNorthernCity = false;

        int left = 0;
        int right = this._noOfCities - 1;

        result.append("The cities north of ").append(cityName).append(" are:\n\n");

        while (left <= right) {
            if (left != targetCityIndex && 
                this._cities[left].getCityCenter().isAbove(targetCenter)) {
                result.append(this._cities[left].toString());
                foundNorthernCity = true;
            }
            left++;

            if (left > right) break;

            if (right != targetCityIndex && 
                this._cities[right].getCityCenter().isAbove(targetCenter)) {
                result.append(this._cities[right].toString());
                foundNorthernCity = true;
            }
            right--;
        }

        return foundNorthernCity ? 
               result.toString() : 
               "There are no cities north of " + cityName;
    }
    
    /**
     * Finds the southernmost city in the country.
     *
     * @return the southernmost city, or null if no cities exist
     */
    public City southernmostCity() {
        if (this._noOfCities == 0) {
            return null;
        }

        City southernmost = this._cities[0];
        for (int i = 1; i < this._noOfCities; i++) {
            if (this._cities[i].getCityCenter().isUnder(southernmost.getCityCenter())) {
                southernmost = this._cities[i];
            }
        }
        return southernmost;
    }
    
    // ------------------ Object Methods ------------------
    /**
     * Returns a string representation of the country.
     *
     * @return formatted string representation of the country
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Cities of ").append(this._countryName).append(":\n\n");

        for (int i = 0; i < this._noOfCities; i++) {
            result.append(this._cities[i].toString());
            if (i < this._noOfCities - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }
}
