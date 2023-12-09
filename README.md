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

--Getting Started--
Model 
| Entity | Path |
| --- | --- |
| Bill | src/main/java/com/rms/app/model/Bill.java |
| Cart | src/main/java/com/rms/app/model/Cart.java |
| Menu | src/main/java/com/rms/app/model/Menu.java |
| Notification | src/main/java/com/rms/app/model/Notification.java |
| Order | src/main/java/com/rms/app/model/Order.java |
| Review | ssrc/main/java/com/rms/app/model/Review.java |
| Staff | src/main/java/com/rms/app/model/Staff.java |
| Stock | src/main/java/com/rms/app/model/Stock.java |
| Tables | src/main/java/com/rms/app/model/Tables.java |
| Ticket | src/main/java/com/rms/app/model/Ticket.java |
| User | src/main/java/com/rms/app/model/User.java|

Controller:
| Entity | Path |
| --- | --- |
| AdminController | src/main/java/com/rms/app/controllers/AdminController.java | 
| CustomerController | src/main/java/com/rms/app/controllers/CustomerController.java | 
| RMSController | ssrc/main/java/com/rms/app/controllers/RMSController.java | 
| StaffController | src/main/java/com/rms/app/controllers/StaffController.java |


service:
| Entity | Path |
| --- | --- |
| AdminService | src/main/java/com/rms/app/service/AdminService.java |
| AdminServiceImpl | src/main/java/com/rms/app/service/AdminServiceImpl.java |
| StaffService | src/main/java/com/rms/app/service/StaffService.java |
| StaffServiceImpl | src/main/java/com/rms/app/service/StaffServiceImpl.java |
| UserService | src/main/java/com/rms/app/service/UserService.java |
| UserServiceImpl | src/main/java/com/rms/app/service/UserServiceImpl.java|



