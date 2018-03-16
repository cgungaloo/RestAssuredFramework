$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("base.feature");
formatter.feature({
  "line": 1,
  "name": "Base data",
  "description": "As a SWAPI user\r\nI want to be able to get data about different api calls\r\nSo that I can make those calls for star wars knowledge",
  "id": "base-data",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9402816,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Make A Base Call",
  "description": "",
  "id": "base-data;make-a-base-call",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I make make a base call",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I should get the following url responses:",
  "rows": [
    {
      "cells": [
        "people",
        "https://swapi.co/api/people/"
      ],
      "line": 9
    },
    {
      "cells": [
        "planets",
        "https://swapi.co/api/planets/"
      ],
      "line": 10
    },
    {
      "cells": [
        "films",
        "https://swapi.co/api/films/"
      ],
      "line": 11
    },
    {
      "cells": [
        "species",
        "https://swapi.co/api/species/"
      ],
      "line": 12
    },
    {
      "cells": [
        "vehicles",
        "https://swapi.co/api/vehicles/"
      ],
      "line": 13
    },
    {
      "cells": [
        "starships",
        "https://swapi.co/api/starships/"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "the size of the response is \"6\"",
  "keyword": "And "
});
formatter.match({
  "location": "baseSteps.iMakeABaseCall()"
});
formatter.result({
  "duration": 3743302733,
  "status": "passed"
});
formatter.match({
  "location": "baseSteps.iShouldGetTheFollowingUrlResponses(DataTable)"
});
formatter.result({
  "duration": 662958199,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 29
    }
  ],
  "location": "baseSteps.theSizeOfTheResponseIs(String)"
});
formatter.result({
  "duration": 85626055,
  "status": "passed"
});
formatter.uri("people.feature");
formatter.feature({
  "line": 1,
  "name": "People Feature",
  "description": "As a user\r\nI want to be able to search for people with the SWAPI\r\nSo I can understand more about star wars characters",
  "id": "people-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 546969,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Search for Luke Skywalker",
  "description": "",
  "id": "people-feature;search-for-luke-skywalker",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I make a people call for \"1\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I should see \"Luke Skywalker\" in the name response",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 26
    }
  ],
  "location": "peopleSteps.iMakePeopleCallforCharacter(String)"
});
formatter.result({
  "duration": 1120839467,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Luke Skywalker",
      "offset": 14
    }
  ],
  "location": "peopleSteps.iShouldSeeInTheNameResponse(String)"
});
formatter.result({
  "duration": 21267205,
  "status": "passed"
});
formatter.before({
  "duration": 738985,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Get character heights and genders",
  "description": "",
  "id": "people-feature;get-character-heights-and-genders",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "the people url is correct",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "following ids for height and gender should be correct:",
  "rows": [
    {
      "cells": [
        "1",
        "172",
        "male"
      ],
      "line": 13
    },
    {
      "cells": [
        "2",
        "167",
        "n/a"
      ],
      "line": 14
    },
    {
      "cells": [
        "3",
        "96",
        "n/a"
      ],
      "line": 15
    },
    {
      "cells": [
        "4",
        "202",
        "male"
      ],
      "line": 16
    },
    {
      "cells": [
        "5",
        "150",
        "female"
      ],
      "line": 17
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "peopleSteps.iCheckPeopleUrl()"
});
formatter.result({
  "duration": 366072,
  "status": "passed"
});
formatter.match({
  "location": "peopleSteps.thePeopleCallsShouldReturnTheCorrectHeightsAndGenders(DataTable)"
});
formatter.result({
  "duration": 5169771146,
  "status": "passed"
});
formatter.before({
  "duration": 347682,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Go to Film from person",
  "description": "",
  "id": "people-feature;go-to-film-from-person",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "I make a people call for \"5\"",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "I should see \"Leia Organa\" in the name response",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I should get the following film responses:",
  "rows": [
    {
      "cells": [
        "https://swapi.co/api/films/2/"
      ],
      "line": 23
    },
    {
      "cells": [
        "https://swapi.co/api/films/6/"
      ],
      "line": 24
    },
    {
      "cells": [
        "https://swapi.co/api/films/3/"
      ],
      "line": 25
    },
    {
      "cells": [
        "https://swapi.co/api/films/1/"
      ],
      "line": 26
    },
    {
      "cells": [
        "https://swapi.co/api/films/7/"
      ],
      "line": 27
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I should be taken to be taken to \"The Empire Strikes Back\" with entry \"https:/swapi.co/api/films/2/\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 26
    }
  ],
  "location": "peopleSteps.iMakePeopleCallforCharacter(String)"
});
formatter.result({
  "duration": 1083765335,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Leia Organa",
      "offset": 14
    }
  ],
  "location": "peopleSteps.iShouldSeeInTheNameResponse(String)"
});
formatter.result({
  "duration": 15506714,
  "status": "passed"
});
formatter.match({
  "location": "peopleSteps.iShouldGetTheFollowingFilmResponses(String\u003e)"
});
formatter.result({
  "duration": 80758503,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "The Empire Strikes Back",
      "offset": 34
    },
    {
      "val": "https:/swapi.co/api/films/2/",
      "offset": 71
    }
  ],
  "location": "filmSteps.iShouldBeTakenToBeTakenToWithEntry(String,String)"
});
formatter.result({
  "duration": 1148122046,
  "status": "passed"
});
});