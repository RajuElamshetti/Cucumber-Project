Feature:
validate Add emp module
Scenario Outline:
check add employee with multiple data
Given user navigate url "http://orangehrm.qedgetech.com/" with browser
When user enter username as "Admin" and password as "Qedge123!@#"
And user click login button
And user click pim 
And user click add button
When user enter fname as "<Firstname>"
When user enter mname as "<Middlename>"
When user enter lname as "<Lastname>"
When user capture employeeid before adding
When user click save button
When user capture employeeid after adding
Then user validate employeeid
Then user close browser
Examples:
|Firstname|Middlename|Lastname|
|Raju1|Data1|Maven1|
|Raju2|Data2|Maven2|
|Raju3|Data3|Maven3|
|Raju4|Data4|Maven4|
|Raju5|Data5|Maven5|
|Raju6|Data6|Maven6|


