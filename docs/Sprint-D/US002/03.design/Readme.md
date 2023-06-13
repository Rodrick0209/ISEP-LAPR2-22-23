# UUS 002 - To publish an announcement

## 3. Design - User Story Realization 

### 3.1. Rationale


| Interaction ID | Question: Which class is responsible for... | Answer                        | Justification (with patterns)                                                                                 |
|:---------------|:--------------------------------------------|:------------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... requesting login of the US?            | AgentUI                       | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 		             | 	... validating the login of the Us?        | PublishAnnouncementController | Controller                                                                                                    |
| 			  		        | 	... instantiating a new Announcement?      | Organization                  | Creator (Rule 1): in the DM Organization has a Announcement.                                                  |
| 			  		        | ... knowing the user using the system?      | UserSession                   | IE: cf. A&A component documentation.                                                                          |
| 			  		        | 							                                     | Organization                  | IE: knows/has its own Agents                                                                                  |
| 			  		        | 							                                     | Agent                         | IE: knows its own data (e.g. email)                                                                           |
| Step 3 		      | 	...saving the seletcted agency?            | Announcement                  | IE: object created in step 1 is classified in one Property.                                                   |
| Step 4  		     | 	                                           |                               |                                                                                                               |
| Step 5	        | 	... saving the inputted data?              | AnnouncementRepository        | IE: objects created in step 1 has its own data.                                                               |
| 	              | 	... validating the commision               | PublishAnnouncmentUI          | IE: owns its data.                                                                                            | 

| Step 6  		     | 	... informing that the announcement is published? | PublishAnnouncementUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Organization
 * Announcement

Other software classes (i.e. Pure Fabrication) identified: 

 * PublishAnnouncementUI  
 * PublishAnnouncementController


## 3.2. Sequence Diagram (SD)

### Alternative 1 - Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us002-sequence-diagram-full.svg)



**Get Property Partial SD**

![Sequence Diagram - Partial - Get Property List](svg/us002-sequence-diagram-partial-get-agency-list.svg)

**Get Property**

![Sequence Diagram - Partial - Get Property](svg/us002-sequence-diagram-partial-get-agency.svg)

**Get Agent**

![Sequence Diagram - Partial - Get Agent](svg/us002-sequence-diagram-partial-get-agent.svg)

**Create Announcement**

![Sequence Diagram - Partial - Create Announcement](svg/us002-sequence-diagram-partial-create-announcement.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us002-class-diagram.svg)