package com.company.from1to100.problem2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ListNode ln = l1;
        String a1 = "";
        String a2 = "";
        while (ln != null) {
            list1.add(ln.val);
            a1 = ln.val + a1;
            ln = ln.next;

        }
        ln = l2;
        while (ln != null) {
            list2.add(ln.val);
            a2 = ln.val + a2;
            ln = ln.next;
        }
        BigInteger b1 = new BigInteger(a1);
        BigInteger b2 = new BigInteger(a2);
        System.out.println(a1);
        System.out.println(a2);
        BigInteger ans = b1.add(b2);
        String sAns = ans.toString();
        System.out.println(sAns);
        ListNode listNode = new ListNode();
        listNode.val = Integer.parseInt(String.valueOf(sAns.charAt(0)));
        System.out.println(listNode.val);
        for(int i = 1; i < sAns.length(); i++){
            listNode = new ListNode(Integer.parseInt(String.valueOf(sAns.charAt(i))), listNode);
            System.out.println(listNode.val);
        }
        return listNode;
    }
}
