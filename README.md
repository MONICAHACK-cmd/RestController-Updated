# RestController-Updated
Updated with file upload and save functionality


Mail Input :
{"to":["mandalmonica27@gmail.com","umapuja@gmail.com","priti.sharma127@gmail.com"],"cc":["hackathon06032020@gmail.com"],"from":"no_reply@gmail.com","subject":"Test Mail Gmail","content":"I am sending this Test Mail"}


Create table query 

CREATE TABLE `CTODETAILS` (
  `UUNAME` varchar(7) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `STATUS_DSC` varchar(255) DEFAULT NULL,
  `FILECONTENT` blob,
  `CREATED_DATE` timestamp NULL DEFAULT NULL,
  `UPDATED_DATE` timestamp NULL DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


Db Connection possible  with MysQL Workbench App:

- hostname :  ppmagile.cja1wagvqrjw.us-east-2.rds.amazonaws.com
- port : 3306
- username : nighthunter
- password : Awsrdspassword
