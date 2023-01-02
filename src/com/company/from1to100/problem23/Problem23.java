package com.company.from1to100.problem23;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem23 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] listNodes = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        System.out.println(Arrays.stream(listNodes).collect(Collectors.toList()));
        System.out.println(solution.mergeKLists(new ListNode[] {null, null}));
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return sort(lists, 0, lists.length  - 1);
    }

    ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        ListNode listNode;
        if (left.val < right.val) {
            listNode = new ListNode(left.val);
            left = left.next;
        } else {
            listNode = new ListNode(right.val);
            right = right.next;
        }
        ListNode answer = listNode;
        while (left != null && right != null) {
            if (left.val < right.val) {
                listNode.next = new ListNode(left.val);
                left = left.next;
                listNode = listNode.next;
            } else {
                listNode.next = new ListNode(right.val);
                right = right.next;
                listNode = listNode.next;
            }
        }
        if (left == null) {
            listNode.next = right;
        } else {
            listNode.next = left;
        }
        return answer;
    }

    ListNode sort(ListNode arr[], int l, int r) {
        ListNode listNode = new ListNode();
        if (r - l == 0) {
            listNode = arr[l];
        } else if (r - l == 1) {
            listNode = merge(arr[l], arr[l + 1]);
        } else if (l < r) {
            int m = l + (r - l) / 2;
            ListNode left = sort(arr, l, m);
            ListNode right = sort(arr, m + 1, r);

            listNode = merge(left, right);

        }
        return listNode;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "{val=" + val +
                ", next=" + next +
                '}';
    }
}