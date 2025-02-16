# Point Class
## 2D Coordinate System Implementation

**Author:** Shimon Esterkin (SemionVlad)  
**Version:** 2023B

## Overview
The Point class implements a two-dimensional point in a coordinate system with non-negative coordinates. This class provides comprehensive functionality for point manipulation, comparison, and calculations in 2D space.

## Class Structure
```
Point.java
├── Instance Variables
│   ├── _x (private int)
│   └── _y (private int)
├── Constructors
│   ├── Point(int x, int y)
│   └── Point(Point other)
├── Position Methods
│   ├── isAbove()
│   ├── isUnder()
│   ├── isLeft()
│   └── isRight()
└── Utility Methods
    ├── move()
    ├── middle()
    └── distance()
```

## Features
1. **Coordinate Management**
   - Non-negative coordinate validation
   - Getter and setter methods for x and y coordinates
   - Automatic handling of negative input values

2. **Point Comparison**
   - Position comparison (above, below, left, right)
   - Equality checking
   - Distance calculation

3. **Point Manipulation**
   - Movement in 2D space
   - Midpoint calculation
   - Copy construction

## Usage Examples

### Creating Points
```java
// Create a new point at (3,4)
Point p1 = new Point(3, 4);

// Create a copy of p1
Point p2 = new Point(p1);

// Attempt to create point with negative coordinates
Point p3 = new Point(-1, 5); // Will create point (0,5)
```

### Manipulating Points
```java
// Move a point
p1.move(2, -1);

// Calculate midpoint
Point mid = p1.middle(p2);

// Calculate distance
double dist = p1.distance(p2);
```

### Comparing Points
```java
// Position comparisons
boolean isHigher = p1.isAbove(p2);
boolean isToRight = p1.isRight(p2);

// Equality check
boolean areEqual = p1.equals(p2);
```

## Technical Details

### Coordinate System
- Origin at (0,0)
- X-axis extends right (positive)
- Y-axis extends up (positive)
- Integer coordinates only

### Constraints
- All coordinates must be non-negative
- Movement operations preserve non-negative constraint
- Integer arithmetic used for calculations

### Mathematical Operations
- Distance: Euclidean distance formula
- Midpoint: Average of coordinates
- Movement: Addition of delta values

## Method Descriptions

### Constructors
- `Point(int x, int y)` - Creates new point with given coordinates
- `Point(Point other)` - Creates copy of existing point

### Getters/Setters
- `getX()`, `getY()` - Return coordinate values
- `setX(int)`, `setY(int)` - Set coordinate values (if non-negative)

### Position Methods
- `isAbove(Point)` - Checks if point is above another
- `isUnder(Point)` - Checks if point is below another
- `isLeft(Point)` - Checks if point is left of another
- `isRight(Point)` - Checks if point is right of another

### Utility Methods
- `move(int dx, int dy)` - Moves point by given deltas
- `middle(Point)` - Calculates midpoint with another point
- `distance(Point)` - Calculates distance to another point
- `toString()` - Returns string representation "(x,y)"

## Implementation Notes

### Error Handling
- Negative coordinates in constructor convert to 0
- Negative coordinates in setters are ignored
- Invalid movements are ignored

### Performance
- Basic operations are O(1)
- Distance calculations use Math.sqrt()
- String operations create new objects

## Requirements
- Java Development Kit (JDK)
- No external dependencies

## Testing
To test the Point class:
1. Compile: `javac Point.java`
2. Create test cases for each method
3. Verify coordinate constraints
4. Test edge cases with 0 and large numbers

## Known Limitations
1. Integer coordinates only
2. No negative coordinate support
3. Possible integer overflow in calculations
4. Not thread-safe

## Future Enhancements
- Double coordinate support
- Rotation operations
- Scaling operations
- Thread safety implementation
- Additional geometric calculations

---
*Note: This implementation is designed for educational purposes and demonstrates object-oriented programming concepts in Java.*
