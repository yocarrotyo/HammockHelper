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