/**
 * Created by YANGSONG on 2018-11-27.
 */
public class FindPeakElement {
    public static int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < A.length - 1 && A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (mid > 0 && mid < A.length - 1 && A[mid] > A[mid - 1] && A[mid + 1] > A[mid]) {
                start = mid;
            } else if (mid > 0 && mid < A.length - 1 && A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                end = mid;
            } else if (mid > 0 && mid < A.length - 1 && A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                start = mid;
            }
        }
        System.out.println(start + "," + end);
        System.out.println("yang");

        return A[start] > A[end] ? start : end;
    }

    public static void main(String[] args) {
        int[] A = {13,20,21,7};
        System.out.println(findPeak(A));
    }

}
