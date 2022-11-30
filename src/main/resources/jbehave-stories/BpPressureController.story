Narrative:
To communicate effectively with the business stakeholders
As a development team
I want to use Behaviour-Driven Development
					 
Scenario: Low Pressure

Given A systolic Integer of 80 and diastolic Integer of 50
When calcCategory method of BpPressureController.java is called
Then It should return Low Blood Pressure

Scenario: Ideal Pressure

Given A systolic Integer of 100 and diastolic Integer of 70
When calcCategory method of BpPressureController.java is called
Then It should return Ideal Blood Pressure

Scenario: High Pressure

Given A systolic Integer of 180 and diastolic Integer of 90
When calcCategory method of BpPressureController.java is called
Then It should return High Blood Pressure
