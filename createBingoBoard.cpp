#include <string>
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <ctime>
using namespace std;


//Function that fills an entire array with true values
void fillTrue(bool arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        arr[i] = true;
    }
}

//Value swapping algorithm
void swap(int *xp, int *yp)  
{  
    int temp = *xp;  
    *xp = *yp;  
    *yp = temp;  
}  

//Selection sort algorithm
void selectionSort(int arr[], int n)  
{  
    int i, j, min_idx;  
  
    // One by one move boundary of unsorted subarray  
    for (i = 0; i < n-1; i++)  
    {  
        // Find the minimum element in unsorted array  
        min_idx = i;  
        for (j = i+1; j < n; j++)  
        if (arr[j] < arr[min_idx])  
            min_idx = j;  
  
        // Swap the found minimum element with the first element  
        swap(&arr[min_idx], &arr[i]);  
    }  
}

//Function that generates n random numbers and stores them in an array that is sorted numerically
void fillRandomArray(int arr[], int arrSize)
{
    srand(time(NULL));
    
    bool valid[95];
    fillTrue(valid, 95);

    
    for (int j = 0; j < arrSize; j++)
    {
        int n = rand() % 95 + 1;

        if(valid[n-1] == true)
        {
            arr[j] = n;
            valid[n-1] = false;
        }

        else
        {
            j--;
        }
    }

    selectionSort(arr, arrSize);
}



//Main method where the code is executed
int main(int argc, char* argv[])
{
    //Create the streams and variables needed for program to work
    ifstream fin;
    ofstream fout;
    int count = 1;
    int index = 0;
    int randLines[25];
    int mode = 6;
    int character = 6;
    string trash;
    string filename;

    std::cout << "This is the NSMBUDX IL Bingo Board Generator.\nUsing this program, you will be able to create IL Bingo Boards to place into Bingosync." << endl;
    std::cout << "\nType the name of the output file where you would like the bingo board to be stored\nNOTE: Make sure to include the .txt extension in the filename.\nNOTE: make sure to NOT USE SPACES in the filename:" << endl;
    cin >> filename;

    fin.open("NSMBUDXLevels.txt", ios::in);
    fout.open(filename, ios::out);

    while (mode < 1 || mode > 3)
    {
        cout << "What category would you like the Bingo Board to run?\nType 1 for Any%\nType 2 for 100%\nType 3 for random." << endl;
        cin >> mode;

        if (mode < 1 || mode > 3)
        {
            cout << "\nERROR: Please enter a valid number." << endl;
        }
    }
    

    while (character < 1 || character > 4)
    {
        cout << "What chracter would you like to play as?\nType 1 for Mario/Luigi\nType 2 for Toadette\nType 3 for Nabbit (note Nabbit cannot be used in 100%)\nType 4 for random" << endl;
        cin >> character;

        if (character < 1 || character > 4)
        {
            cout<<"\nERROR: Please enter a valid number."<<endl;
        }
    }
    
    //Random mode and random character
    if (mode == 3 && character == 4)
    {
        //Create the random seed
        srand(time(NULL));

        //Create the array of random integers
        fillRandomArray(randLines, 25);

        //Create ints to store the random character and mode
        int randMode = 0;
        int randChar = 0;


        fout << "[" << endl;
    
        for (int j = 1; j <= 96; j++)
        {
            getline(fin, trash);
            randMode = rand() % 2 + 1;
            randChar = rand() % 3 + 1;
        
            if (randLines[index] == count)
            {
                if (randMode == 1 && randChar == 1)
                {
                    fout << trash << " (Any%, Mario)," << endl;
                    index++;
                }

                else if (randMode == 1 && randChar == 2)
                {
                    fout << trash << " (Any%, Toadette)," << endl;
                    index++;
                }

                else if (randMode == 1 && randChar == 3)
                {
                    fout << trash << " (Any%, Nabbit)," << endl;
                    index++;
                }

                else if (randMode == 2 && randChar == 1)
                {
                    fout << trash << " (100%, Mario)," << endl;
                    index++;
                }

                else if (randMode == 2 && randChar == 2)
                {
                    fout << trash << " (100%, Toadette)," << endl;
                    index++;
                }

                else if (randMode == 2 && randChar == 3)
                {
                    fout << trash << " (100%, Nabbit)," << endl;
                    index++;
                }
                
            }

            count++;
        }

        fout << "]" << endl;

        fin.close();
        fout.close();

        std::cout << "Your bingo board has been created! It has been written to " << filename << endl;
    }

    //Random mode but not a random character
    else if (mode == 3 && character != 4)
    {
        //Create the random seed
        srand(time(NULL));

        //Create the array of random integers
        fillRandomArray(randLines, 25);

        //Create ints to store the random character and mode
        int randMode = 0;

        fout << "[" << endl;
    
        for (int j = 1; j <= 96; j++)
        {
            getline(fin, trash);
            randMode = rand() % 2 + 1;
        
            if (randLines[index] == count)
            {
                if (randMode == 1)
                {
                    fout << trash << " (Any%)," << endl;
                    index++;
                }


                else if (randMode == 2)
                {
                    fout << trash << " (100%)," << endl;
                    index++;
                }
                
            }

            count++;
        }

        fout << "]" << endl;

        fin.close();
        fout.close();

        std::cout << "Your bingo board has been created! It has been written to " << filename << endl;
    }

    else if (mode != 3 && character == 4)
    {
        //Create the random seed
        srand(time(NULL));

        //Create the array of random integers
        fillRandomArray(randLines, 25);

        //Create ints to store the random character and mode
        int randChar = 0;

        fout << "[" << endl;
    
        for (int j = 1; j <= 96; j++)
        {
            getline(fin, trash);
            randChar = rand() % 3 + 1;
        
            if (randLines[index] == count)
            {
                if (randChar == 1)
                {
                    fout << trash << " (Mario)," << endl;
                    index++;
                }


                else if (randChar == 2)
                {
                    fout << trash << " (Toadette)," << endl;
                    index++;
                }

                else if (randChar == 3)
                {
                    fout << trash << " (Nabbit)," << endl;
                    index++;
                }
                
            }

            count++;
        }

        fout << "]" << endl;

        fin.close();
        fout.close();

        std::cout << "Your bingo board has been created! It has been written to " << filename << endl;
    }

    else
    {
        //Create the random seed
        srand(time(NULL));

        //Create the array of random integers
        fillRandomArray(randLines, 25);


        fout << "[" << endl;
    
        for (int j = 1; j <= 96; j++)
        {
            getline(fin, trash);
        
            if (randLines[index] == count)
            {
                fout << trash << "," << endl;
                index++;
            }

            count++;
        }

        fout << "]" << endl;

        fin.close();
        fout.close();

        std::cout << "Your bingo board has been created! It has been written to " << filename << endl;
        }
}