import java.util.Random;
public class MCS {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 20;
        int[] array = new int[n];
        for (int k=0;k<n;k++){
            array[k] = (rand.nextInt(1,n))*(-1)^rand.nextInt(2,4);
        }

        int countP = 0;
        int countM = 0;

        for (int x = 0; x < array.length; x++) {
            if (array[x] < 0){
                countM++;
            } else{
                countP++;
            }
        }





    }
    public static void On3(int[] array){
        int n = array.length;
        int maxSoFar = 0;

        for (int low = 0; low < n; low++) {
            for (int high = low; high < n; high++) {
                int sum = 0;
                for (int i = low; i < high; i++) {
                    sum += array[i];
                    if (sum > maxSoFar) {
                        maxSoFar = sum;
                    }
                }
            }
        }
        System.out.println(maxSoFar);

    }

    public static void On2A(int[] array){
        int n = array.length;
        int maxSoFar = 0;

        for (int low = 0; low < n; low++) {
            int sum = 0;
            for (int r = low; r < n; r++) {
                sum += array[r];
                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }

        System.out.println(maxSoFar);
    }

    public static void On2B(int[] array){
        int n = array.length;
        int[] sumTo = new int[array[0] * (n+1)];

        for (int i = 0;i < n;i++) {
            sumTo[i] = sumTo[i-1] + array[i];
        }

        int maxSoFar = 0;

        for (int low = 0; low < n; low++) {
            for (int high = low; high < n; high++) {
                int sum = sumTo[high] - sumTo[low-1];
                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }
        System.out.println(maxSoFar);
    }

    public static void On(int[] array){
        int N = array.length;
        double maxSoFar = 0.0;
        double maxToHere = 0.0;

        for (int i = 1;i < N;i++) {
            maxToHere = Math.max(maxToHere + array[i], 0.0);
            maxSoFar = Math.max(maxSoFar, maxToHere);
        }
        System.out.println(maxSoFar);
    }

    public static void counter(){
        int[] sizes = {100, 1000, 10000, 100000, 1000000};

        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n",
                "n", "O(n^3)", "O(n^2)", "O(n^2)", "O(n)");

        for (int n : sizes) {

            long countN3 = 0;
            long countN2a = 0;
            long countN2b = 0;
            long countN = 0;

            // 🔹 O(n^3)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int k = 0; k < n; k++)
                        countN3++;

            // 🔹 O(n^2) version 1
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    countN2a++;

            // 🔹 O(n^2) version 2
            for (int i = 0; i < n; i++)
                for (int j = i; j < n; j++)
                    countN2b++;

            // 🔹 O(n)
            for (int i = 0; i < n; i++)
                countN++;

            System.out.printf("%-10d %-15d %-15d %-15d %-15d%n",
                    n, countN3, countN2a, countN2b, countN);
        }
    }
    }


}
