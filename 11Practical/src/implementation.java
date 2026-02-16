import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class implementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number (n): ");
        int n = sc.nextInt();

        shuffleMethods shuffMeth = new shuffleMethods();

        int[] slowShuffle = shuffMeth.slowShuffle(n);
        int[] unbiasedShuffle = shuffMeth.unbiasedShuffle(n);

        System.out.println("Slow Shuffle:");
        for (int i : slowShuffle) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Unbiased Shuffle: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(unbiasedShuffle[i] + " ");
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= 6000; i++){
            String permutation = Arrays.toString(unbiasedShuffle).replace("[", "").replace("]", "");
        }



    }
}
