# Supplementary Specification (FURPS+)

## Functionality

_Spacifies that:_

- are common across several US/UC: 
- are not related to US/UC, namely: Audit, Reporting and Security._

* The agents should be able to review advertisement requests, register information, publish offers visible to all clients, record visits to properties and indicate whether or not they think a deal will take place.
* The client should be able to sort the list of properties by type of property, number of bedrooms, by price and by location.
* The client should also be able to ask for a visit to the property and the agent need to confirm and schedule the visit.
* The System administrator needs to insert every relevant information about the employees and each store.


## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._


* Make recurring tests to evaluate that the user interface is not in error with the various options that the user can choose;
* The user interface needs to be simple to the user navigate;
* The interface must support at least the English language since it is the main language of the country.

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

* The system must run every day, at every hour.
* The software must be secure and protect personal and confidential information. 
* The system should have as few errors as possible, and they must be fixed quickly.  


## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


* The system should be quick in all the tasks (max: 3 secs);
* The app should consume the less CPU and memory possible.


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 


* The software should be easy and cheap to maintain.
* The software should have some updates to improve the app when necessary.
* The app should have an email and a contact from the company to clients have contact with it when they are unable to submit the characteristics of the property.


### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._
java, html,css. A non-interactive functionality to run and store and organize data for example, and an interactive fucntionality to interact with the agent for example. "Property" is going to be one of the main classes.
Each subject of the US is gonna be a class .


* The programming language will be Java.
* The application will be developed using the IntelliJ IDE and the graphical interface is to be developed in JavaFX 11.


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

* The graphical interface is to be developed in JavaFX 11.
* The app must support English language.
* The application will be developed in Java language using the IntelliJ IDE or NetBeans.


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

* The application graphical interface is to be developed in JavaFX 11.

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

* The system must use a database to store and manage data, with appropriate backups and redundancy measures in place.