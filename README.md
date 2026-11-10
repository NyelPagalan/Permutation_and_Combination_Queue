# Permutations and Combinations Using Queue

A Java program that uses a Queue (`LinkedList`) to generate permutations and combinations.

## Features
- Add elements to a Queue (stored in capital letters)
- Display the Queue
- Dequeue two elements when five are entered
- Generate all permutations
- Generate all combinations (no duplicates)
- Display all results and their total counts

## Requirements
- Java JDK 8 or higher

## How to Run
```
javac Main.java
java Main
```

## Menu
```
[1] Add Elements to Queue
[2] Display Queue
[3] Generate Permutations
[4] Generate Combinations
[5] Exit
```

## Sample Output

**Permutations**
```
Queue: [A, B, C]

Enter number of elements to arrange: 3

ABC
ACB
BAC
BCA
CAB
CBA

Total Permutations: 6
```

**Combinations**
```
Queue: [A, B, C, D]

Enter number of elements to select: 2

AB
AC
AD
BC
BD
CD

Total Combinations: 6
```

## Notes
- Permutations and combinations are implemented manually using recursion (no built-in generators).
- Queue operations used: `add()`, `poll()`, `peek()`, `isEmpty()`.
