package missingnumbergame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MissingNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements you want to input: ");
        int seriesSize = scanner.nextInt();
        
        if (seriesSize <= 1) {
            System.out.println("Invalid input. The number of elements should be greater than one.");
        }else{
            int[] series = new int[seriesSize];
            System.out.println("Enter a series of (" + seriesSize + ") numbers:");
            for (int i = 0; i < seriesSize; i++) {
                series[i] = scanner.nextInt();
            }
            
            findMissingNumbers(series);
        }
    }

    private static void findMissingNumbers(int[] series) {
        Set<Integer> missingNumbers = new HashSet<>();
        Arrays.sort(series);
                
        for (int i = series[0], j = 0; i <= series[series.length-1]; i++) {
            if (i != series[j]) {
                missingNumbers.add(i);
            }else{
                j++;
            }
        }

        if (missingNumbers.isEmpty()) {
            System.out.println("None, the series is complete.");
        }else{
            System.out.println("Missing numbers: ");
            missingNumbers.forEach((number) -> {
                System.out.print(number + " ");
            });
            System.out.println();
        }
    }
    
}
