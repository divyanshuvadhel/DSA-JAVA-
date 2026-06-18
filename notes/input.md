> # <span  style="color:green">Input , PrimitiveData type , TypeCasting ..</span>

```java
import java.util.Scanner;  // first import it

Scanner input = new Scanner(System.in);  // System.in = keyboard
```
---
`input.nextInt()` - integer number 
`input.nextFloat()` - decimal number 
`input.next()`- one word (stops at space ).
`input.nextLine()` - Entire line 

---


# Example.

> take a two num and print the sum 

```java
import java.util.Scanner;
public class input {
    public static void main(String[] args) {
        // take  two numbers and print the sum of it .

        Scanner sc=new Scanner(System.in);

        System.out.println("enter a number 1:");
        int num1 = sc.nextInt();

        System.out.println("enter a number 2:");
        int num2 =sc.nextInt();

        System.out.println(num1 +num2);
    }
}

```
# Primitive Data Types

Primitive data types are the basic data types provided by Java. They store simple values directly.

| Data Type | Stores                | Size          |
| --------- | --------------------- | ------------- |
| int       | Whole numbers         | 4 bytes       |
| long      | Large whole numbers   | 8 bytes       |
| float     | Decimal numbers       | 4 bytes       |
| double    | More precise decimals | 8 bytes       |
| char      | Single character      | 2 bytes       |
| boolean   | true / false          | JVM dependent |

Example:

```java
int age = 20;
float marks = 95.5f;
char grade = 'A';
boolean pass = true;
```

### Important

#### Long

By default Java treats whole numbers as int.

```java
long population = 8000000000L;
```

`L` tells Java that the value is long.

#### Float

By default decimal numbers are double.

```java
float pi = 3.14f;
```

`f` tells Java that the value is float.

#### Char vs String

```java
char letter = 'A';
String name = "Divyesh";
```

* char → single quotes
* String → double quotes

---

# Wrapper Classes

Every primitive has a wrapper class.

| Primitive | Wrapper   |
| --------- | --------- |
| int       | Integer   |
| float     | Float     |
| double    | Double    |
| char      | Character |
| boolean   | Boolean   |

Example:

```java
Integer rollNo = 64;
```

Wrapper classes provide extra methods.

---

# Literals and Identifiers

```java
int rollNumber = 64;
```

* `rollNumber` → Identifier
* `64` → Literal

---

# Comments

Single line:

```java
// This is a comment
```

Multi line:

```java
/*
This is
multi-line comment
*/
```

Comments are ignored by the compiler.

---

# Type Conversion (Automatic)

Small data types can be converted to larger data types automatically.

```java
int a = 100;
float b = a;
```

Output:

```text
100.0
```

---

# Type Casting (Manual)

Large type to small type.

```java
float num = 67.56f;
int value = (int) num;
```

Output:

```text
67
```

Decimal part is removed.

---

# Type Promotion

Java converts byte, short and char to int during calculations.

```java
byte a = 40;
byte b = 50;
byte c = 100;

int result = a * b / c;
```

Result:

```text
20
```

---

# If Statement

```java
int a = 10;

if(a == 10){
    System.out.println("A is 10");
}
```

---

# While Loop

Used when number of iterations is not known.

```java
int count = 1;

while(count <= 5){
    System.out.println(count);
    count++;
}
```

---

# For Loop

Used when number of iterations is known.

```java
for(int i = 1; i <= 5; i++){
    System.out.println(i);
}
```

---

# Scanner Input

```java
Scanner input = new Scanner(System.in);

int num = input.nextInt();
```

Used to take input from the keyboard.

---

# Celsius to Fahrenheit

Formula:

```text
F = (C × 9/5) + 32
```

Program:

```java
float celsius = input.nextFloat();

float fahrenheit = celsius * 9 / 5 + 32;

System.out.println(fahrenheit);
```

---

# Unicode

Java supports Unicode.

```java
System.out.println("नमस्ते");
System.out.println("你好");
```

---

# ASCII Example

```java
int value = 'A';

System.out.println(value);
```

Output:

```text
65
```

---

---

# Quick Revision

* Primitive types store simple values.
* Wrapper classes provide methods.
* Widening = automatic conversion.
* Narrowing = manual casting.
* byte, short and char become int in expressions.
* if is used for conditions.
* while is used when count is unknown.
* for is used when count is known.
* Scanner is used for user input.
