# crud-blog-server-springboot

This application is written in Java with Spring boot. It uses in memory database. When you run it, it will create an empty database and delete it when closing the application. 

It will map requests from local port 8080.


Creating a post on the blog(“/blogpost”):
*you should call this endpoint with POST method with a body as follows:
*String post
*String header
*A successful creation returns only status code 200.


Reading a single post from the blog(“/blogposts”):
*you should call this endpoint with GET method and with a id parameter:
*long id
*this will return a BlogPost object with following fields:
*long id
*String header
*String post
*Date date (java.utilli.Date)


Reading posts with paging(“/blogposts”):
*you should call this endpoint with GET method and it takes in a Pageable parameter:
*you can control the page size, page number and the ordering of the response.
*Spring Pageable docs:         http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/domain/Pageable.html
*the return type is Page of BlogPost objects. 
*Spring Page docs:       https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/domain/Page.html


Updating a blogpost(“/blogpost”):
*you should call this endpoint with PUT method with a body as follows:
*String post
*String header
*long id
*A successful update returns only status code 200


Deleting a blogpost(“/blogpost”):
*you should call this endpoint with DELETE method and an id parameter:
*long id
*A successfull delete will return only status code 200
