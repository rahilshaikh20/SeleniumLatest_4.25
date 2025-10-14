# Copilot Instructions for SeleniumLatest_4.25

## Project Overview
This is a Java-based Selenium automation framework with API and UI testing capabilities. The codebase is organized for modularity and maintainability, supporting both web and API test cases.

## Architecture & Key Components
- **src/main/java/**: Core framework code
  - `apiTesting/`: API test utilities and endpoint definitions
  - `javaCode/`: Data providers and reusable code modules
  - `pages/`: Page Object Model (POM) classes for UI automation
  - `utilities/`: Config, driver setup, reporting, and helper utilities
- **src/test/java/**: Test cases
  - `apiTestCases/`: API test implementations
  - `testCases/`: UI test implementations
- **resources/**: TestNG configuration files and test data
- **build.gradle**: Gradle build configuration

## Developer Workflows
- **Build**: Use `./gradlew build` to compile and package the project.
- **Run Tests**: Execute `./gradlew test` for all tests, or use TestNG XMLs in `src/test/resources/` for targeted runs.
- **Reports**: Test results are generated in `build/reports/tests/test/` (HTML) and custom Spark reports in `SparkReports/`.
- **Screenshots**: Failure screenshots are saved in `Screenshots/`.

## Project-Specific Conventions
- **Page Object Model**: All UI interactions are abstracted in `pages/` classes. Tests should use these objects for maintainability.
- **Config Management**: Use `Config.properties` and `ConfigReader.java` for environment/configuration values.
- **Driver Management**: WebDriver setup is centralized in `DriverFactory.java`.
- **Reporting**: Custom reporting via `ExtentReportSetUp.java` and Spark HTML reports.
- **Test Data**: Data providers are implemented in `TestCaseDataProvider.java` and referenced in test classes.

## Integration Points
- **External Dependencies**: Managed via Gradle (`build.gradle`). Selenium, TestNG, and reporting libraries are primary dependencies.
- **CI/CD**: Jenkins integration via `JenkinsFile`.

## Patterns & Examples
- **API Test Example**: See `apiTestCases/TC_001_GETTestCase.java` for REST API test structure.
- **UI Test Example**: See `testCases/` for usage of POM and data providers.
- **Config Usage**: Reference `ConfigReader.java` for accessing properties.

## Tips for AI Agents
- Always use existing utility classes for config, driver, and reporting.
- Follow the POM pattern for new UI tests.
- Place new test data and configs in the appropriate `resources/` or `utilities/` files.
- Reference and extend existing test cases for consistency.

---
_Review and update these instructions as the codebase evolves. For questions or missing conventions, ask the team for clarification._
