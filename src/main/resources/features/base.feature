Feature: Base data
  As a SWAPI user
  I want to be able to get data about different api calls
  So that I can make those calls for star wars knowledge

  Scenario: Make A Base Call
    Given I make make a base call
    Then I should get the following url responses:
    |people   |https://swapi.co/api/people/   |
    |planets  |https://swapi.co/api/planets/  |
    |films    |https://swapi.co/api/films/    |
    |species  |https://swapi.co/api/species/  |
    |vehicles |https://swapi.co/api/vehicles/ |
    |starships|https://swapi.co/api/starships/|
    And the size of the response is "6"
