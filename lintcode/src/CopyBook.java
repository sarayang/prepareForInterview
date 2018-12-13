/**
 * Created by YANGSONG on 2018-11-29.
 */
public class CopyBook {
    public static boolean constraint(int[] pages, int page, int k) {
        int subsum = 0;
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] < page) {
                subsum += pages[i];
                System.out.println(subsum + "," + k);
                if (i < pages.length - 1 && subsum + pages[i + 1] > page) {


                    k--;
                    subsum = 0;
                }
            } else {
                k--;
                subsum = 0;
            }
        }
//        System.out.println(subsum + "," + page + "," + k);
        if (subsum <= page && k >= 1) {
            return true;
        }
        return k == 0 && subsum == 0;
    }

    public static void main(String[] args) {
        int[] pages = {13,999,1,2,13,999,11};
        System.out.println(constraint(pages, 1023, 2));
    }

}
