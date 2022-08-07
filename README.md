# Information Sharing Website Api

Integrated Development Environment: Eclipse  

## Used Technologies
* Java Development Kit (JDK)
* Spring Boot
* Spring Data JPA & Hibernate
* MySQL JDBC driver
* MySQL database server & Workbench
* Lombok

## About The Project
This project aims that people to publish articles about any subject to inform other people. And this project is just backend, provides RESTful interface. The project is prepared with layered architecture.

## Layers
* **Entities**: 
<br>This layer is created for database tables. There are four tables: Authors, Readers, Contents, Images. Authors table keeps informations about the authors. Readers table keeps infromations about readers. Reader can not publish articles. Contents table keeps title, content etc. about contents. Images table holds name of the image, id of the content which image belongs etc.

* **Repositories**:
<br> This layer provide connection between the project and the database. 

* **Services**:
<br> This layer is created for some functions such as add, get all etc and some controls. This controls are as follows in the database, an author can be added as a reader but a reader can not be added as an author. A person try to register as an author but if there is an author with the same email, the program do not add this person as an author, this also aplies to readers. And when a image comes to the project, the project changes the image name with a proper name before adds to the database. Images are holded in a images file which is in the project. When an image is deleted from the database, the image also deleted from the file.

* **Controller**:
<br> This layer provides RESTful interface.
