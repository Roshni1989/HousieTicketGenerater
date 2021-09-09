package com.housie;

import java.util.Arrays;

public class ApplicationHousie {
    public static void main(String[] args) {
        if(args.length !=4){
            throw new IllegalArgumentException("Need 4 arguments => ROWS, COLUMNS, MAX Elements Per ROW and MAX Elements per column");
        }
        try {
            int rows = Integer.parseInt(args[0]);
            int columns = Integer.parseInt(args[1]);
            int maxPerRow = Integer.parseInt(args[2]);
            int maxPerColumn = Integer.parseInt(args[3]);
            HousieTicket housieTicket = new HousieTicket(rows,columns,maxPerRow,maxPerColumn);
            int[][] ticket = housieTicket.generateHousieTicket();
            System.out.println("your housie ticket");
            for(int i=0; i<rows;i++) {
                System.out.println(Arrays.toString(ticket[i]));
            }
        }catch (Exception e){
            System.out.println("Failed to parse aguments to int :: "+e.getCause());
            throw e;
        }



    }

}
