Feature: People Feature
  As a user
  I want to be able to search for people with the SWAPI
  So I can understand more about star wars characters

  Scenario: Search for Luke Skywalker
    Given I make a people call for "1"
    Then I should see "Luke Skywalker" in the name response

  Scenario: Get character heights and genders
    Given the people url is correct
    Then following ids for height and gender should be correct:
      |1 |172|male   |
      |2 |167|n/a    |
      |3 |96 |n/a    |
      |4 |202|male   |
      |5 |150 |female|

  Scenario: Go to Film from person
    Given I make a people call for "5"
    And I should see "Leia Organa" in the name response
    Then I should get the following film responses:
      |https://swapi.co/api/films/2/|
      |https://swapi.co/api/films/6/|
      |https://swapi.co/api/films/3/|
      |https://swapi.co/api/films/1/|
      |https://swapi.co/api/films/7/|
    And I should be taken to be taken to "The Empire Strikes Back" with entry "https:/swapi.co/api/films/2/"
    