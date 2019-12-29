$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("motDePasse.feature");
formatter.feature({
  "line": 1,
  "name": "Ce mot de passe est-il acceptable",
  "description": "Un mot de passe est acceptable si il contient au moins 8 caracteres.",
  "id": "ce-mot-de-passe-est-il-acceptable",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Verifier si \"\u003cmotDePasseATester\u003e\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"\u003cmotDePasseATester\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"\u003cmotDePasseATester\u003e\" pour voir si c\u0027est un mot de passe acceptable",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"\u003cvaleurRetour\u003e\" pour motDePasseATester",
  "keyword": "Then "
});
formatter.examples({
  "line": 7,
  "name": "",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;",
  "rows": [
    {
      "cells": [
        "motDePasseATester",
        "valeurRetour"
      ],
      "line": 8,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;1"
    },
    {
      "cells": [
        "",
        "false"
      ],
      "line": 9,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;2"
    },
    {
      "cells": [
        "a",
        "false"
      ],
      "line": 10,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;3"
    },
    {
      "cells": [
        "abcdefg",
        "false"
      ],
      "line": 11,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;4"
    },
    {
      "cells": [
        "abcdefgh",
        "true"
      ],
      "line": 12,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;5"
    },
    {
      "cells": [
        "abcdefghij",
        "true"
      ],
      "line": 13,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;6"
    },
    {
      "cells": [
        "1234567",
        "false"
      ],
      "line": 14,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;7"
    },
    {
      "cells": [
        "12345678",
        "true"
      ],
      "line": 15,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;8"
    },
    {
      "cells": [
        "1;? 5!8,",
        "true"
      ],
      "line": 16,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;9"
    },
    {
      "cells": [
        "1234567891011121314",
        "true"
      ],
      "line": 17,
      "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;10"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 9,
  "name": "Verifier si \"\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"\" pour voir si c\u0027est un mot de passe acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour motDePasseATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 28
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeMotDePasse(String)"
});
formatter.result({
  "duration": 183397800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnMotDePasseAcceptable(String)"
});
formatter.result({
  "duration": 798100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourMotDePasseATester(String)"
});
formatter.result({
  "duration": 2047200,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Verifier si \"a\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"a\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"a\" pour voir si c\u0027est un mot de passe acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour motDePasseATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "a",
      "offset": 28
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeMotDePasse(String)"
});
formatter.result({
  "duration": 68100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "a",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnMotDePasseAcceptable(String)"
});
formatter.result({
  "duration": 56100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourMotDePasseATester(String)"
});
formatter.result({
  "duration": 60900,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Verifier si \"abcdefg\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"abcdefg\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"abcdefg\" pour voir si c\u0027est un mot de passe acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour motDePasseATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "abcdefg",
      "offset": 28
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeMotDePasse(String)"
});
formatter.result({
  "duration": 90500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abcdefg",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnMotDePasseAcceptable(String)"
});
formatter.result({
  "duration": 6491000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourMotDePasseATester(String)"
});
formatter.result({
  "duration": 50700,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verifier si \"abcdefgh\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"abcdefgh\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"abcdefgh\" pour voir si c\u0027est un mot de passe acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"true\" pour motDePasseATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "abcdefgh",
      "offset": 28
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeMotDePasse(String)"
});
formatter.result({
  "duration": 98400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abcdefgh",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnMotDePasseAcceptable(String)"
});
formatter.result({
  "duration": 56000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourMotDePasseATester(String)"
});
formatter.result({
  "duration": 62600,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verifier si \"abcdefghij\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;6",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"abcdefghij\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"abcdefghij\" pour voir si c\u0027est un mot de passe acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"true\" pour motDePasseATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "abcdefghij",
      "offset": 28
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeMotDePasse(String)"
});
formatter.result({
  "duration": 68500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abcdefghij",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnMotDePasseAcceptable(String)"
});
formatter.result({
  "duration": 45600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourMotDePasseATester(String)"
});
formatter.result({
  "duration": 56200,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Verifier si \"1234567\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;7",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"1234567\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"1234567\" pour voir si c\u0027est un mot de passe acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour motDePasseATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1234567",
      "offset": 28
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeMotDePasse(String)"
});
formatter.result({
  "duration": 64600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234567",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnMotDePasseAcceptable(String)"
});
formatter.result({
  "duration": 49900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourMotDePasseATester(String)"
});
formatter.result({
  "duration": 54600,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Verifier si \"12345678\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;8",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"12345678\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"12345678\" pour voir si c\u0027est un mot de passe acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"true\" pour motDePasseATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "12345678",
      "offset": 28
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeMotDePasse(String)"
});
formatter.result({
  "duration": 64800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "12345678",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnMotDePasseAcceptable(String)"
});
formatter.result({
  "duration": 51300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourMotDePasseATester(String)"
});
formatter.result({
  "duration": 55800,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Verifier si \"1;? 5!8,\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;9",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"1;? 5!8,\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"1;? 5!8,\" pour voir si c\u0027est un mot de passe acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"true\" pour motDePasseATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1;? 5!8,",
      "offset": 28
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeMotDePasse(String)"
});
formatter.result({
  "duration": 66400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1;? 5!8,",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnMotDePasseAcceptable(String)"
});
formatter.result({
  "duration": 76500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourMotDePasseATester(String)"
});
formatter.result({
  "duration": 78300,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Verifier si \"1234567891011121314\" est un mot de passe acceptable",
  "description": "",
  "id": "ce-mot-de-passe-est-il-acceptable;verifier-si-\"\u003cmotdepasseatester\u003e\"-est-un-mot-de-passe-acceptable;;10",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce mot de passe \"1234567891011121314\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"1234567891011121314\" pour voir si c\u0027est un mot de passe acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"true\" pour motDePasseATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1234567891011121314",
      "offset": 28
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeMotDePasse(String)"
});
formatter.result({
  "duration": 63100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234567891011121314",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnMotDePasseAcceptable(String)"
});
formatter.result({
  "duration": 47700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourMotDePasseATester(String)"
});
formatter.result({
  "duration": 49000,
  "status": "passed"
});
formatter.uri("nomDeCompte.feature");
formatter.feature({
  "line": 1,
  "name": "Ce nom de compte est-il acceptable",
  "description": "Un nom de compte est acceptable si il contient au moins 4 caracteres et aucun caractere espace.",
  "id": "ce-nom-de-compte-est-il-acceptable",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Verifier si \"\u003cnomDeCompteATester\u003e\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"\u003cnomDeCompteATester\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"\u003cnomDeCompteATester\u003e\" pour voir si c\u0027est un nom de compte acceptable",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"\u003cvaleurRetour\u003e\" pour nomDeCompteATester",
  "keyword": "Then "
});
formatter.examples({
  "line": 7,
  "name": "",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;",
  "rows": [
    {
      "cells": [
        "nomDeCompteATester",
        "valeurRetour"
      ],
      "line": 8,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;1"
    },
    {
      "cells": [
        "",
        "false"
      ],
      "line": 9,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;2"
    },
    {
      "cells": [
        "a",
        "false"
      ],
      "line": 10,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;3"
    },
    {
      "cells": [
        "abc",
        "false"
      ],
      "line": 11,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;4"
    },
    {
      "cells": [
        "abcd",
        "true"
      ],
      "line": 12,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;5"
    },
    {
      "cells": [
        "abcdefghij",
        "true"
      ],
      "line": 13,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;6"
    },
    {
      "cells": [
        "123",
        "false"
      ],
      "line": 14,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;7"
    },
    {
      "cells": [
        "1234",
        "true"
      ],
      "line": 15,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;8"
    },
    {
      "cells": [
        "123456",
        "true"
      ],
      "line": 16,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;9"
    },
    {
      "cells": [
        "",
        "false"
      ],
      "line": 17,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;10"
    },
    {
      "cells": [
        "",
        "false"
      ],
      "line": 18,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;11"
    },
    {
      "cells": [
        "ab cd",
        "false"
      ],
      "line": 19,
      "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;12"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 9,
  "name": "Verifier si \"\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 69700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 73700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 64000,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Verifier si \"a\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"a\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"a\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "a",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 99000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "a",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 66500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 49900,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Verifier si \"abc\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"abc\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"abc\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "abc",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 76400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abc",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 53700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 48600,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verifier si \"abcd\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"abcd\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"abcd\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"true\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "abcd",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 64100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abcd",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 50000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 53200,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Verifier si \"abcdefghij\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;6",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"abcdefghij\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"abcdefghij\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"true\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "abcdefghij",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 69800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abcdefghij",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 60200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 54000,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Verifier si \"123\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;7",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"123\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"123\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "123",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 128900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "123",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 51700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 51200,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Verifier si \"1234\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;8",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"1234\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"1234\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"true\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "1234",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 768900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 56800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 51400,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Verifier si \"123456\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;9",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"123456\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"123456\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"true\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "123456",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 71700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "123456",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 57000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 53900,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Verifier si \"\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;10",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 58900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 58500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 42500,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Verifier si \"\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;11",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 65700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 69700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 45400,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Verifier si \"ab cd\" est un nom de compte acceptable",
  "description": "",
  "id": "ce-nom-de-compte-est-il-acceptable;verifier-si-\"\u003cnomdecompteatester\u003e\"-est-un-nom-de-compte-acceptable;;12",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "j\u0027ai entre ce nom de compte \"ab cd\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "je teste \"ab cd\" pour voir si c\u0027est un nom de compte acceptable",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "le resultat devrait etre \"false\" pour nomDeCompteATester",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "ab cd",
      "offset": 29
    }
  ],
  "location": "utilisateurSteps.jAiEntreCeNomDeCompte(String)"
});
formatter.result({
  "duration": 66200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ab cd",
      "offset": 10
    }
  ],
  "location": "utilisateurSteps.jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String)"
});
formatter.result({
  "duration": 46200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 26
    }
  ],
  "location": "utilisateurSteps.leResultatDevraitEtrePourNomDeCompteATester(String)"
});
formatter.result({
  "duration": 51000,
  "status": "passed"
});
formatter.uri("suppressionReservation.feature");
formatter.feature({
  "line": 1,
  "name": "Puis-je enlever ou réserver des articles au stock",
  "description": "On peut enlever ou réserver des produits si le nombre d\u0027articles à enlever est inférieur ou égal au nombre d\u0027article présents moins le nombre d\u0027articles réservés.",
  "id": "puis-je-enlever-ou-réserver-des-articles-au-stock",
  "keyword": "Feature"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "j\u0027ai 10 articles dans mon stock d\u0027articles",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 5
    }
  ],
  "location": "produitSteps.jAiPommesDansMonStockDePommes(int)"
});
formatter.result({
  "duration": 5343100,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Je veux enlever 3 alors que 5 sont réservés",
  "description": "",
  "id": "puis-je-enlever-ou-réserver-des-articles-au-stock;je-veux-enlever-3-alors-que-5-sont-réservés",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "5 sont réservés",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "j\u0027essaie d\u0027en enlever 3",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "c\u0027est possible",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "il en reste 7",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "5 sont réservés",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 0
    }
  ],
  "location": "produitSteps.sontRéservés(int)"
});
formatter.result({
  "duration": 574100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 22
    }
  ],
  "location": "produitSteps.jEssaieDEnEnlever(int)"
});
formatter.result({
  "duration": 86800,
  "status": "passed"
});
formatter.match({
  "location": "produitSteps.cEstPossible()"
});
formatter.result({
  "duration": 42300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "7",
      "offset": 12
    }
  ],
  "location": "produitSteps.ilEnReste(int)"
});
formatter.result({
  "duration": 387200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 0
    }
  ],
  "location": "produitSteps.sontRéservés(int)"
});
formatter.result({
  "duration": 77800,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "j\u0027ai 10 articles dans mon stock d\u0027articles",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 5
    }
  ],
  "location": "produitSteps.jAiPommesDansMonStockDePommes(int)"
});
formatter.result({
  "duration": 182500,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Je veux enlever 3 alors que 8 sont réservés",
  "description": "",
  "id": "puis-je-enlever-ou-réserver-des-articles-au-stock;je-veux-enlever-3-alors-que-8-sont-réservés",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "8 sont réservés",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "j\u0027essaie d\u0027en enlever 3",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "c\u0027est impossible",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "il en reste 10",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "5 sont réservés",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 0
    }
  ],
  "location": "produitSteps.sontRéservés(int)"
});
formatter.result({
  "duration": 68000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 22
    }
  ],
  "location": "produitSteps.jEssaieDEnEnlever(int)"
});
formatter.result({
  "duration": 171600,
  "status": "passed"
});
formatter.match({
  "location": "produitSteps.cEstImpossible()"
});
formatter.result({
  "duration": 28100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 12
    }
  ],
  "location": "produitSteps.ilEnReste(int)"
});
formatter.result({
  "duration": 79700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 0
    }
  ],
  "location": "produitSteps.sontRéservés(int)"
});
formatter.result({
  "duration": 180700,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "j\u0027ai 10 articles dans mon stock d\u0027articles",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 5
    }
  ],
  "location": "produitSteps.jAiPommesDansMonStockDePommes(int)"
});
formatter.result({
  "duration": 92600,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Je veux en réserver 3 alors que 5 sont réservés",
  "description": "",
  "id": "puis-je-enlever-ou-réserver-des-articles-au-stock;je-veux-en-réserver-3-alors-que-5-sont-réservés",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "5 sont réservés",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "j\u0027essaie d\u0027en réserver 3",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "c\u0027est possible",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "il en reste 10",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "8 sont réservés",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 0
    }
  ],
  "location": "produitSteps.sontRéservés(int)"
});
formatter.result({
  "duration": 71300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 23
    }
  ],
  "location": "produitSteps.jEssaieDEnRéserver(int)"
});
formatter.result({
  "duration": 92300,
  "status": "passed"
});
formatter.match({
  "location": "produitSteps.cEstPossible()"
});
formatter.result({
  "duration": 18400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 12
    }
  ],
  "location": "produitSteps.ilEnReste(int)"
});
formatter.result({
  "duration": 105100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 0
    }
  ],
  "location": "produitSteps.sontRéservés(int)"
});
formatter.result({
  "duration": 166900,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "j\u0027ai 10 articles dans mon stock d\u0027articles",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 5
    }
  ],
  "location": "produitSteps.jAiPommesDansMonStockDePommes(int)"
});
formatter.result({
  "duration": 96600,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Je veux en réserver 3 alors que 8 sont réservés",
  "description": "",
  "id": "puis-je-enlever-ou-réserver-des-articles-au-stock;je-veux-en-réserver-3-alors-que-8-sont-réservés",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 29,
  "name": "8 sont réservés",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "j\u0027essaie d\u0027en réserver 3",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "c\u0027est impossible",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "il en reste 10",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "8 sont réservés",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 0
    }
  ],
  "location": "produitSteps.sontRéservés(int)"
});
formatter.result({
  "duration": 67600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 23
    }
  ],
  "location": "produitSteps.jEssaieDEnRéserver(int)"
});
formatter.result({
  "duration": 75700,
  "status": "passed"
});
formatter.match({
  "location": "produitSteps.cEstImpossible()"
});
formatter.result({
  "duration": 16700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 12
    }
  ],
  "location": "produitSteps.ilEnReste(int)"
});
formatter.result({
  "duration": 69400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 0
    }
  ],
  "location": "produitSteps.sontRéservés(int)"
});
formatter.result({
  "duration": 51100,
  "status": "passed"
});
});