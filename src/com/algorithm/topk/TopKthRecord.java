package com.algorithm.topk;

import com.collection.HashMap;
import com.collection.Map;

/*
小根堆得到最大的N个数
大根堆得到最小的N个数
 */
import java.util.PriorityQueue;

public class TopKthRecord {
    public static void main(String[] args) {
        String[] s = {"a", "b", "c", "d", "a", "d", "e",
                "a", "b", "c", "d2", "aa", "d", "e1",
                "a", "bc", "c", "d", "aa", "d", "e"};
        int[] nums = {1, 2, 3, 4, 5, 5, 6, 6, 6, 5465, 4, 45, 5654, 65, 4, 4};
        System.out.println(findKthLargest(nums, 5));
        topK(s);
    }

    public static PriorityQueue<Integer> findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minQueue.size() < k || num > minQueue.peek())
                minQueue.offer(num);
            if (minQueue.size() > k)
                minQueue.poll();
        }
        return minQueue;
    }

    public static void topK(String[] str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                int count = map.get(str[i]);
                map.put(str[i], count + 1);
            } else {
                map.put(str[i], 1);
            }
        }
        System.out.println(map);
    }
}
