package com.company.from1to100.problem4;

public class Problem4 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3};
        double answer = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(answer);
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nm = nums1.length + nums2.length;
        int[] mergedArray = new int[nm];
        merge(mergedArray, nums1, nums2);
        if (nm % 2 == 0){
            return (double) (mergedArray[nm / 2 - 1] + mergedArray[nm / 2]) / 2;
        }
        return mergedArray[nm / 2];
    }

    void merge(int[] mergedArray, int[] nums1, int[] nums2) {

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            mergedArray[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            mergedArray[k++] = nums2[j++];
        }
    }
}

