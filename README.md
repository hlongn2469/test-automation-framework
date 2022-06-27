# test-automation-framework
goal:
- create a dedicate Java test automation framework for integration test and support code from scratch

Process:
- Initialize an empty Maven project with IntelliJ
- Add testing framework dependencies (Junit,Selenium, RestAssured) to pom.xml
- Create test folder anc class under src/test

### 1) JUNIT unit testing
- Use @Test for testing method 
- Create dummy method and test expected result vs actual result with ASSERTIONS method

### 2) Selenium Web UI testing
- Download ChromeDriver
- Set up chromeDriver
- Use Chrome Driver to act as client
- Assert

### 3) Refactor UI Tests
- Create a @beforeEach set up and @AfterEach clean up method for the webdriver
- Create constant global variables such as base url and webdriver

### 4) Optimize test runtime (8 seconds -> 3 seconds)
- Replace @BeforeEach and @AfterEach with @BeforeALll and @AfterAll
- Assign web driver constant to static
- Assign set up and clean up method to static
- Static helps because it does not require instance creation.

### 5) Scaling tests using inheritance
- Create a base test which is extended from children tests
