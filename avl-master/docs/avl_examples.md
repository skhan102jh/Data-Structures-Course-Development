---
layout: episode
title: AVL Tree Example with Multiple Rotations
outcomes:
    - Explain and trace the balancing operations of an AVL tree
    - Select the appropriate rotation type in order to rebalance an AVL tree after an operation (insert, remove) is performed
time: 30 
tags: [AVL, tree, rotations, exercise]
---

Beginning with an empty AVL Tree, perform the following operations 

**Section 1: Single Left Rotation**

```java
insert(47);
insert(32);
insert(68);
insert(76);
insert(23);
insert(83);
insert(92);
remove(76);
```

**Section 2: Single Right Rotation**

```java
insert(10);
insert(53);
remove(92);
```

**Section 3: Double Right Left Rotation**

```java
insert(28);
insert(37):
insert(25);
insert(31);
insert(93);
insert(30);
remove(10);
remove(25);
```

**Section 4: Double Left Right Rotation**

```java
insert(57);
insert(50);
insert(62);
remove(83);
insert(29);
remove(32);
```

**Section 5: Challenge Rotations**

```java
remove(28);
remove(29);
insert(100);
remove(31);
insert(10);
remove(93);
```



<details class="solution">
  <summary>Solution</summary>

**Section 1: Single Left Rotation**

`insert(47)`

```plain 
47
```

`insert(32)`

```plain
   47
  /
32
```

`insert(68)`

```plain
   47
 /    \
32    68 
```

`insert(76)`

```plain
    47
   /  \
 /      \
32       68
           \
            76
```

`insert(23)`

```plain
        47
       /  \
     /      \
   32        68
  /            \
23              76
```

`insert(83)`  - TRIGGERS SINGLE LEFT 

```plain 
               47
              /  \
            /      \
          /          \
        /              \ 
      32                68:-2
    /                     \
  /                         \
23                           76:-1
                               \
                                83:0
```

```plain
        47
       /  \
     /      \
   32        76
  /         /  \
23        68    83
```


`insert(92)`

```plain 
             47
            /  \
          /      \
        /          \
      /              \
    32                76
   /                 /  \
 /                 /      \
23               68        83
                             \
                              92
```

`remove(76)` - TRIGGERS SINGLE LEFT FOR STUDENT

```plain 
             47
            /  \
          /      \
        /          \
      /              \
    32                68:-2
   /                    \
 /                        \
23                         83:-1
                             \
                              92:0
```

```plain
        47
       /  \
     /      \
   32        83
  /         /  \
23        68    92
```

---

**Section 2: Single Right Rotation**

`insert(10)` - TRIGGERS SINGLE RIGHT

```plain 
                47
               /  \
             /      \
           /          \
         /              \
       32:2              83
      /                 /   \
    /                 /       \
  23:1              68         92
 /                             
10:0                              
```

```plain
         47
       /    \
     /        \
   23          83
  /  \        /  \
10    32    68    92
```

`insert(53)`

```plain
                47
              /    \
            /        \
          /            \
        /                \ 
       23                 83
      /  \               /  \
    /      \           /      \
  10       32        68       92
                    /
                  53  
```

`remove(92)` - TRIGGERS SINGLE RIGHT FOR STUDENT

```plain
                47
              /    \
            /        \
          /            \
        /                \ 
       23                 83:2
      /  \               / 
    /      \           /     
  10       32         68:1       
                     /
                   53:0  
```

```plain
         47
       /    \
     /        \
   23          68
  /  \        /  \
10    32    53    83
```

---

**Section 3: Double Right Left Rotation**

`insert(28)`

```plain
                47
              /    \
            /        \
          /            \
        /                \ 
       23                 68
      /  \               /  \
    /      \           /      \
  10       32        53       83
          /        
        28           
```

`insert(37)`

```plain
                47
              /    \
            /        \
          /            \
        /                \ 
       23                 68
      /  \               /  \
    /      \           /      \
  10       32        53       83
          /  \      
        28    37
```

`insert(25)` - TRIGGERS DOUBLE RIGHT LEFT

```plain
                            47
                          /    \
                        /        \
                      /            \
                    /                \ 
                  /                    \
                /                        \
              /                            \
            /                                \ 
          23:-2                               68
         /  \                                /  \
       /      \                            /      \
     /          \                        /          \
   /              \                    /              \
10:0              32:1                53               83
                 /  \  
               /      \ 
             28:1     37:0
            /
          25:0 
```

