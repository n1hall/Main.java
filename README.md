# Main.java
Project Report: JavaScript IDW Interpolation (Assignment 2)

Writing a JavaScript program that solves a grid's missing numbers was the main goal of this assignment.  Inverse Distance Weighting (IDW) is the technique I used.  This method uses known numbers in calculating the missing numbers.

As required by the assignment, I made a class called Main with a particular method. The Name of the Method is idw.  A 2D array of doubles (double[][] data) is the input.  A fresh 2D array with all values filled in is the output.

Managing Data Missing  NaN (Not a Number) is a common Java format for missing numbers.  My code checks the grid which is selected.  It immediately copies a real number such as 1.0 or 5.0 to the new grid.  We do not change values that are known. Identifying the Missing Values the calculation process begins when the code detects a NaN.  In order to identify "neighbours" with actual numbers, it analyses every other cell in the grid.

For Distance Calculation I used the Euclidean Distance formula to find each neighbors distance from the missing cell:
                                   d = √[(x₂ – x₁)² + (y₂ – y₁)²]

The row (a) and column (b) indexes in the code are identified by x and y, as needed.

How to Calculate Weights: The impact of nearby neighbours should be higher compared to that of distant neighbours.  As required by the assignment, I determined the "weight" using the inverse square law (p=2). Weight = 1/distance2

To Complete Calculation, the weighted average formula was used for the final value.  I added each neighbor's value after doubling it by its weight (Numerator). Then calculated each weight (denominator). Numerator / Denominator is a final result. At the end I used the assignment's example grid to test the code inside the main function.
