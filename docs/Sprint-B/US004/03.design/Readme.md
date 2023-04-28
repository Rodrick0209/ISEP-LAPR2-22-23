# US 004 - Submit a request

## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID                                                           | Question: Which class is responsible for...                              | Answer               | Justification (with patterns)                                                                                 |
|:-------------------------------------------------------------------------|:-------------------------------------------------------------------------|:---------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		                                                               | 	... interacting with the actor?                                         | CreateTaskUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		                                                                  | 	... coordinating the US?                                                | CreateTaskController | Controller                                                                                                    |
| 			  		                                                                  | 	... instantiating a new Task?                                           | Organization         | Creator (Rule 1): in the DM Organization has a Task.                                                          ||
| 			  		                                                                  | 							                                                                  | Agency               | IE: knows/has its own Agents                                                                                  |
| 			  		                                                                  | 							                                                                  | Agent                | IE: knows its own data (e.g. email)                                                                           |
|                                                                          | ... creating a request?                                                  | Owner                | IE: knows the house information                                                                               |
| Step 2  		                                                               | 							                                                                  |                      |                                                                                                               |
| Step 3  		                                                               | 	...saving the inputted data?                                            | Task                 | IE: object created in step 1 has its own data.                                                                |
| Step 4  		                                                               | 	...knowing the task categories to show?                                 | System               | IE: Task Categories are defined by the Administrators.                                                        |
| Step 5  		                                                               | 	... saving the selected category?                                       | Task                 | IE: object created in step 1 is classified in one Category.                                                   |
| Step 6  		                                                               | 							                                                                  |                      |                                                                                                               |              
| Step 7  		                                                               | 	... validating all data (local validation)?                             | Task                 | IE: owns its data.                                                                                            | 
| 			  		                                                                  | 	... validating all data (global validation)?                            | Organization         | IE: knows all its tasks.                                                                                      | 
| 			  		                                                                  | 	... saving the created task?                                            | Organization         | IE: owns all its tasks.                                                                                       | 
| Step 8  		                                                               | 	... informing operation success?                                        | CreateTaskUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Organization
 * Task

Other software classes (i.e. Pure Fabrication) identified: 

 * CreateTaskUI  
 * CreateTaskController


## 3.2. Sequence Diagram (SD)

### Alternative 1 - Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us004-sequence-diagram-full.svg)

### Alternative 2 - Split Diagram

This diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses interaction ocurrence.

![Sequence Diagram - split](svg/us004-sequence-diagram-split.svg)
**Request Type List**

![Sequence Diagram - Partial - Request Type List](svg/us004-sequence-diagram-partial-requestTypeList.svg)

**Get Agency**

![Sequence Diagram - Partial - Get Agency](svg/us004-sequence-diagram-partial-get-agency.svg)

**Get Property Type**

![Sequence Diagram - Partial - Get Property Type](svg/us004-sequence-diagram-partial-get-property-type.svg)


## 3.3. Class Diagram (CD)

![Class Diagram](svg/us004-class-diagram.svg)