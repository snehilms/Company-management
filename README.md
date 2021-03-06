
# Company-management

A Springboot Company-Team management assignment for creating, and retrieving company information along with team details from the database.




## Running the Application 

Clone the github repo 

```bash
  git clone https://github.com/snehilms/Company-management.git
```


Run the SpringBoot application in an IDE(STS, Intellij)

### Note:
Mysql Db is required for the Project running on port: 3306
First hit the login Api. (All Apis are Forbidden by Default)
Before hitting the login api ensure that the username and password fields are set. Usecase provided already are:
#### username= snehilms, password =1234
Eg:![Screenshot 2022-06-29 114144](https://user-images.githubusercontent.com/42109401/176364381-d0a00375-2235-47d6-a48c-bb305f548ca0.png)

After successfully hitting the login api, an access token and refresh token will be generated which can be used for accessing the other apis
by using the authorization bearer header as : Bearer <access_token>
![Screenshot 2022-06-29 130432](https://user-images.githubusercontent.com/42109401/176378901-0c942711-1e1f-4f6e-8ad4-d09b6091e3bb.png)

All APIs will be accessible now depending upon the role of the user.

(Dockerizing the springboot and mysql in progress...)
## API Reference
http://localhost:8080/ - If running on the local machine. (Recommended for now)

#### Get all items

```http
  POST /login
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| No Parameter | - | The login is initially required for getting access and refresh token  |
                    
#### Get item

```http
  POST /company/create_company
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| company Name, CEO, Date, Company Address      |Json |Create a new company |

![Screenshot 2022-06-29 114822](https://user-images.githubusercontent.com/42109401/176366854-a6fdbd48-f5e6-4925-9818-8932d1f22dda.png)

```http
  GET /company/get_companies
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| No Parameter required      |- |Get the list of the companies present in the database  |

![Screenshot 2022-06-29 114907](https://user-images.githubusercontent.com/42109401/176366868-06f2cec9-8373-4550-9a74-73e9eb2477be.png)



```http
  GET /company/get_company_id/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| id in path      |Numeric |Get Company by the provided id from the database |

![Screenshot 2022-06-29 120014](https://user-images.githubusercontent.com/42109401/176378634-9e49eb26-e5e0-459e-a883-0f118e5dffa4.png)


```http
  GET /company/get_company_name/{comp_name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| Name of company      |String |Get the company by Name from the database

![Screenshot 2022-06-29 121730](https://user-images.githubusercontent.com/42109401/176378628-99a6af4d-4358-4ecf-9cc0-9a9a2fb9cc5e.png)

```http
  POST /team/create_team/{comp_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| Team leadName, Company id in path|- |Creates a new team with the leadName and company

![Screenshot 2022-06-29 115530](https://user-images.githubusercontent.com/42109401/176366930-1d0b95b8-ac49-45b6-91d2-98e5eb16453e.png)


```http
  GET /team/get_teams
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| No Parameter required      |- |Get the List of company along the array of teamLeads

![Screenshot 2022-06-29 115815](https://user-images.githubusercontent.com/42109401/176366940-d94c3bea-45a3-4861-aaf4-f1e347942838.png)


## Documentation
After running the application the documentation can be seen here
[Documentation](http://localhost:8080/swagger-ui.html) (http://localhost:8080/swagger-ui.html)


