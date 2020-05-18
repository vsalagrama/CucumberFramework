$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Dryrun/Sample.feature");
formatter.feature({
  "name": "Automation of Webtest cases using Feature files in gherkin format",
  "description": "Description : The purpose of this feature is to test End 2 End integration",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Sample Scenario",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "open the url",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Steps.open_the_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "type \"Venkatesh\" into searchbar",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Steps.type_into(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click Submit",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.click_Submit()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click Videos",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Steps.click_Videos()"
});
formatter.result({
  "status": "passed"
});
});