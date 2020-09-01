package string;

import java.util.LinkedList;
import java.util.Queue;

public class MaxNotSameString {
    // 最长不重复子序列
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {return 0;}
        int maxlen = 0;
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!queue.contains(c)) {
                queue.offer(c);
                maxlen = Math.max(maxlen, queue.size());
            } else {
                while (queue.contains(c)) {
                    queue.poll();
                }
                queue.offer(c);
                maxlen = Math.max(maxlen, queue.size());
            }

        }
        return maxlen;
    }
}
