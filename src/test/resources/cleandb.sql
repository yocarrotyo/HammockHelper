delete from role;
delete from user;
delete from campsite;
delete from park;
INSERT INTO user VALUES (1,'chihiro963','Caroline','Hughes','hughe297@gmail.com','5Mith5'),(2,'blond2016','Frank','Ocean','grammywinner@gmail.com','$0L0$'),(3,'aardvark96','Arthur','Read','iLoveBooks@gmail.com','DWISANNOYING'),(4,'rockhead929','John','McPhee','rockhead929@yahoo.com','ilovegeology'),(5,'iBeezinDaTrap','Nicki','Minaj','rapQueen4lyfe@gmail.com','p!nkpr!nt'),(6,'itsmyworld','Elmo','','elmosworld@sesame.com','123ABC');
INSERT INTO role VALUES (1,'Camper','rockhead929'),(2, 'Camper', 'blond2016'),(3, 'Camper', 'itsmyworld'),(4, 'Parkemployee', 'aardvark96'),(5, 'Parkemployee', 'chihiro963'),(6, 'Camper', 'iBeezinDaTrap');
INSERT INTO park VALUES (6,'Blue Mound','WI',41,27,'53517'),(1,'Amnicon Falls','WI',41,27,'54874');
INSERT INTO campsite VALUES (1,1,6,10,4,'2'),(2,0,6,10,4,'17'),(3,2,6,10,4,'9');