# SolidBankAppDemo

## About
This Demo application can handle basic bank operations like
- Creating an account
- Listing accounts
- Deposit money to certain account
- Withdraw money from certain account
- Uses ***h2*** database in memory to store Accounts and Transactions
- Uses ***flyway*** to create tables ***ACCOUNT*** and ***TRANSACTION*** at runtime
- Makes use of ***SOLID*** principles


## Steps to run the application
- In IntelliJ, Setup a SDK (this app uses JDK 17)
- Download all maven directories
- Run the main method in DemoApplication class
- Maven 3.8.5 needed to run the application in a terminal

## Running in command line
In the main directory called solidbankapp execute the following command:
```bash
java -cp out/artifacts/demo_jar/demo.jar src/main/java/bankapp/DemoApplication.java
```
Or if you would like to run this application using Maven, you could use the following command:
```bash
mvn compile
mvn spring-boot:run
```

## CLI inputs
- 1 - show accounts  
- 2 - create account  
- 3 - deposit  
- 4 - withdraw  
- 5 - transfer  
- 6 - this message  
- 7 - exit  

The output of the SolidBankApp1 is the following:
![output](https://i.imgur.com/UQI2hFs.png)

## SOLIDBANKAPP2 OUTPUT
![output2](https://i.imgur.com/X9ePcz5.png)

## H2 DATABASE CONSOLE on localhost
![h2database](https://i.imgur.com/k87Z1XT.png)

## REST API
![restapi](https://i.imgur.com/61LVdwr.png)