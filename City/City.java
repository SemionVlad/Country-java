/**
 * The City class represents an urban entity with geographical, demographic, and historical attributes.
 * This class manages city data including location coordinates, population statistics, and establishment dates.
 * It provides comprehensive functionality for city management and information tracking.
 * 
 * The class integrates geographical positioning using the Point class for coordinates
 * and temporal data using the Date class for establishment tracking. It maintains
 * city infrastructure information and population statistics while ensuring data validity.
 * 
 * @author Shimon Esterkin (SemionVlad)
 * @version 2023B
 * 
 */
public class City {

    // Instance variables
    private String _cityName;
    private Point _cityCenter;
    private Point _centralStation;
    private long _numOfResidents;
    private int _noOfNeighborhoods;

    /**
     * Formats a city's information as a string.
     *
     * @param city the city to format
     * @return formatted string containing city details
     */
    private String cityToString() {
        return String.format(
            "City Name: %s\n" +
            "City Center: %s\n" +
            "Central Station: %s\n" +
            "Number of Residents: %d\n" +
            "Number of Neighborhoods: %d\n",
            this._cityName.toString(),
            this._cityCenter.toString(),
            this._centralStation.toString(),
            this._numOfResidents,
            this._noOfNeighborhoods
        );
    }

    /**
     * Constructs a new City with all attributes including establishment date.
     *
     * @param cityName           the name of the city                 year of establishment
     * @param cityCenterX        x-coordinate of city center
     * @param cityCenterY        y-coordinate of city center
     * @param centralStationX    x-coordinate of central station
     * @param centralStationY    y-coordinate of central station
     * @param numOfResidents     number of residents (non-negative)
     * @param noOfNeighborhoods  number of neighborhoods (minimum 1)
     */
    public City(String cityName, int cityCenterX, int cityCenterY, 
                int centralStationX, int centralStationY, long numOfResidents, int noOfNeighborhoods) {
        this._cityName = new String(cityName);
        this._cityCenter = new Point(cityCenterX, cityCenterY);
        this._centralStation = new Point(centralStationX, centralStationY);
        this._noOfNeighborhoods = (noOfNeighborhoods < 1) ? 1 : noOfNeighborhoods;
        this._numOfResidents = (numOfResidents < 0) ? 0 : numOfResidents;
    }

    /**
     * Copy constructor - creates a new City with the same attributes as another City.
     *
     * @param other the City to copy
     */
    public City(City other) {
        this._cityName = other.getCityName();
        this._cityCenter = new Point(other.getCityCenter());
        this._centralStation = new Point(other.getCentralStation());
        this._noOfNeighborhoods = (other.getNoOfNeighborhoods() < 1) ? 1 : other.getNoOfNeighborhoods();
        this._numOfResidents = (other.getNumOfResidents() < 0) ? 0 : other.getNumOfResidents();
    }

    // Getters
    
    /**
     * @return the name of the city
     */
    public String getCityName() {
        return this._cityName;
    }

    /**
     * @return a copy of the city center point
     */
    public Point getCityCenter() {
        return new Point(this._cityCenter);
    }

    /**
     * @return a copy of the central station point
     */
    public Point getCentralStation() {
        return new Point(this._centralStation);
    }

    /**
     * @return the number of residents
     */
    public long getNumOfResidents() {
        return this._numOfResidents;
    }

    /**
     * @return the number of neighborhoods
     */
    public int getNoOfNeighborhoods() {
        return this._noOfNeighborhoods;
    }

    // Setters
    
    /**
     * @param cityName the new name of the city
     */
    public void setCityName(String cityName) {
        this._cityName = new String(cityName);
    }

    /**
     * @param cityCenter the new city center location
     */
    public void setCityCenter(Point cityCenter) {
        this._cityCenter = new Point(cityCenter);
    }

    /**
     * @param centralStation the new central station location
     */
    public void setCentralStation(Point centralStation) {
        this._centralStation = new Point(centralStation);
    }

    /**
     * Sets the number of residents, ensuring it's non-negative.
     *
     * @param numOfResidents the new number of residents
     */
    public void setNumOfResidents(long numOfResidents) {
        this._numOfResidents = (numOfResidents < 0) ? 0 : numOfResidents;
    }

    /**
     * Sets the number of neighborhoods, ensuring it's at least 1.
     *
     * @param noOfNeighborhoods the new number of neighborhoods
     */
    public void setNoOfNeighborhoods(int noOfNeighborhoods) {
        this._noOfNeighborhoods = (noOfNeighborhoods < 1) ? 1 : noOfNeighborhoods;
    }

    // Utility Methods

    public String toString() {
        return cityToString();
    }
    
    /**
     * Checks if this city is equal to another city.
     *
     * @param other the city to compare with
     * @return true if all attributes are equal
     */
    public boolean equals(City other) {
        return this._centralStation.equals(other.getCentralStation()) &&
               this._cityCenter.equals(other.getCityCenter()) &&
               this._cityName.equals(other.getCityName()) &&
               this._numOfResidents == other.getNumOfResidents() &&
               this._noOfNeighborhoods == other.getNoOfNeighborhoods();
    }

    /**
     * Moves the central station by the specified deltas.
     *
     * @param deltaX the change in x-coordinate
     * @param deltaY the change in y-coordinate
     */
    public void moveCentralStation(int deltaX, int deltaY) {
        this._centralStation.move(deltaX, deltaY);
    }

    /**
     * Updates the number of residents while ensuring non-negative value.
     *
     * @param residentsUpdate the change in number of residents
     * @return true if update successful, false if resulted in negative value
     */
    public boolean addResidents(long residentsUpdate) {
        if (this._numOfResidents + residentsUpdate >= 0) {
            this._numOfResidents += residentsUpdate;
            return true;
        }
        this._numOfResidents = 0;
        return false;
    }
    
    /**
     * Creates a new city based on this city with modified location.
     *
     * @param newCityName the name for the new city
     * @param dX the x-coordinate shift
     * @param dY the y-coordinate shift
     * @return a new City object with modified parameters
     */
    public City newCity(String newCityName, int dX, int dY) {
        Point newCityCenter = new Point(this._cityCenter);
        newCityCenter.move(dX, dY);
        
        Point newCentralStation = new Point(this._centralStation);
        newCentralStation.move(dX, dY);
        
        return new City(newCityName, newCityCenter.getX(), newCityCenter.getY(), newCentralStation.getX(), newCentralStation.getY(), 0, 1);
    }

    /**
     * Calculates the distance between city center and central station.
     *
     * @return the Euclidean distance between center and station
     */
    public double distanceBetweenCenterAndStation() {
        return this._cityCenter.distance(this._centralStation);
    }
}
