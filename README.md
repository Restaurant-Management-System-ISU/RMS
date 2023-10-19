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
![architecturelayer](https://github.com/Restaurant-Management-System-ISU/RMS/assets/133285349/1a1f6980-3ab0-414b-b899-0cf0fc5e81aa)


## Communication between Layers
The UI layer communicates with the application layer by invoking controller methods. For example, RMSController handles requests from customers.
The application layer interacts with the domain layer through service methods, such as AdminService and UserService. These services perform business logic and use JPA repositories to access data.
Repositories like UserRepo and MenuRepo, manage the persistence of data in the database.
