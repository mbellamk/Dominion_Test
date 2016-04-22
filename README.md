# Dominion_Test
This is a sample Spring, Hibernate, Spring Boot Application developed as a part of technical round
Used Postgres to store the data.

#Steps to run the application:
1. import the dominion.backup file into the postgres
2. change the username and password in applicaiton.properties
3. Run App.java file

#API details:

1.  /getNotes: 

  input: tagName  (should be passed as a request parameter)
  
  eg: localhost:8080/getNotes?tagName=norfolk
  
2. /saveTag : used to save the tag details
  
  input : name and description in json format
  eg: {"name":"South Portland","description":"Place in Maine"}
  output: Boolean (Success or Failure)
  
3. /saveNotes: used to save notes and the related tags to the notes. For storing the tag details, tagIds are expected to be passed to
  this api
  
  input: note and tagId's in json format.
  eg: {"note":"Room for Rent at virginia","tagIds":[1,2]}
  
  ouotput: List of notes in json format.
  
  
   
