Feature: Automation of Webtest cases using Feature files in gherkin format
Description : The purpose of this feature is to test End 2 End integration
# Singleton manager implementaion is pending

Scenario: Sample Scenario

	Given open the url
	When type "Venkatesh" into searchbar
	And click Submit
	#Then get screenshot
	Then click Videos
	Then close
