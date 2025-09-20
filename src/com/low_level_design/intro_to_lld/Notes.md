# Definition
A formal definition of Low-Level Design (LLD) goes like:
LLD is where your code starts to take shape. It's a crucial phase in the software development lifecycle that focuses on the detailed design of individual components or modules of a system.

It involves specifying the internal structure, algorithms, and data structures that will be used to implement the system's functionality. It also acts as a bridge between high-level design and actual coding.



# HLD vs LLD
Let us understand this with a simple real-life example. Think of building a house:
High-Level Design (HLD) is like the architect's blueprint — it says where the rooms will be, how big they are, and how they're connected.
Low-Level Design (LLD) is like deciding where the switches go, how the plumbing is laid out, what materials to use, etc.

So LLD is all about the small, detailed planning you do before actually building the house (or writing code).

**Coding Example**
A simple example of LLD would be a basic Login System for a website, where LLD would involve forming different details components like: login(), signUp(), forgotPassword() along with their functionality.

# Key Characteristics of LLD
 **Granular and Code-Level:**
LLD dives deep into the fine details of how each component will function.
It defines classes, functions, variables, and data structures.
Example: Instead of just saying "we need user authentication", LLD shows how it's built — what classes handle it, what methods validate login, and what happens on failure.

**Implementation-Focused:**
LLD is directly linked to how the actual code will be written.
It acts as a blueprint for developers, guiding the logic, flow, and structure of modules.
It often includes pseudocode, flow diagrams, and sequence diagrams that show real-time data flow between functions.

**Applies OOP Principles:**
LLD makes heavy use of Object-Oriented Programming (OOP) concepts like classes, inheritance, abstraction, encapsulation, and polymorphism.
This helps build modular, reusable, and maintainable systems.
For example, a base Notification class might have subclasses like EmailNotification and SMSNotification using inheritance and polymorphism.

In Low-Level Design (LLD), the stakeholders are primarily the people directly involved in the actual implementation of the system — Senior Software Developers, Technical Leads, Managers, etc.

# Difference between HLD and LLD

| Aspect        | High-Level Design (HLD)         | Low-Level Design (LLD)               |
|---------------|---------------------------------|---------------------------------------|
| Purpose       | System overview & modules       | Detailed implementation & logic       |
| Level of Detail | Abstract                      | Highly Detailed                       |
| Focus         | Architecture, modules, interfaces | Class diagrams, methods, details     |
| Outcome       | Modules, System diagrams        | Detailed class/method diagrams        |

### Importance of Low-Level Design
Other than its role in the software development lifecycle and its high demand for senior roles, **Low-Level Design (LLD)** is crucial for several reasons:

Avoids Rework: Clearly defined logic and structure help catch design issues early, reducing costly changes during development.
Improves Collaboration: Acts as a shared reference for teams, ensuring everyone understands component behavior and integration points.
Promotes Scalability: Well-designed, modular components can handle growth and new features without major redesign.
Encourages Best Practices: Enforces use of clean code, design patterns, and OOP principles, leading to maintainable and robust systems.