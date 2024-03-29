package random;

// Java program to print all combination of size r in an array of size n
import java.io.*;
import java.util.Scanner;

class Combination {
    static int count = 1;

    /* arr[] ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Starting and Ending indexes in arr[]
    index ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(String arr[], String data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            System.out.println("Portfolio "+count++);
            for (int j=0; j<r; j++)
                System.out.println(data[j]+" ");
            System.out.println("\n");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(String arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        String[] data=new String[r];

        // Print all combination using temporary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r);
        System.out.println(data.length);
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) throws FileNotFoundException {

    }
}

/* This code is contributed by Devesh Agrawal */
