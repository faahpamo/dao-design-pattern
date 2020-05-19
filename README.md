# dao-design-pattern
Discussing the implementation Data Access Object (DAO) Java EE Design Pattern
## Introduction
Ever since I came across the DAO design pattern, I am in love with it. Because, it makes my application design process easier. I still remember the early days of my web application development where I started developing a web app for my team to make daily project reporting easier. The project started out of my personal interest. Initially, I started using the Oracle database. After some days, I began using MySQL on my laptop because it was better working on it when compared with Oracle DB. As soon as I decided to switch to MySQL from Oracle DB, I started facing the mammoth task of changing many parts of my already developed code. It was a frustrating experience. During such period I came across the DAO design pattern and it solved my data access layer issues forever. It remains my favorite to this day. I have been solely developing web applications and DAO is the part of my application that gets developed first, immediately after designing my data model.

DAO design pattern is part of the [core J2EE design patterns](http://www.corej2eepatterns.com/DataAccessObject.htm). The pattern lets you separate the application's data access layer from other parts of the application. Usually, web applications are developed following the Model View Controller (MVC) 2 design pattern, where MVC are three different parts of the same web application. The components of these three parts interact with the application's database for CRUD (Create Read Update Delete) operations. Without having a separate layer for database interactions, we find ourselves using the same JDBC API methods from various components. This results in boilerplate code apart from the tight coupling. Numerous classes that belong to the Model part of our MVC 2 based application would require change if we make changes to our persistent storage. Imagine the scenario of moving from a RDBMS to a file based (XML or plain files for example) system for persistent storage! Without a separate data base access layer, we would definitely end up modifying a big chunk of our existing codebase apart from writing whole lot new!

Having a separate and uniform layer for data base access brings us benefits like:
1. a single layer for all components of the application to interact with database irrespective of the type of the database
2. decoupling the boilerplate database access calls from the other parts of application
3. easy to maintain and increases portability

In this little project, I will demonstrate a fully functional DAO implementation.

## Example Implementation
In our example implementation, we first begin with designing our data model. To keep it simple, I will use a database to store names/titles of books. Our database will have a single table called 'Books':

|Book_ID|Title|
|---|---|
|1|Java|
|2|The Java Programming Language|

That's it. Very simple. The books database will be used by both command line and web based applications. So, it should support uniform access.
