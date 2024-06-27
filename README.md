# Recording incidents

### About the project:

Application for recording incidents.

Technologies used:
* Commons apache lang
* Docker
* Java
* JPA
* Junit
* Lombok
* MongoDB

## Installation

### Pre-requisites

* Postman or another endpoint testing application. 

* Some IDE that runs Java, in the project we used Intellij. 

* Docker to be able to upload the MongoDB database.
> [!NOTE]
> - To follow the creation and have access to the database information, you can download MongoDB Compass.
> 
> - You can also test the applications using JUnit tests.


### Installation

1. Get the repository link [https://github.com/leilanyaragao/Recording-incidents]
2. Clone the repository
   ```https
   git clone git@github.com:leilanyaragao/Recording-incidents.git
   ```
3. Open the project in your preferred IDE

4. Open the terminal in the docker folder and run - docker compose up - so that the database is created.

5. In the IDE run the file IncidentsApplication.java

8. In postman (or another application of your choice) test the endpoints at localhost:8080

   ```JS
   DELETE / - delete all incidents

   DELETE /deleteById/{id} - delete incident by id

   DELETE /deleteByName/{name} - delete incident by name
   
   GET / - Get all incidents
   
   GET /id/{id} - Get incident by id

   GET /name/{name} - Get incident by name

   GET /find - Get last 20 incident order by desc

   POST  - Add new incident

   PUT  - Update incident (Here you can update/add name, description and add closedAt"

   ```

### Some examples:
#### - (POST) 
```
Input:
  localhost:8080/

Body:
  {
    "description": "description1",
    "idIncident": "1",
    "name": "name1"
  } 
```
> [!NOTE]
> If you don't put incident it will be generated random id.
>
> createdAt will be automatically set to the incident creation time.

#### - (PUT) 
```
  Input:
    localhost
  
 Body:
  {
    "description": "description2",
    "idIncident": "1",
    "name": "name1"
    "closedAt": "2007-12-03T10:15:30"
  } 
```
> [!NOTE]
> You must report the incident for an update to be made.
> 
> In the update you can change/add name, description and add closedAt.
> 
> updatedAt will be automatically set to the incident update time.


