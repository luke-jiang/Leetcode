// [Greedy] ***

/** You are given a char array representing tasks CPU need to do. It contains capital
  * letters A to Z where each letter represents a different task. Tasks could be done
  * without the original order of the array. Each task is done in one unit of time.
  * For each unit of time, the CPU could complete either one task or just be idle.
  *
  * However, there is a non-negative integer n that represents the cooldown period
  * between two same tasks (the same letter in the array), that is that there must
  * be at least n units of time between any two same tasks.
  *
  * You need to return the least number of units of times that the CPU will take to
  * finish all the given tasks.
  */

public class Solution1 {
    // Greedily selects the globally most frequent task and find the
    // maximum idle time, which is the time needed to schedule ONLY the
    // most frequent task. Then, for each less frequent task, decrement
    // idle times accordingly.

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];

        for (char task : tasks) {
            counter[task - 'A']++;
        }

        Arrays.sort(counter);

        int fmax = counter[25];
        int idle_time = (fmax - 1) * n;

        for (int i = counter.length - 2; i >= 0; i--) {
            idle_time -= Math.min(fmax - 1, counter[i]);
        }
        idle_time = Math.max(0, idle_time);

        return idle_time + tasks.length;
    }
}


public class Solution2 {
    // Math method
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
