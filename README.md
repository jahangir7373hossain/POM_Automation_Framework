Framework name: POM_Automation_Framework
Created By: Jahangir Hossain Khan

Framework Description:

It is a maven project developed in java programming language.
The concept used in framework that is data driven by using page
object model with page factory.Framework has three source folder
As per page object model we have maintained classes for every web
page. Each web page has separate classes and classes hold the 
functionality and members of that page. We have separate classes
for individual tests. We have separate packages for page and 
test script.All web page related classes come under pages 
package and all test classes come under tests package
1. src/main/java 2. src/test/java 3. src/main/resources

src/main/java
=============
src/main/java has four packages such as base,listener,page and
utils.

base package: 
*************
base package has two classes such as Driver and TestBase

Driver class: Driver class is used for lunching the application on
browsers.This framework support multiple browser such as chrome, ie
and firefox.

TestBase class: TestBase class is the brain of the framework.TestBase
will help to initialize the pages classes webelement use pageFactory.
Also,this class will be extended with every single test classes.

listener:
********
listener package has class called TestListener.

TestListener: TestListener class implements ITestListener to generate the
test report in pdf. After running the test cases,test report will generated
as Result folder in below.

pages package:
**************
pages package will have all the classes for every single web page with web element.

utils package:
*************
utils package has class called TestUtils.

TestUtils: TestUtils class has all the supporting functions for framework.

src/test/java
=============
src/test/java has only one package called test

test package:
************
test package will have all the classes with test scripts.test package will have separate.
classes for individual tests.

src/main/resources
==================
src/main/resources has three folder such as exe_files, properties and suite.

exe_files: exe_files has binary for all browsers driver.
**********

properties: properties contains all required properties for framework.
**********

suites: suites has testng.xml file. Test cases should be run from this file.
*******

excel:
=====
excel folder will have all excel files with historic data and application login
credentials.






