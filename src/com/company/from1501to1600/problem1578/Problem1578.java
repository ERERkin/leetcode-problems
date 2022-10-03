package com.company.from1501to1600.problem1578;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1578 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String colors = "aabaa";
        int[] neededTime = new int[]{1,2,3,4,1};
        int answer = solution.minCost(colors, neededTime);
        System.out.println(answer);
    }
}

class Solution {
    public int minCost(String colors, int[] neededTime) {
        List<Item> items = new ArrayList<>();
        int colorIndex = 0;
        items.add(new Item(colorIndex, colors.charAt(0), neededTime[0]));
        for (int i = 1; i < colors.length(); i++){
            if (colors.charAt(i) != colors.charAt(i - 1)){
                colorIndex++;
            }
            items.add(new Item(colorIndex, colors.charAt(i), neededTime[i]));
        }

        items = items.stream().sorted().collect(Collectors.toList());
        int answer = 0;
        for (int i = 0; i < items.size() - 1; i++){
            if (items.get(i).color == items.get(i + 1).color){
                answer += items.get(i).neededTime;
            }
        }
        return answer;
    }
}

class Item implements Comparable <Item>{
    public Item(int secondIndex, char color, int neededTime) {
        this.secondIndex = secondIndex;
        this.color = color;
        this.neededTime = neededTime;
    }

    int secondIndex;
    char color;
    int neededTime;

    @Override
    public int compareTo(Item o) {
        if (this.secondIndex < o.secondIndex){
            return -1;
        }else if (this.secondIndex > o.secondIndex){
            return 1;
        }
        if (this.color == o.color){
            return Integer.compare(this.neededTime, o.neededTime);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Item{" +
                "secondIndex=" + secondIndex +
                ", color=" + color +
                ", neededTime=" + neededTime +
                '}';
    }
}
