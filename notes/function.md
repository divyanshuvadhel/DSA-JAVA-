# Java Notes — Lecture 2 (Functions / Methods)


---

## why do we even need functions?

so the problem was simple — take two numbers as input and print their sum. easy right. but then he said okay now do it 10 times. and the solution without functions is just copy pasting the same code 10 times which is obviously terrible.

two reasons why that's bad:

**1. don't repeat yourself (DRY principle)**
if you write the same code again and again and then later want to change something — like the logic changes — you have to go edit it in 10 different places. nightmare.

**2. readability**
nobody wants to read 200 lines of repeated code. functions let you give a name to a block of code and just call that name whenever you need it. clean and simple.

so basically — function = a block of code that does one specific thing, and you can call it as many times as you want from anywhere.

---

## syntax of a method in java

```java
accessModifier returnType methodName(parameters) {
    // body of the method
    return something;  // if return type is not void
}
```

example of the most basic function:

```java
public static void greet() {
    System.out.println("Hello!");
}
```

and you call it like this from main:

```java
greet();   // just write the name and brackets
```

every time you write `greet()`, it runs that block of code. call it 100 times, it runs 100 times. change it in one place, it changes everywhere. that's the whole point.

---

## what does each word mean

**`public`** — the function can be called from anywhere. we've seen this before with the class too.

**`static`** — same thing as before. we need static here because we're calling this function from the main method, and main is static. a static method can only directly call other static methods. (we'll understand this better in OOP)

**`void`** — the return type. void means this function doesn't give back any value when it finishes. it just does its thing and exits.

**`greet`** — the name of the function. you choose this. make it meaningful.

**`()`** — parameters go inside these brackets. if your function needs inputs, you put them here. if it needs nothing, just leave it empty.

---

## program 1 — sum of two numbers using a function

without function (bad way, repeated 3 times):
```java
// you'd have to copy paste this block 3 times
Scanner input = new Scanner(System.in);
int num1 = input.nextInt();
int num2 = input.nextInt();
int sum = num1 + num2;
System.out.println(sum);
```

with a function (good way):
```java
import java.util.Scanner;

public class Main {

    public static void printSum(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println("Sum is: " + sum);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();

        printSum(a, b);    // call it once
        printSum(a, b);    // call it again, no copy paste
        printSum(a, b);    // and again
    }
}
```

clean. readable. if the logic needs to change, change it in one place only.

---

## return types

so far we just printed stuff inside the function. but what if you want to USE the result of a function instead of just printing it?

that's where return type comes in.

**void** = function does something but gives nothing back
**int, float, String, etc.** = function gives back a value of that type

example — function that RETURNS the sum instead of printing it:

```java
public static int getSum(int num1, int num2) {
    int sum = num1 + num2;
    return sum;    // sending the value back to whoever called this function
}
```

now in main you can do:
```java
int answer = getSum(10, 20);   // answer = 30
System.out.println(answer);
```

or even simpler:
```java
System.out.println(getSum(10, 20));   // directly use the returned value
```

**the return statement does two things:**
1. sends a value back to the caller
2. immediately ends the function — nothing after return runs

so if you write:
```java
public static int getSum(int a, int b) {
    return a + b;
    System.out.println("this will never run");  // dead code — compiler will warn you
}
```

that print line never executes. once return runs, function is over.

---

## program 2 — returning a string

```java
public static String getGreeting(String name) {
    String message = "Hello " + name + ", how are you?";
    return message;
}

public static void main(String[] args) {
    String msg = getGreeting("Kunal");
    System.out.println(msg);    // Hello Kunal, how are you?

    // or directly:
    System.out.println(getGreeting("Rahul"));   // Hello Rahul, how are you?
}
```

the return type is `String` so the function gives back a String value. whatever calls it can store that string or use it directly.

---

## parameters vs arguments — quick note

these two words get mixed up a lot.

**parameters** = the variable names you define in the function signature
```java
public static int add(int a, int b)   // a and b are parameters
```

**arguments** = the actual values you pass when calling the function
```java
add(10, 20)   // 10 and 20 are arguments
```

when you call `add(10, 20)`, java replaces `a` with 10 and `b` with 20 inside the function. that's it.

---

## program 3 — swap two numbers

this is where things get interesting. kunal showed this to explain something very important about how java passes values.

```java
public static void swap(int num1, int num2) {
    int temp = num1;
    num1 = num2;
    num2 = temp;
    System.out.println("inside function — num1: " + num1 + ", num2: " + num2);
}

public static void main(String[] args) {
    int a = 10;
    int b = 20;
    swap(a, b);
    System.out.println("in main — a: " + a + ", b: " + b);
}
```

