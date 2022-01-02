# Getting started

### How to build the back end api as a standalone project

* ./gradlew bootJar
* sudo docker build .
* sudo docker run -d -it -p 8080:8080 crypto-price-api


### Assumptions on developing backend service

* All cryptocurrency rates are saved in an in memory database along with the IP address

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