` CH.1 `

> # <span style="color: green;"> Types of programing language   </span>

#  Types of programing language 
  
- their are  mainly three types of programing language 
 

- By Level of Abstraction 
  - 🔴 Low-Level 
     > Close to hardware, fast but complex
    Machine Language (binary: 0s & 1s)
    Assembly Language
   - 🟡 Mid-Level 
      >Balance of control & readdability C, C++, Rust
   
  - 🟢 High-Level 
      > Easy to read, human-friendly Python, Java, Ruby, Swift
    
- By Programming Paradigm 
     - procedural 
     - object oriented (opps)
     - functional 
  
 - By typing System 
   - static typed 
     > java ,c++ 
   - Dynamic typed 
     > javascript ,python
     

# what is procedural language ?

A procedural language is a programming paradigm where you tell the computer how to do something, step by step, using a sequence of instructions.

think of it like a food recipie 
 - chop veggies 
 - heat oil 
 - add veggies 
 - add spices 
 - serv

this is procedural thinking - we break a problem in to a sequence of steps and executes them one by one 

## The Core Building Block — the Procedure

A procedure (also called a function or subroutine) is a named, reusable block of steps. Instead of writing the same 10 lines again and again, you write them once, give them a name, and call that name.

``` renderscript
// in c — a classic procedural language

void greetStudent(char name[]) {    // This is a PROCEDURE
    printf("Hello, ");
    printf(name);
    printf("! Welcome to IIT.\n");
}

int main() {
    greetStudent("Arjun");    // CALL the procedure
    greetStudent("Priya");    // REUSE it
    return 0;
}
```
computer reads and runs  a code from top to bottom.

# what is object oreinted  programing language ?

in  procedural language we thinks problem in to steps and executes in steps but in `object oriented programing  ` we think in things there is two main points 
    - object 
    - classes
>class is blueprint.

>object is the building form that blueprint.


the real world has thing - a car, a bank account
 `each things has `
 - data (what it is ) - `name , balance `
 - behaviour (what it can do ) - `drive ,deposite`

```java
// CLASS — blueprint (only write once )
class Car {
    // data (what it is )
    String color;
    int speed;

    // The Constructor — it  builds 
    public Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    // behavior ( what it does)
    public void drive() {
        System.out.println("The " + this.color + " car is driving at " + this.speed + " km/h");
    }
}

// MAIN RUNNER 
public class Main {
    public static void main(String[] args) {
        // OBJECTS 
        Car myCar   = new Car("red", 120);
        Car yourCar = new Car("blue", 90);

        myCar.drive();   // → "The red car is driving at 120 km/h"
        yourCar.drive(); // → "The blue car is driving at 90 km/h"
    }
}

```
>Object-Oriented Programming (OOP) is a way of organizing code by grouping related data and actions together into objects, just like real-world things such as bank accounts, cars, or students.
-------
## static vs dynamic laguages 



| static language | dynamic language |
|:---|:---|
|perform typechecking at complile time | perform type checking at runtime |
 | Errors shows at compile time | Err shows at runtime |
| Declare datatype before use it | no need to declare datatype of variables |
|more controll | gives most err at runtime |














# .





