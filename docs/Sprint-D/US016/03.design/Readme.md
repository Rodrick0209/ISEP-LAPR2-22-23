# US 016 - To respond to the User that scheduled the visit when viewing a booking request.

## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...        | Answer                                        | Justification (with patterns)                               |
|:---------------|:---------------------------------------------------|:----------------------------------------------|:------------------------------------------------------------|
| Step 1  		     | 	... asks to see booking request list?             | Agent                                         | IE: want to response the request                            |
| Step 2         | ...shows the booking request list?                 | RespondBookingRequestUI                       | Pure Fabrication                                            |
| Step 3         | ...selects a booking request?                      | Agent                                         | IE: choose the request                                      |
| Step 4         | ...shows the data of the selected booking request? | RespondBookingRequestUI                       | Pure Fabrication                                            |
| Step 5         | ...write the response to the user?                 | Agent                                         | IE: write the response he wants                             |
| Step 6         | ...send the response wrote by the agent?           | RespondBookingRequestUI                       | Pure Fabrication                                            |
 
### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Agent


Other software classes (i.e. Pure Fabrication) identified: 

* RespondBookingRequestUI



## 3.2. Sequence Diagram (SD)

### Alternative 1 - Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us016-sequence-diagram-full.svg)


## 3.3. Class Diagram (CD)

![Class Diagram](svg/us016-class-diagram.svg)