```plain
                   47
                 /    \
               /        \
             /            \
           /                \ 
         28                  68
        /  \                /  \
      /      \            /      \
    23        32         53      83
  /    \         \      
10     25        37
```

`insert(31)`

```plain
                   47
                 /    \
               /        \
             /            \
           /                \ 
         28                  68
        /  \                /  \
      /      \            /      \
    23        32        53        83
  /    \    /    \      
10     25  31     37
```

`insert(93)`

```plain
                   47
                 /    \
               /        \
             /            \
           /                \ 
         28                  68
        /  \                /  \
      /      \            /      \
    23        32        53        83
  /    \    /    \                  \
10     25  31     37                 93
```

`insert(30)`

```plain
                                 47
                               /    \
                             /        \
                           /            \
                         /                \ 
                       /                    \
                     /                        \
                   /                            \
                 /                                \ 
               28                                  68
              /  \                                /  \
            /      \                            /      \
          /          \                        /          \
        /              \                    /              \
      23                32                53                 83
    /    \             /  \                                    \
  /        \         /      \                                    \
10          25     31        37                                   93   
                 /
               30
```

`remove(10)`

```plain
                                 47
                               /    \
                             /        \
                           /            \
                         /                \ 
                       /                    \
                     /                        \
                   /                            \
                 /                                \ 
               28                                  68
              /  \                                /  \
            /      \                            /      \
          /          \                        /          \
        /              \                    /              \
      23                32                53                 83
         \             /  \                                    \
           \         /      \                                    \
            25     31        37                                   93   
                 /
               30
```

`remove(25)` - TRIGGERS DOUBLE RIGHT LEFT FOR STUDENT

```plain
                                 47
                               /    \
                             /        \
                           /            \
                         /                \ 
                       /                    \
                     /                        \
                   /                            \
                 /                                \ 
               28:-2                               68
              /  \                                /  \
            /      \                            /      \
          /          \                        /          \
        /              \                    /              \
      23:0             32:1                53               83
                       /  \                                    \
                     /      \                                    \
                  31:1      37:0                                  93   
                 /
               30:0
```

```plain
                   47
                 /    \
               /        \
             /            \
           /                \ 
         31                  68
        /  \                /  \
      /      \            /      \
    28        32        53        83
  /    \         \                  \
23      30        37                 93
```

---

**Section 4: Double Left Right Rotation**

`insert(57)`

```plain
                    47
                 /      \
               /          \
             /              \
           /                  \ 
         31                    68
        /  \                  /  \
      /      \              /      \
    28        32          53        83
  /    \         \          \         \
23      30        37         57         93
```

`insert(50)`

```plain
                    47
                 /      \
               /          \
             /              \
           /                  \ 
         31                    68
        /  \                  /  \
      /      \              /      \
    28        32          53        83
  /    \         \       /   \         \
23      30        37   50     57        93
```

`insert(62)`

```plain
                                  47
                               /      \
                             /          \
                           /              \
                         /                  \ 
                       /                      \
                     /                          \
                   /                              \
                 /                                  \ 
               31                                    68
              /  \                                  /  \
            /      \                              /      \
          /          \                          /          \
        /              \                      /              \
      28                32                 53                  83
    /    \                \              /     \                  \
  /        \                \          /         \                  \ 
 23        30                37      50           57                 93   
                                                    \
                                                     62
```

`remove(83)` - TRIGGERS DOUBLE LEFT RIGHT

```plain
                                  47
                               /      \
                             /          \
                           /              \
                         /                  \ 
                       /                      \
                     /                          \
                   /                              \
                 /                                  \ 
               31                                    68:2
              /  \                                  /  \
            /      \                              /      \
          /          \                          /          \
        /              \                      /              \
      28                32                53:-1              93:0
    /    \                \              /     \
  /        \                \          /         \
 23        30                37      50:0         57:-1
                                                    \
                                                     62:0
```

```plain
                    47
                 /      \
               /          \
             /              \
           /                  \ 
         31                    57
        /  \                  /  \
      /      \              /      \
    28        32          53        68
  /    \         \       /        /    \
23      30        37   50       62      93
```

`insert(29)`

