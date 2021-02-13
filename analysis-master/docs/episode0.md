---
layout: episode
title: Questions regarding counting steps based on specific code loops. 
outcomes:
    - Express the number of steps for a given code segment as a function of the input size in the worst case scenario.

time: 15 minutes total throughout lecture broken into 2-3 minutes for clicker question #1 and 10-12 minutes for worksheet question #1. 
tags: [Steps, Complexity]
---

# Algorithmic Complexities Questions Pt. 1

## Clicker Questions:

### Clicker Question #1:  
What is the total number of steps taken in the following code?  
```java
int count = 0;  
for (int i = 0; i < 10; i++) {  
    for (int j = 0; j < 5; j++) {  
        count++;  
    }   
}  
System.out.println(count);  
```


A) about 50    
B) about 200   
C) about 500  
D) about 2000  

## Worksheet Questions:

### Worksheet Question #1:


For each of the following code fragments, derive the $\Theta$ time complexity (tight bound) as a function of *N*. Remember, this means it must be big *O* and $\Omega$ of the function, bounded above and below for the worse-case scenario. You must show all work, including approximate operation counts. For partial credit, give the best *O* and $\Omega$ bounds you can figure out, even if they are not tight. 

a.)
```java
sum = 0;
for ( i = 0; i < 2*N; i+=4)
    sum += i;
```

b.)
```java
sum = 0;
s = keyboard.nextLine(); // keyboard is an initialized Scanner
N = s.length();
v = "aeiou";
for ( i=0; i < v.length(); i++)
    if ( s.indexOf(v.charAt(i)) >= 0)
	sum++;
```

c.)
```java
sum = 0;
for ( i = 0; i < 3*N; i++)
    for ( j = 0; j < 5; j++)
	for ( k = i; k > 1; k--)
	    sum++;
```


{::solution}


# Solutions

## Clicker Questions:

### Clicker Question #1:


A) about 50    
**B) about 200**   
C) about 500  
D) about 2000 


```java
int count = 0;                             // 1 (or 2?)
for (int i = 0; i < 10; i++) {  	   // 1 (or 2?) + 11 + 10
    for (int j = 0; j < 5; j++) {  	   // (1 (or 2?) + 6 + 5) * 10
        count++;  			   // 5 * 10
    }   				   //
}  					   //
System.out.println(count);  		   // 1
```


**Explanation:** Each time the inner loop runs, j is compared to 5, j is incremented, and count is incremented. So, we have 3 * 5 = 15 operations, plus the initial j = 0 operation, and the check j < 5 once j = 5, which gives us 17 operations total. This is run 10 times, since the outer loop goes from 0:9, so we have 170 operations. Each time the outer loop runs, we also have that i is compared to 10 and incremented, giving us 20 more operations for a total of 190. Finally, in this loop i is initialized and is checked against 10 when it equals 10, for 2 more operations. Then adding the initialization of count at the beginning and the print call at the end, we have a total of 194 operations (steps). Note we ask for approximate because the details can get tricky (e.g. does int i = 0 count as an initialzation and a declaration, or just an initialization?), so really we want to see if students can handle the loop multiplication properly.


## Worksheet Questions:


### Worksheet Question #1:


a.)


**Answer:** $\Theta$(*N*)


**Explanation:** *i* is being incremented by 4 each time, and the loop is running until *i* < 2*N*, so the loop will run 2*N*/4 = *N*/2 times. The check '*i* < 2*N*' will happen *N*/2 + 1 times (check will run when *i* = *N*/2), and the increment will happen *N*/2 times. The operation sum += *i* will run each time *i* is incremented, so that is another *N*/2 steps. Counting the 2 initializations sum = 0 and *i* = 0, we have a total of *T*(*N*) = 3(*N*/2) + 3 steps. We can see (3/2)*N* <= *T*(*N*), so *T*(*N*) is in $\Omega$(*N*). We can also see *T*(*N*) <= (9/2)*N*, so *T*(*N*) is in *O*(*N*). Since *T*(*N*) is in both $\Omega$(*N*) and *O*(*N*), we have *T*(*N*) is in $\Theta$(*N*).



b.)


**Answer:** $\Theta$(*N*)


**Explanation:** Note that while "indexOf" may seem like a constant operation, it is actual a linear search; it is  telling you to search through an array (in this case, a word) until you find the proper position. So, we are effectively running a linear search for each vowel (i.e. a constant number of times), and we know linear search is $\Theta$(*N*), so we have a tight bound of $\Theta$(*N*) for this program.



c.) **(Difficulty: Tricky)**


**Answer:** $\Theta(N^2)$


**Explanation:** This one is tricky. We know the outer loop will run 3*N* times, and the second loop will run 5 times for each *N*, for a total of 15*N* times. The third loop is tricky, and runs depending on *i*. Since this *k* loop is dependent on *i*, *k* will take values from 0:3*N*, but since *k* is being decremented will be equal to *i*-1. So, the last loop will run 3*N*-1 times while the outer loop runs *3N* times and the middle loop runs 5 times each, for a total of *O*((3*N*(3*N*-1))5), which we know is $\Theta(N^2)$.


{:/solution}


{::note}


# Purpose of the questions


## Clicker Questions:


### Clicker Question #1:
This serves as an introduction to students of what step counting really is. There is no level of conceptual abstraction here, so students can becoming acquainted with what to qualify as a step and arrive at a specific number of steps. This exercise is meant to build a foundation before we introduce the idea of the number of steps depending on input size "N." The instructor is able to assess the baseline understanding of the students' abilities to count steps in for loops. 


## Worksheet Questions:


### Worksheet Question #1:
(This question already existed on the worksheet.)


Might be a good idea here to emphasize the importance of doing asymptotic analysis; i.e. counting steps isn't a consistent measure, etc. Some emphasis on the *appreciation* of why we do asymptotic analysis might need to be directly stated/reinforced to get the point across.


Also a good idea to emphasize the importance of input size on solution efficiency before doing the worksheet. Giving students a chance to really think about and process what "worst-case" really means physically for a program (i.e. the input that causes that case), rather than just knowing an algorithm can run slow, is good to reinforce here.


{:/note}
