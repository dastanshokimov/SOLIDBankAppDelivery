# SOLIDBankAppDelivery

## About this app

The SOLIDBankAppDelivery is a basic bank app that can

  * Show all the information about accounts
  * Create three types of accounts (CHECKING, FIXED, SAVING)
  * Transfer money to an available account
  * Withdraw money from an available account
  * Delete accounts of the user
  * Show transactions on a specific account
  * Show all transactions of a specific client on his/her accounts
 
Technologies applied in the project
  * The ***f2*** DBMS to store all the information about accounts and transactions

## How to run the app:

  * Clone this repository using `git clone https://github.com/dastanshokimov/SOLIDBankAppDelivery.git`, and run it with IntelliJ Ultimate Edition
  * Or download this repository as an archive and run it with IntelliJ Ultimate Edition
  * Or using `java -cp out/artifacts/ src/main/java/` for running it on the command line

## Swagger test:

### Initial response to `GET/accounts`: 
![image](https://user-images.githubusercontent.com/104251147/174427129-3b3f90ae-a570-4ccf-aa04-72f2596eceb7.png)

### Response to `POST/accounts` creating FIXED and SAVING accounts:
![image](https://user-images.githubusercontent.com/104251147/174427320-ce3ba010-5396-4bdb-87c1-1099266665cb.png)
![image](https://user-images.githubusercontent.com/104251147/174427332-b3eaa87c-7b50-4545-bcda-e7707a011c35.png)

### Response to `POST/accounts/{account_id}/deposit`:
![image](https://user-images.githubusercontent.com/104251147/174427445-513348ef-263f-4b69-9d20-e8721dcf0773.png)
![image](https://user-images.githubusercontent.com/104251147/174427462-d4e8e5ce-fe51-4044-93b7-52d32f8a9134.png)

### Response to `POST/accounts/{account_id}/withdraw` from FIXED and SAVING accounts:
![image](https://user-images.githubusercontent.com/104251147/174427539-621f150a-65a4-4ab8-b6d9-7cc06f7f5d6b.png)
![image](https://user-images.githubusercontent.com/104251147/174427569-024ee7c1-7a4d-4641-a402-ac8dff13a719.png)

### Response to `GET/accounts/{account_id}` for the first account (SAVING):
![image](https://user-images.githubusercontent.com/104251147/174427591-0863a106-63f1-4c6b-934c-b728b719d4e4.png)

### Response to `DELETE/accounts/{account_id}` for the first account (FIXED):
![image](https://user-images.githubusercontent.com/104251147/174427614-cd80c7e2-312a-4f67-86a7-249e6fd95e39.png)

### Response to `GET/accounts/{account_id}` for the second account (SAVING):
![image](https://user-images.githubusercontent.com/104251147/174427715-3dcc3a2f-7632-48d8-b416-a50422b438cf.png)

### Response to `GET/transactions/`:
![image](https://user-images.githubusercontent.com/104251147/174427736-134bcc96-3483-446f-b5f4-3e04c69b3bb5.png)

