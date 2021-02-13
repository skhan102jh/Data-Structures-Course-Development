---
layout: episode
title: Questions regarding analyzing asymptotic run times based on input "N."
outcomes:
    - Express the number of steps for a given code segment as a function of the input size in the worst case scenario.

time: 10-12 minutes total throughout lecture broken into 2-3 minute chunks for each clicker question. 
tags: [Complexity, Bounds]
---

# Algorithmic Complexities Questions Pt. 2

## Clicker Questions:

### Clicker Question #2: 
For the linear search example on the previous slide, what is the best (most precise) approximation for the total number of steps taken? (**HINT:** Use the labels for each line!)  


A) 3*N*  
B) 4*N* + 3  
C) 4*N*  
D) 3*N* + 2  


### Clicker Question #3:  
Which of the following functions are in the **set** *O*($n^3$)? Choose all that apply.   


A) $n^2$
B) *n*  
C) $n^4$  
D) $n^3$   


### Clicker Question #4: 
Which of the following pairs $n_0$, *c*, can be used to show that the function $3n^3 + 7$ is in *O*($n^3$)? Choose all that apply.


A) $n_0$ = 0, *c* = 10  
B) $n_0$ = 1, *c* = 10   
C) $n_0$ = 1, *c* = 9  
D) $n_0$ = 2, *c* = 4  


### Clicker Question #5:
Which of the following pairs $n_0$, *c*, can be used to show that the function $3n^3 + 7$ = $\Omega(n^3)$?


A) $n_0$ = 0, *c* = 3  
B) $n_0$ = 1, *c* = 11  
C) $n_0$ = 1, *c* = 12   
D) $n_0$ = 0, *c* = 1  


{::solution}


# Solutions

## Clicker Questions:

### Clicker Question #2: (Difficulty Level: Tricky)


A) 3*N*  
B) 4*N* + 3  
C) 4*N*  
**D) 3*N* + 2**


**Explanation:** Iterating through each value in the list gives us *N*. We have worst case that no value equals target, so all *N* iterations get checked and fail the 'if' statement and go to 'otherwise', for another *N* operations. In 'otherwise', the value is incremented, and since this happens each iteration we have *N* more operations, for a total of 3*N*. Index = 0 is one step, as is returning the value, for a total of 3*N* + 2 steps total.


### Clicker Question #3:


**A) $n^2$**   
**B) *n***  
C) $n^4$ 
**D) $n^3$**  


**Explanation:** A), B), and D) are all $\leq n^3$, and such for $n_0$ = 0 and *c* = 1, all of those functions satisfy the criteria for *O*($n^3$). $n^4 \geq n^3$ always, so it is not in *O*($n^3$).


### Clicker Question #4:


A) $n_0$ = 0, *c* = 10  
**B) $n_0$ = 1, *c* = 10**  
C) $n_0$ = 1, *c* = 9  
**D) $n_0$ = 2, *c* = 4**


**Explanation:** For A), at $n_0$ = 0 we have 7 $\leq$ 10, which is false. Similarly for C), at $n_0$ = 1 we have 12 $\leq$ 9, which is also false. For B), we can see that with *c* = 10, $3n^3 + 7 \leq 3n^3 + 7n^3 \leq 10n^3 \leq 10n^3$, which holds for all *n* > 0, so $n_0$ = 1 satisfies the conditions (at $n_0$ = 0 we have 7 $\leq$ 0, which fails). We use a similar argument for D), where $3n^3 + 7 \leq 4n^3$ for all *n* > 1, so $n_0$ = 2 satisfies the conditions (at $n_0$ = 0 we have 7 $\leq$ 0 which is false, and at $n_0$ = 1 we have 10 $\leq$ 4 which is false, but at $n_0$ = 2 we have 31 $\leq$ 32, which is true and remains true for all larger *n*).


### Clicker Question #5:


**A) $n_0$ = 0, *c* = 3**    
B) $n_0$ = 1, *c* = 11  
C) $n_0$ = 1, *c* = 12  
**D) $n_0$ = 0, *c* = 1**  


**Explanation:** For B), at $n_0$ = 1 we have 10 $\geq$ 11, which is false. Similarly for C), at $n_0$ = 1 we have 10 $\geq$ 12, which is also false. For A), we can see that with *c* = 3, $3n^3 + 7 \geq 3n^3 \geq 3n^3$, which holds for all *n* $\geq$ 0, so $n_0$ = 0 satisfies the conditions. We use a similar argument for D), where $3n^3 + 7 \geq 3n^3 \geq n^3$ for all *n* $\geq$ 0, so $n_0$ = 0 satisfies the conditions.


{:/solution}


{::note}


# Purpose of the questions

## Clicker Questions:

### Clicker Question #2:
This problem is meant to be tricky. If the students simply sum the steps that are labeled, they would arrive at 4N + 3, which is incorrect. This exercise forces students to think about how the "if-else" structure of code affects the total number of steps taken. 


### Clicker Question #3:
The purpose of this question is to reinforce the idea that if a function is in *O*(*f*(*n*)), it is *also* in *O*(*g*(*n*)) for all functions *g*(*n*) that are larger than *f*(*n*). This is a subtle point, but it demonstrates *O()* is not just the lowest upper bound, but can be *any* function that is larger/grows faster than your function.


### Clicker Question #4:
The purpose of this question is to show students that there are infinite solutions to the pair $n_0$, *c* to satisfy the conditions. Here there are multiple correct answers, which is emphasized in the following slide of the PowerPoint.


### Clicker Question #5:
Same justification as Question #4, just for $\Omega$() instead of *O*().


{:/note}
