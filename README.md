[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=hypheni_spring-bpcalc&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=hypheni_spring-bpcalc)

# BP Calculator - CI/CD Demo
A Java SpringBoot MVC application to build a CI/CD pipeline using Github Actions. This includes:

- Web app with an index and history page using thymeleaf template engine
- Continuous Integration
    - Unit test using JUnit and code coverage calculated by Jococo
    - Integration test using SpringBoot Testing framework
    - BDD test using JBehave framework
    - Code quality check by SonarCloud

## Build commands
- Compile `mvn clean compile`
- Unit test `mvn surefire:test`
- Integration test `mvn verify failsafe:integration-test`
- Generate code coverage report `mvn jacoco:report`
- BDD test `mvn jbehave:run-stories-as-embeddables@run-stories-as-embeddables`
- Sonar analysis `mvn sonar:sonar -Dsonar.login=<key> -Dsonar.host.url=https://sonarcloud.io -Dsonar.qualitygate.wait=true -Dsonar.organization=<key> -Dsonar.projectKey=<key>`
- Dependency scan: `mvn dependency-check:check -DfailBuildOnCVSS=4`
- End to end test: `npx playwright test`
