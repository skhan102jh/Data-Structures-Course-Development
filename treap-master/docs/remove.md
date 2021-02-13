---
layout: episode
title: Remove operation 
outcomes:
	- explain and practice the remove operation of a treap
time: 10 
tags: [treap, remove]
---

1. Given this **max-heap treap**, where the <u>keys are the letters</u> and the <u>priorities are the integers</u>, Show the result of removing the key T-8 from this max-heap treap by setting the priority of T to -1. 

```plain
                 J(10)
               /       \
             D(9)       T(8)
           /    \      /   \ 
         A(5)   F(2)  P(4)  Y(7)
                           /   \
                         X(3)  Z(6)
```

<details class="solution">
  <summary>Solution</summary>

First change the priority of key T to -1. 

```plain
                 J(10)
               /       \
             D(9)       T(-1)
           /    \      /   \ 
         A(5)   F(2)  P(4)  Y(7)
                           /   \
                         X(3)  Z(6)
```

Left rotate the subtree starting with node T to fix the heap property.

```plain
             J(10)
           /       \
         D(9)       Y(7)
       /    \      /    \ 
     A(5)  F(2)   T(-1)  Z(6)
                 /   \
               P(4)   X(3)
```

Right rotate the subtree starting with node T to fix the heap property.

```plain
         J(10)
       /       \
     D(9)       Y(7)
   /    \      /    \ 
 A(5)  F(2)   P(4)   Z(6)
                \
                T(-1)
                   \
                   X(3)
```

Left rotate the node starting with T to fix the heap property.

```plain
         J(10)
       /       \
     D(9)      Y(7)
   /    \      /    \ 
 A(5)   F(2)  P(4)   Z(6)
                \
                X(3)
               /
             T(-1)
```

Now that T is at a leaf position, it can just be deleted. 

```plain
         J(10)
       /       \
     D(9)       Y(7)
   /    \      /    \ 
 A(5)   F(2)  P(4)   Z(6)
                \
                X(3)
```

This is the balanced treap.

</details>
