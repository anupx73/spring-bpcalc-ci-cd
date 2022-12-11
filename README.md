[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=hypheni_spring-bpcalc-ci-cd&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=hypheni_spring-bpcalc-ci-cd)

# BP Calculator - CI/CD Demo
A Java [SpringBoot](https://spring.io/guides/gs/spring-boot/) MVC application to build a CI/CD pipeline using [Github Actions](https://github.com/hypheni/spring-bpcalc-ci-cd/actions). This includes:

- [Web app](https://spring-bpcalc-lxwpse7yja-ez.a.run.app/) with an index and history page using [Thymeleaf](https://www.thymeleaf.org/documentation.html) template engine
- Continuous Integration
    - Unit test using [JUnit](https://mvnrepository.com/artifact/junit/junit) and code coverage calculated by [Jococo](https://mvnrepository.com/artifact/org.jacoco/jacoco-maven-plugin)
    - Integration test using [SpringBoot Testing](https://www.baeldung.com/spring-boot-testing) framework
    - Acceptance or behavior driven testing using [JBehave](https://jbehave.org/)
    - Static code analyslus and quality check by [SonarCloud](https://sonarcloud.io/)
    - OWASP [Dependency Check](https://search.maven.org/artifact/org.owasp/dependency-check-maven/7.4.1/maven-plugin) for vulnerabilities check
- Continuous Deployment
    - Authentication to Google Cloud project
    - Build application container using [JIB](https://cloud.google.com/java/getting-started/jib)
    - Deploy the container to [Google Cloud Run](https://cloud.google.com/run)
    - Executes [PlayWright](https://playwright.dev/docs/intro) end to end testing
    - Executes [K6](https://k6.io/docs/examples/single-request/) load testing
    - Executes OWASP [ZAP](https://www.zaproxy.org/docs/desktop/start/pentest/) penetration testing
- Reporting
    - Both the [CI](https://github.com/hypheni/spring-bpcalc-ci-cd/actions/workflows/ci.yml) and [CD](https://github.com/hypheni/spring-bpcalc-ci-cd/actions/workflows/cd.yml) stage will aggregate all test reports
    - Reports will be published in Github Actions page

## Build commands
- Compile `mvn clean compile`
- Unit test `mvn surefire:test`
- Integration test `mvn verify failsafe:integration-test`
- Generate code coverage report `mvn jacoco:report`
- BDD test `mvn jbehave:run-stories-as-embeddables@run-stories-as-embeddables`
- Sonar analysis `mvn sonar:sonar -Dsonar.login=<key> -Dsonar.host.url=https://sonarcloud.io -Dsonar.qualitygate.wait=true -Dsonar.organization=<key> -Dsonar.projectKey=<key>`
- Dependency scan: `mvn dependency-check:check -DfailBuildOnCVSS=4`
- End to end test: `npx playwright test`
