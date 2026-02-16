import java.util.Arrays;
import java.util.Random;

class shuffleMethods {

    int[] slowShuffle(int n){
        Random rand = new Random();
        int[] shuffled = new int[n];
        boolean[] isNotPresent = new boolean[n + 1];

        // filling isNotPresent[] with true
        //NB shuffled[] is empty
        for (int i = 1; i < n + 1; i++) {
            isNotPresent[i] = true;
        }

        int num = 0;
        int r = rand.nextInt(n) + 1;
        while (num < n - 1){
            if (isNotPresent[r]) { // if isNotPresent at pos r is true
                shuffled[num] = r;
                isNotPresent[r] = false;
                num++;
            } else {
                r = rand.nextInt(n) + 1;
            }
        }

        for (int i = 1; i < n + 1; i++) { // takes the last pos that is true and puts it into the last pos of shuffled
            if (isNotPresent[i]) {
                shuffled[n - 1] = i;
            }
        }

        return shuffled;
    }

    int [] unbiasedShuffle(int n){
        Random rand = new Random();
        int[] B = new int[n + 1];


        for (int j = 1; j <= n; j++) {
            B[j] = j;
        }

        int b = 1;

        for (int i = 1; i <= n; i++) {
            int r = b + rand.nextInt(n - b + 1);
            int temp = B[b];
            B[b] = B[r];
            B[r] = temp;
            b += 1;
        }

        return B;
    }


}
