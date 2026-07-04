# Algorithm Complexity Analysis

> **Topics Covered:** Time Complexity, Space Complexity, Big-O/Omega/Theta, Recurrence Relations, Sorting, NP-Completeness

---

## 1. Introduction to Complexity Analysis

### 1.1 Why Complexity Analysis?
- **Real-world scenario:** If you run the same algorithm on an old computer vs. a new computer, the actual time taken will differ.
- However, the **rate at which time grows with respect to input size** remains the same.
- Therefore, we do not measure actual clock time. We measure the **growth rate** of time/space as input grows.

### 1.2 Time Complexity ≠ Time Taken
| Concept | Meaning |
|---------|---------|
| **Actual Time** | Depends on hardware, compiler, OS, programming language |
| **Time Complexity** | Mathematical function describing how time grows as input size `n` grows |

- We care about **trends**, not absolute seconds.
- We always analyze for **large input sizes** (as `n → ∞`). Small inputs don't reveal the true trend.

---

## 2. Time Complexity (Detailed)

### 2.1 Definition
> **Time Complexity** is a mathematical function that describes the amount of time an algorithm takes to run as a function of the length of the input string.

- It tells us **how the time will grow** as the input size grows.
- It gives a **relationship**, not an exact duration.

### 2.2 Comparing Growth Rates
Consider searching 1 million elements:

| Algorithm | Time Complexity | Approximate Steps |
|-------------|-----------------|-------------------|
| Linear Search | O(n) | ~1,000,000 |
| Binary Search | O(log n) | ~20 |

- For **small n**, differences are negligible.
- For **large n**, the difference becomes massive.
- **Rule of Thumb:** Always analyze complexity for large inputs.

### 2.3 Common Growth Functions (Slowest → Fastest)
```
O(1) < O(log n) < O(√n) < O(n) < O(n log n) < O(n²) < O(n³) < O(2ⁿ) < O(n!)
```

| Complexity | Name | Example |
|------------|------|---------|
| O(1) | Constant | Accessing array by index |
| O(log n) | Logarithmic | Binary Search |
| O(n) | Linear | Linear Search, traversing array |
| O(n log n) | Linearithmic | Merge Sort, Quick Sort (avg) |
| O(n²) | Quadratic | Bubble Sort, Selection Sort |
| O(n³) | Cubic | Floyd-Warshall |
| O(2ⁿ) | Exponential | Subset generation |
| O(n!) | Factorial | Traveling Salesman (brute force) |

---

## 3. The Three Golden Rules of Complexity Analysis

### Rule 1: Always Look at the Worst Case
- Unless specified otherwise, assume **Worst Case Time Complexity**.
- Why? Because it gives an **upper bound guarantee**.
- Example: In linear search, the worst case is the element is at the end or not present → `O(n)`.

### Rule 2: Ignore Constants & Lower-Order Terms
- We only care about the **dominant term** (the term that grows fastest as `n → ∞`).
- Constants and smaller terms become insignificant for large `n`.

**Examples:**
- `3n + 5` → **O(n)**
- `n² + 3n + 100` → **O(n²)**
- `100n log n + 50n` → **O(n log n)**
- `2ⁿ + n³` → **O(2ⁿ)**

### Rule 3: Ignore Machine-Specific Factors
- Do not consider hardware speed, programming language, or compiler optimizations.
- Time complexity is **independent** of the machine it runs on.

---

## 4. Asymptotic Notations

Asymptotic notations describe the **bounding behavior** of functions as the input tends toward infinity.

### 4.1 Big-O Notation (O) — Upper Bound
> **Definition:** `f(n) = O(g(n))` if there exist positive constants `c` and `n₀` such that:
> ```
> 0 ≤ f(n) ≤ c·g(n)  for all n ≥ n₀
> ```

- **Meaning:** `f(n)` grows **no faster than** `g(n)`.
- It provides an **asymptotic upper bound**.
- **Analogy:** `f(n)` is "less than or equal to" `g(n)` in terms of growth rate.

