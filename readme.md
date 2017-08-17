# WorldTicket Recruitment Test
Keep it simple. We would like to see your coding style. *Please do not copy solution from the internet.*

## Pre-requisite
- [Mercurial](https://www.mercurial-scm.org/)
- [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven](https://maven.apache.org/download.cgi)

## Requirement
Create a simple web application for currency conversion.
The application should have the following features:

- Database to store the currency exchange rates
- REST API to retrieve the exchange rate and calculate the result
- Business Logic to offer cheaper rate for large volume selling or more expensive rate for small volume buying

# Solution
This system is for exchange from thai baht to another currency(BUY). And another currency to thai baht(SELL)

Class Rate is for keep the rating data.
Class Exchange is for keep the exchange  data .


## Step 1
- Database configuration to see application.properties. I use mySQL

## Step 2
- Run the application (Spring Boot don't need Tomcat It has inside)

## Applicationn 
- To the main page  http://localhost:8080/index
- First of all to "Add the new rate"

## REST to calculate the exchange
-Before call link below should run Application and configuration rating data first!
-http://localhost:8080/calculate/US?action=BUY&amount=10000
