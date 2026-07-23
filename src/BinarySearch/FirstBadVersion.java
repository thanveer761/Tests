package BinarySearch;

import org.junit.jupiter.api.Test;

public class FirstBadVersion {

    @Test
    public void test1() {
        int n = 5;
        int bad = 4;
        VersionControl vc = new VersionControl(bad);
        int op = vc.firstBadVersion(n);
        System.out.println(op); // expect 4
    }

    @Test
    public void test2() {
        int n = 1;
        int bad = 1;
        VersionControl vc = new VersionControl(bad);
        int op = vc.firstBadVersion(n);
        System.out.println(op); // expect 1
    }

    @Test
    public void test3() {
        int n = 10;
        int bad = 1;
        VersionControl vc = new VersionControl(bad);
        int op = vc.firstBadVersion(n);
        System.out.println(op); // expect 1
    }
/*
    Iteration	left	right  mid	isBadVersion(mid)	action
      1	          1	      5	    3	 false	            left = 4
      2           4       5     4    true               right=4
      /*
* GOAL: find the first version where isBadVersion returns true,
*        minimizing the number of API calls

* initialize left = 1, right = n

* while left < right:
    * mid = left + (right - left) / 2
      (careful: use this form instead of (left+right)/2 to avoid integer overflow for large n)

    * if isBadVersion(mid) == true:
        - mid could be the first bad version, or the first bad version is even earlier
        - keep mid in range (don't rule it out)
        - move right = mid

    * else:
        - mid is good, so the first bad version must be strictly after mid
        - move left = mid + 1

* when left == right, that version is the first bad version
* return left
*/
static class VersionControl {
    private final int badVersion;

    VersionControl(int badVersion) {
        this.badVersion = badVersion;
    }

    boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
}

