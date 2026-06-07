package StudentRegistration;

import java.util.*;

public class TablePrinter {
    public static void printTable(List<String[]> data) {
        int[] widths = new int[data.get(0).length];

        for(String[] row : data) {
            for(int i = 0; i < row.length; i++) {
                widths[i] = Math.max(widths[i], row[i].length());
            }
        }


        for(String[] row : data) {
            
            for(int i = 0; i < row.length; i++) {
                System.out.print("|" + String.format("%-" + widths[i] + "s", row[i]));
            }
            System.out.print("|");
            System.out.println();
        }
    }
}


