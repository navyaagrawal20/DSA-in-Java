# Data Structures in Java — Guide

This repository contains Java code exploring data structures. Use this README as a quick reference for navigating, compiling, and extending the code.

## Project layout
- Trees/Segment.java — implementation to inspect: [`Trees.Segment`](Trees/Segment.java)

## How to compile & run
From the repository root:

- Compile:
  - javac Trees/Segment.java

- Run:
  - If `Segment` declares a package `Trees`: 
    - java -cp . Trees.Segment
  - If `Segment` has no package:
    - java -cp . Segment

Adjust commands if your codebase has a build tool (Maven / Gradle).

## What to look for
- Class responsibilities (construction, operations, edge cases)
- Public API (methods and expected inputs/outputs)
- Tests (add JUnit tests under a test directory to cover behavior)

## Adding a new data structure
1. Create a new file under an appropriate directory (e.g., Trees/BinaryTree.java).
2. Add clear Javadoc for public types and methods.
3. Add unit tests (JUnit) validating behavior and edge cases.
4. Update README with a brief description and usage example.

## Resources
- Oracle Java Tutorials — Collections and data structures
- "Algorithms, 4th Edition" by Sedgewick & Wayne — practical implementations

## Contributing
- Follow the existing code style in the repo.
- Write unit tests for new features.
- Open a pull request with a short description and usage examples.