output:
```
inside function — num1: 20, num2: 10
in main — a: 10, b: 20
```

wait... we swapped them inside the function. but in main they're still the same? why?

---

## pass by value — very important concept

in java, **primitives are always passed by value**.

this means when you do `swap(a, b)`, java doesn't send `a` and `b` themselves to the function. it sends a **copy** of their values.

so inside the function:
- `num1` is a completely separate variable that has the value 10
- `num2` is a completely separate variable that has the value 20

when you swap num1 and num2, you're swapping the copies. the originals `a` and `b` in main are totally untouched. they don't even know anything happened.

diagram of what's happening in memory:

```
main memory:
  a = 10
  b = 20

function gets COPIES:
  num1 = 10   (copy of a)
  num2 = 20   (copy of b)

after swap in function:
  num1 = 20
  num2 = 10

but a and b in main are still:
  a = 10  (unchanged)
  b = 20  (unchanged)
```

this is called **pass by value** — java passes the value, not the variable itself.

**but wait — what about strings and objects?**

strings are a bit different. technically java passes the reference by value. meaning:

- if you MODIFY the object through the reference — the original changes
- but if you REASSIGN the reference to point to a new object — the original doesn't change

this was shown in the lecture. when kunal did `name = "Rahul"` inside a function that took a String — the original name didn't change in main. because reassigning creates a new String object, it doesn't modify the original.

but if you have an array or object and you modify its contents (like changing an element) — that WILL reflect in the original. more on this when we do arrays and OOP.

for now just remember: **primitives → pass by value → original never changes inside a function**.

---

## scope — where can you access a variable?

scope = the area in code where a variable exists and can be used.

### method scope

variables defined inside a method only exist inside that method.

```java
public static void sayHello() {
    String message = "Hello!";
    System.out.println(message);   // works fine
}

public static void main(String[] args) {
    sayHello();
    System.out.println(message);   // ERROR — message doesn't exist here
}
```

`message` was created inside `sayHello()` so it only lives there. once the function ends, it's gone.

### block scope

even inside a function, variables only live in the block `{}` where they're defined.

```java
public static void main(String[] args) {
    int x = 10;

    {
        int y = 20;
        System.out.println(x);   // works — x is from outer block
        System.out.println(y);   // works — y is in this block
    }

    System.out.println(x);   // works fine
    System.out.println(y);   // ERROR — y doesn't exist here anymore
}
```

the curly braces create a new block. anything defined inside that block dies when the block ends.

**but** — you can use variables from outer scope inside an inner block. it goes one way only. outer → inner works. inner → outer doesn't.

### loop scope

same rule applies to for loops:

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);   // works fine
}
System.out.println(i);   // ERROR — i only lives inside the for loop
```

`i` is declared in the for loop, so it only exists for the duration of that loop.

---

## shadowing — using same variable name in inner scope

shadowing = when you declare a variable with the same name as an outer variable, inside an inner block.

```java
public static void main(String[] args) {
    int x = 10;

    {
        int x = 20;              // shadowing the outer x
        System.out.println(x);   // prints 20 (uses the inner x)
    }

    System.out.println(x);       // prints 10 (back to outer x)
}
```

the inner `x` "shadows" or hides the outer `x` while you're inside that block. once you exit the block, the outer `x` comes back.

this is technically allowed in java (unlike some other languages) but it's considered bad practice. it's confusing. don't do it.

kunal also mentioned **class-level variables** — if you have a variable at the class level and also a local variable with the same name inside a method, the local one shadows the class-level one. we'll understand this more in OOP.

---

## variable arguments (varargs)

what if you don't know how many arguments a function will receive?

like what if sometimes you want to add 2 numbers, sometimes 3, sometimes 5?

you could write multiple functions... or you can use varargs.

```java
public static int sum(int... numbers) {
    int total = 0;
    for (int n : numbers) {
        total += n;
    }
    return total;
}
```

the `int... numbers` syntax means "accept any number of int values". internally java treats this as an array.

calling it:
```java
System.out.println(sum(1, 2));           // 3
System.out.println(sum(1, 2, 3));        // 6
System.out.println(sum(10, 20, 30, 40)); // 100
```

same function, different number of arguments every time. the vararg parameter must always be the last parameter in the list.

---

## method overloading

what if you want a function that works with both `int` and `String`?

you can have two functions with the **same name** as long as they have **different parameters**.

```java
public static void greet(int number) {
    System.out.println("Number is: " + number);
}

public static void greet(String name) {
    System.out.println("Hello " + name);
}

