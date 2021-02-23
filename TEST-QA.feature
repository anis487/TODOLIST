@tag
Feature: Website TodoList

  @tag1
  Scenario: Connect to Todo List website
   Given the website Todo List is opened
    When All fields are not filled
    Then The submit button  is disabled
    And The Tasks and Logout links are not displayed
    
    When I enter the incorrect mail
    And I enter incorrect the password
    And I click Connexion button
    Then The message Alerte is displayed
    And The Tasks and Logout links are not displayed
    
    When I enter the correct mail
    And I enter correct the password
    And I click Connexion button
    Then The page of Tasks is opened
    And The Tasks and Logout links are displayed

  @tag2
  
  Scenario: filling list of tasks
  
    Given The page of Tasks is opened
    When All fields of Task page are not filled
    Then The task button  is disabled
    
    When I enter the task name
    And I enter the task description
    And I click add task button "Ajouter la tâche"
    Then The task is created in list
    And Data is saved in StorageLocal
    
    When I edit the task statut to completed
    Then The statut completed is displayed
    And The statut is modified in StorageLocal
    
    When I delete the task
    Then The task is deleted in list
    And The task is deleted in StorageLocal
    
