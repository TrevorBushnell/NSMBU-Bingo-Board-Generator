/*
* Insert fancy comment here
*/
import java.util.*;
import java.io.*;
import java.lang.Math;

public class BingoBoard
{
    //Declare private instance variables
    private int[] randomSeeds;
    private ArrayList<String> currentGoals;
    
    //Constructor
    public BingoBoard(ArrayList<String> goals, int[] seeds)
    {
        randomSeeds = seeds;
        currentGoals = goals;
    }


    //Getter functions

    public int[] getSeeds()
    {
        return randomSeeds;
    }

    public ArrayList<String> getGoals()
    {
        return currentGoals;
    }
    
    
    /*
    * PARAMETER: A boolean array representing whether a random number has been selected
    * 
    * POST: Returns an integer array containing the seeds for the goals to be used for the bingo
    */
    

    public void printSeeds(int[] seeds)
    {
        for (int i = 0; i < seeds.length; i++)
        {
            System.out.print(seeds[i] + " ");
        }
    }



    //A standard selection sort algorthim used to sort the randomly generated seeds in numerical order

    public static int[] selectionSort(int[] arr)
    {

        for (int j = 0; j < arr.length - 1; j++)
        {

            int index = j;

            for (int k = j + 1; k < arr.length; k++)
            {

                if (arr[k] < arr[index])
                {
                    index = k;
                }
            }


            int temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }
    



    /*
    * PARAMETER: An ArrayList of Strings containing all of the goals 
    *
    * POST: Generates a random bingo card for Any%. This means that the card that
    * is generated is a card with goals necesarry to complete before beating the
    * game.
    */
    public void generateBingoCard(ArrayList<String> goals) throws FileNotFoundException
    {
        PrintStream out = new PrintStream(new File("BINGOCARD.json"));

        out.println("[");

        for (int i = 0; i < goals.size(); i++)
        {
            out.println("{\"name\": \"" + goals.get(i) + "\""},");
        }

        out.println("]");
    }

}
