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
Park employees and other administrative users will be able to monitor the site, for example, to prevent hammockers from
using trees that are too small to safely support them

A public spreadsheet to track hammock sites was started in 2017 on hammockforums.net, but my app will be easier to read and allow different types of searching.

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: create trail, create trail report, edit data they have entered previously
  * All: anyone can view trail information (no login)
* Database
  * MySQL
  * Store users and roles
  * Store all data for the trails and reports
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * NOAA for weather conditions at a trail location, including snow depth
* CSS 
  * Bootstrap or Materialize
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Materialize
  * Google Maps API
  * Hibernate Validation
  * Hibernat Search
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA


### Design - Coming soon

* [User Stories](DesignDocuments/userStories.md)
* [Screen Design](DesignDocuments/HammockHelper Screen Flow.pdf)
* [Application Flow](DesignDocuments/HammockHelper Full Flow.md)
* [Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](ProjectPlan.md)