**Examples:**
- `3n² + 2n + 1 = O(n²)`
- `100n + 50 = O(n)`
- `n = O(n²)` (loose but valid upper bound)

### 4.2 Big-Omega Notation (Ω) — Lower Bound
> **Definition:** `f(n) = Ω(g(n))` if there exist positive constants `c` and `n₀` such that:
> ```
> 0 ≤ c·g(n) ≤ f(n)  for all n ≥ n₀
> ```

- **Meaning:** `f(n)` grows **at least as fast as** `g(n)`.
- It provides an **asymptotic lower bound**.
- **Analogy:** `f(n)` is "greater than or equal to" `g(n)`.

**Examples:**
- `3n² + 2n = Ω(n²)`
- `n³ = Ω(n²)`

### 4.3 Big-Theta Notation (Θ) — Tight Bound
> **Definition:** `f(n) = Θ(g(n))` if and only if:
> ```
> f(n) = O(g(n))  AND  f(n) = Ω(g(n))
> ```

- **Meaning:** `f(n)` grows **at exactly the same rate** as `g(n)`.
- It provides both an **upper and lower bound**.
- **Analogy:** `f(n)` is "equal to" `g(n)` in terms of growth.

**Examples:**
- `3n² + 2n = Θ(n²)`
- `100n + 50 = Θ(n)`

### 4.4 Little-o Notation (o) — Strict Upper Bound
> **Definition:** `f(n) = o(g(n))` if:
> ```
> lim (n→∞) [f(n) / g(n)] = 0
> ```

- **Meaning:** `f(n)` grows **strictly slower** than `g(n)`.
- This is a **stronger statement** than Big-O.
- **Analogy:** `f(n)` is "strictly less than" `g(n)`.

**Examples:**
- `n = o(n²)`
- `n log n = o(n²)`
- `100n = o(n²)`

### 4.5 Little-Omega Notation (ω) — Strict Lower Bound
> **Definition:** `f(n) = ω(g(n))` if:
> ```
> lim (n→∞) [f(n) / g(n)] = ∞
> ```

- **Meaning:** `f(n)` grows **strictly faster** than `g(n)`.
- **Analogy:** `f(n)` is "strictly greater than" `g(n)`.

**Examples:**
- `n² = ω(n)`
- `n² = ω(n log n)`

### 4.6 Notation Summary Table

| Notation | Bound Type | Mathematical Meaning | Analogy |
|----------|------------|----------------------|---------|
| **O** | Upper | `f(n) ≤ c·g(n)` | ≤ |
| **Ω** | Lower | `f(n) ≥ c·g(n)` | ≥ |
| **Θ** | Tight | Both O and Ω | = |
| **o** | Strict Upper | `f(n) / g(n) → 0` | < |
| **ω** | Strict Lower | `f(n) / g(n) → ∞` | > |

---

## 5. Space Complexity

### 5.1 Definition
> **Space Complexity** = **Input Space** + **Extra (Auxiliary) Space**

- **Input Space:** Space required to store the input itself.
- **Auxiliary Space:** Extra space used by the algorithm (variables, recursion stack, temporary arrays, etc.).

### 5.2 Examples

| Algorithm | Auxiliary Space | Space Complexity |
|-----------|----------------|------------------|
| Bubble Sort | O(1) | O(1) |
| Selection Sort | O(1) | O(1) |
| Insertion Sort | O(1) | O(1) |
| Merge Sort | O(n) | O(n) |
| Quick Sort | O(log n) (avg) | O(log n) |
| Binary Search | O(1) iterative, O(log n) recursive | O(1) / O(log n) |

### 5.3 Important Note
- When we say "Space Complexity is O(1)", it means the algorithm uses **constant extra space** (in-place).
- Recursion uses stack space. The maximum depth of recursion determines the space used.

---

