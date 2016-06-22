$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("search/exampleSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Demo example",
  "description": "",
  "id": "demo-example",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 3,
      "value": "#  Scenario: Running a Full Text Quick Search"
    },
    {
      "line": 4,
      "value": "#    Given I set search request \"iPhone4s\""
    },
    {
      "line": 5,
      "value": "#    When I perform search"
    },
    {
      "line": 6,
      "value": "#    Then the tern query \"iPhone 4S\" should be the first in the Search Result grid"
    }
  ],
  "line": 8,
  "name": "Running a Full Text Quick Search _2",
  "description": "",
  "id": "demo-example;running-a-full-text-quick-search--2",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I set search request \"\u003crequest\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I perform search",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the tern query \"\u003crequest\u003e\" should be the first in the Search Result grid",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "demo-example;running-a-full-text-quick-search--2;",
  "rows": [
    {
      "cells": [
        "request"
      ],
      "line": 13,
      "id": "demo-example;running-a-full-text-quick-search--2;;1"
    },
    {
      "cells": [
        "iPhone 4S"
      ],
      "line": 14,
      "id": "demo-example;running-a-full-text-quick-search--2;;2"
    },
    {
      "cells": [
        "Samsung Galaxy"
      ],
      "line": 15,
      "id": "demo-example;running-a-full-text-quick-search--2;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "Running a Full Text Quick Search _2",
  "description": "",
  "id": "demo-example;running-a-full-text-quick-search--2;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I set search request \"iPhone 4S\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I perform search",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the tern query \"iPhone 4S\" should be the first in the Search Result grid",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "iPhone 4S",
      "offset": 22
    }
  ],
  "location": "BaseStepDef.iSetSearchRequest(String)"
});
formatter.result({
  "duration": 8863123939,
  "status": "passed"
});
formatter.match({
  "location": "BaseStepDef.iPerformSearch()"
});
formatter.result({
  "duration": 2401144569,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "iPhone 4S",
      "offset": 16
    }
  ],
  "location": "BaseStepDef.theTernQueryShouldBeTheFirstInTheSearchResultGrid(String)"
});
formatter.result({
  "duration": 99855069,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Running a Full Text Quick Search _2",
  "description": "",
  "id": "demo-example;running-a-full-text-quick-search--2;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I set search request \"Samsung Galaxy\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I perform search",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the tern query \"Samsung Galaxy\" should be the first in the Search Result grid",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Samsung Galaxy",
      "offset": 22
    }
  ],
  "location": "BaseStepDef.iSetSearchRequest(String)"
});
formatter.result({
  "duration": 5959791289,
  "status": "passed"
});
formatter.match({
  "location": "BaseStepDef.iPerformSearch()"
});
formatter.result({
  "duration": 4095461798,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Samsung Galaxy",
      "offset": 16
    }
  ],
  "location": "BaseStepDef.theTernQueryShouldBeTheFirstInTheSearchResultGrid(String)"
});
formatter.result({
  "duration": 126292097,
  "status": "passed"
});
});