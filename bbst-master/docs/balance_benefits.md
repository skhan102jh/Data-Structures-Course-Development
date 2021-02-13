---
layout: episode
title: The benefits of balanced BST
outcomes:
    - Differentiate binary trees, binary search trees and balanced binary search trees based on the structure (balance) and ordering properties
time: 10 
tags: [bbst, worksheet, trace]
---

1. Insert the following integers to a binary search tree, in order: `[1, 2, 3, 4, 5, 6, 7]`.
  
    - How many comparisons does it take to find the 7?
    - Is this a balanced tree?
    
2. Now insert the following integers (a random permutation of the first set) to a binary search tree, in order: `[4, 2, 6, 1, 3, 5, 7]`.

    - How many comparisons does it take to find the 7?
    - Is this a balanced tree?

3. If a dataset has 2 trillion integers, would you insert them in sorted order or randomly for best performance? Why?

<details class="solution">
  <summary>Solution</summary>

1. -  It takes 7 comparisons to find the 7.
   -  The tree is unbalanced.

2. - It takes 3 comparisons to find the 7.
   - The tree is balanced.

3. We want to insert randomly because this will give us a more balanced tree.

</details>