## 6. Complexity Analysis of Sorting Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable? |
|-----------|-----------|--------------|------------|-------|---------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | Yes |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) | No |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | Yes |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
| **Heap Sort** | O(n log n) | O(n log n) | O(n log n) | O(1) | No |
| **Counting Sort** | O(n+k) | O(n+k) | O(n+k) | O(k) | Yes |
| **Radix Sort** | O(nk) | O(nk) | O(nk) | O(n+k) | Yes |

*(Where k = range of input, d = number of digits)*

### 6.1 Key Insights
- **Bubble Sort:** Can be optimized with a flag to detect if array is already sorted.
- **Selection Sort:** Always performs `n²` comparisons regardless of input order.
- **Insertion Sort:** Excellent for small or nearly sorted arrays.
- **Merge Sort:** Guaranteed O(n log n) but requires extra space.
- **Quick Sort:** Fastest in practice for average cases but O(n²) worst case.

---

## 7. Complexity Analysis of Recursive Programs

### 7.1 Key Insight: Function Call Stack
- Every recursive call consumes stack memory.
- At any point in time, only calls along the **current path** exist in the stack.
- **Calls at the same level do NOT exist simultaneously** in the stack.

### 7.2 Rule for Space Complexity of Recursion
> **Space Complexity of a Recursive Program = Height of the Recursion Tree**

Or equivalently:
> **Maximum depth of the recursion stack**

### 7.3 Example: Factorial
```c
int fact(int n) {
    if (n == 0) return 1;
    return n * fact(n - 1);
}
```
- **Time:** O(n) — n function calls
- **Space:** O(n) — recursion depth goes up to n

### 7.4 Example: Binary Search (Recursive)
```c
int binarySearch(int arr[], int l, int r, int x) {
    if (r >= l) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == x) return mid;
        if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);
        return binarySearch(arr, mid + 1, r, x);
    }
    return -1;
}
```
- **Time:** O(log n)
- **Space:** O(log n) — maximum recursion depth is log₂n

---

## 8. Recurrence Relations

A recurrence relation is an equation that defines a sequence based on a rule that gives the next term as a function of the previous term(s).

### 8.1 Types of Recurrence Relations

#### Type 1: Divide and Conquer
General form:
```
T(n) = a·T(n/b) + f(n)
```
- `a` = number of subproblems
- `n/b` = size of each subproblem
- `f(n)` = cost of dividing and combining

**Examples:**
- **Binary Search:** `T(n) = T(n/2) + O(1)` → `T(n) = O(log n)`
- **Merge Sort:** `T(n) = 2T(n/2) + O(n)` → `T(n) = O(n log n)`

#### Type 2: Linear Recurrence (Decreasing)
General form:
```
T(n) = a·T(n-1) + b·T(n-2) + ... + f(n)
```

**Examples:**
- **Fibonacci:** `T(n) = T(n-1) + T(n-2) + O(1)` → `T(n) = O(2ⁿ)` (naive), `O(n)` (memoized)
- **Factorial:** `T(n) = T(n-1) + O(1)` → `T(n) = O(n)`

---

## 9. Solving Recurrence Relations

### 9.1 Akra-Bazzi Theorem (Generalized Master Theorem)
Used for solving divide-and-conquer recurrences of the form:
```
T(x) = Σ(i=1 to k) aᵢ · T(bᵢ · x + hᵢ(x)) + g(x)
```

Where:
- `aᵢ > 0` and `0 < bᵢ < 1`
- `hᵢ(x)` is polynomially smaller than `x`
- `g(x)` is polynomially bounded

**Solution:**
1. Find `p` such that: `Σ aᵢ · bᵢ^p = 1`
2. Then:
```
T(x) = Θ(x^p · (1 + ∫(1 to x) [g(u) / u^(p+1)] du))
```

**Special Case (Master Theorem):**
For `T(n) = aT(n/b) + f(n)` where `f(n) = Θ(n^c)`:

