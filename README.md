# Automation Assignment

Created Automation test assignment to automate below API service.
API documentation can be found at https://exchangeratesapi.io/documentation/

## Getting Started
#### Tech Stack
* **JAVA 8** as ther programming language for writing test code.
* **Cucumber** as the frameworks.

#### Setup:
* Install [Gradle](https://gradle.org/install/)

#### IDE 
* Intellij

#### Execution
To run **Unit test** use below command.
`gradle test -Dcucumber.filter.tags="@smoke"`

To run all tests use below command.
`gradle test -Dcucumber.filter.tags="@regression"`



#### Report Generation
Report can be found at below path post execution
`/build/reports/tests/cucumberTests/index.html`

#### Note 
I only have limited access to API because of free account.Tests for `Specific date` will fail.

