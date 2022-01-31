# Getting started

### How to run the project

* I used docker-compose to containeraize and deploy the application but got stuck in a CORS issue. PLease follow the following steps to run the application

* ./gradlew bootRun -> to run the back end application

* npm start  -> to run the front end application 

(open terminals on respective project root directory)

* access the web app on localhost:3000


### supported currency list

* BITCOIN - 127.0.0.1

* ETHER - 127.0.1.1

* BINANCE - 127.0.1.2

* TETHER - 127.0.1.3

### Assumptions on developing backend service

* All cryptocurrency rates are saved in an in memory database along with the IP address

* For a given currency and IP address there will be only one rate ( currency and ip pair will be unique ) 

### Proposed backend Architecture

![](../../../../Downloads/architecure.png)

1. when landing page load a get request will send to the backend to fetch all the supported currency

2. From back end service, query the data from H2 database

3. Since the currency values are static for a given time a cache is introduced to increase the performance. When we query the data from database for the first time, 
   we will insert data into cache. When next call comes the data will be fetched from cache, no need to query in the database

4. return the supported currency list to front end, and it will render the cryptocurrency name in UI

since the IP address is also available in front end no need of api call to backend. we can show the crypto rate from the result array

#### Reason to choose this architecture

* we can render the currency list dynamically and any future addition and deletion of currency will not impact the system.

* Cache is used for performance improvement, fast retrieve of data