# Country Management System
## National Urban Data Management and Analysis

**Author:** Shimon Esterkin (207972258)  
**Version:** Maman14.2023b

## Dependencies
This class requires additional classes that should be included in your project:
- [City Class](link-to-city-repository) - For managing individual cities
- [Point Class](link-to-point-repository) - For handling geographical coordinates (used by City)
- [Date Class](link-to-date-repository) - For managing establishment dates (used by City)

## Overview
The Country class provides a comprehensive system for managing and analyzing a collection of cities within a country. It supports city administration, geographical analysis, and population statistics. The system can handle up to 1000 cities per country.

## Features

### 1. City Management
- Add new cities with full details
- Unify two existing cities
- Track number of cities
- Maintain city information

### 2. Geographic Analysis
- Find cities north of a reference city
- Identify southernmost city
- Calculate maximum distance between cities
- Track city centers and stations

### 3. Statistical Functions
- Calculate total population
- Track number of neighborhoods
- Monitor city growth and changes

## Class Structure
```
Country.java
├── Constants
│   └── MAX_NUM_CITIES (1000)
├── Instance Variables
│   ├── _countryName (String)
│   ├── _cities (City[])
│   └── _noOfCities (int)
└── Method Groups
    ├── Constructors
    ├── Basic Getters
    ├── City Management
    ├── Statistical Methods
    ├── Geographical Methods
    └── Object Methods
```

## Usage Examples

### Creating a Country
```java
Country israel = new Country("Israel");
```

### Adding Cities
```java
israel.addCity("Tel Aviv", 32, 34,    // City center coordinates
               32, 34,                 // Station coordinates
               460613,                 // Population
               9);                     // Neighborhoods

israel.addCity("Jerusalem", 31, 35,    // City center coordinates
               31, 35,                 // Station coordinates
               936425,                 // Population
               15);                    // Neighborhoods
```

### City Analysis
```java
// Find cities north of reference
String northernCities = israel.citiesNorthOf("Tel Aviv");

// Get southernmost city
City southmost = israel.southernmostCity();

// Calculate maximum distance between cities
double maxDist = israel.longestDistance();

// Get total population
long totalPop = israel.getNumOfResidents();
```

### City Unification
```java
// Merge two cities
City unifiedCity = israel.unifyCities("Tel Aviv", "Jaffa");
```

## Implementation Details

### Constraints
1. City Limits
   - Maximum 1000 cities per country
   - Each city must have at least 1 neighborhood
   - Population must be non-negative

2. Data Management
   - Deep copying for object safety
   - Null handling for missing cities
   - Array management for city removal

### Error Handling
- Returns null for non-existent cities
- Returns false when adding to full country
- Validates all numerical inputs

## Testing Recommendations

### 1. Basic Operations
```java
// Test city addition
boolean added = country.addCity(...);
assert country.getNumCities() == 1;

// Test population calculation
long population = country.getNumOfResidents();
assert population >= 0;
```

### 2. Geographic Operations
```java
// Test north/south relationships
String northCities = country.citiesNorthOf("CityName");
City southCity = country.southernmostCity();
```

### 3. City Unification
```java
// Test city merging
City unified = country.unifyCities("City1", "City2");
assert unified != null;
```

## Performance Considerations
- O(1) for adding cities
- O(n) for city searches
- O(n²) for distance calculations
- Efficient memory management with array resizing

## Known Limitations
1. Fixed maximum city capacity (1000)
2. No direct city removal (except through unification)
3. Linear search for city names
4. No support for multiple central stations

## Future Enhancements
- Dynamic array sizing
- Direct city removal capability
- Advanced search capabilities
- Multiple station support
- Population density analysis
- Geographic clustering

## Contributing
1. Fork the repository
2. Create your feature branch
3. Test thoroughly
4. Submit pull request

## License
This project is part of academic coursework at [Your Institution].

---
*Note: This implementation is part of a programming assignment demonstrating object-oriented programming concepts in Java.*
