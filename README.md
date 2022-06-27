# Test-automation-framework
## Goal:
- Create a dedicate Java test automation framework for Web UI, API and support code from scratch
- System Under Test (SUT): Github Page
- Maintain a clear organization of test framework:
  - Develop support code under main folder including entities POJOS and Body Handlers to handle object mapping
  - Develop test cases including Junit, Selenium, HTTPClient/RestAssured under test folder

## Process:
- Initialize an empty Maven project with IntelliJ
- Add testing framework dependencies (Junit,Selenium, RestAssured) to pom.xml
- Create test folder anc class under src/test

### 1) JUNIT unit testing
- Use @Test for testing method 
- Create dummy method and test expected result vs actual result with ASSERTIONS method

### 2) Selenium Web UI testing
- Test username display, repo access, and repo counts.
- General flow:
  - Download ChromeDriver
  - Set up chromeDriver
  - Use Chrome Driver to act as client
  - Assert against expected output

#### a) Refactor UI Tests
- Create a @beforeEach set up and @AfterEach clean up method for the webdriver
- Create constant global variables such as base url and webdriver

#### b) Optimize test runtime
- Replace @BeforeEach and @AfterEach with @BeforeALll and @AfterAll
- Assign web driver constant to static
- Assign set up and clean up method to static
- Static helps because it does not require instance creation.

#### c) Scaling tests using inheritance
- Create a base test which is extended from children tests

### 3) HTTPClient API testing
- Test GET API access (200 code?), GET header values (content type, x rate limit), POST without Authorization (401?), and GET response body whether User URL is expected
- General flow:
  - Set up HTTP Client and Request to establish API connection to the server
  - Receive a response from client 
  - Assert the response against expected values
 
#### b) Refactor API test
- Create a @beforeAll set up method to fire the request and get response per test run
- Create constant global variables such as base url, HTTP client, HTTP response

#### c) Optimize test runtime
- Use @ParameterizedTest to takes in as many input headers and expected values as we want
- Reduce repeated code for a specific testing area. In this case, header values.
- Remove all hard code values for input header and expected values.
- Declare set up method and global variables as static

### 4) Substitute HTTPClient with RestAssured
- Pros: High level, easy to use, time-effective 
- Cons: Hide details in testing Rest APIs

### 5) Scaling test framework to multi-module

