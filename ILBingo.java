/*
* Add fancy schmancy comment here later
*/
import java.util.*;
import java.io.*;

public class ILBingo extends BingoBoard
{
    //Constructor
    public ILBingo(ArrayList<String> goals, int[] seeds)
    {
        super(goals,seeds);
    }
    
    
    public int[] generateSeeds(int[] seeds)
    {

        boolean[] hasBeenUsed = new boolean[95];
        
        for (int i = 0; i < 25; i++)
        {
            int x = (int)(Math.random() * (94)) + 1;
            
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
        Scanner in = new Scanner(new File("NSMBUDXLevels.txt"));
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


    
    
    /*
    * PARAMETER: an int that is the sum of the inputs of the user indicating the
    * character and category of the ILs.
    * 
    * POST: Returns a String to append to the goal describing the character
    * and/or gamemode required in order to complete the challenge
    */
    public String printer(String character, String mode)
    {
        String to_print = " (";
        
        
        //Check for characters
        if (character.equalsIgnoreCase("Mario"))
        {
            to_print = to_print + "Mario";
        }

        else if (character.equalsIgnoreCase("Toadette"))
        {
            to_print = to_print + "Toadette";
        }

        else if (character.equalsIgnoreCase("Nabbit"))
        {
            to_print = to_print + "Nabbit";
        }


        //Check for game mode
        if(mode.equalsIgnoreCase("Any"))
        {
            to_print = to_print + " Any%";
        }

        else if(mode.equalsIgnoreCase("100"))
        {
            to_print = to_print + " 100%";
        }

        to_print = to_print + ")";
        return to_print; //Here only to pass syntax checks
    }
}