| Case | Condition | Solution |
|------|-----------|----------|
| **1** | `c < log_b(a)` | `T(n) = Θ(n^(log_b a))` |
| **2** | `c = log_b(a)` | `T(n) = Θ(n^c · log n)` |
| **3** | `c > log_b(a)` | `T(n) = Θ(n^c)` |

### 9.2 Solving Homogeneous Linear Recurrence Relations

**Standard Form:**
```
a₀·f(n) + a₁·f(n-1) + a₂·f(n-2) + ... + aₖ·f(n-k) = 0
```

**Steps:**
1. **Form the Characteristic Equation:**
   Replace `f(n)` with `r^n`:
   ```
   a₀·r^k + a₁·r^(k-1) + ... + aₖ = 0
   ```

2. **Find the Roots:**
   Solve the characteristic equation to get roots `r₁, r₂, ..., rₖ`.

3. **General Solution:**
    - **Distinct Roots:**
      ```
      f(n) = c₁·r₁^n + c₂·r₂^n + ... + cₖ·rₖ^n
      ```
    - **Repeated Root (multiplicity m):**
      ```
      (c₁ + c₂·n + c₃·n² + ... + cₘ·n^(m-1)) · r^n
      ```

4. **Use Initial Conditions** to find constants `c₁, c₂, ...`.

