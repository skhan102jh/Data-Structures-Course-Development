---
layout: episode
title: Rotation in pseudocode
outcomes:
    - Explain and trace the balancing operations of an AVL tree
    - Implement the core operations of an OrderedMap efficiently with an AVL tree
time: 10 
tags: [AVL, rotation, code, algorithm]
---

Write an algorithm to do a <u>singleRight</u> rotation on a given node that has left and right children references. Assume it would be called on node `n` below as an example.

![](assets/rotaion_pseudocode_01.jpg)


<details class="solution">
  <summary>Solution</summary>
  
```java
Node singleRight (Node n) {
  Node child = n.left; //bring up this child
  n.left = child.right; 
  child.right = n;
  return child; //new root 
}
```

![](assets/rotaion_pseudocode_02.jpg)


</details>
