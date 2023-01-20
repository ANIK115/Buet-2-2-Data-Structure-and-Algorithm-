package random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        Scanner scan = new Scanner(new File("input.txt"));
        String[] arr = new String[15];
        for(int i=0; i<15; i++)
        {     arr[i] = new String(scan.nextLine());
        }
        int r = 3;
        int n = arr.length;
        Combination.printCombination(arr, n, r);

    }
}
