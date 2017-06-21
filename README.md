# ms3andme
Technical Challenge Project for Mountain State Software Solutions

There are two Mule (AnyPoint) projects. 
  1) Website - consisting of a single webpage for running the api. 
  2) WebAPI - a Mulesoft API project 

Tools
--------------------------------
Java (1.8.0_131)
AnyPoint Studio (6.2.5) Note: This version includes APIkit.
Tomcat (8.5.15)

Installation
--------------------------------
1) Import "ms3andme-api" into AnyPoint Studio
2) Import "ms3andme-site" into AnyPoint Studio.

3) Open "ms3andme-site" in AnyPoint Studio.
4) Edit the build.xml file and update the destination directory as necessary. I was using tomcat on my system b/c it's easy but any web server will do. The script will create the target if necessary.
5) Right click on the build.xml file and select Run As..->Ant Build. This will copy the webpage to your web server.

Running WebAPI
--------------------------------
1) Open "ms3andme-api" in AnyPoint Studio
2) The current logging level is set to DEBUG. This allows some logging to track when the API is called and a little about what was returned. To change this open "log4j2.xml" in the "src/main/resources" folder of the project and change the following line to INFO instead of DEBUG:
        <AsyncLogger name="com.ms3.ms3andme" level="DEBUG" />
3) The WebAPI will run on localhost:8091 and allows access from localhost:8080 (my Tomcat instance). If you will be running the webpage from another server you will need to update the following line in the "mule-app.properties" in the "src/main/app" folder of the project:
        cors-allowed-url=http://localhost:8080
4) Right click the main project folder and select Run As..->Mule Application
Note: A log file will be created in <mule src root, not app src root>/.mule/logs/ms3andme-api.log, but you can also monitor the console log for activity.
   
Running WebUI
--------------------------------
1) Open a browser, navigate to the destination URL. Since the page is index.html it should run without explicitly calling the page.
2) Enter numbers (or don't) for lower and upper and click "Convert Range" for results.
3) When a result set is available, the "Reverse Results" button is enabled, click it to toggle the order between ASC and DESC.

Accessing WebAPI from Browser
--------------------------------
1) Open a browser and navigate to the WebAPI url: htt://localhost:8091/api/ms3andm3?lower=3&upper=21
