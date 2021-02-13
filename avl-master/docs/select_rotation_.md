---
layout: episode
title: Deciding on rotation
outcomes:
    - Select the appropriate rotation type in order to rebalance an AVL tree after an operation (insert, remove) is performed
time: 15
tags: [balancing, rotations, AVL, pseudocode]
---


1. Calculate the balance factor of each node, balance the tree and name the type of rotation used:

   a. 

   ```
   1
    \
     2
      \
       3
   ```

   b.

   ```
   1
    \
     3
    / \
   2   4
   ```

   c.

   ```
   1
    \
     3
    /
   2
   ```

   d.

   ```
     10
    /
   7
    \
     8
   ```

   e.

   ```
        15
       /
      10
     /  \
    5   12
   ```

   f.

   ```
       20
      /
     10
    /
   3
   ```

2. Using the answers above, write an algorithm that given a node, determines if it needs rebalancing and if so, which type of rotation to do (`singleLeft`, `singleRight`, `doubleLR`, `doubleRL`). Assume there is a method to compute the `balanceFactor` of a node based on the heights as well as the methods to perform each rotation.


<details class="solution">
  <summary>Solution</summary>

1. a. Single left rotation:

   ```
   1 (bf = -2)                           2 (bf = 0)
    \                                  /   \
     2 (bf = -1)      ->     (bf = 0) 1     3 (bf = 0)
      \
       3 (bf = 0)
   ```

   b. Single left rotation:

   ```
             1 (bf = -2)                             3 (bf = 1)
              \                                    /   \
               3 (bf = 0)       ->      (bf = -1) 1     4 (bf = 0)
              / \                                  \
   (bf = 0)  2   4  (bf = 0)                        2 (bf = 0)
   ```

   c. Double right-left rotation

   ```
   1 (bf = -2)          1 (bf = -2)                       2 (bf = 0)
    \                    \                              /   \
     3 (bf = 1)  ->       2 (bf = -1)    ->   (bf = 0) 1     3 (bf = 0)
    /                      \
   2 (bf = 0)               3 (bf = 0)
   ```

   d. Double left-right rotation

   ```
       10 (bf = 2)	          10 (bf = 2)                  8 (bf = 0)
       /			          /                          /   \
      7 (bf = -1)   ->      8 (bf = 1)   ->   (bf = 0) 7     10 (bf = 0)
       \			        /
        8 (bf = 0)	       7 (bf = 0)
   ```

   e. Single right rotation

   ```
                15 (bf = 2)                  10 (bf = -1)
               /                            /  \
              10 (bf = 0)    ->   (bf = 0) 5    15 (bf = 1)
             /  \                               /
   (bf = 0) 5   12 (bf = 0)           (bf = 0) 12
   ```

   f. Single right rotation

   ```
       20 (bf = 2)                  10 (bf = 0)
      /                            /  \
     10 (bf = 1)    ->   (bf = 0) 3    20 (bf = 0)
    /
   3 (bf = 0)
   ```

2. |                      | child `balancefactor`=-1 | child `balancefactor`=0 | child `balancefactor`=1 |
   | -------------------- | ------------------------ | ----------------------- | ----------------------- |
   | `balancefactor` = -2 | `singleLeft`             | `singleLeft`            | `doubleRL`              |
   | `balancefactor` = 2  | `doubleLR`               | `singleRight`           | `singleRight`           |

</details>
