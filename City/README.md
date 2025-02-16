# City Management System
## Urban Entity Management Implementation

**Author:** Shimon Esterkin (SemionVlad)  
**Version:** 2023B

## Dependencies
This class requires:
- [Point Class](link-to-point-repository) - For handling geographical coordinates

## Overview
The City class represents an urban entity with geographical and demographic attributes. It provides comprehensive functionality for managing city data, including location coordinates, population statistics, and urban infrastructure information.

## Class Structure
```
City.java
├── Instance Variables
│   ├── _cityName (String)
│   ├── _cityCenter (Point)
│   ├── _centralStation (Point)
│   ├── _numOfResidents (long)
│   └── _noOfNeighborhoods (int)
├── Constructors
│   ├── Full Constructor
│   └── Copy Constructor
└── Methods
    ├── Getters/Setters
    ├── Location Management
    └── Demographic Operations
```

## Features

### 1. Location Management
- City center coordinates tracking
- Central station positioning
- Distance calculations
- Location modification capabilities

### 2. Demographic Data
- Population tracking
- Neighborhood counting
- Population updates
- Data validation

### 3. City Operations
- City comparison
- City duplication
- Station relocation
- Distance calculations

## Usage Examples

### Creating a City
```java
// Create new city
City telaviv = new City("Tel Aviv",    // Name
                       32, 34,         // City center coordinates
                       32, 34,         // Station coordinates
                       460613,         // Population
                       9);             // Neighborhoods

// Create copy of existing city
City telavivCopy = new City(telaviv);
```

### Managing City Data
```java
// Update population
telaviv.addResidents(1000);

// Move central station
telaviv.moveCentralStation(1, -1);

// Calculate distances
double distance = telaviv.distanceBetweenCenterAndStation();

// Create new city based on existing one
City newCity = telaviv.newCity("New Tel Aviv", 5, 5);
```

## Technical Details

### Constraints
- Non-negative population values
- Minimum of 1 neighborhood
- Valid coordinates (through Point class)

### Data Validation
- Population: Automatically corrected to 0 if negative
- Neighborhoods: Automatically corrected to 1 if less
- Deep copying for all object references

## Implementation Notes

### Memory Management
- Deep copies for all object references
- Defensive copying in getters/setters
- Immutable string handling

### Error Handling
- Invalid inputs are corrected to valid values
- Population updates maintain non-negative values
- Coordinate changes respect Point class constraints

## Method Descriptions

### Constructors
- `City(String, int, int, int, int, long, int)` - Creates new city
- `City(City)` - Creates copy of existing city

### Getters/Setters
- `getCityName()`, `setCityName()` - Manage city name
- `getCityCenter()`, `setCityCenter()` - Manage center location
- `getCentralStation()`, `setCentralStation()` - Manage station location
- `getNumOfResidents()`, `setNumOfResidents()` - Manage population
- `getNoOfNeighborhoods()`, `setNoOfNeighborhoods()` - Manage neighborhoods

### Utility Methods
- `equals(City)` - Compares cities
- `moveCentralStation(int, int)` - Relocates station
- `addResidents(long)` - Updates population
- `newCity(String, int, int)` - Creates modified copy
- `distanceBetweenCenterAndStation()` - Calculates distance

## Requirements
- Java Development Kit (JDK)
- Point class implementation

## Testing Guidelines
1. Location Management
   - Coordinate updates
   - Distance calculations
   - Movement operations

2. Demographics
   - Population updates
   - Neighborhood modifications
   - Validation checks

3. Object Operations
   - City copying
   - Equality comparisons
   - New city creation

## Known Limitations
1. Single central station
2. Basic demographic model
3. Limited to 2D coordinates

## Future Enhancements
- Multiple station support
- Advanced demographic tracking
- 3D coordinate support
- Historical data tracking
- Population density calculations

---
*Note: This implementation is part of an educational project demonstrating object-oriented programming concepts in Java.*
