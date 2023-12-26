<!-- PROJECT LOGO -->
<div align="center">
  <h1 align="center">Flights Booking</h1>
  <p align="center">Web Testing Project</p>
</div>

<!-- TABLE OF CONTENTS -->
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#workflow">Workflow</a></li>
    <li><a href="#useful documentation">Useful Documentation</a></li>
  </ol>

<!-- ABOUT THE PROJECT -->
## About The Project

The project focuses on testing the Flights Booking Practice website from Rahul Shetty Academy, using core testing tools such as Java, and Selenium Web Driver. The testing process is integrated with Jenkins and using TestRail to provide a comprehensive testing experience. The goal of the project is to improve testing skills and gain experience in web testing.
![Alt text](img.png)
### Built With

* Programming Language: Java
* CI Tools: Jenkins
* Frameworks: Selenium Web Driver
* Test Management Tools: TestRail

<!-- GETTING STARTED -->
## Getting Started


### Prerequisites

- [ ] Install Java +11
- [ ] Download chromedriver and selenium server standalone
- [ ] Install Jenkins

### Installation
- [ ] Download chromedriver for your Chrome browser version, save it in Downloads.
- [ ] Download selenium-server-standalone-3.141.59.jar, save it in Downloads.
- [ ] Clone the repo.
- [ ] Run selenium standalone openning a new terminal in Downloads and run this command: java -jar selenium-server-standalone-3.141.59.jar
- [ ] Modify the -config.properties file with browsername and version.
- [ ] Add a _testdata.properties file with TestRail's credentials data (testRailUrl, testRailUsername, testRailPassword).

<!-- USAGE EXAMPLES AND STUDY CASES-->
## Usage

- [ ] Run tests from testng.xml files to create automatically a test run in TestRail.

## Implementation details

### Study case: LOGGER implementation
- Logging is a powerful aid for understanding and debugging a program’s run-time behavior. Logs capture and persist the important data and make it available for analysis at any point in time.
```
import java.util.logging.Logger;

public static final Logger LOGGER= Logger.getLogger(String.valueOf(HomePage.class));
```
### Study case: Static Dropdown
- Selenium can handle static dropdowns with the help of the Select class. A dropdown is identified with <select> tagname and its options are represented with the tagname <option>. 
- The statement - from selenium.webdriver.support.select import Select should be added to work with Select class.

```
Identify the <select> WebElement
private WebElement currencyDropdown= driver.findElement(By.xpath("locator));

Create a Select object from org.openqa.selenium.support.ui.Select and star using all its methods to select by Value, Index or Text
Select staticDropdown =new Select(currencyDropdown);
staticDropdown.selectByIndex(3);
```

<!-- WORKFLOW -->
## Workflow

1. Check tickets assigned to you defined in the Project Management Tool (e.g. Trello)
2. Check TestRail's test case: preconditions, steps, expected results
3. Create your Feature Branch following naming convention [TCXX]-testName
4. Add components and pages as needed, using Page Object Model Design Pattern
5. Commit your changes, push them to your branch and create a pull request assigning a reviewer
6. Merge changes to master branch

<!-- USEFUL DOCUMENTATION -->
## Useful Documentation

* [Selenium](https://www.selenium.dev/documentation/overview/)
* [Selenium Github Example](https://github.com/SeleniumHQ/seleniumhq.github.io/tree/trunk/examples)
* [TestRail](https://support.gurock.com/hc/en-us)
* [Flights Booking Practice Website](https://rahulshettyacademy.com/dropdownsPractise/)
* [TestNG](https://testng.org/doc/documentation-main.html)