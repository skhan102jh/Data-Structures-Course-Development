---
layout: episode
title: Questions regarding general applications of asymptotic complexity. 
outcomes:
    - Understand and appreciate why we do asymptotic analysis (not just timed performance evaluation.)

time: 10 minutes total with about 3 minutes per question. 
tags: [Runtime, Algorithms]
---

# More Complexities! Questions Pt. 2

## Worksheet Questions:

### Worksheet Question #3:
Suppose you have a quadratic time algorithm that takes 10ms to run when the input size is 25. How long do you think it will take to run for an input of size 100?

### Worksheet Question #4: 
How could you raise some number *N* to the $64^{th}$ power using only 6 multiplications?

### Worksheet Question #5: 
Set **A** has *n* - 1 unique integers from the inclusive range [1,*N*] - find the missing number.


{::solution}


# Solutions

## Worksheet Questions: 

### Worksheet Question #3:

If an algorithm is quadratic time, your actual runtime increases *quadratically* as input size increases. Since 100 is 4 times higher than 25, this means the running time will increase by a factor of $4^2$ = 16. So, the new runtime will be 10 * 16 = 160 ms.



### Worksheet Question #4:


When you raise an exponent to an exponent, those exponents get multiplied together. Conveniently, $2^6$ is 64, so to raise a number *N* to the $64^{th}$ power, you can compute $(((((N^2)^2)^2)^2)^2)^2) = N^{64}$.


### Worksheet Question #5:


See slides.


{:/solution}


{::note}


# Purpose of the questions

## Worksheet Questions: 

### Worksheet Question #3:
(This question already existed in the previous worksheet.)


### Worksheet Question #4:
(This question already existed in the previous worksheet.)


### Worksheet Question #5:
(This question already existed in the previous worksheet.)


{:/note}
