# selenium-web-automation-gradle

## Technology:
- Tool: selenium
- IDE: IntelIJ
- Build tool: Gradle
- Language: Java
- Framework: TestNG


## Requirement:
1. Navigate to an ecommerce site
2. Register a customer account with unique email
3. Login to customer account
4. Search for an item by typing 'dress' on search box
5. Add to cart
6. Checkout item
7. Assert with purchase confirmation message

## Prerequisite:
1. Need to install jdk 1.8
2. Need good internet connectivity

## Run the automation script:
1. Open cmd to the project folder
2. Type this command:

```sh
gradle clean test
```
3. Selenium will open the browser and start automation.
4. To view report, type this command:
```sh
allure generate allure-results --clean -o allure-report
allure serve allure-results
```
## Report View
![alluresult](https://user-images.githubusercontent.com/48891202/85232576-b6ae0600-b421-11ea-8a5e-913df13d30cd.png)
![allureresult2](https://user-images.githubusercontent.com/48891202/85232626-245a3200-b422-11ea-90f1-de4c649f3534.png)

You will find the automation <a href="https://youtu.be/VzlgCcbHZWU" target="_blank">video</a> here.
