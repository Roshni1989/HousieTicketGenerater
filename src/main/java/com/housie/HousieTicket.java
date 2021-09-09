package com.housie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HousieTicket {


    //no of rows and columns
   private int rows,columns,maxPerRow,maxPerColumn;
//Constructor to create a ticket
    public HousieTicket(int rows, int columns,int maxPerRow, int maxPerColumn) {
        this.rows = rows;
        this.columns = columns;
        this.maxPerRow = maxPerRow;
        this.maxPerColumn = maxPerColumn;
    }

    //random number generate function
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int[][] generateHousieTicket()
    {
        // 2-D array
        int [][] ticket = new int[rows][columns];
        int min=1;
        int max=10;
        //iterate on columns and rows of the table
        //System.out.println("starting ticket generation");
        populateTicketCells(ticket, min, max);

        // remove extra cells from the ticket
        applyFilterConditions(ticket);

        return ticket;
    }

    private void applyFilterConditions(int[][] ticket) {
        Set<Integer> uniqueColumnValues = new HashSet<>();

        for(int k=0;k<rows;k++){
            for(int m=0;m<columns-maxPerRow;m++) {
                int indexCol = -1;
                //System.out.println("finding for kth row: "+k);
                if(k==0) {
                    indexCol = getRandomNumber(0, columns);
                    while (!uniqueColumnValues.add(indexCol)){
                        indexCol = getRandomNumber(0, columns);
                    }
                }else{
                    indexCol = getRandomNumber(0, columns);
                    //System.out.println("check inde: "+indexCol+" in set : "+uniqueColumnValues);
                    while (!uniqueColumnValues.add(indexCol)){
                        if(uniqueColumnValues.size()==columns && ticket[k][indexCol]!=0){
                            //System.out.println("exiting while");
                            break;
                        }
                        //System.out.println(":: check index: "+indexCol+" in set : "+uniqueColumnValues);
                        indexCol = getRandomNumber(0, columns);
                    }
                }
                //System.out.println("removing from kth row: "+k+" for mth cell"+m+" columns : "+indexCol);
                if(indexCol!= -1)
                    ticket[k][indexCol] = 0;
            }
        }
    }

    private void populateTicketCells(int[][] ticket, int min, int max) {
        for(int i=0;i<columns;i++){
            Set<Integer> uniqueColumnValues = new HashSet<>();
            for(int j=0;j<rows;j++)
            {
                // generate random number for given cell
                int result=getRandomNumber(min, max);
                // validate if the result is already present in the column
                while(!uniqueColumnValues.add(result)){
                    result=getRandomNumber(min, max);
                }
                ticket[j][i] =result;
            }
            min +=10;
            max +=10;
        }
    }

}
