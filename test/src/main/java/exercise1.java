import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jatin on 12/2/2017.
 */
public class exercise1 {

    public static void findLargestIncreasingSubsequence(Float[] arrA) {
        int[] LIS = new int[arrA.length];
        for (int i = 0; i < arrA.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                // check if previous elements > current element
                if (arrA[i] > arrA[j]) {
                    // update the max from the previous entries
                    if (max == -1 || max < LIS[j] + 1) {
                        max = 1 + LIS[j];
                    }
                }
            }
            if (max == -1) {
                // means none of the previous element has smaller than arrA[i]
                max = 1;
            }
            LIS[i] = max;
        }
        // find the max in the LIS[]
        int result = -1;
        int index = -1;
        for (int i = 0; i < LIS.length; i++) {
            if (result < LIS[i]) {
                result = LIS[i];
                index = i;
            }
        }
        // Print the result
        // Start moving backwards from the end and
        String path =  arrA[index] + " ";
        int res = result-1;
        for (int i = index-1; i >= 0; i--) {
            if(LIS[i]==res){
                path =  arrA[i] + " " + path;
                res--;
            }
        }
        System.out.println("Longest Increasing Subsequence Length: " + result);
        System.out.println("Longest Increasing Subsequence: " + path);
    }



    public static  void main(String args[])
    {

        FileReader freader = null;

        try {
            // Path of EDA.txt file having floating point numbers
            freader = new FileReader("src/main/resources/exercise1/EDA.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        BufferedReader br = new BufferedReader(freader);
        String s;
        List<Float> listOfFloatingPointNumbers= new ArrayList<Float>();

        try {
            int i=0;
            while((s = br.readLine()) != null) {
                listOfFloatingPointNumbers.add(Float.valueOf(s.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            freader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Float[] arrayOfFloatingPointNumbers=listOfFloatingPointNumbers.toArray(new Float[listOfFloatingPointNumbers.size()]);

        findLargestIncreasingSubsequence(arrayOfFloatingPointNumbers);

    }
}
