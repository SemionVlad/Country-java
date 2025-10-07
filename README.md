# Country Management System (National Urban Data Management and Analysis)

## Author
- **Name**: Shimon Esterkin  
- **ID**: *****2258  
- **Course**: System Programming Laboratory (20465)  
- **Semester**: 2025A


## Dependencies
This class requires the following classes:
- [City Class](link-to-city-repository) - For managing individual cities
- [Point Class](link-to-point-repository) - For handling geographical coordinates (used by City)

## Overview
The Country class provides a comprehensive system for managing and analyzing a collection of cities. It offers functionality for city administration, geographical analysis, and population statistics, with support for up to 1000 cities per country.

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
    ├── Basic Getters
    ├── City Management
    ├── Statistical Methods
    ├── Geographical Methods
    └── Object Methods
```

## Features

### 1. City Management
- Add new cities with:
  - Name
  - City center coordinates
  - Central station coordinates
  - Population
  - Number of neighborhoods
- Unify two existing cities
- Maintain city collection

### 2. Statistical Analysis
- Calculate total country population
- Track number of cities
- Calculate distances between cities

### 3. Geographical Functions
- Find cities north of a reference city
- Identify southernmost city
- Calculate maximum distance between cities

## Usage Examples

### Creating a Country
```java
Country israel = new Country("Israel");
```

### Managing Cities
```java
// Add a new city
israel.addCity("Tel Aviv", 
              32, 34,          // City center coordinates
              32, 34,          // Station coordinates
              460613,          // Population
              9);             // Neighborhoods

// Find northern cities
String northernCities = israel.citiesNorthOf("Tel Aviv");

// Get southernmost city
City southmost = israel.southernmostCity();

// Unify cities
City unifiedCity = israel.unifyCities("Tel Aviv", "Jaffa");
```

## Implementation Details

### City Management
- Maximum 1000 cities per country
- Deep copying of city objects
- Safe city unification process
- Automatic array management

### Geographical Analysis
- Uses Point class for coordinates
- North/south relationship tracking
- Distance calculations between cities
- City center comparisons

### Error Handling
- Bounds checking for city array
- Null checking for city names
- Population validation
- Safe array manipulation

## Method Descriptions

### Basic Operations
- `getCountryName()` - Returns country name
- `getNumCities()` - Returns number of cities
- `getCities()` - Returns deep copy of cities array

### City Management
- `addCity(...)` - Adds new city
- `unifyCities(...)` - Merges two cities

### Analysis
- `getNumOfResidents()` - Total population
- `longestDistance()` - Maximum city distance
- `citiesNorthOf(...)` - Northern cities
- `southernmostCity()` - Southernmost city

## Performance Considerations
- O(1) city addition
- O(n) city searches
- O(n²) distance calculations
- Efficient array management

## Testing Guidelines
1. City Management
   - Adding cities
   - City capacity limits
   - City unification

2. Geographical Analysis
   - North/south relationships
   - Distance calculations
   - City locations

3. Population Statistics
   - Total population
   - Resident counting
   - Demographic updates

## Known Limitations
1. Fixed maximum city capacity (1000)
2. No direct city removal
3. Linear city searches
4. Basic distance calculations

## Future Enhancements
- Dynamic array sizing
- Direct city removal
- Improved search algorithms
- Advanced statistical analysis
- Geographic clustering

## 📄 License
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

---
Created by [SemionVlad](https://github.com/SemionVlad) for academic and portfolio purposes. This repository is intended for **non-commercial**, **educational** sharing only.
