---
layout: episode
title: Review Key concepts  
outcomes:
	- to better understand the properties of a treap
time: 10 
tags: [treap, clicker]
---

1. **When you insert/remove a new node into a treap, rotations are based on:** 
	- (A) Balance factor of the node 
	- (B) Height of the node
	- (C) Priorities
	- (D) Balance factors of both the node and it's children

2. **Run-time for a treap operation is:**
	- (A) Always $O(\log N)$
	- (B) Always $O(N)$
	- (C) Approximately $O(\log N)$ if priorities are randomly assigned from a large range of values
	- (D) Approximately $O(\log N)$ if priorities are randomly assigned from a small range of values

3. **What properties must be satisfied for a treap?**
	- (A) Heap order property
	- (B) Complete Ordering Property (BST)
	- (C) Balance property (considering balance factors)
	- (D) A and B

4. **Which of these is NOT a major difference between a treap and an AVL tree:**
	- (A) Treap rotations are based on priorities, while an AVL rotation is based on balance factors. 
	- (B) Treaps can undergo both single and double rotations, while AVL trees can only undergo a single rotation. 
	- (C) Treaps only require single rotations, while AVL trees can undergo a single or double rotation. 
	- (D) The worst case efficiency for an AVL tree is $O(\log N)$, while $O(\log N)$ is the best case efficiency for a treap operation. 



<details class="solution">
  <summary>Solution</summary>

1. - (C) Treap rotations are solely based on priorities. AVL trees are based on balance factors, which are calculated by subtracting the height of the right subtree of a node from the height of its left subtree. 
2. - (C) The expected time per operation is $O(\log N)$ when priorities are randomly chosen from a large range of values. A large range of values is important to avoid duplicate priorities. 
3. - (D) Heap order property and the complete ordering property must be satisfied for a treap. The balance property and the complete ordering property property must be satisfied for an AVL tree. 
4. - (B) Treaps only require single rotations, while AVL trees can undergo either single rotations or double rotations depending on the balance factors of the node and its children. The other statements are all true. 

</details>
