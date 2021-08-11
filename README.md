# Character Creation API

### What is `Character Creation API` ?

This application is a `Java` API REST developed for a simple Character RPG like system creation using `Spring Boot` and the entity relationship diagram for the database is:

![characterAPI-MER](https://user-images.githubusercontent.com/68413884/127718454-6e6a57b1-0f14-4c3f-a52a-eb1a27e41d6f.png)

As shown in the diagram above, each character (Champion), has a level, a name and a list of Skills and Professions.

<br/>

## What do you need to use it?

> - **Java** (at least Java version 8)
> - **Any IDE**
> - **Any software to make requests - Recommended: [Postman](https://www.postman.com)**

<br/>

## How to install

> To install this project all you have to do is to clone this repository with the command:
>
> ```
>    git clone https://github.com/ricksoliveira/character_api_dio.git
> ```
>
> Or you can just download it as a `ZIP` file and open as a project  within your IDE.

<br/>

## How to execute it

> 1. Load the **maven** dependencies in the `pom.xml` file.
>
> 2. Run the `main` class and wait for the spring boot to load.
>
>    - Alternatively you can run the project on the terminal with the command:
>
>      ```
>         mvn spring-boot:run 
>      ```


<br/>

## How to use the application

> 1. Having **Postman** installed, go to **Workspace** and create a new one:
>
> ![image](https://user-images.githubusercontent.com/68413884/127719215-ac00fb18-b7cc-4c32-9f4c-ec8e7a947d78.png)
>
> 2. Inside your new **Workspace**, you can create a new **Collection** and right-click the Collection to **Add a Request**:
>
> ![image](https://user-images.githubusercontent.com/68413884/127719439-f8616953-b4ee-4f48-b47c-cc6c7fbdc553.png)
>
> 3. Requests can be 4 types: **POST** for creating, **GET** and Get by ID for reading, **DELETE** for deleting and PUT for updating. By default your database starts empty, so you can chose a **POST** method and add a Character.
>
>    - Go to **Body** and select **Raw**, and make a request like the **JSON** in the link **`http://localhost:8080/api/v1/champion`**:
>
> ![image](https://user-images.githubusercontent.com/68413884/127720063-4bb13a04-9694-4a64-98c4-a98cc770c010.png)
>
>      
>      {
>          "name": "Usernametest",
>          "level": "1",
>          "charSpec": "PRIEST",
>          "professions": [
>              {
>                  "name": "Cooking"
>              }
>          ],
>          "skills": [
>              {
>                  "name": "Heal"
>              },
>              {
>                  "name": "Shadow Shield"
>              }
>          ]
>      }
>      
>
>    - The links for adding an **Skill** and a **Profession** are, respectively:
>
>      ```
>         http://localhost:8080/api/v1/skill
>      ```
>
>      ```
>         http://localhost:8080/api/v1/profession
>      ```
>
>    - The `charSpec` field can only be one out of 5 possibilities:
>      - WARRIOR
>      - PALADIN
>      - MAGE
>      - PRIEST
>      - HUNTER
>    - For searching a specific entry just add the endpoint: **`/id`**, like: **`http://localhost:8080/api/v1/champion/2`**
>
> 4. Click on **Send** and you should receive a **201 Status Code** if your entry was added to the database:
>
> ![image](https://user-images.githubusercontent.com/68413884/127720458-91c3dac2-c543-4ac3-a98b-fd28d31472b8.png)
>
> 5. You can also verify using the **H2 Console** by **[clicking here](localhost:8080/h2-console)**.
> 6. Make sure the **JDBC URL** is `jdbc:h2:mem:champdb` and click **Connect.**
> 7. It will confirm that everything you added on Postman is on your memory database!
>
> ![image](https://user-images.githubusercontent.com/68413884/127720651-418cb95d-b691-412a-89d6-99736c75bc3e.png)

<br/>

## Authors

- **Henrique Servidoni de Oliveira** - [LinkedIn](https://www.linkedin.com/in/ricksoliveira/)


## Thanks !

> Special thanks to [**DIO**](https://web.digitalinnovation.one/home) and [**Santander**](https://www.santander.com.br) for the full-stack scholarship opportunity.
