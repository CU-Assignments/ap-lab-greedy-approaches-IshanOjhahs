import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
      
        for (int pile : piles) {
            maxHeap.add(pile);
        }

       
        while (k-- > 0) {
            int largest = maxHeap.poll(); 
            int reduced = largest - largest / 2; 
            maxHeap.add(reduced); 
        }

        int total = 0;
        while (!maxHeap.isEmpty()) {
            total += maxHeap.poll();
        }

        return total;
    }
}
