#ACCOUNT_SERVICE
 
 A Spring boot application with 2 apis
 
 1. Get account information by passing account number, API should produce a JSON with Telephone Number and Address
 	eg: localhost:8080/accountservices/123456 | method= Get | COntent-type= application/json
 
 2. End point to save the information , data again contains telephone number and Address
 	eg: localhost:8080/accountservices/ | metho=post |content-type=application/json
 	payload:
 	
 	{
    "telephoneNumber": 1234900000,
    "address": {
        "addressLine1": "Address_line_1_of_123490",
        "addressLine2": "Address_line_2_of_123490",
        "state": "FL",
        "city": "MIAMI",
        "zip": "33160"
    	}
	}
	
	
	Note: 
	Data is stored in memory, Data.sql file in the resource folder is responsible for creating and hydrating the table.
	Why not use the same object as VO and enity bean: That would partially give away the table structure in the DB, hence a bad practice.
	DB deisgn: Per MDM , Address is considered a sperate table, DB table is purely for demo purpose

	What is out of scope?
	1. Logging mechanism [AOP]
	2. Custom exception  [AOP]
	3. Security
	 