package DesignHitCounter;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        System.out.println(hitCounter.getHits(4));
        hitCounter.hit(300);
        System.out.println(hitCounter.getHits(300));
        System.out.println(hitCounter.getHits(301));
    }
    static class HitCounter {

        private ArrayList<Integer> requests = new ArrayList<>();
        private int lastStartIndex = 0;

        public HitCounter() {

        }

        public void hit(int timestamp) {
            requests.add(timestamp);
        }

        public int getHits(int timestamp) {
            int start = Math.max((timestamp - 300), 0);
            int startIndex = lastStartIndex;

            // Находим такой "тайминг", который соответствует началу диапазона
            while (requests.get(startIndex) <= start) {
                startIndex++;
            }

            lastStartIndex = startIndex;
            return requests.size() - startIndex;
        }
    }
}
