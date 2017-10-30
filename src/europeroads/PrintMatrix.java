/* CLASS:  PrintMatrix         used by PROJECT:  EuropeRoads
 * AUTHOR: DREW RAUTENBERG             DESIGNED BY:  Dr. Kaminski
 * ----------------------------------------------------------------------------
 * NOTE: Shows passing a file as a parameter.  This is needed because the file
 *      is OPENED in one method (main), but then WRITTEN to in another method,
 *      printToFile (here in this class).
 * NOTE:  Because there's file I/O in this class, need to import java.io.*
 * NOTE:  Because printToFile method does file I/O, need throws IOException
 *      for that method header.
 *****************************************************************************/
package europeroads;

import java.io.*;

public class PrintMatrix {

    public static void printToScreen(String[] abbr, int[][] dist) {
        System.out.print("     ");                              // HEADER LINE
        for (int i = 0; i < abbr.length; i++)
            System.out.printf("%5s",abbr[i]);
        System.out.println();
        // DETAIL LINES
        for (int row = 0; row < dist.length; row++) {
            System.out.printf("%5s",abbr[row]);
            for (int col = 0; col < dist[0].length; col++)
                System.out.printf("%5d",dist[row][col]);
            System.out.println();
        }
    }
    //----------------------------------------------------------------------
    public static void printToFile(String[] abbr, int[][] dist,
                                   PrintWriter file)     throws IOException {

       file.print("     ");                              // HEADER LINE
        for (int i = 0; i < abbr.length; i++)
            file.printf("%5s",abbr[i]);
        file.println();
        // DETAIL LINES
        for (int row = 0; row < dist.length; row++) {
            file.printf("%5s",abbr[row]);
            for (int col = 0; col < dist[0].length; col++)
                file.printf("%5d",dist[row][col]);
            file.println();
        }
    }
}