$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/expedia/ListYourProperty.feature");
formatter.feature({
  "line": 2,
  "name": "List Your Property",
  "description": "",
  "id": "list-your-property",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@expedia"
    }
  ]
});
formatter.before({
  "duration": 3140254025,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "New window for property listing",
  "description": "",
  "id": "list-your-property;new-window-for-property-listing",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "the user is on the main expedia page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the user clicks on \u0027list your property button\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the new tab should open",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "how much could you earn text is be displayed",
  "keyword": "And "
});
formatter.match({
  "location": "ExpediaNewWindowVerificationSteps.the_user_is_on_the_main_expedia_page()"
});
formatter.result({
  "duration": 9082649207,
  "status": "passed"
});
formatter.match({
  "location": "ExpediaNewWindowVerificationSteps.the_user_clicks_on_list_your_property_button()"
});
formatter.result({
  "duration": 188722311,
  "status": "passed"
});
formatter.match({
  "location": "ExpediaNewWindowVerificationSteps.the_new_tab_should_open()"
});
formatter.result({
  "duration": 4132963891,
  "status": "passed"
});
formatter.match({
  "location": "ExpediaNewWindowVerificationSteps.how_much_could_you_earn_text_is_be_displayed()"
});
formatter.result({
  "duration": 54592911,
  "error_message": "java.lang.AssertionError: This is me failing the test\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat step_defs.ExpediaNewWindowVerificationSteps.how_much_could_you_earn_text_is_be_displayed(ExpediaNewWindowVerificationSteps.java:57)\n\tat ✽.And how much could you earn text is be displayed(features/expedia/ListYourProperty.feature:8)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1476449835,
  "status": "passed"
});
});