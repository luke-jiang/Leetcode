/** Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
  * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. 
  * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
  *
  * Example 1:
  * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
  * Output: [2,2,2,1,4,3,3,9,6,7,19]
  *
  * Example 2:
  * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
  * Output: [22,28,8,6,17,44]
  */

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], 0);
        }
        List<Integer> remain = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int n = arr1[i];
            if (map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            } else {
                remain.add(n);
            }
        }
        Collections.sort(remain);
        int[] res = new int[arr1.length];
        int i = 0;
        for (int n : arr2) {
            int k = map.get(n);
            while (k > 0) {
                res[i] = n;
                i++;
                k--;
            }
            
        }
        for (int j = 0; j < remain.size(); j++) {
            res[i] = remain.get(j);
            i++;
        }
        
        return res;
    }
}

// use Comparator and sort
class Solution {
    Map<Integer, Integer> map;
    
    class MyComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            // use 1001 because it's given that arr1[i] <= 1000
            return map.getOrDefault(a, 1001 + a) - map.getOrDefault(b, 1001 + b);
        }
    }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> ls = new ArrayList<>();
        for (int n : arr1) ls.add(n);
        Collections.sort(ls, new MyComparator());
        for (int i = 0; i < arr1.length; i++) arr1[i] = ls.get(i);
        return arr1;
    }
}

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = map.getOrDefault(arr1[i], 1001 + arr1[i]);
        }
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < arr2.length) {
                arr1[i] = arr2[arr1[i]];
            } else {
                arr1[i] = arr1[i] - 1001;
            }
        }
        return arr1;
    }
}
