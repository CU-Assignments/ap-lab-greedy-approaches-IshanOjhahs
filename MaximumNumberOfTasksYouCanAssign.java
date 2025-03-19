import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length, workers.length);

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canAssign(mid, tasks, workers, pills, strength)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean canAssign(int count, int[] tasks, int[] workers, int pills, int strength) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = count - 1;
        int j = workers.length - 1;
        int availablePills = pills;

        while (i >= 0) {
            
            while (j >= workers.length - count && workers[j] + strength >= tasks[i]) {
                pq.offer(workers[j]);
                j--;
            }

            
            if (pq.isEmpty()) return false;

            
            int worker = pq.poll();
            if (worker >= tasks[i]) {
                i--;
            }
            
            else if (availablePills > 0 && worker + strength >= tasks[i]) {
                availablePills--;
                i--;
            }
            
            else {
                return false;
            }
        }

        return true;
    }
}
