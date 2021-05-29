/*
* Add fancy schmancy comment here later
*/
import java.util.*;
import java.io.*;

public class AnyBingo extends BingoBoard
{

    //Constructor
    public AnyBingo(ArrayList<String> goals, int[] seeds)
    {
        super(goals, seeds);
    }


    public int[] generateSeeds(int[] seeds)
    {

        boolean[] hasBeenUsed = new boolean[132];
        
        for (int i = 0; i < 25; i++)
        {
            int x = (int)(Math.random() * (131)) + 1;
            
            if (hasBeenUsed[x] == true)
            {
                i--;
            }

            else
            {
                seeds[i] = x;
                hasBeenUsed[x] = true;
            }
        }

        int[] to_return = selectionSort(seeds);
        return to_return;
    }
    
    
    
    /*
    * PARAMETERS: A sorted integer array of randomly generated seeds, an ArrayList of Strings
    * where the goals will be stored
    * 
    * POST: Reads goals from an input file and writes them to an ArrayList
    */
    
    
    public ArrayList<String> generateGoals(int[] seeds, ArrayList<String> goals) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("NSMBUDXGoals.txt"));
        int line = 1;
        int index = 0;
        String temp = "";

        while (in.hasNextLine())
        {
            temp = in.nextLine();
            
            if (seeds[index] == line)
            {
                goals.add(temp);
                index++;
            }

            line++;

            if (index >= 25)
            {
                break;
            }
        }

        return goals;
    }
    
}