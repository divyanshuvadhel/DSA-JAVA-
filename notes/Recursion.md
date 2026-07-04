# Recursion: Complete Lecture Notes

> **Prerequisites:** Functions, Memory Management (Stack vs Heap)
> **Difficulty:** Beginner to Intermediate

---

## 0. Why This Lecture Matters

> **⚠️ WARNING:** This is the most important topic in the entire DSA course. If you skip or don't understand recursion, you will NOT understand:
> - Binary Trees
> - Linked List problems
> - Binary Search Trees (BST)
> - **Dynamic Programming** (the heart of coding interviews)
> - Heaps & their internal implementations
> - Graphs & traversals (DFS/BFS)
> - 90% of all future course content

**Key Points:**
- Recursion is the **foundation** of almost all advanced DSA topics
- It is **NOT** a difficult topic — it only *feels* confusing at first
- The struggle lasts **2-7 days** for most beginners
- Once understood, it becomes second nature
- **DO NOT** quit the course at recursion — this is where most people give up, and this is where you should push harder

---

## 1. Prerequisites for Recursion

Before starting recursion, you MUST know:
1. **Functions** — how to define, call, and return values
2. **Memory Management** — Stack memory, Heap memory, how variables are stored
3. **Basic Debugging** — stepping through code line by line

> If you don't know these, watch the prerequisite lectures first. Link in playlist description.

---

## 2. How Function Calls Work Internally (The Foundation)

Understanding how normal function calls work is **essential** before understanding recursion.

### 2.1 The Stack Memory
- Every function call in a program is stored in the **Stack Memory**
- The stack follows **LIFO** (Last In, First Out)
- `main()` is always the **first** function pushed and the **last** popped

### 2.2 Function Call Lifecycle

```
Step 1: Function is CALLED → Pushed onto Stack
Step 2: Function EXECUTES → Stays in Stack
Step 3: Function FINISHES → Popped from Stack
Step 4: Control RETURNS to where it was called
```

### 2.3 Key Rules

| Rule | Explanation |
|------|-------------|
| **Rule 1** | While a function is NOT finished executing, it **remains in the stack** |
| **Rule 2** | When a function finishes, it is **removed from stack** |
| **Rule 3** | Program flow **returns to the exact line** where the function was called |
| **Rule 4** | Each function call gets its **own separate memory space** in the stack |

### 2.4 Example: Chained Function Calls

```java
void message1() {
    System.out.println("Hello");
    message2();  // calls message2
    // returns here after message2 finishes
}

void message2() {
    System.out.println("World");
    message3();
}

void message3() {
    System.out.println("!");
}
```

**Stack Evolution:**
```
[main]              → main calls message1
[main, message1]    → message1 calls message2
[main, message1, message2]  → message2 calls message3
[main, message1, message2, message3]  → message3 finishes
[main, message1, message2]  → message3 popped, back to message2
[main, message1]    → message2 popped, back to message1
[main]              → message1 popped, back to main
[]                  → main finishes, program ends
```

---

## 3. What is Recursion?

> **Definition:** Recursion is a function that **calls itself**.

### 3.1 The "Aha!" Moment
Instead of creating multiple functions with the same body:
```java
void print1(int n) { print(n); print2(n+1); }
void print2(int n) { print(n); print3(n+1); }
void print3(int n) { print(n); print4(n+1); }
// ... and so on
```

We create **ONE function** that calls **itself**:
```java
void print(int n) {
    System.out.println(n);
    print(n + 1);  // calls itself!
}
```

### 3.2 The Two Components of Recursion

Every recursive function MUST have:

| Component | Purpose | What Happens Without It |
|-----------|---------|------------------------|
| **Base Condition** | Stops the recursion | **Stack Overflow Error** — infinite calls fill memory |
| **Recursive Call** | Function calls itself with modified parameters | No recursion happens |

### 3.3 Example: Print 1 to 5

```java
void print(int n) {
    // BASE CONDITION
    if (n == 5) {
        System.out.println(5);
        return;  // STOP here, don't call further
    }

    System.out.println(n);   // print current number
    print(n + 1);            // RECURSIVE CALL with n+1
}

// Call: print(1);
// Output: 1 2 3 4 5
```

### 3.4 What Happens Without Base Condition?

```java
void print(int n) {
    System.out.println(n);
    print(n + 1);  // NO base condition!
}
```

**Result:** Prints 1, 2, 3, ... until memory is full → **StackOverflowError**

**Why?**
- Every call adds a new frame to the stack
- Stack has limited size (e.g., 1MB)
- Without stopping condition, stack fills completely
- This is where the website **StackOverflow.com** gets its name from!

---

## 4. How Recursion Works Internally (Stack Visualization)

### 4.1 Example: `print(1)` to `print(5)`

