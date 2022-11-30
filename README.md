# BP Category Calculator
A spring boot MVC application. The main objective of this repo is to work on CI/CD with Github Actions with end to end testing.

## Features
- Calculate the category for given Systolic and Diastolic pressure
- Show the historical pressure readings
- Calculate an average pressure

## Build commands

---

Compile `mvn clean compile`

Unit test `mvn surefire:test`

Integration test `mvn failsafe:integration-test`

BDD test `mvn jbehave:run-stories-as-embeddables@run-stories-as-embeddables`
