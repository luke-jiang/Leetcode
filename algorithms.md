# Strings
## Subsequence
## String Compression
String compression transforms a string into the form of `[char][int]+`, representing how many times a character repreats itself. E.g. `aabbc` can be converted into `a2b2c1`.

Related Problems:
- q443_string_compression
- q809_expressive_words
- q696_count_binary_substrings

## Frequency Array
A frequency array of a word string is an array of size 26, where each entry represent the frequency of the corresponding character in the word.  
```java
for (char c : s.toCharArray()) {
  freq[x - 'a']++;
}
```




# Recursive Search & Backtracking:
Backtracking is a decrease-and-conquer technique: To solve a problem of size N, we start from an initial state and recursively build a larger solution while removing non-satisfiable answers in the meantime. There are three types of problem in backtracking:
- Decision Problem: search for a feasible solution (a.k.a decide if a solution exists)
- Optimization Problem: search for the best solution
- Enumeration Problem: search for all solutions

A backtracking algorithm has the following pattern:
* Starting an initial state S, a set of choices C, and a constraint P on the states  
* Select the next element c in C, construct state S + c  
* check if S + c satisfies the constraint P  
  * if so, S + c is eligible to be further constructed  
  * else, S + c is not a valid state, so all its children states are not valid as well. We can return to the parent state S.  

In effect, the algorithm performs a DFS on the state tree, which consists of all valid states.

The output set may be required to remove duplicate combinations. **q39_combination_sum** gives the basic pattern to this kind of problems and **q39_combination_sum_ii** describes the technique of avoiding including duplicates to the result.





# Binary Search
Binary Search is used to search an element in a sorted array. The following template shows an iterative implementation of binary search. The search region is marked by two pointers `low` and `high`. `low` is initialized as the starting index `0` and `high` is initialized as the last index `arr.length-1`. The search ends with `low` is strictly larger than `high`, indicating that the target is not found. At each iteration, we calculate the medium index `mid`, and update `low` and `high` accordingly.

The runtime of binary search is O(logn), because at each iteration we cut the search space half in size.
```java
// `low` and `high` mark the search region [low, high] 
int low = 0;
int high = arr.length - 1;
while (low <= high) {
  // formula for calculating `mid`
  int mid = low + (high - low) / 2;
  if (arr[mid] == target) {
    return true;
  } else if (target > arr[mid]) {
    low = mid + 1;
  } else {
    high = mid - 1;
  }
}
return false;
```

# Binary Search Tree
A binary search tree is a binary tree that satisfies the following condition:
1. all nodes in a node n's LST (left sub-tree) is smaller than the node's value.
2. all nodes in a node n's RST (right sub-tree) is larger than the node's value.
The natural order of a BST is in-order traversal. One can use a stack to perform in-order traversal.

# Dynamic Programming
Dynamic programming is a method to solve a particular type of problem: The answer to a larger problem is dependent on answers to smaller problems, which are subset to the larger problem. In other words, given a problem P of size i, we can efficiently find its answer by

The key rationale of the solution to a DP problem is its *recurrent relation*. Mathematically, recurrent relation defines how the answer to a big problem is related to the answers to sub-problems.

To approach an DP problem, one should consider the following questions:

1. What is the semantics of the recurrence relation?
2. How is the recurrence relation defined?
3. What are the initial cases?
4. How is the return value related to the recurrence relation?

## Iterative Implementation

## Recursive Implementation (Memoization)
Given a recurrence relation, one can directly translate the recurrence relation into a recursive function. This approach is also known as memoization, where the DP array serves as a cache. Whenever we queries a value in the cache via the recursive function, we check if the value is already present. If so, we just return the cached value. Otherwise, we recursively query answers to subproblems and generate the answer using the recurrence. Lastly, we save the answer into the cache and return it.



## Recursive DP:
Recursive DP implements the recurrent relation recursively. One advantage of this implementation is that the recurrent relation is clearly encoded in the recursive *search* function. The following pseudocode shows a structure of a recursive search on a 2d DP problem:
```Java
int[][] dp;

private int search(int i, int j, ...) {
  if (cond1) {
    dp[i][j] = f_1(search(i_1, j_j))
  } else if (cond2) {
    dp[i][j] = f_2(search(i_2, j_2))
  } else ...
}
```

## DP Variation 1: Reduced DP
In this case, the answer to the current problem is not dependent on all previous answers, but only a single previous answer or some state (e.g. max/min) about the previous answers. In this case, the dp cache array can be reduced to variables.

## DP Variation 2: Multiple Caches
In this case, the answer to the current problem depends on multiple (usually two) types of previous answers.

Problems:
- q322_coin_exchange
- q139_word_break


## DP technique: Reduce DP array space:
When the recurrence relation only requires knowing a small subset of all previous values, we can reduce the DP array space to only include the values that will be used.

Problems:
- q53_maximum_subarray (easy)
- q509_fibonacci_number (easy)

## DP technique: 



# Reduction Search
Reduction search is a generalization of binary search. Similar to binary search, we have two pointers marking the boundary of the search space (i.e., sub-problem). However, at each step, we do not necessarily reduce the search space by half. The reduction can be more general.

Problems:
- q680_valid_palindrome_ii
- q42_trapping_rain_water




# In-place Marking

Problems:
- q287_find_the_duplicate_number

# Bit Manipulation
Basic bitwise operators: &, |, ~, ^
properties of xor: 0^x = x, x^x = 0, x^y = y^x


# Greedy Algorithm
Greedy Algorithms are constructed based on the following assertion:

> Selecting the best choice for each step results in the overall optimal solution.

The criteria for "best choice" is usually determined by intuition and observation, so the criteria itself does not guarantee the correctness of a greedy algorithm. One must prove the correctness by contradiction: assume there exists another optimal solution that is different from the greedy solution, and that yields to contradiction.

## Interval Covering Problem:
The statement of the problem is the following:

> Given a list of intervals and a range to cover, return the minimum number of intervals to cover the whole range. Return -1 if it is not possible.

Suppose we have constructed the optimizal solution for a sub-region of the whole range. How can we extend the solution to cover a larger range? We know that we can extend the covered region by selecting some new intervals that start before the current end. Since we want to minimize total number of selected intervals, we want to greedily select the longest candidate interval. This insight gives the following algorithm:

1. sort the intervals by their starts.
2. `end` := the current end of covered region  
   `farCanReach` := the maximal extent that all intervals starting before the end can reach  
   `res` := the result of the algorithm (i.e, minimum number of intervals)  
   initialize all three variables to 0.
3. while `end` is less than the end of the region to cover:  
   consider all intervals that start before `end`, set `canReach` to be the maximum of their ends.  
   If there is no such interval, then we have no interval to cover the region after `end`. return -1  
   `end = canReach`
   
Related Problems:
- q1326_minimum_number_of_taps_to_open_to_water_a_garden
- q1024_video_stitching
- q45_jump_game_ii

# Coding Tips
- use `Arrays.toString()` and `Arrays.deepToString()` to print an array
- use `Arrays.asList(T... a)` to create a fixed-size list backed by the specified array.
- use `Integer[]` instead of `int[]` for dp such that there is no need to fill default value

