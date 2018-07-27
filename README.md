# DMARC-Reporting-Tool
DMARC refers to Domain-based Message Authentication, Reporting and Conformance. It is basically a tool build on widely deployed SPF and DKIM protocols that facilitates email authentication and reporting. It's key feature is to present a graphical overview of the results obtained.

# Overview

This tool performs the following tasks
1.	Fetches raw data (xml, gz, zip) files from the folder and unzips them and attains the required file to be parsed.
2.	Establishes the database connection.
3.	Parses the file according to the concerned tags and stores it in the database. 
4.	Generates a report containing details of the dropped mails according to DMARC policy.
5.	Provides graphical representation of the report based on the data extracted

# Requirements

1. Windows OS or Kali Linux
2. Java (7 or above)
3. JRE
4. Xampp Server (only for windows) 
5. Apache and Mysql services (only for Kali Linux)[See the installation procedure below]
		
# Metabase.jar Download

	1.Visit the website of metabase  https://www.metabase.com/start/jar.html
	2.Click on “Get started” and scroll down, metabase.jar can be downloaded from here. 
 
# Installation

	There are 2 jar files for the whole tool to work:
		1.Dmarc_windows.jar(for windows) or Dmarc_kali.jar(for Kali Linux) or Dmarc_Server.jar
		2.Metabase.jar(Reporting)

# Setting up environment for Dmarc_windows.jar
	# For Windows:-
		1.Start the xampp server. Start apache and mysql services in xampp server.
		2.Make 2 new folders on any desired location: one for zip files (raw data) and other for where unzipped (xml) files will 		   be saved.
		3.Run the Dmarc_windows.jar file as shown below.
		4.Enter the path (Browse) of these folders in the welcome screen. 
		5.To run the Dmarc_windows.jar file: Double click on the jar file or run it through Command Prompt using the command: 
			java –jar Dmarc_windows.jar
 # Setting up environment for Dmarc_kali.jar
 	 # For Kali Linux:-
		1. Start apache and mysql services in the terminal using the following commands:-
			service apache2 start
			service mysql start
		2.Make 2 new folders on any desired location: one for zip files (raw data) and other for where unzipped (xml) files will 		   be saved.
		3.Run the Dmarc_kali.jar file in the terminal as shown below.
		4.Enter the path (Browse) of these folders in the welcome screen.
		5.Enter the password for the mysql database. [You must be logged in as ‘root’ user].
		6.To run the Dmarc_kali.jar file: Run it on terminal using the command: 
			java –jar Dmarc_kali.jar
					
# Setting up environment for Dmarc_Server.jar

	This jar need to be used in case your database is present on another server(linux based).
	1. Start apache and mysql services in the terminal using the following commands:-
			service apache2 start
			service mysql start
	2. Create new mysql user and grant it all privileges:
		create user 'username'@'%' identified by 'password';
	['username' specifies the name of the user you want to create and 'password' specifies its corresponding password]
		grant all privileges on *.* to 'username'@'%';
	3. In case 'connection refused' error is encountered try the following in linux terminal:
			nano /etc/mysql/my.cnf
		Add the following to the file:
			[mysqld]
			bind-address=0.0.0.0
		Save the file and restart the mysql service
	4.Run the jar file in Windows base machine as instructed above.Replace 'Dmarc_windows' with 'Dmarc_Server' in the command 
	  'java -jar Dmarc_windows.jar'	

# To run the Metabase.jar file run the following command in command prompt(windows)/terminal(kali):

java –jar Metabase.jar
						
# Setting up environment for Metabase.jar

	1.	Run the jar file as shown above.
	2.	Open localhost: 3000 in the browser, welcome page will be shown:
	3.	Set up the admin account to continue.
 	4.	Configure and connect to the database in the metabase.Enter the following fields:
			The hostname of the server where your database lives
			The port the database server uses
			The database name
			The username you use for the database
			The password you use for the database
	
# Installation of Apache and Mysql

	For apache
		sudo apt-get install apache2
	For mysql
		sudo apt-get install mysql-server
