---
layout: episode
title: Questions regarding simplifying algebraic expressions to find asymptotically dominant term, which determines Big O. 
outcomes:
    - Determine the asymptotic growth rates of a given function (Big O, Big Omega, Big Theta).

time: 12 minutes total throughout lecture broken into 2 minutes for each clicker question and 4 minutes for each worksheet question.
tags: [Complexity]
---

# Algorithmic Complexities Questions Pt. 3

## Clicker Questions:

### Clicker Question #6:  
What is the asymptotic complexity of the following function?


$T(N) = (N+2)^2$log$N + N$log$N + (N+1)^3$


A) $N^3$   
B) $N^2$log$N$  
C) $N$log$N$  
D) $N$  


### Clicker Question #7:   
What summation formula could help us count the total number of steps in this exercise?  


A) Summation of *i*   
B) Summation of $i^2$  
C) Summation of $2^i$   
D) Summation of $c^i$  

## Worksheet Questions:

### Worksheet Question #2
For each of the functions listed below, figure out its growth rate (simplify first!). Then rank the functions in growth rate order, starting with the slowest growth rate (i.e. those resulting in a fast runtime), and ending with the fastest growth rate (worst runtime). If two functions have the same asymptotic complexity, then rank them based on the original expressions (including constants).


| **Function:**| **$\Theta$:** | **Rank:**|
| ----------- | ----------- | ------- |
| **(log$(\frac{N}{4}))^3$**      | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; |
| **$\frac{N^2-4}{N+2}$**  |         | |
| **($3N+$log$N)^2$**  |         | |
| **2log$N^2$**  |         | |
| **$(2^N)^2 + $log$N$**  |         | |
| **$N^2$log16**  |         | |
| **$2N$loglog$N$**  |         | |
| **$4N^2 + N(10+$log$N$)**  |         | |


### Worksheet Question #2.5


For each of the following asymtotic (runtime) complexities, come up with an example function or program that would create this complexity as a function of input with size *N*.


| **Asymptotic Complexity:** | **Your Example:** | **Lecture Example:** |
| ----------- | ----------- | ----- |
| **Linear Time *O*(*N*):**      |    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   |&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; |
| **Constant Time *O*(1):**   |         | |
| **Linearithmic Time *O*(*N*log*N*):**   |         | |
| **Quadratic Time *O*($N^2$):**   |         | |
| **Sublinear Time *O*(log*N*):**   |         | |



{::solution}


# Solutions

## Clicker Questions:

### Clicker Question #6:


**A) $N^3$**   
B) $N^2$log*N*  
C) *N*log*N*  
D) *N*  


**Explanation:** The complexity is effectively the dominant term of the function, as this is what will control the behavior asymptotically. If we expand our function, we see:

$T(N) = (N+2)^2$log$N + N$log$N + (N+1)^3$

$T(N) = (N^2+4N+4)$log$N + N$log$N + N^3 + 3N^2 + 3N + 1$

$T(N) = N^2$log$N + 4N$log$N + 4$log$N + N$log$N + N^3 + 3N^2 + 3N + 1$

$T(N) = N^3 + N^2$log$N + 3N^2 + 5N$log$N + 3N + 4$log$N + 1$

We see above the dominant term is $N^3$, which is our asymptotic complexity.


### Clicker Question #7:


**A) Summation of *i***  
B) Summation of $i^2$ 
C) Summation of $2^i$  
D) Summation of $c^i$ 


**Explanation:** We see the inner loop is dependent on *i*; it runs *i* times each iterations. We see *i* is going from 1:*N*, so that means the inner loop is running 1 time, then 2 times, ... , then *N* times. So, the number of times the inner loop runs is 1 + 2 + ... + *N*, which is represented by the sum of *i*; i.e. that summation formula can help us count the number of steps in this exercise.


## Worksheet Questions:

### Worksheet Question #2


**Explanations & Answers:** 


| **Function:**| **$\Theta$:** | **Rank:**|
| ----------- | ----------- | ------- |
| **(log$(\frac{N}{4}))^3$**    | = (log$N$-log4)$^3$ = (log$N$-2)$^3$ = $\Theta$(log$N)$ | **RANK: 2** |
| **$\frac{N^2-4}{N+2}$**  |    = \frac{(N+2)(N-2)}{N+2} = N-2 = \Theta(N)$   | **RANK: 3**|
| **($3N+$log$N)^2$**  |    = 9N^2 + $log$^2N + 6N$log$N = \Theta(N^2)$     | **RANK: 7**|
| **2log$N^2$**  |     = 4$log$N = \Theta($log$N$)   |**RANK: 1 ( Best! :) )** |
| **$(2^N)^2 + $log$N$**  |   = 4^N + $log$N = \Theta(4^N)$      |**RANK: 8 ( Worst! :( )**|
| **$N^2$log16**  |     = = $4N^2 = \Theta(N^2)$    |**RANK: 5** |
| **$2N$loglog$N$** |   =  Nothing to simplify = $\Theta(N$loglog$N$)    |**RANK: 4** |
| **$4N^2 + N(10+$log$N$)**  |   = $4N^2 + 10N + 4$log$N = \Theta(N^2)$      | **RANK: 6**|



### Worksheet Question #2.5


**Explanations & Answers:** The 'Lecture Examples' are listed in slides 43 - 48 of lec07_slides.pdf. 


{:/solution}


{::note}


# Purpose of the questions

## Clicker Questions:

### Clicker Question #6:
The purpose of this question is to show students how finding the dominant term of their function will give them the asymptotic complexity. Hopefully, with this intuition students will start to be able to simply look at functions and see the dominant term, and hence the complexity, without having to simplify/expand the function.


### Clicker Question #7:
These summations can look irrelevant or confusing at first glance, as its not immediately clear how they can be used in counting steps. So, the point of this question is to give an example of how these summations can be used. This answer is given in the slides, but we think its helpful to have students try to think this through for themselves first to gain some insight into how these summations can be helpful.

## Worksheet Questions:

### Worksheet Question #2
(This question already existed in the previous worksheet.)


### Worksheet Question #2.5
 We want the students to consider methods or data structures that they are already familiar with and think of their associated runtimes, as well as be able to compare their efficiencies.
 
 
 {:/note}
