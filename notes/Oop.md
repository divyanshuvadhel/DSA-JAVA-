# Object-Oriented Programming in Java


---

## Table of Contents
1. [Historical Foundations](#1-historical-foundations)
2. [The Philosophy of Object-Oriented Thinking](#2-the-philosophy-of-object-oriented-thinking)
3. [Java: Language Genesis and Evolution](#3-java-language-genesis-and-evolution)
4. [Core Pillars of OOP](#4-core-pillars-of-oop)
5. [Classes and Objects in Java](#5-classes-and-objects-in-java)
6. [Constructors and Initialization](#6-constructors-and-initialization)
7. [Encapsulation and Access Control](#7-encapsulation-and-access-control)
8. [Inheritance and the Class Hierarchy](#8-inheritance-and-the-class-hierarchy)
9. [Polymorphism: Static and Dynamic](#9-polymorphism-static-and-dynamic)
10. [Abstraction: Abstract Classes and Interfaces](#10-abstraction-abstract-classes-and-interfaces)
11. [The Object Class and Universal Contracts](#11-the-object-class-and-universal-contracts)
12. [Nested and Inner Classes](#12-nested-and-inner-classes)
13. [Generics and Type Safety](#13-generics-and-type-safety)
14. [Enums and Annotations](#14-enums-and-annotations)
15. [Functional Interfaces and Lambda Expressions](#15-functional-interfaces-and-lambda-expressions)
16. [The Java Memory Model](#16-the-java-memory-model)
17. [Design Patterns in Java](#17-design-patterns-in-java)
18. [SOLID Principles](#18-solid-principles)
19. [Advanced OOP: Reflection and Metadata](#19-advanced-oop-reflection-and-metadata)
20. [Modern Java: Records, Sealed Classes, and Pattern Matching](#20-modern-java-records-sealed-classes-and-pattern-matching)
21. [Best Practices and Anti-Patterns](#21-best-practices-and-anti-patterns)
22. [Appendix: Key Terms Glossary](#22-appendix-key-terms-glossary)

---

## 1. Historical Foundations

### 1.1 The Pre-OOP Era: Structured Programming
Before the advent of object-oriented paradigms, software was constructed primarily through **procedural programming** — a methodology championed by languages such as C, Pascal, and Fortran. Programs were organized as sequences of procedures (functions) operating on shared data structures. While revolutionary for its time, this approach suffered from a critical flaw: as systems grew in complexity, data and behavior became decoupled, leading to the notorious **"spaghetti code"** phenomenon.

> **Historical Context (1960s–1970s):** The software crisis of the late 1960s — characterized by projects running over budget, behind schedule, and failing to meet requirements — catalyzed the search for better abstractions.

### 1.2 The Birth of Object-Oriented Thinking
The intellectual seeds of OOP were planted in the 1960s at the **Norwegian Computing Center** in Oslo, where **Kristen Nygaard** and **Ole-Johan Dahl** developed **SIMULA 67** — widely regarded as the first object-oriented programming language. SIMULA introduced two revolutionary concepts:
- **Classes** as blueprints for objects
- **Inheritance** as a mechanism for code reuse and specialization

> **Key Insight:** Nygaard and Dahl were not merely creating a programming language; they were developing a **simulation framework** for modeling real-world systems. This simulation-centric origin explains why OOP naturally maps to domain modeling.

### 1.3 Smalltalk and the Pure OOP Vision
In the 1970s, **Alan Kay** and his team at **Xerox PARC** developed **Smalltalk**, refining the OOP paradigm into an elegant, pure object-oriented environment. Kay's vision was profound:

> *"I thought of objects being like biological cells and/or individual computers on a network, only able to communicate with messages."* — Alan Kay

Smalltalk established the foundational principles that would influence every subsequent OOP language, including Java.

### 1.4 The C++ Bridge
**Bjarne Stroustrup** at Bell Labs created **C++** (originally "C with Classes," 1979–1985), merging the efficiency of C with OOP constructs. While powerful, C++ introduced complexity through manual memory management, multiple inheritance, and the lack of a unified type system — challenges that Java's designers would explicitly address.

---

## 2. The Philosophy of Object-Oriented Thinking

### 2.1 The Core Metaphor
Object-oriented programming is not merely a syntax or a set of language features — it is a **worldview**. The central metaphor is this:

> **The program is a simulation of a community of collaborating entities, each responsible for its own state and behavior.**

### 2.2 Object-Oriented Analysis and Design (OOAD)
Before writing a single line of Java code, we must think in objects:

| Phase | Activity | Key Question |
|-------|----------|--------------|
| **Analysis** | Identify entities in the problem domain | *"What are the nouns?"* |
| **Design** | Define responsibilities and collaborations | *"What does each entity know and do?"* |
| **Implementation** | Map design to Java constructs | *"How do classes represent these entities?"* |

### 2.3 The Principle of Responsibility-Driven Design
Pioneered by **Rebecca Wirfs-Brock**, this principle states that every object should have a **single, well-defined responsibility**. When objects collaborate by sending messages (method invocations), the system exhibits **low coupling** and **high cohesion** — the hallmarks of maintainable software.

---

## 3. Java: Language Genesis and Evolution

### 3.1 The Green Project (1991–1995)
Java was conceived by **James Gosling**, **Mike Sheridan**, and **Patrick Naughton** at **Sun Microsystems** as part of the **Green Project**. The original goal was to create a language for programming consumer electronic devices — specifically, an interactive television system. The language was initially named **Oak** (after an oak tree outside Gosling's office) and later **Green**, before settling on **Java** (inspired by Java coffee).

### 3.2 The "Write Once, Run Anywhere" Revolution
The pivotal innovation was the **Java Virtual Machine (JVM)**. Unlike C++, which compiled to machine-specific binaries, Java compiled to **bytecode** — an intermediate representation executed by the JVM. This achieved **platform independence**, encapsulated in Sun's famous slogan:

> *"Write Once, Run Anywhere" (WORA)*

### 3.3 Timeline of Evolution

| Year | Version | Landmark Features |
|------|---------|-------------------|
| 1995 | Java 1.0 | Initial release; applets; AWT |
| 1998 | Java 1.2 (J2SE) | Swing; Collections Framework; JIT compiler |
| 2004 | Java 5 | **Generics**; **Annotations**; **Enums**; Enhanced for-loop; Autoboxing |
| 2011 | Java 7 | Try-with-resources; Diamond operator; NIO.2 |
| 2014 | Java 8 | **Lambda expressions**; **Streams API**; Functional interfaces; `java.time` |
| 2017 | Java 9 | Module System (Project Jigsaw); JShell |
| 2021 | Java 17 | **Sealed classes**; **Pattern matching for switch** (preview) |
| 2023 | Java 21 | **Virtual threads** (Project Loom); **Record patterns**; Sequenced collections |

> **Professor's Note:** Notice the paradigm shift between Java 7 and Java 8. Java 8 marked Java's embrace of functional programming, transforming it from a purely object-oriented language into a **multi-paradigm** powerhouse.

---

## 4. Core Pillars of OOP

The object-oriented paradigm rests upon four foundational pillars. Mastery of Java requires deep understanding of each.

### 4.1 The Four Pillars

```
┌─────────────────────────────────────────────────────────────┐
│                    OBJECT-ORIENTED PROGRAMMING               │
├──────────────┬──────────────┬──────────────┬────────────────┤
│              │              │              │                │
│ ENCAPSULATION│ INHERITANCE  │ POLYMORPHISM │  ABSTRACTION   │
│              │              │              │                │
│  Data hiding │  Code reuse  │  Many forms  │  Essential     │
│  & bundling  │  & hierarchy │  of behavior │  complexity    │
│              │              │              │  management    │
└──────────────┴──────────────┴──────────────┴────────────────┘
```

### 4.2 Encapsulation: The Foundation of Trust
**Encapsulation** is the bundling of data (fields) and methods (behavior) that operate on that data within a single unit (class), while restricting direct access to some components.

> **Analogy:** Consider a car. You interact with it through the steering wheel, pedals, and gear shift — not by directly manipulating the pistons, crankshaft, or fuel injectors. The engine's internal state is **encapsulated**.

### 4.3 Inheritance: The "Is-A" Relationship
**Inheritance** enables a new class (subclass) to acquire the properties and methods of an existing class (superclass), establishing an **"is-a"** relationship.

> **Caution:** Inheritance is powerful but dangerous. As the **Gang of Four** warned: *"Favor composition over inheritance."*

### 4.4 Polymorphism: Many Forms, One Interface
**Polymorphism** (Greek: "many forms") allows objects of different classes to be treated uniformly through a common interface, while exhibiting specialized behavior.

### 4.5 Abstraction: Managing Complexity
**Abstraction** involves hiding implementation details and exposing only essential features. It is the art of managing complexity by creating appropriate levels of representation.

---

## 5. Classes and Objects in Java

### 5.1 The Class: Blueprint of an Object
A **class** is a user-defined blueprint from which objects are created. It represents a set of properties (fields) and behaviors (methods) common to all objects of that type.

```java
public class Student {
    // Fields (Instance Variables)
    private String name;
    private int age;
    private String studentId;
    private double gpa;

    // Static Field (Class Variable)
    private static int totalStudents = 0;

    // Methods
    public void study(int hours) {
        System.out.println(name + " is studying for " + hours + " hours.");
    }

    public double calculateHonorPoints() {
        return gpa * 4.0;
    }
}
```

### 5.2 The Object: An Instance of a Class
An **object** is a runtime entity with state and behavior. It occupies memory and is created from a class using the `new` keyword.

```java
// Object instantiation
Student alice = new Student();
Student bob = new Student();
```

### 5.3 Anatomy of a Java Class

```
┌─────────────────────────────────────────┐
│           public class ClassName        │
│  ┌─────────────────────────────────┐    │
│  │  FIELDS (State)                 │    │
│  │  - Instance variables           │    │
│  │  - Static variables (class)     │    │
│  │  - Constants (final static)     │    │
│  └─────────────────────────────────┘    │
│  ┌─────────────────────────────────┐    │
│  │  CONSTRUCTORS (Initialization)  │    │
│  │  - Default constructor          │    │
│  │  - Parameterized constructors   │    │
│  └─────────────────────────────────┘    │
│  ┌─────────────────────────────────┐    │
│  │  METHODS (Behavior)             │    │
│  │  - Instance methods             │    │
│  │  - Static methods (class)       │    │
│  │  - Getters / Setters            │    │
│  └─────────────────────────────────┘    │
│  ┌─────────────────────────────────┐    │
│  │  INNER CLASSES / ENUMS          │    │
│  └─────────────────────────────────┘    │
└─────────────────────────────────────────┘
```

### 5.4 The `this` Keyword
The `this` keyword refers to the current object instance. It resolves ambiguity between instance variables and parameters with identical names.

```java
public class Student {
    private String name;

    public Student(String name) {
        this.name = name; // 'this.name' = field, 'name' = parameter
    }
}
```

### 5.5 Static vs. Instance Members

| Aspect | Instance Members | Static Members |
|--------|-----------------|----------------|
| **Belongs to** | Object (instance) | Class itself |
| **Memory** | Heap (per object) | Method Area (one copy) |
| **Access** | `object.field` or `object.method()` | `ClassName.field` or `ClassName.method()` |
| **Lifecycle** | Created with `new`, garbage collected | Loaded with class, unloaded with class |
| **Use case** | Object-specific state/behavior | Shared state/utility methods |

```java
public class MathConstants {
    public static final double PI = 3.14159265359;

    public static double circleArea(double radius) {
        return PI * radius * radius;
    }
}

// Usage — no object needed!
double area = MathConstants.circleArea(5.0);
```

---

## 6. Constructors and Initialization

### 6.1 Constructor Fundamentals
A **constructor** is a special method invoked when an object is instantiated. It has no return type and shares the class name.

```java
public class Book {
    private String title;
    private String author;
    private int yearPublished;

    // Parameterized constructor
    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }
}
```

### 6.2 Constructor Chaining
Constructors can call other constructors using `this(...)`. This avoids code duplication.

```java
public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;

    public Book(String title, String author) {
        this(title, author, 2024); // Delegates to 3-arg constructor
    }

    public Book(String title, String author, int yearPublished) {
        this(title, author, yearPublished, "Unknown");
    }

    public Book(String title, String author, int yearPublished, String isbn) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
    }
}
```

### 6.3 Initialization Blocks
Java provides two types of initialization blocks:

```java
public class Example {
    // Static initialization block — runs once when class is loaded
    static {
        System.out.println("Static block: Class loaded");
    }

    // Instance initialization block — runs before constructor, per object
    {
        System.out.println("Instance block: Object being created");
    }

    public Example() {
        System.out.println("Constructor: Object created");
    }
}
```

**Order of Initialization:**
1. Static fields and static blocks (in declaration order, once)
2. Instance fields and instance blocks (in declaration order)
3. Constructor

### 6.4 The Singleton Pattern (Constructor Restriction)
By making the constructor `private`, we control instantiation — the foundation of the Singleton pattern.

```java
public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Private constructor prevents external instantiation
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

---

## 7. Encapsulation and Access Control

### 7.1 Access Modifiers
Java provides four levels of access control, forming the bedrock of encapsulation:

```
┌─────────────────┬──────────┬───────────┬──────────┬─────────────┐
│   Modifier      │  Class   │  Package  │ Subclass │   World     │
├─────────────────┼──────────┼───────────┼──────────┼─────────────┤
│   public        │    ✓     │     ✓     │    ✓     │      ✓      │
│   protected     │    ✓     │     ✓     │    ✓     │      ✗      │
│   (default)     │    ✓     │     ✓     │    ✗     │      ✗      │
│   private       │    ✓     │     ✗     │    ✗     │      ✗      │
└─────────────────┴──────────┴───────────┴──────────┴─────────────┘
```

### 7.2 The JavaBean Convention
The canonical encapsulation pattern in Java:

```java
public class Employee {
    private String name;       // Private field
    private double salary;     // Private field

    // Getter (accessor)
    public String getName() {
        return name;
    }

    // Setter (mutator)
    public void setName(String name) {
        this.name = name;
    }

    // Read-only property (no setter)
    public double getSalary() {
        return salary;
    }
}
```

> **Professor's Note:** Modern Java (records, Lombok) reduces boilerplate, but understanding the underlying mechanism is essential. Never expose mutable objects directly — return defensive copies.

### 7.3 Defensive Copying
When returning mutable objects (like collections or dates), return copies to preserve encapsulation:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private List<String> enrolledStudents = new ArrayList<>();

    // BAD: Exposes internal list
    public List<String> getStudents() {
        return enrolledStudents;
    }

    // GOOD: Returns unmodifiable view
    public List<String> getStudents() {
        return Collections.unmodifiableList(enrolledStudents);
    }

    // ALSO GOOD: Returns defensive copy
    public List<String> getStudentsCopy() {
        return new ArrayList<>(enrolledStudents);
    }
}
```

---

## 8. Inheritance and the Class Hierarchy

### 8.1 The `extends` Keyword
In Java, a class inherits from another using the `extends` keyword. Every class implicitly extends `java.lang.Object` if no superclass is specified.

```java
public class Animal {
    protected String name;
    protected int age;

    public void speak() {
        System.out.println("Some generic animal sound");
    }
}

public class Dog extends Animal {
    private String breed;

    @Override
    public void speak() {
        System.out.println(name + " says: Woof!");
    }

    public void fetch() {
        System.out.println(name + " is fetching the ball.");
    }
}
```

### 8.2 The `super` Keyword
`super` accesses the superclass's members:

```java
public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(); // Implicitly calls Animal's constructor
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    @Override
    public void speak() {
        super.speak(); // Call parent's implementation
        System.out.println("And also: Woof!");
    }
}
```

### 8.3 Method Overriding Rules
When overriding a method, the subclass version must adhere to these rules:

| Rule | Requirement |
|------|-------------|
| **Name & Signature** | Must match exactly |
| **Return Type** | Must be the same or a **covariant** subtype (Java 5+) |
| **Access Modifier** | Cannot be more restrictive than the parent's |
| **Exceptions** | Cannot throw checked exceptions broader than parent's |
| **Annotation** | Use `@Override` to catch errors at compile time |

### 8.4 The `final` Keyword in Inheritance

```java
public final class SecureClass { 
    // Cannot be extended
}

public class Base {
    public final void criticalMethod() {
        // Cannot be overridden
    }
}
```

| Usage | Effect |
|-------|--------|
| `final class` | Prevents subclassing |
| `final method` | Prevents overriding |
| `final variable` | Prevents reassignment (constant) |

### 8.5 Composition vs. Inheritance

> **The Liskov Substitution Principle (LSP):** If `B` is a subclass of `A`, then objects of type `A` should be replaceable with objects of type `B` without altering program correctness.

**Prefer composition when:**
- The subclass needs only *some* behavior of the superclass
- The "is-a" relationship is questionable
- You need multiple sources of behavior (Java has no multiple inheritance of classes)

```java
// COMPOSITION: Engine "has-a" relationship
public class Car {
    private Engine engine; // Composed, not inherited

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.ignite(); // Delegation
    }
}
```

---

## 9. Polymorphism: Static and Dynamic

### 9.1 Compile-Time Polymorphism (Method Overloading)
Multiple methods share a name but differ in parameter lists. The compiler resolves which to call.

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

### 9.2 Runtime Polymorphism (Dynamic Method Dispatch)
The JVM determines which method implementation to invoke at runtime based on the object's actual type.

```java
Animal myPet; // Reference type: Animal

myPet = new Dog("Rex", 3, "German Shepherd");
myPet.speak(); // Output: "Rex says: Woof!" — Dog's version called

myPet = new Cat("Whiskers", 2);
myPet.speak(); // Output: "Whiskers says: Meow!" — Cat's version called
```

### 9.3 The V-Table Mechanism
Internally, Java uses a **virtual method table (vtable)** to achieve dynamic dispatch. Each class has a table of method pointers. When `speak()` is called on an `Animal` reference, the JVM follows the vtable of the *actual* object to find the correct implementation.

```
Animal reference ──► [Dog object] ──► Dog's vtable ──► Dog.speak()
Animal reference ──► [Cat object] ──► Cat's vtable ──► Cat.speak()
```

### 9.4 Polymorphism in Collections
Polymorphism enables elegant, extensible designs:

```java
List<Animal> zoo = new ArrayList<>();
zoo.add(new Dog("Rex", 3, "Labrador"));
zoo.add(new Cat("Whiskers", 2));
zoo.add(new Bird("Tweety", 1, 15.5));

// Polymorphic iteration
for (Animal animal : zoo) {
    animal.speak(); // Each animal speaks in its own way
}
```

---

## 10. Abstraction: Abstract Classes and Interfaces

### 10.1 Abstract Classes
An **abstract class** cannot be instantiated and may contain abstract methods (declarations without implementations). It represents a partial abstraction — shared implementation with required customization points.

```java
public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    // Abstract method — must be implemented by subclasses
    public abstract double calculateArea();

    // Concrete method — shared implementation
    public void display() {
        System.out.println("Color: " + color);
        System.out.println("Area: " + calculateArea());
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
```

### 10.2 Interfaces
An **interface** defines a contract — a set of methods that implementing classes must provide. Before Java 8, interfaces contained only abstract methods.

```java
public interface Drawable {
    void draw();           // Implicitly public and abstract
    void setColor(String color);
}

public interface Resizable {
    void scale(double factor);
}

// Multiple interface implementation
public class Rectangle implements Drawable, Resizable {
    @Override
    public void draw() { /* ... */ }

    @Override
    public void setColor(String color) { /* ... */ }

    @Override
    public void scale(double factor) { /* ... */ }
}
```

### 10.3 Abstract Class vs. Interface

| Feature | Abstract Class | Interface (Java 8+) |
|---------|---------------|---------------------|
| **Instantiation** | No | No |
| **Methods** | Abstract + concrete | Abstract + default + static |
| **Fields** | Instance + static | Only `public static final` (constants) |
| **Inheritance** | Single (`extends`) | Multiple (`implements`) |
| **Constructors** | Yes | No |
| **Access Modifiers** | Any | Methods: public; Fields: public static final |
| **Use Case** | "Is-a" with shared code | "Can-do" capability contract |

### 10.4 Default and Static Methods (Java 8+)
Interfaces evolved to support implementation without breaking existing code:

```java
public interface Logger {
    void log(String message); // Abstract

    default void logError(String message) {
        log("ERROR: " + message); // Default implementation
    }

    static Logger nullLogger() {
        return message -> {}; // Static factory method
    }
}
```

### 10.5 Private Interface Methods (Java 9+)
Java 9 introduced private methods in interfaces to share code between default methods:

```java
public interface Statistics {
    default double mean(double[] values) {
        return sum(values) / values.length;
    }

    default double variance(double[] values) {
        double mean = mean(values);
        return sumOfSquaredDifferences(values, mean) / values.length;
    }

    private double sum(double[] values) { /* ... */ }
    private double sumOfSquaredDifferences(double[] values, double mean) { /* ... */ }
}
```

---

## 11. The Object Class and Universal Contracts

### 11.1 The Root of All Classes
`java.lang.Object` is the ultimate superclass of every Java class. It provides nine methods that form universal contracts:

```java
public class Object {
    // Identity and comparison
    public native int hashCode();
    public boolean equals(Object obj);

    // String representation
    public String toString();

    // Cloning
    protected native Object clone() throws CloneNotSupportedException;

    // Concurrency
    public final native void notify();
    public final native void notifyAll();
    public final native void wait(long timeout) throws InterruptedException;
    public final void wait(long timeout, int nanos) throws InterruptedException;
    public final void wait() throws InterruptedException;

    // Finalization (deprecated in Java 9)
    protected void finalize() throws Throwable;
}
```

### 11.2 The `equals()` and `hashCode()` Contract
These methods must be overridden together to maintain consistency:

```java
public class Student {
    private String studentId;
    private String name;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
```

**The Contract:**
1. **Reflexive:** `x.equals(x)` → `true`
2. **Symmetric:** `x.equals(y)` ↔ `y.equals(x)`
3. **Transitive:** if `x.equals(y)` and `y.equals(z)`, then `x.equals(z)`
4. **Consistent:** Multiple invocations yield the same result
5. **Hash code consistency:** If `x.equals(y)`, then `x.hashCode() == y.hashCode()`

### 11.3 The `toString()` Method
Override `toString()` to provide meaningful object representation:

```java
@Override
public String toString() {
    return "Student{id='" + studentId + "', name='" + name + "'}";
}

// Modern Java (Java 14+): Using String.format or text blocks
@Override
public String toString() {
    return String.format("Student[id=%s, name=%s]", studentId, name);
}
```

---

## 12. Nested and Inner Classes

### 12.1 Types of Nested Classes

```
Class Outer {
├── static class StaticNested {}     // Static nested class
├── class Inner {}                   // Non-static inner class
├── void method() {
│   class Local {}                   // Local inner class
│   Runnable r = new Runnable() {   // Anonymous inner class
│       public void run() {}
│   };
}
```

### 12.2 Static Nested Classes
Behave like top-level classes but have access to private static members of the enclosing class:

```java
public class University {
    private static String motto = "Veritas";

    public static class Department {
        public void displayMotto() {
            System.out.println(motto); // Accesses enclosing class's static member
        }
    }
}

// Usage
University.Department cs = new University.Department();
```

### 12.3 Inner (Non-Static) Classes
Have an implicit reference to the enclosing instance:

```java
public class University {
    private String name = "Harvard";

    public class Student {
        public void introduce() {
            System.out.println("I study at " + name); // Accesses enclosing instance
        }
    }
}

// Usage
University harvard = new University();
University.Student student = harvard.new Student();
```

### 12.4 Anonymous Classes
One-time implementations, often used for event listeners and callbacks:

```java
// Pre-Java 8: Anonymous class implementing Runnable
Runnable task = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running in anonymous class");
    }
};

// Java 8+: Lambda expression (syntactic sugar for functional interfaces)
Runnable task = () -> System.out.println("Running with lambda");
```

---

## 13. Generics and Type Safety

### 13.1 The Problem: Raw Types
Before generics (pre-Java 5), collections used `Object`, requiring unsafe casting:

```java
List list = new ArrayList();
list.add("Hello");
list.add(42); // Compiles fine — runtime disaster
String s = (String) list.get(1); // ClassCastException at runtime!
```

### 13.2 Generic Classes
Generics provide **compile-time type safety** through **parametric polymorphism**:

```java
public class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

// Usage
Box<String> stringBox = new Box<>();
stringBox.setContent("Hello");
// stringBox.setContent(42); // Compile-time error!
```

### 13.3 Generic Methods

```java
public class Utils {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static <T extends Comparable<T>> T findMax(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}
```

### 13.4 Bounded Type Parameters

```java
// Upper bound: T must be Number or its subclass
public class Statistics<T extends Number> {
    private List<T> values = new ArrayList<>();

    public double average() {
        return values.stream()
                     .mapToDouble(Number::doubleValue)
                     .average()
                     .orElse(0.0);
    }
}

// Multiple bounds
public class Processor<T extends Comparable<T> & Serializable> {
    // T must implement both Comparable and Serializable
}
```

### 13.5 Wildcards

| Wildcard | Meaning | Example |
|----------|---------|---------|
| `?` | Unknown type | `List<?>` |
| `? extends T` | Upper bounded (covariant) | `List<? extends Number>` |
| `? super T` | Lower bounded (contravariant) | `List<? super Integer>` |

**PECS Principle:** *Producer `extends`, Consumer `super`*

```java
public static double sumOfList(List<? extends Number> list) {
    double sum = 0.0;
    for (Number n : list) {
        sum += n.doubleValue();
    }
    return sum;
}

public static void addIntegers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
    list.add(3);
}
```

### 13.6 Type Erasure
Generics in Java are implemented via **type erasure** — generic type information is removed at compile time and replaced with casts. This maintains backward compatibility but has implications:

```java
// At runtime, List<String> and List<Integer> are both just List
List<String> strings = new ArrayList<>();
List rawList = strings; // Allowed (backward compatibility)
rawList.add(42); // Compiles with warning; runtime ClassCastException on get
```

---

## 14. Enums and Annotations

### 14.1 Enumerations
An **enum** is a special class representing a fixed set of constants:

```java
public enum DayOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, 
    THURSDAY, FRIDAY, SATURDAY
}
```

### 14.2 Enums with Fields and Methods
Enums are full-fledged classes:

```java
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6);

    private final double mass;   // In kilograms
    private final double radius; // In meters

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double surfaceGravity() {
        final double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }

    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
}
```

### 14.3 Annotations (Metadata)
Annotations provide metadata about code. Java defines several built-in annotations:

```java
@Override          // Method overrides superclass method
@Deprecated       // Element is obsolete, avoid use
@SuppressWarnings // Ignore specific compiler warnings
@FunctionalInterface // Interface has exactly one abstract method
@SafeVarargs      // Varargs method doesn't perform unsafe operations
```

### 14.4 Custom Annotations

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // Available at runtime via reflection
@Target(ElementType.METHOD)         // Can only annotate methods
public @interface Test {
    String description() default "";
    int timeout() default 0;
    Class<? extends Throwable> expected() default None.class;
}

// Usage
@Test(description = "Verify addition", timeout = 1000)
public void testAdd() { /* ... */ }
```

---

## 15. Functional Interfaces and Lambda Expressions

### 15.1 The Functional Interface
A **functional interface** has exactly one abstract method (SAM — Single Abstract Method):

```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2); // Single abstract method

    // Default and static methods don't count
    default Comparator<T> reversed() { /* ... */ }
}
```

### 15.2 Lambda Expressions
Lambdas provide a concise syntax for implementing functional interfaces:

```java
// Anonymous class (verbose)
Comparator<String> byLength = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
};

// Lambda expression (concise)
Comparator<String> byLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());

// Method reference (most concise)
Comparator<String> byLength = Comparator.comparingInt(String::length);
```

### 15.3 Built-in Functional Interfaces (java.util.function)

| Interface | Signature | Use Case |
|-----------|-----------|----------|
| `Predicate<T>` | `boolean test(T t)` | Filtering |
| `Function<T,R>` | `R apply(T t)` | Transformation |
| `Consumer<T>` | `void accept(T t)` | Side effects |
| `Supplier<T>` | `T get()` | Factory/Lazy init |
| `UnaryOperator<T>` | `T apply(T t)` | In-place transformation |
| `BinaryOperator<T>` | `T apply(T a, T b)` | Reduction |

```java
// Predicate: Filter even numbers
Predicate<Integer> isEven = n -> n % 2 == 0;

// Function: String to length
Function<String, Integer> length = String::length;

// Consumer: Print each element
Consumer<String> printer = System.out::println;

// Supplier: Generate random numbers
Supplier<Double> random = Math::random;
```

---

## 16. The Java Memory Model

### 16.1 Runtime Data Areas
Understanding memory is essential for understanding object lifecycle:

```
┌─────────────────────────────────────────────────────────────┐
│                      JVM MEMORY MODEL                        │
├─────────────────────────────────────────────────────────────┤
│  ┌──────────────────┐    ┌──────────────────┐                │
│  │     HEAP         │    │   STACK          │                │
│  │                  │    │                  │                │
│  │  All objects     │    │  Method frames   │                │
│  │  (shared among   │    │  (per thread)    │                │
│  │   all threads)   │    │  - Local vars    │                │
│  │                  │    │  - Operand stack │                │
│  │  ┌───────────┐   │    │  - Frame data    │                │
│  │  │  Young    │   │    │                  │                │
│  │  │  (Eden,   │   │    └──────────────────┘                │
│  │  │   S0, S1) │   │                                        │
│  │  ├───────────┤   │    ┌──────────────────┐                │
│  │  │  Old      │   │    │  METHOD AREA     │                │
│  │  │  (Tenured)│   │    │  (MetaSpace)     │                │
│  │  └───────────┘   │    │  - Class data    │                │
│  │                  │    │  - Static vars   │                │
│  └──────────────────┘    │  - Code cache     │                │
│                          └──────────────────┘                │
└─────────────────────────────────────────────────────────────┘
```

### 16.2 Stack vs. Heap

| Aspect | Stack | Heap |
|--------|-------|------|
| **Contents** | Primitive values, object references | Objects and arrays |
| **Lifetime** | Method execution | Until garbage collected |
| **Management** | Automatic (LIFO) | Garbage Collector |
| **Thread Safety** | Thread-private | Shared (requires synchronization) |
| **Size** | Small (typically 1MB) | Large (configurable) |

```java
public void demonstrate() {
    int x = 10;              // x stored on stack
    Student s = new Student(); // s (reference) on stack, Student object on heap
}
```

### 16.3 Garbage Collection
Java's **Garbage Collector (GC)** automatically reclaims memory occupied by unreachable objects:

**Mark-and-Sweep Algorithm:**
1. **Mark:** Traverse object graph from GC roots, marking reachable objects
2. **Sweep:** Reclaim memory of unmarked objects
3. **Compact:** (Optional) Defragment memory

**GC Roots include:**
- Local variables in stack frames
- Static fields
- JNI references
- Objects held by synchronized monitors

> **Professor's Note:** You cannot force garbage collection (`System.gc()` is merely a suggestion). Trust the JVM's sophisticated GC algorithms (G1, ZGC, Shenandoah in modern Java).

---

## 17. Design Patterns in Java

### 17.1 Creational Patterns

**Singleton:** Ensures a class has only one instance.
```java
public enum Singleton {
    INSTANCE; // Thread-safe, serialization-safe, reflection-safe

    public void doSomething() { }
}
```

**Factory Method:** Delegates instantiation to subclasses.
```java
public interface DocumentFactory {
    Document createDocument();
}

public class PdfFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
```

**Builder:** Constructs complex objects step by step.
```java
public class Computer {
    private final String cpu;
    private final int ram;
    private final int storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;

        public Builder cpu(String cpu) { this.cpu = cpu; return this; }
        public Builder ram(int ram) { this.ram = ram; return this; }
        public Builder storage(int storage) { this.storage = storage; return this; }
        public Computer build() { return new Computer(this); }
    }
}

// Usage
Computer pc = new Computer.Builder()
    .cpu("Intel i9")
    .ram(32)
    .storage(1000)
    .build();
```

### 17.2 Structural Patterns

**Adapter:** Converts one interface to another.
```java
public class LegacyPrinterAdapter implements ModernPrinter {
    private LegacyPrinter legacyPrinter;

    @Override
    public void print(Document doc) {
        legacyPrinter.printDocument(doc.getContent());
    }
}
```

**Decorator:** Adds responsibilities dynamically.
```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
}

public class MilkDecorator extends CoffeeDecorator {
    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.50;
    }
}
```

### 17.3 Behavioral Patterns

**Observer:** Defines one-to-many dependency.
```java
public interface Observer {
    void update(String event);
}

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer o) { observers.add(o); }
    public void detach(Observer o) { observers.remove(o); }

    public void notifyObservers(String event) {
        observers.forEach(o -> o.update(event));
    }
}
```

**Strategy:** Encapsulates interchangeable algorithms.
```java
public interface PaymentStrategy {
    void pay(double amount);
}

public class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(double amount) {
        strategy.pay(amount);
    }
}
```

---

## 18. SOLID Principles

### 18.1 S — Single Responsibility Principle
> *"A class should have only one reason to change."* — Robert C. Martin

```java
// BAD: Multiple responsibilities
public class Employee {
    public void calculatePay() { }
    public void saveToDatabase() { }
    public void generateReport() { }
}

// GOOD: Separated concerns
public class Employee { /* ... */ }
public class EmployeeRepository { public void save(Employee e) { } }
public class PayrollService { public void calculatePay(Employee e) { } }
public class ReportGenerator { public void generate(Employee e) { } }
```

### 18.2 O — Open/Closed Principle
> *"Software entities should be open for extension, but closed for modification."*

```java
// BAD: Must modify to add new shapes
public double calculateArea(Object shape) {
    if (shape instanceof Circle) { /* ... */ }
    else if (shape instanceof Rectangle) { /* ... */ }
    return 0;
}

// GOOD: Extend via polymorphism
public interface Shape {
    double calculateArea();
}

public class Circle implements Shape { /* ... */ }
public class Triangle implements Shape { /* ... */ } // New shape, no existing code modified
```

### 18.3 L — Liskov Substitution Principle
> *"Subtypes must be substitutable for their base types."*

```java
// VIOLATION: Square changes Rectangle's contract
public class Rectangle {
    public void setWidth(double w) { this.width = w; }
    public void setHeight(double h) { this.height = h; }
}

public class Square extends Rectangle {
    @Override
    public void setWidth(double w) { 
        super.setWidth(w);
        super.setHeight(w); // Violates Rectangle's behavior!
    }
}
```

### 18.4 I — Interface Segregation Principle
> *"Clients should not be forced to depend on methods they do not use."*

```java
// BAD: Fat interface
public interface Worker {
    void work();
    void eat();
}

// GOOD: Segregated interfaces
public interface Workable { void work(); }
public interface Feedable { void eat(); }

public class Robot implements Workable { /* Only implements work() */ }
public class Human implements Workable, Feedable { /* Implements both */ }
```

### 18.5 D — Dependency Inversion Principle
> *"Depend upon abstractions, not concretions."*

```java
// BAD: High-level module depends on low-level module
public class Application {
    private MySQLDatabase database = new MySQLDatabase(); // Tight coupling!
}

// GOOD: Depend on abstraction
public class Application {
    private Database database; // Interface

    public Application(Database database) { // Dependency injection
        this.database = database;
    }
}
```

---

## 19. Advanced OOP: Reflection and Metadata

### 19.1 The Reflection API
Reflection enables runtime inspection and manipulation of classes:

```java
Class<?> clazz = Class.forName("java.util.ArrayList");

// Inspect methods
Method[] methods = clazz.getDeclaredMethods();
for (Method m : methods) {
    System.out.println(m.getName() + " - " + m.getReturnType());
}

// Create instance dynamically
Constructor<?> constructor = clazz.getConstructor();
Object instance = constructor.newInstance();

// Invoke method dynamically
Method addMethod = clazz.getMethod("add", Object.class);
addMethod.invoke(instance, "Element");
```

### 19.2 Use Cases and Warnings
**Appropriate uses:**
- Dependency injection frameworks (Spring)
- Object-relational mapping (Hibernate)
- Serialization libraries (Jackson, Gson)
- Testing frameworks (JUnit)

**Warnings:**
- Breaks encapsulation
- Performance overhead
- Loses compile-time type safety
- Fragile to refactoring

> **Professor's Note:** Reflection is a powerful tool — and like all powerful tools, it is dangerous in untrained hands. Use it when necessary, but prefer compile-time solutions.

---

## 20. Modern Java: Records, Sealed Classes, and Pattern Matching

### 20.1 Records (Java 16+)
Records provide a compact syntax for immutable data carriers:

```java
// Traditional class (verbose)
public final class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() { return x; }
    public double y() { return y; }

    @Override public boolean equals(Object o) { /* ... */ }
    @Override public int hashCode() { /* ... */ }
    @Override public String toString() { /* ... */ }
}

// Record (concise, immutable, automatically generates methods)
public record Point(double x, double y) { }
```

Records are ideal for:
- Data transfer objects (DTOs)
- Return types with multiple values
- Immutable domain objects

### 20.2 Sealed Classes (Java 17+)
Sealed classes control inheritance, explicitly defining permitted subclasses:

```java
public abstract sealed class Shape 
    permits Circle, Rectangle, Square { }

public final class Circle extends Shape { }
public final class Rectangle extends Shape { }
public final class Square extends Shape { }
// No other class can extend Shape!
```

### 20.3 Pattern Matching for `instanceof` (Java 16+)

```java
// Old way
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.toUpperCase());
}

// Pattern matching
if (obj instanceof String s) {
    System.out.println(s.toUpperCase()); // s is in scope and casted
}
```

### 20.4 Pattern Matching for `switch` (Java 21)

```java
public String describe(Object obj) {
    return switch (obj) {
        case Integer i -> "Integer: " + i;
        case String s when s.length() > 5 -> "Long string: " + s;
        case String s -> "Short string: " + s;
        case Point(double x, double y) -> "Point at (" + x + ", " + y + ")";
        case null -> "Null value";
        default -> "Unknown type";
    };
}
```

---

## 21. Best Practices and Anti-Patterns

### 21.1 Best Practices

1. **Favor immutability:** Make classes `final`, fields `private final`, provide no setters.
2. **Use `final` liberally:** On classes not designed for extension, on parameters, on local variables.
3. **Validate constructor arguments:** Fail fast with `Objects.requireNonNull()` and `IllegalArgumentException`.
4. **Override `toString()`, `equals()`, and `hashCode()`** together when value semantics matter.
5. **Program to interfaces:** Declare variables as `List<T>`, not `ArrayList<T>`.
6. **Minimize mutability:** Return unmodifiable collections; use builders for complex construction.
7. **Document thread safety:** Clearly state if a class is thread-safe, immutable, or requires external synchronization.

### 21.2 Common Anti-Patterns

| Anti-Pattern | Description | Solution |
|-------------|-------------|----------|
| **God Object** | Class knows/does too much | Apply SRP; extract classes |
| **Anemic Domain Model** | Classes are data bags with no behavior | Push behavior into domain objects |
| **Leaky Encapsulation** | Internal state exposed | Return copies; use unmodifiable views |
| **Premature Abstraction** | Abstracting what doesn't vary | YAGNI — You Aren't Gonna Need It |
| **Deep Inheritance Hierarchies** | Excessive subclassing | Favor composition; keep hierarchies shallow |
| **Refusal to Bequest** | Subclass rejects parent's interface | Violates LSP; use composition |

---

## 22. Appendix: Key Terms Glossary

| Term | Definition |
|------|------------|
| **Abstraction** | Hiding implementation details while exposing essential features |
| **Aggregation** | "Has-a" relationship where the part can exist independently |
| **Association** | Relationship between two classes (weakest form) |
| **Class** | Blueprint/template for creating objects |
| **Cohesion** | Degree to which class elements belong together |
| **Composition** | Strong "has-a" where the part cannot exist without the whole |
| **Coupling** | Degree of interdependence between classes |
| **Encapsulation** | Bundling data and methods; restricting direct access |
| **Inheritance** | Mechanism for acquiring properties of another class |
| **Instance** | A concrete realization of a class (object) |
| **Interface** | Contract defining methods a class must implement |
| **Message Passing** | Objects communicating via method invocation |
| **Method Overloading** | Same method name, different parameters (compile-time) |
| **Method Overriding** | Subclass redefines superclass method (runtime) |
| **Object** | Runtime entity with state and behavior |
| **Polymorphism** | Ability to take many forms; one interface, multiple implementations |
| **Subtype Polymorphism** | Subclass objects used where superclass objects expected |
| **UML** | Unified Modeling Language for visualizing system design |

---

> **Final Words from Your Professor:**
>
> *Object-oriented programming is not about syntax — it is about modeling. It is the art of decomposing complex systems into coherent, collaborating entities. Java, with its disciplined type system and rich ecosystem, provides an excellent vehicle for mastering this art. But remember: the tool serves the thinker. Understand the principles deeply, question dogma, and always write code that the next programmer — who may be you, six months from now — can read, understand, and modify with confidence.*
>
> *Class dismissed. Now go build something remarkable.*

---

*Document Version: 1.0*  
*Prepared for: CS-61B Advanced Software Construction*  
*Institution: Harvard University (Simulated Academic Context)*
