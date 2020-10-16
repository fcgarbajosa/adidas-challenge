# adidas-challenge README

Author: Fidel C. Garbajosa
Date: 16 October 2020

This application has been designed and coded according the requirements stated on the PDF received.

The chosen approach is write a subscription web service which is in charge of store, modify, list and delete subscriptions of the mail service. This is the app that does that.

The email service doesn't have to be communicated with the subscription service, as the only thing the email service has to do is read the subscriptions from the database that have the 'flagOfConsent' field to 'Y', get the emails of these users and send then an email.

This app uses a rest microservice exposing different endpoints (see challenge.web.controllers.SubscriptionController) where subscriptions are stored, modified, listed and deleted. Spring framework (Spring Boot) is used to do that, H2 Database to store information, JSON Web Token security to protect the api from non authorized users and Spring JPA to access to the database. 
Also the microservice endpoints are exposed using Swagger 2.

a Docker configuration file (see 'Dockerfile') has been included in order that this app can be run on a Docker container.

# How to use the app

Being an app written in Spring and maven, you can run it with 'mvn spring-boot:run'. On the other side you can build an image and container to run with Docker 

1.- The first thing to do is add a user to the system in order he/she can use the app, so you need to register a user. We recommend use a tool like Postman to test the app.
You will have to call to the unprotected post endpoint:

http://localhost:8080/adidas-challenge/register

with Body: 

{
	"id":1,
	"username":"adidas",
	"password":"adidas"
}

2.- Then you need to get a token to access to the app sending user and password. Call to post endpoint:

http://localhost:8080/adidas-challenge/authenticate

with Body:

{
	"username":"adidas",
	"password":"adidas",
	"minutesTokenValidity": 300
}

You will receive a token. This gives you access rights to the app. You will have to set Postman, as the 
endpoints are protected, to have an authorization of type 'Bearer Token' and insert the token value on the field 
(we presuppose the tester has a good knowledge of the Postman tool). 

3.- Once the Authorization and token are set in Postman you can call to the different entry points to store, list, 
modify and delete subscriptions (see 'SubscriptionController' file to see what endpoints the rest web controller has)

4. The Swagger documentation can be accessed on the url: http://localhost:8080/adidas-challenge/v2/api-docs

 # Team career
 
 In my opinion, the best thing to do is to divide the team into two, one for the Subscription app and the second one for the 
 mailer app
 
 # Bonus 1
 
 The classic pipeline with three phases: Build, Test and Deploy
 
 # Bonus 3
 
 Parameters to monitor: Database server load, number of subscriptions on table Subscription in database, 
 system loads where these apps are deployed.    