```
CALL PHASE (Building the stack):

[main]              → main calls print(1)
[main, print(1)]    → print(1) calls print(2)
[main, print(1), print(2)]  → print(2) calls print(3)
[main, print(1), print(2), print(3)]  → print(3) calls print(4)
[main, print(1), print(2), print(3), print(4)]  → print(4) calls print(5)
[main, print(1), print(2), print(3), print(4), print(5)]  → Base case hit!

RETURN PHASE (Unwinding the stack):

[main, print(1), print(2), print(3), print(4)]  → print(5) finishes, returns to print(4)
[main, print(1), print(2), print(3)]            → print(4) finishes, returns to print(3)
[main, print(1), print(2)]                      → print(3) finishes, returns to print(2)
[main, print(1)]                                → print(2) finishes, returns to print(1)
[main]                                          → print(1) finishes, returns to main
[]                                              → Program ends
```

### 4.2 Critical Insight

> **Each recursive call is treated as a SEPARATE function call in the stack.**
>
> Even though it's the same function name, each call gets its **own memory space** with its **own copy of parameters and local variables**.

---

## 5. Why Use Recursion?

### 5.1 Advantages

| Advantage | Explanation |
|-----------|-------------|
| **Simplifies Complex Problems** | Breaks big problems into smaller, identical subproblems |
| **Natural Fit** | Perfect for trees, graphs, divide-and-conquer |
| **Readable Code** | Often more intuitive than iterative solutions |
| **Mathematical Elegance** | Direct translation of recurrence relations |

### 5.2 The Process

```
Step 1: Solve using Recursion (easier to think)
Step 2: Convert to Iteration if needed (for optimization)
```

> **Directly solving with iteration is often harder.** Recursion gives you the logic first.

### 5.3 Disadvantages

| Disadvantage | Explanation |
|--------------|-------------|
| **Space Complexity** | Each call uses stack space → O(n) space for n calls |
| **Stack Overflow Risk** | Deep recursion can exceed stack limit |
| **Overhead** | Function call overhead is slower than loops |

---

## 6. The 5-Step Method to Understand ANY Recursion Problem

> **Follow these steps religiously. No one can teach you recursion if you skip these.**

### Step 1: Identify if Problem Can Be Broken Down
- Can you solve a smaller version of the same problem?
- Example: `fib(n) = fib(n-1) + fib(n-2)` — smaller subproblems!

### Step 2: Write the Recurrence Relation
- Express the problem as a mathematical formula
- Example: `T(n) = T(n-1) + T(n-2)` for Fibonacci

### Step 3: Draw the Recursion Tree
- Visualize every function call as a node
- Show which calls which
- **Use pen and paper — no exceptions**

### Step 4: Analyze the Tree

**Sub-step 4a:** See the flow of functions — how they enter the stack

**Sub-step 4b:** Identify left tree calls vs right tree calls
- Left calls execute FIRST (written first in code)
- Right calls execute AFTER left subtree completes

**Sub-step 4c:** See how values are returned at each step
- Trace the return values backward

**Sub-step 4d:** See where function calls come out of
- They return to the exact line where they were called

### Step 5: Use Debugger + Pen & Paper
- Run the code with a debugger
- Draw the tree AGAIN and AGAIN
- **If you don't draw it, you won't understand it — guaranteed**

---

## 7. Example 1: Fibonacci Numbers

### 7.1 Problem
Find the nth Fibonacci number where:
- `F(0) = 0`
- `F(1) = 1`
- `F(n) = F(n-1) + F(n-2)` for n > 1

### 7.2 Recurrence Relation
```
F(n) = F(n-1) + F(n-2)
```

### 7.3 Code
```java
int fibo(int n) {
    // BASE CONDITION
    if (n < 2) {
        return n;  // F(0)=0, F(1)=1
    }

    // RECURSIVE CALLS
    return fibo(n - 1) + fibo(n - 2);
}
```

### 7.4 Recursion Tree for `fibo(4)`

```
                    fibo(4)
                   /       \
              fibo(3)       fibo(2)
             /       \      /       \
        fibo(2)   fibo(1) fibo(1)  fibo(0)
       /       \     |       |        |
   fibo(1)  fibo(0)  1       1        0
      |        |
      1        0

Execution Order:
1. fibo(4) calls fibo(3) [LEFT]
2. fibo(3) calls fibo(2) [LEFT]
3. fibo(2) calls fibo(1) [LEFT] → returns 1
4. fibo(2) calls fibo(0) [RIGHT] → returns 0
5. fibo(2) returns 1+0 = 1
6. fibo(3) calls fibo(1) [RIGHT] → returns 1
7. fibo(3) returns 1+1 = 2
8. fibo(4) calls fibo(2) [RIGHT] → (recomputes: returns 1)
9. fibo(4) returns 2+1 = 3

Final Answer: 3
```

