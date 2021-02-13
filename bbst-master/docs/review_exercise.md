---
layout: episode
title: Checking if a Tree is a BBST
outcomes:
	- Identify the height and balance factor of binary search tree nodes
	- Differentiate binary trees, binary search trees and balanced binary search trees based on the structure (balance) and ordering properties
time: 7 
tags: [bst, bbst]	
---

Could this tree be a balanced binary search tree? If not, list every instance of all BBST violations by indicating roots of all non-BBST compliant subtrees.

![](assets/bbst01.jpg)

<details class="solution">
  <summary>Solution</summary>

A violation of the order property can be seen through an in order traversal: 
A, <u>C, B,</u> D, E, F, G, M, I, J, <u>M, L, N, K,</u> O, P

A violation of the balance property exists in nodes D, A, and G: 

![](assets/bbst02.jpg)

</details>
