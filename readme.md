Task 1) Write a simple application that provides movie suggestions for a user based on their movie genre preference. You can choose tools and libraries that you use yourself. Provide a REST API for this. We want to use multiple external services like Netflix or IMDB for the recommendations. Let's assume that you don't have access to those external services yet, don't know their exact API yet, but have to implement something now and use the APIs later.

COMMENTS: 
- A very simple back end app for processing movies was built using Spring Boot, Hibernate & Gradle
- A REST API for this was provided with POST, GET and a GET method for receiving movies by category
- The database "movies" could easily be populated by retrieving data from external services such as Netflix and IMDB. This would just need to repeatedly retrieve data from respective endpoints and POST the movies to the "movies" database.

Tips and questions to consider:
- What kind of architecture would you use to achieve this?
- How would you design the application for testability?
- There is no need to implement persistence but how would you take that into account in the design?

COMMENTS:
- To process data from third-party APIs as part of the application, a three-tier architecture would be better. The application developed so far would become the Logic Tier and it would be extended so that it would seamlessly process API requests from the application database as well as external databases.
- To design the application for testability, all methods would be designed to execute only individual tasks, so that a tester could design simple tests for each method independently. 
- Persistence would be provided by hibernate and my implementation connects to Persistence Layer through Spring Data JPA (see repositories)

Task 2) If you later decided to migrate to a microservices architecture, what kind of patterns would you use for this? No implementation needed.

COMMENTS:
- If this were to migrate to a microservices architecture, I would use the "Database or Shared Data Pattern". With this pattern the system would have a database per each service or a shared database per each service, which would seek to minimise duplication of data and inconsistencies arising from using third-party API data.