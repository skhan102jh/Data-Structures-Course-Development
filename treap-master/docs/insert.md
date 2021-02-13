---
layout: episode
title: Insert operation
outcomes:
    - Explain and trace the balancing operations of a Treap
time: 10
tags: [insert, treap, trace]
---

1. Given this **max-heap treap**, where the <u>keys are the letters</u> and the <u>priorities are the integers</u>, show the result of inserting the key-priority pair `M-15`, including any necessary rotations.

   ```
           J-10
         /      \
      D-9        T-8
     /   \      /   \
   A-5   F-2   P-4  Y-7
                   /   \
                 X-3   Z-6
   ```


<details class="solution">
  <summary>Solution</summary>
  

1. Insert `M-15` into the treap based on the key:

   ```
           J-10
         /      \
      D-9        T-8
     /   \      /   \
   A-5   F-2  P-4   Y-7
              /    /   \
           M-15  X-3   Z-6
   ```

   Rebalance the priority heap:

   ```
        10                  10                    10                      15
      /    \              /    \                /    \                  /     \
     9      8      ->    9       8        ->   9     15       ->      10       8
    / \    / \          / \    /   \          / \      \             /        / \
   5   2  4   7        5   2  15    7        5   2      8           9        4   7
         /   / \               \   / \                 / \         / \          / \
        15  3   6               4 3   6               4   7       5   2        3   6
                                                         / \
                                                        3   6
   ```

   Balanced treap:

   ```
            M-15
          /     \
       J-10     T-8
       /       /   \
      D-9    P-4   Y-7
     /  \          /  \
   A-5  F-2      X-3  Z-6
   ```

</details>