
## Application Description
Summer is coming and we are all looking forward to having a barbecue with friends. For a nice barbecue, we also need some refreshing drinks. Therefore, we want to start a new business where we sell beverages and deliver them to people. The easiest way is to implement a REST API where users can access the beverages via a well defined interface.

The requirements for the system are:
1. Support different views on the API (we will split this into two parts in the next assignment). One view is for customers and the other one is for employees.
2.  A user should be able to view beverages and place orders. Implement a simple search function and a filtering mechanism with min and max price. When submitting an order, the order has the status SUBMITTED. The available quantity in the stock will be reduced for each beverage included in an order item. EXAMPLE: Assume there are six bottles of sparkling water in stock. If a customer wants to buy five bottles of sparkling water and submits his order, a single bottle remains in stock. So changes are made directly when submitting the order.
3. To see the status and details of an order, a customer can access their order via the order’s ID.
4. If an order hasn’t been processed yet, a customer can change their order.
5. If an order hasn’t been processed yet and a customer doesn’t need the beverages any more, they can cancel the order. HINT: Think about the correct HTTP verb and the consequences.
6.  An employee should be able to create new beverages (bottles or crates), adjust their prices, quantities in stock etc. When an order is submitted by a customer, an employee has to process the orders. When the order is ok, the employee packs the beverages and commits the order as PROCESSED. HINT: There is no possibility for the customer to change the order any more.
7. Therefore, we need a portable and scalable solution to host our service since a single monolithic application running on one of our laptops is not sufficient any more. This requires some changes in our code and the solution design.

8. We build a microservices architecture, where all the boxes are simple JAX-RS compliant Java microservices. They communicate via API calls23. We extract our in-memory database and use files instead, which are stored on our host system. The orange border marks the Docker/Kubernetes boundaries, so the microservices and the files should be included and managed by these frameworks. Only the Beverage Service and your Management Service expose an API, which is accessible outside of the inner network.
Specification of your services
9. Beverage Service - Java Microservice - Re-implement a simple version from the first assignment. The only endpoint this service should be offering is to GET all the beverages, which are stored in DB. Consume the API of the DB-Handler to achieve this goal. Your service should be accessible outside of the docker network with port 8080.
10. Managment Service - Java Microservice - This is the view of your employees, who create, read, update and delete beverages. So re-implement these four facilities from the first assignment. Your service should use the handler and be accessible outside of your docker network with port 8090.
HINT: Think about different representations (DTOs) of your beverages for your Beverage Service and your Management Service. You have to consume your own DB-Handler REST API. Look at WebTarget and other classes to do so.
 
11. DB-Handler - Java Microservice - A single instance of this DB-Handler should be deployed in both orchestration versions. This is for consistency reasons, since the DB handler reads and writes the files exclusively. Also think about concurrency issues. For each request, a single resource instance (runtime automatically instantiates the resource class) is created and serves the request. So race conditions, lost updates etc. can occur. Think about a good design of your solution. The REST API of your DB-Handler should be accessible only within the docker network under db:9999/v1
(design the API accordingly).
12. DB - File System - We don’t want to store the data in memory, therefore we use files instead. (REMARK: in a business scenario, we would use a NoSQL database, but this storage solution let us understand how storage is handled in Docker and Kubernetes). Use appropriate storage concepts, where the corresponding framework handles this for you.
### PART 1: 
Docker All of the described services should be packaged inside their own Docker container and orchestrated via Docker Compose. Make sure to set appropriate dependencies and links to allow an automatic bootstrapping of the service composition via docker-compose up. Also support environment variables in your compose file (implement it by hand or via MicroProfile Config) so that service configurations can be easily changed without rebuilding the container images. Especially the connections from the beverage service and the management service to the db handler must be dynamically configurable.
### PART 2: 
Kubernetes Use the docker containers from PART 1. You should not rebuild your images, make the projects configurable and specify the environment variables via ConfigMaps. For the database part, you are allowed to rebuild the image, if you decide to use StatefulSets (as shown in the example on GitHub) with a mongo db integration, or store the data in files as in the docker case.



##
 
 

