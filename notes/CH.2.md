`ch.2`

> ## <span style="color: green; "> Flowchart </span>

## What is a Flowchart?

A flowchart is a graphical representation of an algorithm or program logic using symbols connected by arrows.

---

# Basic Flowchart Components

## 1. start / End (Terminator) 

>![img.png](oval.png)

**Symbol:** Oval Used to indicate the beginning or end of a program.

---

## 2. process
>![img_2.png](sqaur.png)

**Symbol:** Rectangle
Used for:
- Calculations
- Variable assignments
- Data manipulation

Example:
```java
int sum = a + b;
```

---

## 3. input / output
> ![img_4.png](parallerlo.png)

**Symbol:** Parallelogram

Used for:
- Taking input
- Displaying output

Examples:
```java
Scanner sc = new Scanner(System.in);
System.out.println("Hello");
```

---

## 4. Decision
>![img_1.png](dimond.png)

**Symbol:** Diamond

Used for:
- if
- if-else
- switch conditions

Example:

```java
if(age >= 18)
```

---

## 5. Flow Line


> ![img_2.png](flowline.png)
> 
**Symbol:** Arrow
Shows the direction of execution.

---

## 6. Connector

> ![img.png](circle.png)

**Symbol:** Circle

Used to connect different parts of large flowcharts.

---

## 7. predefined Process

**Symbol:** Double-sided rectangle

```text
|| Function ||
```

Represents:
- function call
- Method call
- subroutine

Example:

```java
calculateTotal();
```

---

## 8. document

**symbol:** document

```text
+----------+
| document |
+----------+
 \________/
```

represents:
- reports
- printed output
- files

---

# Example flowchart

## input a  Number and  Print Whether it is Prime or Not

 > <img src="flowchart.png"  width="300px" />
---

# Mapping flowchart to Java

| Flowchart Symbol | Java Statement |
|------------------|----------------|
| Start/End | main() |
| Process | Variable assignment |
| Input | Scanner |
| Output | System.out.println() |
| Decision | if, else, switch |
| Loop | for, while, do-while |
| Predefined Process | Method call |

---


