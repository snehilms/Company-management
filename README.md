
# Company-management

A Springboot Company-Team management assignment for creating, and retrieving company information along with team details from the database.




## Running the Application 

Clone the github repo 

```bash
  git clone https://github.com/snehilms/Company-management.git
```


Run the SpringBoot application in an IDE(STS, Intellij)

### Note:
First hit the login Api. (All Apis are Forbidden by Default)
Before hitting the login api ensure that the username and password fields are set. Usecase provided already are:
#### username= snehilms, password =1234

After successfully hitting the login api, an access token and refresh token will be generated which can be used for accessing the other apis
by using the authorization bearer header as : Bearer <access_token>

All APIs will be accessible now depending upon the role of the user
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


```http
  GET /company/get_companies
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| No Parameter required      |- |Get the list of the companies present in the database  |




```http
  GET /company/get_company_id/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| id in path      |Numeric |Get Company by the provided id from the database |


```http
  GET /company/get_company_name/{comp_name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| Name of company      |String |Get the company by Name from the database

```http
  POST /team/create_team/{comp_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| Team leadName, Company id in path|- |Creates a new team with the leadName and company



```http
  GET /team/get_teams
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| No Parameter required      |- |Get the List of company along the array of teamLeads


## Documentation
After running the application the documentation can be seen here
[Documentation](http://localhost:8080/swagger-ui.html) (http://localhost:8080/swagger-ui.html)


