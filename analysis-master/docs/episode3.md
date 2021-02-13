---
layout: episode
title: Questions regarding space complexity depending on method implementation. 
outcomes:
    - Express the space requirements for a given code segment as a function of the input size in the worst case scenario.
time: 5 minutes total throughout lecture broken into 2-3 minute chunks 
tags: [Fibonacci, Recursion]
---


# More Complexities! Questions Pt. 1

## Clicker Questions

### Clicker Question #1:
What is the asymptotic complexity of this first Fibonacci version?


A) *n*  
B) $n^2$  
C) $2^n$   
D) log*n*  


### Clicker Question #2:
Now that we have observed a simulation of this Fibonacci method, what is the asymptotic complexity of this first Fibonacci version?


A) *n*  
B) $n^2$   
C) $2^n$     
D) log*n* 


### Clicker Question #3:  
In this iterative form of the Fibonacci method, how is the extra space dependent on the parameter n? For the worst-case scenario, extra space is...?


A) Constant     
B) *n*  
C) $n^2$  
D) $2^n$    


{::solution}


# Solutions

## Clicker Questions

### Clicker Question #'s 1 & 2:  (Difficulty Level: Tricky)


A) *n*   
B) $n^2$  
**C) $2^n$**      
D) log*n*


**Explanation:** Each time we call fib(int n), we are making 2 more calls to fib(int n). Worst case we are calling *O*(*n*) times, for a total of $2^n$. We have to make these two extra calls for each call regardless, so our lower bound is also $2^n$, for a tight bound of $2^n$. 


### Clicker Question #3:


**A) Constant**    
B) *n*    
C) $n^2$   
D) $2^n$ 


**Explanation:** Regardless of how large *n* is, the only space needed is for variables declared. So, there is a *constant* amount of space needed regardless of *n*, so we have constant space.


{:/solution}


{::note}


# Purpose of the questions

## Clicker Questions

### Clicker Question #'s 1 & 2:  
Recursion can be really tricky, especially when trying to explicitly count how many steps are taken. Since this is the first time recursion appears in our complexity discussion, we think it would be beneficial for students to try to reason this out on their own, since the example is not overly difficult. We give students a chance to answer this question before and after the simulation so that they can change their thinking if they did not intially understand how the method will use extra space.  

The purpose of having two questions is so that students can take their best intuitive guess beforehand, and then when they see how the recursive process works they can think about it with context and see if they change their answer.

It might be a good idea to clarify why the second most popular answer is incorrect if students are still confused. Recursive complexity can be very tricky, so it's important to ensure the students understand the material.


### Clicker Question #3:
Most of the discussion on asymptotics thus far has been with running time, so we thought it would be good to give students a question to think about *space* as well. It is good in this example too because the tradeoff between space and time is noted, so students can start to understand having a really fast run time is not everything.


{:/note}
