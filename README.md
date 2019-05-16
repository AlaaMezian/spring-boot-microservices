# Maf-Task

this is a solution based on micro-service architecture to easily add / remove services providers without effecting other providers and without effecting the main services consumer.

in this solution i used spring boot and spring cloud to implement microservice archtiture here are some of the modules used in the solution: 
  -Service Discovery (Eureka Naming Server)
  -Feign Rest Client
  -Hystrix for fault tolerance
  -Rest Controllers 
  -Swagger for api documentation 
  
# Archticture
  in this paragraph i will explain the archticture ,our solution  contains four core microservices, bestHotel, crazyHotel ,      available hotel which act as a consumer for other services and aggregateHotels the aggregate hotel micro service act as bridge or as some other people call front door to other underlying micro service.
  
  the purpose of the aggregate service is to be the main portal to microservices leaving each microservice sperate independent on other services,so adding or removing microservice will be maintain only in the aggregate service cod, the aggregate service is the key for this structure to because it will calls each relevant microservice collects the data, apply business logic to it, and further publish it is as a REST Endpoint.
 
 
 implementating hystrix applied defensive programming strategy is essential, if besthotel service provider went down , our main service consumer won't go down and will not recive an error but instead hystrix will call a FallBack Command which will handle besthotel microservice fauiler.


   
  
