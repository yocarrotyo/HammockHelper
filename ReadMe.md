# Caroline Hughes Individual Project

This repository contains an application to help people track hammock-friendly campsites. 

### Problem Statement

In the Wisconsin State Park system, there are many campsites that have good trees for hammock camping, but the reservation
website doesn't include this information. Car campers may bring extra supplies because they aren't sure which sleeping
arrangements will be available, or they may skip hammock camping due to the uncertainty.

People looking to reserve a site will be able to:

* Search for hammock-ready sites across the state or within a specific park
* Check if a specific site is hammock-ready
That individual site checker will be especially useful on busy weekends where only one or two sites may be available at a park.
Hammock camping aficionados will be able to:
* Add information about campsites they’ve visited, like total hammock capacity or better pictures of a site

Park employees and other administrative users will be able to:
* Monitor the site, for example, to prevent hammockers from
using trees that are too small to safely support them

A public spreadsheet to track hammock sites was started in 2017 on hammockforums.net, but my app will be easier to read and allow different types of searching.

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Anyone: search campsites
  * Registered campers: submit provisional data, review others' data
* Database
  * MySQL
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * ZIP code API for nearby hammock Search
* CSS 
  * Used a W3Schools template since CSS is pretty foreign to me
* Data Validation
  * Some html form validation
  * Relying heavily on human review built into the "crowdsourced data" nature of the app...submitted data stored in provsional table
* Logging
  * Log4J2
* Hosting
  * AWS
* Independent Research Topic/s
  * Zip Code API
* IDE: IntelliJ IDEA


### Design - Coming soon

* [User Stories](DesignDocuments/userStories.md)
* [Screen Design](DesignDocuments/HammockHelper Screen Flow.pdf)
* [Application Flow](DesignDocuments/HammockHelper Full Flow.md)
* [Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](ProjectPlan.md)


