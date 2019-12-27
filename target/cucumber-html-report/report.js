$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("calculator.feature");
formatter.feature({
  "line": 1,
  "name": "Titre de la fonctionnalité",
  "description": "Description de la fonctionnalité",
  "id": "titre-de-la-fonctionnalité",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Add two numbers \u003cnum1\u003e \u0026 \u003cnum2\u003e",
  "description": "",
  "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I have a calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I add \u003cnum1\u003e and \u003cnum2\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the result should be \u003ctotal\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;",
  "rows": [
    {
      "cells": [
        "num1",
        "num2",
        "total"
      ],
      "line": 10,
      "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;;1"
    },
    {
      "cells": [
        "-2",
        "3",
        "1"
      ],
      "line": 11,
      "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;;2"
    },
    {
      "cells": [
        "10",
        "15",
        "25"
      ],
      "line": 12,
      "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;;3"
    },
    {
      "cells": [
        "99",
        "-99",
        "0"
      ],
      "line": 13,
      "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;;4"
    },
    {
      "cells": [
        "-1",
        "-10",
        "-11"
      ],
      "line": 14,
      "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Add two numbers -2 \u0026 3",
  "description": "",
  "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I have a calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I add -2 and 3",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the result should be 1",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "calculatorSteps.initializeCalculator()"
});
formatter.result({
  "duration": 144520900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "-2",
      "offset": 6
    },
    {
      "val": "3",
      "offset": 13
    }
  ],
  "location": "calculatorSteps.testAdd(int,int)"
});
formatter.result({
  "duration": 1559000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 21
    }
  ],
  "location": "calculatorSteps.validateResult(int)"
});
formatter.result({
  "duration": 2067100,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Add two numbers 10 \u0026 15",
  "description": "",
  "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I have a calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I add 10 and 15",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the result should be 25",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "calculatorSteps.initializeCalculator()"
});
formatter.result({
  "duration": 31800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 6
    },
    {
      "val": "15",
      "offset": 13
    }
  ],
  "location": "calculatorSteps.testAdd(int,int)"
});
formatter.result({
  "duration": 98900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "25",
      "offset": 21
    }
  ],
  "location": "calculatorSteps.validateResult(int)"
});
formatter.result({
  "duration": 60600,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Add two numbers 99 \u0026 -99",
  "description": "",
  "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I have a calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I add 99 and -99",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the result should be 0",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "calculatorSteps.initializeCalculator()"
});
formatter.result({
  "duration": 30000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "99",
      "offset": 6
    },
    {
      "val": "-99",
      "offset": 13
    }
  ],
  "location": "calculatorSteps.testAdd(int,int)"
});
formatter.result({
  "duration": 89000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 21
    }
  ],
  "location": "calculatorSteps.validateResult(int)"
});
formatter.result({
  "duration": 60600,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Add two numbers -1 \u0026 -10",
  "description": "",
  "id": "titre-de-la-fonctionnalité;add-two-numbers-\u003cnum1\u003e-\u0026-\u003cnum2\u003e;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I have a calculator",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I add -1 and -10",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the result should be -11",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "calculatorSteps.initializeCalculator()"
});
formatter.result({
  "duration": 48000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "-1",
      "offset": 6
    },
    {
      "val": "-10",
      "offset": 13
    }
  ],
  "location": "calculatorSteps.testAdd(int,int)"
});
formatter.result({
  "duration": 93600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "-11",
      "offset": 21
    }
  ],
  "location": "calculatorSteps.validateResult(int)"
});
formatter.result({
  "duration": 71800,
  "status": "passed"
});
});