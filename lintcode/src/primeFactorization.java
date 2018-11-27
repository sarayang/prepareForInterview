import java.util.ArrayList;
import java.util.List;

/**
 * Created by YANGSONG on 2018-11-27.
 */
public class primeFactorization {
    public static List<Integer> primeFactorization(int n) {
        List<Integer> result = new ArrayList<>();
        System.out.println((int)Math.sqrt(n));
        int up = (int) Math.sqrt(n);

        for (int k = 2; k <= up && n > 1; ++k) {
            while (n % k == 0) {
                n /= k;
                result.add(k);
            }
        }
        System.out.println(n);
        if (n > 1) {
            result.add(n);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(primeFactorization(14));
    }
}
