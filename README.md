# Restaurant Managaement System

In this project, we have applied a mixed architectural approach combining MVC and N-tier architecture for effective organization.

## Model View Controller:

Model:
The model classes are User and Menu, they represent key entities within our RMS.
UserRepo and MenuRepo interact with the database, handling data storage and retrieval.

View:
In the presentation/UI layer, we have web pages, graphical interfaces that allow interactions with the system. Some of the components that are included in view are Login,Signup and Menu.

Controller:
In our RMS, application layer includes controllers for different user roles and services for managing the business logic.
Controllers: RMSController, AdminController, CustomerController.
Services: AdminService, UserService.

## N-tier Architecture
https://viewer.diagrams.net/architecturediagramRMS
