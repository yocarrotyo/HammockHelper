# Weekly Reflection


### Week 2 (Started Sept 9)

Wrote an elevator pitch
Created a repository on GitHub and completed some basic project setup work - created in IntelliJ, made files for plan
Sketched screen design with pen/paper

I was a bit distracted this weekend by lots and lots of housework and did the bare minimum to stay "on track."

### Week 3 (Started Sept 16)

* Filled out my project plan
* Brainstormed APIs to use, but didn't do any research
* Created screen design and identified which parts are the MVP (aka, basically, the entire thing)

Unfortunately another week of traveling. This week was my big test of whether I can get all my work done without using weekends. Test failed, I need to work on weekends!! I had scheduled a weekend on lake Michigan a few months ago with an old friend who is mega chatty and wanted to unplug from research. Also did lots of driving.
I decided to make my screen design in Google Slides because the lack of "technology" makes it easier for me to do exactly what I want and I am really comfortable with the tools. 
I wanted to focus as much as possible on how someone moves around the site.
I am happy with my site structure--I think I did a good job keeping it simple--but nervous about APIs. Possibilities:
*https://www.dropzonejs.com/
*Not really an API, but just a technology: https://developer.mozilla.org/en-US/docs/Web/API/HTML_Drag_and_Drop_API/File_drag_and_drop

## Week 4 (started Sept 23)

Pretty squarely ignored my project this week. Decided not to attempt to build ex. 4 as a project.

## Week 5 (started Sept 30)

I built out my User and Role table, created the DAO and test for each of those.
Got stuck on the unit testing for a couple of reasons:
* cleandb had a type-o causing values in my child table to attempt to add a row where the corresponding user_name value in the user table did not exist
* cleandb was deleting the role table AFTER adding data back into the user table, causing it to fail to execute, so it appeared that BeforeEach wasn't running properly.
Also did some research on what data types to use to track the park locations. I will have columns for latitude and longitude in addition to ZIP code.

## Week 6 (started Oct 7)
Did "code review" in class this week. While sharing I realized that I hadn't thought about the need to track individual "submissions" of campsite data separately from what is stored as "final" in the campsite. That way if people submit duplicate data, I can either:
* Keep a second record describing the same campsite and mark the "affirmation count" (aka the number of poeple who disagree with you) to -1 on both
* Keep just one record with an affirmation count of 1.
I want users to be able to see when a site has a negative affirmation count, not just pretend it isn't in the database. Othwerise, if it so happens that they DO know something about that site, the site would behave weirdly when it gets the info.

Also during code review, Julie pointed out the extremely obvious use case of tracking the locations of actual, individual HAMMOCK TREE PAIRS in distributed/backcountry camping scenarios, which I had never thought of. Could a lookup like this take the fun out of finding a campsite while backpacking? Lead to overuse of specific spots? Maybe? But it could also help someone who needs confidence in how far away a campsite might be. I should try this on the Ice Age Trail, but I have no data.

Other stuff that happened this week:
* Fixed last week's issues with cleandb. Fixed .gitignore and deleted hibernate config, database properties files from repository.
* Got connected to AWS but realized I need to finish building out my database. Struggling with setting a foreign key between "reviews" and the user who submits them. It is saying my columns are incommpatible. For now I will leave them as-is without creating a foreign key. The purpose is to suspend users' accounts when they submit too much misinformation. I bet I'm already better at this than Mark Z.
* Started working on introductory MongoDB courses for my prof dev project. Not sure how deep they'll go, but they're free. I want to do a little demo.

I need to figure out a generic Dao, and also figure out why the name of my project is appearing in AWS Tomcat as the user display exercise.
I am using a really useless user display jsp for my first deployment of my project. Getting concerned about the jsp aspects of it.

## Week 7 (Started Oct 14)
* Started building Generic Dao.
* Added form-based authentication as part of the exercise. I want to have an admin role but don't think I can actually build out functionality that the admin would perform for my MVP. Contributing data will be available to Campers for now, that's the default user role that is assigned to everyone

## Week 8 (Started Oct 21)
* Researched and implemented consumption of the ZIP code api, at least for trivial case. My project is a great use case for this API because the rural locations of the state parks are far ennough apart that the ZIP code can approximate their location. For urban sites the ZIP code is not precise enough, would have to use some kind of latitude and longitude measurement.

## Week 9 (Started Oct 28)
* Struggled with re-deploying to AWS after implementing user authentication. I think this is because my application context in IntelliJ was HammockHelper_war but I thought it was supposed to be HammockHelper
* Updated the gitignore file to exclude my database credentials. Removed sensitive files from the github cache.