```plain
                                  47
                               /      \
                             /          \
                           /              \
                         /                  \ 
                       /                      \
                     /                          \
                   /                              \
                 /                                  \ 
               31                                    57
              /  \                                  /  \
            /      \                              /      \
          /          \                          /          \
        /              \                      /              \
      28                32                 53                  68
    /    \                \              /                    /   \
  /        \                \          /                    /       \ 
 23        30                37      50                   62         93   
          /                                         
        29                                           
```

`remove(32)` - TRIGGERS DOUBLE LEFT RIGHT FOR STUDENT

```plain
                                  47
                               /      \
                             /          \
                           /              \
                         /                  \ 
                       /                      \
                     /                          \
                   /                              \
                 /                                  \ 
               31:2                                  57
              /  \                                  /  \
            /      \                              /      \
          /          \                          /          \
        /              \                      /              \
      28:-1             37:0               53                  68
    /    \                               /                   /    \
  /        \                           /                   /        \ 
 23:0      30:-1                     50                   62         93   
          /                                         
        29:0
```

```plain
                    47
                 /      \
               /          \
             /              \
           /                  \ 
         30                    57
        /  \                  /  \
      /      \              /      \
    28        31          53        68
  /    \         \       /        /    \
23      29        37   50       62      93
```

---

**Section 5: Challenge Rotation (Changing Root)**

`remove(28)`

```plain
                47
             /      \
           /          \
         /              \
       /                  \ 
     30                    57
    /  \                  /  \
  /      \              /      \
23        31          53       68
  \         \       /        /    \
    29       37   50       62      93
```

`remove(29)`

```plain
                47
             /      \
           /          \
         /              \
       /                  \ 
     30                    57
    /  \                  /  \
  /      \              /      \
23        31          53        68
             \       /        /    \
              37   50       62      93
```

`insert(100)`

```plain
                            47
                         /      \
                       /          \
                     /              \
                   /                  \ 
                 /                      \
               /                          \
             /                              \
           /                                  \ 
         30                                     57
        /  \                                  /    \
      /      \                              /        \
    /          \                          /            \
  /              \                      /                \
23                31                  53                   68
                    \                /                   /     \
                      \            /                   /         \ 
                       37        50                  62           93   
                                                                    \
                                                                     100
```

`remove(31)` - TRIGGERS SINGLE LEFT IN ROOT

```plain
                           47:-2
                         /      \
                       /          \
                     /              \
                   /                  \ 
                 /                      \
               /                          \
             /                              \
           /                                  \ 
         30:0                                 57:-1
        /  \                                  /    \
      /      \                              /        \
    /          \                          /            \
  /              \                      /                \
23:0              37:0                53:-1               68:-1
                                     /                   /     \
                                   /                   /         \ 
                                 50:0                62:0         93:-1   
                                                                    \
                                                                     100:0
```

```plain
                    57
                 /      \
               /          \
             /              \
           /                  \ 
         47                    68
        /   \                 /  \
      /       \             /      \
    30         53         62        93
  /    \      /                        \
23     37    50                         100
```

`insert(10)`

```plain
                                    57
                                 /      \
                               /          \
                             /              \
                           /                  \ 
                         /                      \
                       /                          \
                     /                              \
                   /                                  \ 
                 47                                     68
                /  \                                  /    \
              /      \                              /        \
            /          \                          /            \
          /              \                      /                \
        30                53                  62                   93
       /  \              /                                           \
     /      \          /                                               \ 
   23        37      50                                                 100   
  /                                                                    
10                                                                     
```

`remove(93)` - TRIGGERS SINGLE RIGHT IN ROOT

```plain
                                   57:2
                                 /      \
                               /          \
                             /              \
                           /                  \ 
                         /                      \
                       /                          \
                     /                              \
                   /                                  \ 
                47:1                                   68:0
                /  \                                  /    \
              /      \                              /        \
            /          \                          /            \
          /              \                      /                \
        30:1              53:-1               62:0                 100:0
       /  \              /                                           
     /      \          /                                                
   23:-1    37:0    50:0                                                   
  /                                                                    
10:0    
```

```plain
                    47
                 /      \
               /          \
             /              \
           /                  \ 
         30                    57
        /   \                 /  \
      /       \             /      \
    23         37         53        68
  /                     /         /    \
10                    50        62      100  
```


</details>