public static void main(String[] args) {
    greet(5);         // calls the int version
    greet("Kunal");   // calls the String version
}
```

java figures out which version to call based on what you pass. this is called **method overloading**.

rules for overloading:
- same method name ✓
- different parameters (different type OR different number) ✓
- return type doesn't matter — you can't overload just by changing return type

**when does java decide which one to call?**
at compile time. the compiler looks at what you're passing and picks the right version. this is called **compile-time polymorphism** or **static dispatch**.

(there's also runtime polymorphism with method overriding — that's OOP, later.)

practical example — sum function that handles 2 or 3 numbers:
```java
public static int sum(int a, int b) {
    return a + b;
}

public static int sum(int a, int b, int c) {
    return a + b + c;
}

// call them:
System.out.println(sum(10, 20));       // 30
System.out.println(sum(10, 20, 30));   // 60
```

---

## practice questions from the lecture

### question 1 — check if a number is prime

a prime number is only divisible by 1 and itself. like 2, 3, 5, 7, 11, 13...

logic:
- if number is 1 → not prime
- check if any number from 2 to √n divides it evenly
- if yes → not prime
- if no → prime

```java
public static boolean isPrime(int n) {
    if (n <= 1) return false;

    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            return false;   // found a divisor, not prime
        }
    }
    return true;   // no divisor found, it's prime
}

public static void main(String[] args) {
    System.out.println(isPrime(7));    // true
    System.out.println(isPrime(10));   // false
    System.out.println(isPrime(13));   // true
}
```

why `Math.sqrt(n)`? because if a number has a factor larger than its square root, the corresponding smaller factor would already have been found. so no need to check beyond √n. makes it faster.

notice the return type is `boolean` — function returns true or false.

also notice when we write `return false` inside the loop, the function immediately stops. no need for else.

---

### question 2 — check if a number is armstrong

a 3-digit armstrong number = sum of cubes of each digit equals the number itself.

example: 153 → 1³ + 5³ + 3³ = 1 + 125 + 27 = 153 ✓

```java
public static boolean isArmstrong(int n) {
    int original = n;
    int sum = 0;

    while (n > 0) {
        int digit = n % 10;         // get last digit
        sum += digit * digit * digit;  // add its cube
        n = n / 10;                 // remove last digit
    }

    return sum == original;   // if sum equals original, it's armstrong
}

public static void main(String[] args) {
    System.out.println(isArmstrong(153));   // true
    System.out.println(isArmstrong(120));   // false
    System.out.println(isArmstrong(370));   // true
}
```

how the digit extraction works for 153:
- `153 % 10 = 3` → cube = 27, n becomes 15
- `15 % 10 = 5` → cube = 125, n becomes 1
- `1 % 10 = 1` → cube = 1, n becomes 0
- sum = 27 + 125 + 1 = 153 = original ✓

---

### question 3 — print all 3-digit armstrong numbers

now just loop through all 3-digit numbers (100 to 999) and print the ones that pass the armstrong check:

```java
public static boolean isArmstrong(int n) {
    int original = n;
    int sum = 0;
    while (n > 0) {
        int digit = n % 10;
        sum += digit * digit * digit;
        n /= 10;
    }
    return sum == original;
}

public static void main(String[] args) {
    System.out.print("Armstrong numbers: ");
    for (int i = 100; i <= 999; i++) {
        if (isArmstrong(i)) {
            System.out.print(i + " ");
        }
    }
}
```

output: `Armstrong numbers: 153 370 371 407`

this is a good example of how reusing a function makes life easy. instead of putting the armstrong logic inside the loop, we just call `isArmstrong(i)` and it's clean.

---

## complete summary

| concept | what it means |
|---|---|
| function / method | reusable block of code with a name |
| why use functions | avoid repeating code, easier to maintain |
| `void` return type | function gives nothing back |
| `return` | sends value back + ends the function |
| parameters | inputs the function needs (defined in signature) |
| arguments | actual values passed when calling the function |
| pass by value | primitives: copy is passed, original unchanged |
| method scope | variables die when the method ends |
| block scope | variables die when the `{}` block ends |
| shadowing | inner variable hides outer one with same name (avoid this) |
| varargs `int...` | accept any number of arguments |
| method overloading | same name, different parameters = different versions |

---

## things to keep in mind

- `return` ends the function immediately. anything after it is dead code.
- you can't access a variable outside the scope it was created in.
- pass by value means your original primitive variables are safe inside a function — the function works on copies.
- method overloading is decided at compile time, not runtime.
- varargs must be the last parameter.
- always name your functions clearly — `getSum` is better than `doThing`.

---

