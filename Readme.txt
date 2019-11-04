Hi,

We have created this project using selenium webdriver and testng as runner. We have followed the page object model without using page factory.

We could use page factory with page object model but as of now, it is only page object model without using page factory.

This is the first draft or created in one go, so it is considerable to refactor the code. We have created three different packages under src/:

po: This package contains all the page object classes for all different pages. We have created some classes for error objects and for common objects across pages. This would keep the trace of those elements in separte class to keep the page object more robust and reusable. Again we have not created separate page objects for few pages for ex. for Edit post and Edit settings, since elements are same as on New post and Settings pages. We could separate them with respect to pages.

test: This package contains all test classes, each class contains different scenarios with respect to pages. We have tried to cover basic flows on the pages but they don't contains each and every corner cases, when we actually work on a project, we do the corner cases and different flow's analysis and then categorize/create scripts for those.
For every test class, first scenario is covering the objects/components verification on the page.

utils: This package contains utilities, properties and constants classes. Ideally we should create separate packages/folder for properties or constants but for this exercise, We didn't want to increase the size of the project.

We have focused on Conduit's automation only, so haven't implemented Listeners, Logger, Other reports and Data driven approach in this project. We could use listeners for various purposes, Loggers to log information, Extent report, Data driven using Apache POI, testng's Data provider, JSON files and other ways.

Also we could use BDD for the automation but as of now it's a plane automation using selenium webdriver with page object model. Test method's name and comments should be elaborative to explain about the test method's behavior.

Thanks,
Ankur Dubey