### 7.5 Key Observations

| Observation | Detail |
|-------------|--------|
| **Left-first execution** | `fibo(n-1)` executes completely before `fibo(n-2)` |
| **Repeated computations** | `fibo(2)` is computed TWICE — very inefficient! |
| **Exponential time** | Time complexity is O(φⁿ) where φ ≈ 1.618 (Golden Ratio) |
| **NOT O(2ⁿ)** | Many sources incorrectly say O(2ⁿ); actual is ~O(1.618ⁿ) |

### 7.6 Why Fibonacci is Inefficient

For `fibo(50)`, the program **hangs** because:
- The tree grows exponentially
- Same subproblems are recomputed again and again
- Solution: **Dynamic Programming** (memoization) — store computed values

---

## 8. Types of Recurrence Relations

### 8.1 Linear Recurrence (Decreasing by constant)
```
T(n) = T(n-1) + T(n-2) + ... + f(n)
```
- Search space reduces **linearly** (subtracting constants)
- **Example:** Fibonacci — `T(n) = T(n-1) + T(n-2)`
- **Efficiency:** Very slow for large n

### 8.2 Divide and Conquer (Decreasing by factor)
```
T(n) = T(n/2) + f(n)     // Binary Search
T(n) = 2T(n/2) + f(n)    // Merge Sort
```
- Search space reduces by a **factor** (dividing)
- **Example:** Binary Search — `T(n) = T(n/2) + O(1)`
- **Efficiency:** Much faster — logarithmic or linearithmic

### 8.3 Comparison

| Type | Reduction | Speed | Example |
|------|-----------|-------|---------|
| Linear | n → n-1 | Slow | Fibonacci |
| Divide & Conquer | n → n/2 | Fast | Binary Search, Merge Sort |

> **Dividing by 2 is MUCH faster than subtracting 1.**

---

## 9. Example 2: Binary Search using Recursion

### 9.1 Problem
Find target element in a sorted array.

### 9.2 Recurrence Relation
```
T(n) = T(n/2) + O(1)
// Search in half the array + one comparison
```

### 9.3 Code
```java
int search(int[] arr, int target, int start, int end) {
    // BASE CONDITION - not found
    if (start > end) {
        return -1;
    }

    // BODY - specific to THIS call
    int mid = start + (end - start) / 2;

    // BASE CONDITION - found
    if (arr[mid] == target) {
        return mid;
    }

    // RECURSIVE CALLS
    if (target < arr[mid]) {
        // Search left half
        return search(arr, target, start, mid - 1);
    } else {
        // Search right half
        return search(arr, target, mid + 1, end);
    }
}
```

### 9.4 Recursion Tree for Binary Search

```
search(arr, target=78, start=0, end=6)
    mid = 3, arr[3] = 4
    78 > 4 → search RIGHT

    └── search(arr, target=78, start=4, end=6)
            mid = 5, arr[5] = 66
            78 > 66 → search RIGHT

            └── search(arr, target=78, start=6, end=6)
                    mid = 6, arr[6] = 78
                    FOUND! Return 6

                ← Returns 6
        ← Returns 6
← Returns 6

Final Answer: 6
```

### 9.5 Key Insight: The Return Chain

```
fibo(6,6) returns 6
    ↓
search(4,6) returns 6  ← because of "return search(...)"
    ↓
search(0,6) returns 6  ← because of "return search(...)"
    ↓
main prints 6
```

> **CRITICAL:** Always `return` the recursive call result if your function has a return type!

---

## 10. Working with Variables in Recursion

### 10.1 The Three Types of Variables

| Type | Location | Purpose | Example |
|------|----------|---------|---------|
| **Arguments** | Function parameters | Passed to NEXT recursive calls | `start`, `end` in Binary Search |
| **Return Type** | Function signature | Value returned to PREVIOUS call | `int` in `fibo()`, `int` in `search()` |
| **Body Variables** | Inside function | Specific to CURRENT call only | `mid` in Binary Search |

### 10.2 Golden Rule: Where to Put Variables?

```
┌─────────────────────────────────────────────────────────────┐
│  If a variable is needed by FUTURE calls → Put in ARGUMENTS │
│  If a variable is only for THIS call → Put in BODY          │
│  If a value must go BACK to caller → Use RETURN TYPE        │
└─────────────────────────────────────────────────────────────┘
```

### 10.3 Example Application

**Binary Search Variables:**
- `arr` and `target` → **Arguments** (needed by all future calls)
- `start` and `end` → **Arguments** (define search space for next call)
- `mid` → **Body** (only needed for current comparison)

**Fibonacci Variables:**
- `n` → **Argument** (defines which Fibonacci number)
- Return type `int` → Returns the Fibonacci value back up the chain

