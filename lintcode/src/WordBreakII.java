import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by YANGSONG on 2018-12-13.
 */

public class WordBreakII {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(s, dict, new ArrayList<String>(), res);
        return res;
    }

    private List<String> dfs(String s, Set<String> dict, List<String> subres, List<String> res) {
        if (s.length() == 0) {
            return subres;
        }
        // List<String> ans = new ArrayList<>();
        for (int i = 1; i < s.length() + 1; i++) {
            if (dict.contains(s.substring(0, i))) {
                String prefix = s.substring(0, i);
                List<String> partialSubres = dfs(s.substring(i), dict, new ArrayList<String>(), res);
                StringBuffer sb = new StringBuffer();
                sb.append(prefix + " ");
                for (String ss : partialSubres) {
                    sb.append(ss + " ");
                }
                res.add(sb.toString().trim());
            }
        }
        return res;
    }
}