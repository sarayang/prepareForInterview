import java.util.ArrayList;
import java.util.List;

/**
 * Created by YANGSONG on 2018-12-12.
 */
public class Factorization {
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    public static List<List<Integer>> getFactorss(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 3) {
            return res;
        }
        dfs(n, 2, n, new ArrayList<Integer>(), res);
        return res;
    }

    private static void dfs(int n,
                     int startVal,
                     int target,
                     List<Integer> subres,
                     List<List<Integer>> res) {
        // System.out.println(target);
//        if (n == 1) {
//            System.out.println(subres);
//            res.add(new ArrayList<>(subres));
//            return;
//        }
        if (n <= 1) {
            if (subres.size() > 1) {
                res.add(new ArrayList<Integer>(subres));
            }
            return;
        }
        for (int i = startVal; i <= (int)Math.sqrt(n); i++) {

            if (n % i == 0) {
                subres.add(i);
                dfs(n / i, i, n, subres, res);
                subres.remove(subres.size() - 1);
            }
        }
        if (n >= startVal) {
            subres.add(n);
            dfs(1,n, n, subres, res);
            subres.remove(subres.size() - 1);
        }
    }

    public static List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
        System.out.println("n: " + n + ", START: " + start);
        System.out.println("result: " + result);
        if (n <= 1) {
            System.out.println("subres: " + item);
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }
        System.out.println("Math.sqrt(n): " + "-----" + Math.sqrt(n));
        for (int i = start; i <= Math.sqrt(n); i++) {
            System.out.println("n: " + n + ", i:" + i);

            if (n % i == 0) {
                item.add(i);
                helper(result, item, n / i, i);
                item.remove(item.size()-1);
            }
        }
        System.out.println(n + "====" + start);
        if (n >= start) {
            System.out.println("n: " + n + ", start:" + start);
            item.add(n);
            helper(result, item, 1, n);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int input = 6718464;
        int input = 8;
        System.out.println(getFactors(input));
//        getFactors(input);

    }
}