## Week 10 (Started Nov 4)
* Avoided project. Afraid of AWS.

## Week 11 (Started Nov 11)
* Did pretty much nothing. Team project going on. Started working at Target this week, plus it was Etan's birthday, so majorly distracted.
* In hindsight, doing nothing this week was my tragic accident.

## Week 12 (Started Nov 18)
* Fixed my generic DAO based on what we learned in the group project. Yay! Tiny amount of momentum restored!

## Week 13 (Started Nov 25)
* Could have done more because Thanksgiving was cancelled BUT I spent like 15 hours trying to bake a single pumpkin pie because of oven issues, also I felt guilty because I had gone so late to get daffodil bulbs that the only thing left were pre-chilled paperwhites and they were literally starting to sprout in the bag. I expect there is a 30% chance I will have flowers come Spring.
* Properly figured out the search of the campsite table, my first JSP that actually returns results someone would want to see instead of random user data. Yay :)
* Got a CSS template and modified it slightly to look decently accetpable. This can be a time-suck and distraction!!! There are millions of little things to change but none of them are really important right now.

## Week 14 (Started Dec 2)
* Worked out handling the results sent back by the ZIP code API. I am proud to say I did this in a rather TDD-manner. I made sure ZIp codes were coming back from the API first, then parks, then resolved those to sites, then to hammock-friendly sites. They aren't displaying correctly. The results are stored in a hashmap and the inner object isn't accessible with the way my loop is set up.
* Continued working on CSS, but trying not to get distracted by the little inconsistencies.
* Bought a domain name for the project for the future. #RetailTherapy
* Reviewed unit tests for thoroughness, realized I maybe need to build more using DAOs of other entities (most were copied from back when user and role were my only tables).
* Stole Paula's code to build sign-up page to be able to register a new user.
* Tried to implement a captcha as Paula has. Got a key on Google, otherwise failed.
* Prepped presentation

## Week 15 (Started Dec 9)
* Fixed problems with displaying the contents of my HashMap of nearby campsites. Needed a nested for-loop. 
Decided the data review function wouldn't be worth implementing without doing it propertly using a Review table. Built this out. Simplified the Review and Campsite tables by getting rid of the site rating concept. Had to rebuild database tables, which feels so risky to do.
* Wrote a data validation utility to clean up data in Review and copy data with a high confidence score from Review to Campsite. This feels like the "special sauce" of my whole web app. Learned (sort of) to implement the Comparator interface in order to remove duplicate Reviews with inferior confidence scores! Currently, there's no limit on the number of times people can add a "review" for a certain campsite. I do not deal with validating information as it's submitted to the Review table, relying on the human review process for that, which is sort of silly. In the future, the submission process should include only creating a new row in Review when there is another review with the same park and campsite nunmber, but a DIFFERENT hammock capacity. Reviews that are the same should just result in increasing the confidence score of the existing one automatically, meaning that entry would be copied to the Campsite table right away. I probably didn't test enough corner cases of the validation utility to validate that it *really* works exactly the way I think it does.
* Refactored some servlets to avoid monstrous doGet and doPost methods. Some still are too large/rambling, but I thouoght refactoring this late was risky and could introduce errors. This is especially true for the servlets that have more code built in for handling null result type of situations...scared to break them.
* Wanted to implement better data checking for the campsite submissions, but deprioritized in favor of getting it all working on AWS. YOu can enter total garbage as a campsite number, like 34t5DF*(&#$$Tghs. Well, if Hammocker Helper were a company, I'd be paying a lot for human data review.
* Attempted to implement loading the API target for the ZIP code API from a properties file. I kept getting the inStream parameter is null error. Internet suggested my Resources folder wasn't really known to Intellij as a Resources folder, but that wasn't right. Theory: the properties file isn't in the classpath. But I don't know how to get it there. I gave up.
* Wrote more unit tests, but could not get coverage to go up.
* Tested everything 10 billion times and kept finding little errors. I ultimately took out the "summary table" that displays to users after they have either submitted or reviewed data. I was sharing this page between to servlets/functions and it was too confusing. Especially since the Review table can have many duplicate entries.
* To get ready to deploy to amazon, rebuilt database tables in Amazon. Struggles with foreign keys as usual. But was able to resolve after being very careful with mysqldump.
* Figured out that my struggles with authentication were due to not re-assigning read access to Tomcat
