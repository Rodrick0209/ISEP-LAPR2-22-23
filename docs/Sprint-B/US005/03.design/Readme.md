# US 005 - To register a Store

## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...   | Answer                  | Justification (with patterns)                                                                                 |
|:-------------  |:----------------------------------------------|:------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		 | 	... interacting with the actor?              | RegisterStoreUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		 | 	... coordinating the US?                     | RegisterStoreController | Controller                                                                                                    |
| 			  		 | 	... instantiating a Store?                   | Company                 | Creator (Rule 1): in the DM, Company has a Store.                                                             |
| Step 2  		 | 							                                       |                         |                                                                                                               |
| Step 3  		 | 	...saving the inputted data?                 | Store                   | IE: object created in step 1 has its own data.                                                                |
| Step 4  		 | 	...knowing the districts to show?            | System                  | IE: Task Categories are defined by the Administrators.                                                        |
| Step 5  		 | 	... saving the selected category?            | Task                    | IE: object created in step 1 is classified in one Category.                                                   |
| Step 6  		 | 							                                       |                         |                                                                                                               |              
| Step 7  		 | 	... validating all data (local validation)?  | Store                   | IE: owns its data.                                                                                            | 
| 			  		 | 	... validating all data (global validation)? | Company                 | IE: knows all stores.                                                                                         | 
| 			  		 | 	... saving the created task?                 | Company                 | IE: owns all stores.                                                                                          | 
| Step 8  		 | 	... informing operation success?             | RegisterStoreUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * Store

Other software classes (i.e. Pure Fabrication) identified: 

 * RegisterStoreUI  
 * RegisterStoreController


## 3.2. Sequence Diagram (SD)

### Alternative 1 - Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us005-sequence-diagram-full.svg)

### Alternative 2 - Split Diagram

This diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses interaction ocurrence.

![Sequence Diagram - split](svg/us005-sequence-diagram-split.svg)

**Get State List Partial SD**

![Sequence Diagram - Partial - Get State List](svg/us005-sequence-diagram-partial-get-state-list.svg)

**Get District List Partial SD**

![Sequence Diagram - Partial - Get District List](svg/us005-sequence-diagram-partial-get-district-list.svg)

**Get City List Partial SD**

![Sequence Diagram - Partial - Get City List](svg/us005-sequence-diagram-partial-get-city-list.svg)

**Register Store**

![Sequence Diagram - Partial - Register Store](svg/us005-sequence-diagram-partial-register-store.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us005-class-diagram.svg)