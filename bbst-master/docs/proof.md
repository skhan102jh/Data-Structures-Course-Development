---
layout: episode
title: Prove height of BBST is O(log N)
outcomes:
    - Identify the height and balance factor of binary search tree nodes
    - Analyze the time/space efficiency of BBST implementation approach
time: 15
tags: [BBST, proof]
---

A Balanced Binary Search Tree (BBST) is useful because unlike a regular BST, it guarantees that the height of the tree is $O(\log N)$. This can be easily observed for a perfect BST, where each internal node has two children and all the leaves are at the same level. 

```plain
()        ()                 ()                          ()
         /  \              /    \                     /       \
       ()    ()          ()      ()                ()            ()
                       /   \    /  \            /     \       /      \ 
                      ()   ()  ()   ()        ()      ()      ()      ()
                                            /   \    /   \   /   \   /   \
                                           ()   ()  ()   () ()   () ()   () 
     
```

For each of the above trees, determine the height, number of nodes, and if the binary log calculation satisfies this property. 

| Height | Nodes | Binary Log Calculation |
| ------ | ----- | ---------------------- |
|        |       | ${\log}_{2}$         = |
|        |       | ${\log}_{2}$         = |
|        |       | ${\log}_{2}$         = |
|        |       | ${\log}_{2}$         = |

<details class="solution">
  <summary>Solution</summary>

| Height | Nodes | Binary Log Calculation |
| ------ | ----- | ---------------------- |
| $0$    | $1$   | ${\log}_{2} 1 = 0$     |
| $1$    | $3$   | ${\log}_{2} 3 = 1$     |
| $2$    | $7$   | ${\log}_{2} 7 = 2$     |
| $3$    | $15$  | ${\log}_{2} 15 = 3$    |

</details>

Given these perfect BSTs, one can intuit how this holds more generally. This can be proved more rigorously for any BST that is balanced through the following: 

Let's consider a BBST of height $h \geq 3$ and let $N(h)$ be the min # of nodes

$$
N(h) = 1 + N(h-1) + N(h-2)
$$

<details class="solution">
  <summary>What do each of the three terms represent and how were they derived? (hint: recall what it means for a BST to be balanced in terms of height)</summary>

The terms represent the root and the two subtrees, with a balance factor of $1$. Given that the height of the two siblings can vary at most by $1$, to determine the minimum number of internal nodes, one of the subtrees must have a height of $h-1$, and if the tree is to be balanced, the other must be of height $h-2$.

</details>

We know

$$
N(h) > N (h-1)​ \space and \space N(h-1) > N(h-2)​
$$

Therefore,

$$
N(h) > N(h-1) + N(h-2) > 2\times N(h-2) > 4\times N(h-4) > 8\times N(h-6)
$$

<details class="solution">
  <summary>What does the previous line of the proof demonstrate and why is that significant?</summary>

This demonstrates that the number of nodes at least doubles each time that the height increase by a factor of $2$. This is significant because it shows that $N(h)$ is exponential in $h$, and therefore $h$ is logarithmic in the number of nodes.

</details>

Continuing the proof, we see that this can be written as: 

$$
N(h) > 2^i \times N(h - 2i)
$$

where we can substitute the following value for i: $i = h/2 - 1$

<details class="solution">
  <summary>Why is this value of <code>i</code> chosen to substitute?</summary>

This allows the expression to equal either $1$ or $2$, depending on if $h$ is even or odd. 
  * Even $h$: $h - 2i = h - (h - 2) = 2$
  * Odd $h$: $h - 2i = h - (2(h/2) - 2) = h - ((h + 1)-2) = 1$

</details>

Substituting this value of 'i' into the equation and simplifying, 

$$
N(h) > 2^{(h/2)} \times N(h - 2i)
$$

$$
N(h) \geq 2^{(h/2) - 1} \times N(h - 2(h/2 - 1))
$$

$$
N(h) \geq 2^{(h/2) - 1} \times (1)
$$

$$
N(h) \geq 2^{(h/2) - 1}
$$

Here, we have now derived the minimum number of internal nodes in a BBST. Returning to the original theorem: the height of a BBST with $N$ # of nodes is $O(\log N)$. 

From the above, we know that: 

$$
N(h) \geq 2^{(h/2) - 1}
$$

Taking the log of both sides we obtain: 

$$
log(N(h)) > (h/2) - 1
$$

$$
h < 2 \times log(N(h)) + 2
$$

Finally, we can see that:

$$
h < 2 \times log(N)
$$

So, we have proved that for a BBST with $N$ nodes, the height is guaranteed to be $O(\log N)$