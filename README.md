# RESTAURANT MANAGEMENT SYSTEM

The Restaurant Management System is an advanced software solution designed to enhance the efficiency and effectiveness of restaurant operations. Tailored to meet the needs of both customers and restaurant staff, it offers features like order processing, inventory management, and staff coordination. This system is integral for restaurant owners and staff, streamlining their daily tasks and improving the overall dining experience for customers.

This application stands out by providing a user-friendly interface for customers to browse menus, place orders, and make reservations, while offering restaurant staff tools for efficient order and inventory management. It caters to various user groups, including individual diners, restaurant admin, and staff, ensuring a seamless and enjoyable dining and management experience. The system is accessible via web platforms and optimized for use on browsers like Google Chrome, requiring only a stable internet connection for optimal performance.


## MODEL VIEW CONTROLLER

## SOURCE CODE LINK
| Source Code Link |
| --- |
| [src/main/java/com/rms/app](https://github.com/Restaurant-Management-System-ISU/RMS/tree/main/src/main/java/com/rms/app) |

## Model:
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

## Controller:
| Entity | Path |
| --- | --- |
| AdminController | src/main/java/com/rms/app/controllers/AdminController.java | 
| CustomerController | src/main/java/com/rms/app/controllers/CustomerController.java | 
| RMSController | ssrc/main/java/com/rms/app/controllers/RMSController.java | 
| StaffController | src/main/java/com/rms/app/controllers/StaffController.java |


## Service:
| Entity | Path |
| --- | --- |
| AdminService | src/main/java/com/rms/app/service/AdminService.java |
| AdminServiceImpl | src/main/java/com/rms/app/service/AdminServiceImpl.java |
| StaffService | src/main/java/com/rms/app/service/StaffService.java |
| StaffServiceImpl | src/main/java/com/rms/app/service/StaffServiceImpl.java |
| UserService | src/main/java/com/rms/app/service/UserService.java |
| UserServiceImpl | src/main/java/com/rms/app/service/UserServiceImpl.java|


Model:
The model classes are User and Menu, they represent key entities within our RMS.
UserRepo and MenuRepo interact with the database, handling data storage and retrieval.

View:
In the presentation/UI layer, we have web pages, graphical interfaces that allow interactions with the system. Some of the components that are included in view are Login,Signup and Menu.

Controller:
In our RMS, application layer includes controllers for different user roles and services for managing the business logic.
Controllers: RMSController, AdminController, CustomerController.
Services: AdminService, UserService.

## N-TIER ARCHITECTURE
![architecture](https://github.com/Restaurant-Management-System-ISU/RMS/assets/133285349/e51c39ab-ae1f-4944-95c4-c99c7936f79d)


## COMMUNICATION BETWEEN LAYERS
The UI layer communicates with the application layer by invoking controller methods. For example, RMSController handles requests from customers.
The application layer interacts with the domain layer through service methods, such as AdminService and UserService. These services perform business logic and use JPA repositories to access data.
Repositories like UserRepo and MenuRepo, manage the persistence of data in the database.



## TEST LINK
| Test Link |
| --- |
| [src/test/java/com/rms/app](https://github.com/Restaurant-Management-System-ISU/RMS/tree/main/src/test/java/com/rms/app) |
 
## TEST CASES
## Controller
| Entity | Path |
| --- | --- |
| AdminControllerTest | src/test/java/com/rms/app/controller/AdminControllerTest.java |
| CustomerControllerTest | src/test/java/com/rms/app/controller/CustomerControllerTest.java |
| StaffControllerTest | src/test/java/com/rms/app/controller/StaffControllerTest.java |

## Service
| Entity | Path |
| --- | --- |
| AdminServiceTest | src/test/java/com/rms/app/service/AdminServiceTest.java |
| StaffServiceTest | src/test/java/com/rms/app/service/StaffServiceTest.java |
| UserServiceTest | src/test/java/com/rms/app/service/UserServiceTest.java |

## INSTALLATION
| Hardware/Software | Source |
| --- | --- |
| Java (JDK 11) | https://www.oracle.com/java/technologies/downloads/#java11-windows |
| Eclipse | https://www.eclipse.org/ |
| MySQL | https://www.mysql.com/ |

## APPLIED TECHNOLOGIES
| Category | Technologies and Tools |
| --- | --- |
| IDE | Eclipse |
| Programming Languages | Java (JDK 11) |
| Frameworks and Libraries | Spring Boot |
| Application Server | Apache Tomcat |
| Front End |	HTML, CSS |
| Backend	| Java, Spring Boot, Spring Web Security, Hibernate, Spring JPA, Tomcat, MySQL, Swagger (API Documentation), Node.js, Spring Boot Framework |
| Database Server/DMBS | MySQL WorkBench |



## AUTHORS
Sai Vineela Madamanchi (smadama@ilstu.edu)
Srilekha Naidu (snaidu1@ilstu.edu)
Sairahul Baddapuram (sbaddap@ilstu.edu)
Shreya Veeramaneni (sveera1@ilstu.edu)
Shanmukh Chittabattini (schitt1@ilstu.edu)












