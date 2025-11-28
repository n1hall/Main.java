
public class Main {
    public static void main(String[] args) {
        // The input grid with some missing values (NaN)(example input)
        double[][] data = {
            {1.0, Double.NaN, 3.0},
            {Double.NaN, Double.NaN, 2.0},
            {4.0, 5.0, Double.NaN}
        };

        // The new grid in order to store the result
        double[][] result = idw(data);

        // Loop through each row of the result
        for (int i = 0; i < result.length; i++) {
            // Loop through each column of the result
            for (int j = 0; j < result[0].length; j++) {
                // Printing the value followed by a space
                System.out.print(result[i][j] + " ");
            }
            // Moving to the next line after printing a row
            System.out.println();
        }
    }

    static double[][] idw(double[][] data) {
        // Number of rows in the grid
        int rows = data.length;
        // Number of columns in the grid
        int cols = data[0].length;
        // The new grid to store the result
        double[][] result = new double[rows][cols];

        // Loop through each cell in the grid to find missing values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Checking if the current cell is not missing (not NaN)
                if (!Double.isNaN(data[i][j])) {
                    result[i][j] = data[i][j]; // Keeping known values
                } else {
                    // Sum of weighted values
                    double numerator = 0;
                    // Sum of weights
                    double denominator = 0;

                    // Loop through all other cells to calculate the interpolated value
                    for (int a = 0; a < rows; a++) {
                        for (int b = 0; b < cols; b++) {
                            // Checking if the neighbor cell has a value
                            if (!Double.isNaN(data[a][b])) {
                                // Calculating distance between the target cell and the neighbor
                                double distance = Math.sqrt((i - a) * (i - a) + (j - b) * (j - b));
                                
                                // Calculating weight (inverse distance squared, p=2)
                                double weight = 1.0 / (distance * distance);
                                
                                // Adding to the sums
                                numerator = numerator + weight * data[a][b];
                                denominator = denominator + weight;
                            }
                        }
                    }
                    // Calculating the final interpolated value
                    result[i][j] = numerator / denominator;
                }
            }
        }
        return result; 
    }
}
