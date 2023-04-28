# Some kind of user management application.

Spring boot Java REST Api application, made with Eclipse.

Starts: jk.test.users.UserManagement

Requires DB user and pwd in application.properties file.

Current configuration is for MySQL.

Supports :

POST http://localhost:8080/user

GET http://localhost:8080/users

DELETE http://localhost:8080/user/{id}

PUT http://localhost:8080/user/{id}

User example json :
{
    "id": 1,
    "name": "...",
    "username": "...",
    "email": "...",
    "address": {
      "street": "...",
      "suite": "...",
      "city": "...",
      "zipcode": "..",
      "geo": {
        "lat": "-1",
        "lng": "1"
      }
    },
    "phone": "...",
    "website": "...",
    "company": {
      "name": "...",
      "catchPhrase": "...",
      "bs": "..."
    }
  }