---

## 11. Tail Recursion

### 11.1 Definition
> **Tail Recursion** occurs when the **recursive call is the LAST operation** in the function.

### 11.2 Example: Tail Recursive
```java
void print(int n) {
    if (n == 5) {
        System.out.println(5);
        return;
    }
    System.out.println(n);
    print(n + 1);  // LAST statement - nothing after this!
}
```

### 11.3 Example: NOT Tail Recursive
```java
int fibo(int n) {
    if (n < 2) return n;
    return fibo(n-1) + fibo(n-2);  // NOT last - addition happens AFTER calls!
}
```

### 11.4 Why Tail Recursion Matters
- Some compilers can optimize tail recursion into iteration (Tail Call Optimization)
- Saves stack space in optimized environments
- Not all languages support this (Java does NOT, some functional languages do)

---

## 12. Common Mistakes & How to Avoid Them

### Mistake 1: Forgetting Base Condition
```java
void print(int n) {
    System.out.println(n);
    print(n + 1);  // NO BASE CASE → StackOverflowError!
}
```
**Fix:** Always define when to stop.

### Mistake 2: Not Returning Recursive Calls
```java
int search(...) {
    if (target < arr[mid]) {
        search(arr, target, start, mid - 1);  // MISSING return!
    }
}
```
**Fix:** `return search(...)` — always return if function has return type.

### Mistake 3: Wrong Variable Placement
```java
// BAD: mid should be in body, not arguments
int search(int[] arr, int target, int start, int end, int mid) { ... }

// GOOD: mid calculated inside, start/end passed
int search(int[] arr, int target, int start, int end) {
    int mid = ...;  // body variable
}
```

### Mistake 4: Overthinking Before Solving
**The Rule:**
```
1. FIRST: Write the recursive solution (don't think about stack)
2. THEN: Trace through to understand internals
```

---

## 13. How to Study Recursion (Action Plan)

### Week 1: Foundation
| Day | Task |
|-----|------|
| 1-2 | Watch lecture, take notes, understand stack mechanism |
| 3-4 | Draw recursion trees for simple problems (print 1 to N, factorial) |
| 5-6 | Debug Fibonacci step-by-step using pen & paper |
| 7 | Solve 5 easy recursive problems |

### Week 2: Practice
| Day | Task |
|-----|------|
| 8-10 | Solve medium problems (tree traversals, combinations) |
| 11-12 | Implement Binary Search, Merge Sort recursively |
| 13-14 | Start simple Dynamic Programming problems |

### Essential Tools
- **Pen & Paper** — Non-negotiable for drawing trees
- **Debugger** — Step through every line
- **IDE** — Use breakpoints to visualize stack

---

## 14. Quick Reference: Recursion Checklist

When solving ANY recursive problem, verify:

- [ ] Can I break this into smaller identical subproblems?
- [ ] What is the **base condition**? (When do I stop?)
- [ ] What is the **recurrence relation**? (Mathematical formula)
- [ ] What goes in **arguments**? (Future calls need this)
- [ ] What goes in **body**? (Current call only)
- [ ] What is the **return type**? (What goes back to parent?)
- [ ] Am I **returning** recursive calls? (If return type exists)
- [ ] Have I drawn the **recursion tree** on paper?
- [ ] Have I traced the **stack flow**?
- [ ] Have I checked for **tail recursion**?

---

## 15. What's Next?

| Topic | What You'll Learn |
|-------|-----------------|
| **Space & Time Complexity** | Exact formulas for recursive algorithms |
| **Solving Recurrence Relations** | Master Theorem, Akra-Bazzi, characteristic equations |
| **Merge Sort & Quick Sort** | Divide and conquer in action |
| **Trees** | Binary trees, BST, AVL — all use recursion |
| **Graphs** | DFS uses recursion inherently |
| **Dynamic Programming** | Recursion + Memoization = Efficiency |
| **Backtracking** | Recursion with decision trees |
| **Variable Function Calls** | One call spawning multiple children |

---

## 16. Key Takeaways

1. **Recursion is NOT hard** — it only feels hard for the first few days
2. **Draw the tree** — no one can understand recursion without visualizing it
3. **Base condition is mandatory** — without it, you get StackOverflowError
4. **Return your recursive calls** — if your function returns something, return the recursive result
5. **Arguments vs Body** — arguments pass forward, body stays local
6. **Don't overthink initially** — write the solution first, understand internals later
7. **Practice is the ONLY way** — no course can make you pro without your effort

---

> **Remember:** The only way to learn recursion is to sit with pen and paper, draw the tree, and trace every single call. There are no shortcuts.

---

*"Recursion is not about being smart. It's about trusting that the smaller problem will be solved, so you can focus on combining the results."*