**Example: Fibonacci Sequence**
```
f(n) = f(n-1) + f(n-2)
```
- Characteristic equation: `r² - r - 1 = 0`
- Roots: `r = (1 ± √5) / 2`
- General solution: `f(n) = c₁·((1+√5)/2)ⁿ + c₂·((1-√5)/2)ⁿ`
- Using `f(0)=0, f(1)=1`, we get the **Golden Ratio formula** (Binet's Formula):
  ```
  f(n) = (1/√5) · [φⁿ - (1-φ)ⁿ],  where φ = (1+√5)/2 ≈ 1.618
  ```

### 9.3 Solving Non-Homogeneous Linear Recurrence Relations

**Standard Form:**
```
a₀·f(n) + a₁·f(n-1) + ... + aₖ·f(n-k) = g(n)
```
where `g(n) ≠ 0`.

**Steps:**
1. **Find Homogeneous Solution (fₕ):** Solve the equation as if `g(n) = 0`.
2. **Find Particular Solution (fₚ):** Guess a solution based on `g(n)`.
3. **General Solution:** `f(n) = fₕ(n) + fₚ(n)`
4. **Use Initial Conditions** to find constants.

#### How to Guess a Particular Solution?

| Form of g(n) | Guess for fₚ(n) |
|--------------|-----------------|
| Constant `c` | `A` (constant) |
| Polynomial of degree `d` | Polynomial of degree `d` (or higher if conflict) |
| `c·r^n` | `A·r^n` |
| `c·n·r^n` | `(An + B)·r^n` |
| `c·sin(kn)` or `c·cos(kn)` | `A·sin(kn) + B·cos(kn)` |

**Important Rule:** If your guess conflicts with the homogeneous solution, multiply by `n` (or `n^m` where `m` is multiplicity).

**Example:**
```
f(n) = 2f(n-1) + 1,  with f(0) = 0
```
1. Homogeneous: `fₕ(n) = c·2ⁿ`
2. Guess particular: `fₚ(n) = A` (constant)
3. Substitute: `A = 2A + 1` → `A = -1`
4. General: `f(n) = c·2ⁿ - 1`
5. Using `f(0)=0`: `0 = c·1 - 1` → `c = 1`
6. Final: `f(n) = 2ⁿ - 1` → **O(2ⁿ)**

---

## 10. NP-Complete Problems

### 10.1 Key Definitions

| Class | Definition |
|-------|------------|
| **P** | Problems solvable in **Polynomial Time** by a deterministic algorithm |
| **NP** | Problems whose solutions can be **verified** in Polynomial Time |
| **NP-Hard** | Problems at least as hard as the hardest problems in NP |
| **NP-Complete** | Problems that are both **in NP** and **NP-Hard** |

### 10.2 Important Properties
- **P ⊆ NP** (Every problem solvable in polynomial time can be verified in polynomial time)
- **P vs NP** is one of the most important unsolved problems in computer science.
- If **P = NP**, then every problem whose solution can be quickly verified can also be quickly solved.

### 10.3 Examples of NP-Complete Problems
- **Traveling Salesman Problem (TSP)**
- **Knapsack Problem**
- **Boolean Satisfiability (SAT)**
- **Graph Coloring**
- **Clique Problem**
- **Hamiltonian Path**
- **Subset Sum Problem**

### 10.4 Why Care?
- No known polynomial-time algorithm exists for NP-Complete problems.
- For large inputs, exact solutions are computationally infeasible.
- We use **approximation algorithms**, **heuristics**, or **brute force** for small inputs.

---

## 11. Quick Reference: Complexity Cheat Sheet

### Data Structures

| Operation | Array | Linked List | BST (avg) | BST (worst) | Hash Table |
|-----------|-------|-------------|-----------|-------------|------------|
| Access | O(1) | O(n) | O(log n) | O(n) | O(1) |
| Search | O(n) | O(n) | O(log n) | O(n) | O(1) |
| Insert | O(n) | O(1)* | O(log n) | O(n) | O(1) |
| Delete | O(n) | O(1)* | O(log n) | O(n) | O(1) |

*At known position

### Graph Algorithms

| Algorithm | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| BFS | O(V + E) | O(V) |
| DFS | O(V + E) | O(V) |
| Dijkstra (binary heap) | O((V+E) log V) | O(V) |
| Bellman-Ford | O(V·E) | O(V) |
| Floyd-Warshall | O(V³) | O(V²) |
| Kruskal's MST | O(E log E) | O(E) |
| Prim's MST | O(E log V) | O(V) |

### Dynamic Programming Patterns

| Problem | Time | Space | Optimization |
|---------|------|-------|--------------|
| Fibonacci | O(n) | O(n) → O(1) | Space optimization |
| 0/1 Knapsack | O(n·W) | O(n·W) → O(W) | 1D array |
| LCS | O(m·n) | O(m·n) → O(min(m,n)) | Rolling array |
| Matrix Chain | O(n³) | O(n²) | — |
| Edit Distance | O(m·n) | O(m·n) → O(min(m,n)) | Rolling array |

---

## 12. Important Interview Tips

1. **Always clarify:** Ask if the interviewer wants best, average, or worst case.
2. **Specify both:** Time AND Space complexity.
3. **Explain your reasoning:** Don't just state the answer; show how you derived it.
4. **Watch for hidden complexity:**
    - String concatenation in loops: O(n²) in some languages
    - Sorting inside a loop: O(n log n) per iteration
    - Recursive calls creating overlapping subproblems
5. **Master the math:** Know logarithm properties, geometric series, and the Master Theorem.
6. **Practice the "Three Rules":**
    - Worst case
    - Drop constants and lower-order terms
    - Ignore machine factors

---

## 13. Common Mistakes to Avoid

| Mistake | Correction |
|---------|------------|
| Confusing actual time with time complexity | They are unrelated; complexity is about growth rate |
| Using best case by default | Always assume worst case unless stated otherwise |
| Forgetting recursion stack space | Space complexity includes auxiliary AND stack space |
| Ignoring the base case in recurrences | Base cases are crucial for closed-form solutions |
| Writing `O(2n)` instead of `O(n)` | Drop constants: `O(2n)` is just `O(n)` |
| Thinking `O(n²)` is always bad | It depends on constraints; for `n ≤ 1000`, it may be fine |

---

> **End of Notes**
>
> *"Time complexity is not about how fast your computer is. It's about how smart your algorithm is."*
