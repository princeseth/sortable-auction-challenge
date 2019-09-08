# Auction Application

This application will load the config file (config.json) which lists all valid sites and bidders and their configuration, and input file (input.json) which contains the list of auctions to run.

After running the auction, the highest valid bidder for each ad unit will be returned for each site provided in input.json.

## Requirement

Sample input.json, config.json are given to run this application. 
Sample output.json is provided as output format of auction result for particular site.
 
## Prerequisite for Application

* Java Jdk- 1.8
* Maven

## Step to run the application

* Clone repository 

  ```bash
   git clone https://github.com/princeseth/sortable-auction-challenge.git
  ```

* Install dependencies & build jar file:

  ```bash
  mvn clean install  
  ```
* Execute following command to run the application

 ```bash
	java -jar target/auction-0.0.1-SNAPSHOT.jar
 ```
 
Now, open the browser and at listen at port 5051 or click at below url:
	http://localhost:5051/
 