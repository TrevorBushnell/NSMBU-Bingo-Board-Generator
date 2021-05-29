/*
* Add fancy schmancy comment here later
*/
import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main
{
    
    
    
    /*
    * POST: runs the entire program and outputs the final card to a .txt file
    * which has content that can be copied into Bingosync.
    */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        int[] randomSeeds = new int[25];
        ArrayList<String> currentGoals = new ArrayList<String>();

        
        //preamble
        System.out.println("\nHello! Welcome to the NSMBUDX Bingo Board Generator! Before I get");
        System.out.println("started, there are a couple of notes that need to be addressed:\n");
        System.out.println("1. This bingo board generator is compatible with both NSMBUDX and");
        System.out.println("NSLUDX, as well as their respective counterparts on the Wii U console.\n");
        System.out.println("2. If you are interested in reading the rules for this project, you");
        System.out.println("can read the file titles \"RULES.md\" which includes all of the rules");
        System.out.println("for both the Normal and IL Bingo variants.\n\n");
        System.out.println("Let's get started with making your custom bingo board! For starters:\n");
        System.out.println("What bingo type are you playing? Type the letter next to the option");
        System.out.println("that you want to play:\n");
        System.out.println("NORMAL BINGO [N]: Standard bingo rules. The first player to complete");
        System.out.println("their row/diagonal/column of objectives wins the game.\n");
        System.out.println("IL BINGO [I]: First player to tie or beat WR for the IL gets to marl");
        System.out.println("the square. First player to get a bingo wins.");

        String bingoType = scan.nextLine();
        boolean flag = false;

        
        //Testing whether the user input is valid
        while(!flag)
        {
            if (bingoType.equalsIgnoreCase("N") || bingoType.equalsIgnoreCase("I"))
            {
                flag = true;
            }

            else
            {
                flag = false;
                System.out.println("ERROR: Please type N for Normal bingo or I for IL bingo");
                bingoType = scan.nextLine();
            }

        }

        
        //Creating a normal bingo board
        if (bingoType.equalsIgnoreCase("N"))
        {
            System.out.println("\nCreating Normal bingo.");

            AnyBingo newBoard = new AnyBingo(currentGoals, randomSeeds);
            newBoard.generateBingoCard(newBoard.generateGoals(newBoard.generateSeeds(newBoard.getSeeds()), newBoard.getGoals()));

            newBoard.printSeeds(newBoard.getSeeds());
        }

        //Creating an IL Bingo board
        else if (bingoType.equalsIgnoreCase("I"))
        {
            System.out.println("\nCreating IL Bingo.");
            ILBingo newBoard = new ILBingo(currentGoals, randomSeeds);
            newBoard.generateBingoCard(newBoard.generateGoals(newBoard.generateSeeds(newBoard.getSeeds()), newBoard.getGoals()));

            
        }

        

        System.out.println("\nBingo board created. You can find the requested bingo board");
        System.out.println("within the file called \"BINGOCARD.txt\"\n");
        System.out.println("Thank you for using this program. If you want to create another");
        System.out.println("bingo card, please re-run the program.");
        System.out.println("\nEnjoy the game! :)\n\n");
    }
}