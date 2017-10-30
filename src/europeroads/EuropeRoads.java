/* PROJECT:  EuropeRoads
 * AUTHOR:  DREW RAUTENBERG             DESIGNED BY:  Dr. Kaminski
 * DESCRIPTION:  This is creates a 2-D matrix of road distances between major
 *      cities in Europe, based on raw data in 2 files.  The completed matrix
 *      is printed to a file and to the Console window.
 * INPUT FILE #1:  RawNameData.txt
 *      - 1st line contains N (i.e., the number of records to follow)
 *      - rest of records contain:   cityName - abbreviation
 *      - NOTE:  assume no errors in data file
 * INPUT FILE #2:  RawDistanceData.txt
 *      - contains records of the form:  cityANum cityBNum distance
 *          where we'll assume that the city numbers correspond to the cities
 *          in the RawNameData file, starting with 0 (not 1).
 *          So Amsterdam is city number 0 . . .
 *                  and Warsaw is city number 18
 *      - Assume all are "2-way roads" with distance B-to-A = distance A-to-B.
 *      - NOTE:  There aren't necessarily roads between all pairs of cities.
 *      - NOTE:  assume no errors in data file
 * OUTPUT FILE:  DistanceMatrix.txt
 *      A nicely printed (with city abbreviations for labels) distance matrix.
 * OTHER OUTPUT (to screen):  same matrix file.
 * ----------------------------------------------------------------------------
 * NOTE: Shows passing a file as a parameter.  This is needed because the file
 *      is OPENED in one method (here in main), but then WRITTEN to in the
 *      called method (printToFile).
 *****************************************************************************/
package europeroads;
import java.io.*;
import java.util.Scanner;

public class EuropeRoads {

    public static void main(String[] args) throws IOException {
        //-------------------------------------------------------- OPEN 3 FILES      
        File rawNameFile = new File("RawNameData.txt");
        Scanner nameFile = new Scanner(rawNameFile);

        Scanner distFile = new Scanner(new File("RawDistanceData.txt"));

        PrintWriter outFile = new PrintWriter("DistanceMatrix.txt");
        //--------------------------------------- INTERNAL STORAGE DECLARATIONS
        String strN = "";
        int n = 0;
        // Before declaring arrays, need to read in n from RawNameData file,
        //      so you know arrays' sizes

        // WRITE CODE HERE to get n




//        String[] name = new String[n];           // don't need to store names
        String[] abbr = new String[n];
        int[][] distance = new int[abbr.length][abbr.length];

        //----------------------------------------------- FILL ARRAYS WITH DATA
        // step 1 - fill abbr array with data from RawNameData file
        //      INSIDE-OUT DESIGN HELP:
        //      A) for a SINGLE record, do this:
        //          1) read a single line from the file
        //          2) split it into 2 fields (though we don't care about name)
        //          3) store abbreveviation in the array in spot [i]
        //      B) THEN, this single-record handling needs to be inside a LOOP
        //          for handling ALL data in RawNameData file

        // VARIABLES NEEDED:
        String line;
        String[] field= new String[5];     // though only need 2 for this part
        String abbreviation;

        // WRITE CODE HERE to do fill abbr array





        // -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
        // step 2a - initialize matrix with all -1's
        //      (the diagonal & good road data will overwrite some values below)
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                distance[row][col] = -1;
        // -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
        // step 2b - initialize matrix's diagonal to 0's
        for (int i = 0; i < n; i++)
            distance[i][i] = 0;
        // -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
        // step 2c - load file's data into matrix into BOTH TRIANGLES
        //      INSIDE-OUT DESIGN HELP:
        //      A) for a SINGLE record, do this:
        //          1) read the record into line
        //          2) split it into 3 parts
        //          3) store 3 fields in cityA cityB miles
        //                      (after converting to int's)
        //          4) store miles in matrix in spots   [cityA][cityB]
        //                                      AND     [cityB][cityA]
        //      B) THEN, this single-record handling needs to be inside a LOOP
        //          to handle ALL the records in RawDistanceData file

        // VARIABLES NEEDED:  and just re-use line and field array from above
        int cityA;
        int cityB;
        int miles;

        // WRITE CODE HERE  to do step 2c





        // ------------------------------------------------------- PRINT MATRIX
        PrintMatrix.printToScreen(abbr,distance);
        PrintMatrix.printToFile(abbr,distance,outFile);
        // -------------------------------------------------------- CLOSE FILES
        nameFile.close();
        distFile.close();
        outFile.close();
    }
}