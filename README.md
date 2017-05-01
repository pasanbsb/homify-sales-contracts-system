# Homify Sales Contracts System

## RESTful webservice that provides a small set of operations on a small scope model. The model is composed of customers and the sales contracts that they sign. So, for each Customer , we can have several unique Contract (s). Each Customer has a unique numeric id , full name and email as fields. Contract has a unique numeric id , the id of the Customer it belongs to, a start date , a type and a monthly revenue , as fields.

###### Used libraries
- Jetty -  to start stanalone web server with web services
- Jersey - to create RESTful web services
- slf4j - logging

###### installation
- run mvn clean install 
- go to homify-sales-contracts-system\hscs-app\target and copy  following files
-- hscs-app-1.0.0.0-SNAPSHOT.jar
-- lib
- to run the application, execute java -jar hscs-app-1.0.0.0-SNAPSHOT.jar
- A web server with port number 8085 will start
- logs will be created in both console and logs folder

###### testing
- execute following requests using curl or a web service client

```
curl -H "Content-Type: application/json" -X POST -d '{"customerId":12,"fullName":"123456", "email" : "email"}' localhost:8085/customerservice/customer/12
curl -H "Content-Type: application/json" -X POST -d '{ "customerId" : "12", "startDate" : "2017/05/01", "type" : "full", "revenue" : 200}' localhost:8085/customerservice/contract/1
curl -H "Content-Type: application/json" -X GET localhost:8085/customerservice/contract/12
curl -H "Content-Type: application/json" -X GET localhost:8085/customerservice/contract/full
```