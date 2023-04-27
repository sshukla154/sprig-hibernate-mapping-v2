# Hibernate Mappings:

1. OneToOne:
   1. Using Join Table 
      E.G. 
   
   2. Using Foreign Key 
      E.G.
   3. Using Primary Key
2. OneToMany:
3. ManyToMany:

## URLS:
OneToOne:
- _POST_ : localhost:8080/v2/api/employee/create
  ```
  {
   "name": "Hello World",
    "department": "HR",
    "salary": 342.567,
    "employeeInfo": {
        "country": "Netherlands",
        "state": "Utrecht",
        "city": "Nieuwegein",
        "pinCode": "3432TM",
        "phoneNumber": "23456"
    }
  }
- _GET_ : localhost:8080/v2/api/employee/all
- _GET_ : localhost:8080/v2/api/employee/{employeeId}
- _DELETE_ : localhost:8080/v2/api/employee/{employeeId}

- _POST_ : localhost:8080/v2/api/user/create
   ```
  {
    "name": "Hello World1234567899",
    "userProfile": {
        "phoneNumber": "76543",
        "gender": "FEMALE"
    }
  }
  ```
- _GET_ : localhost:8080/v2/api/user/all
- _GET_ : localhost:8080/v2/api/user/{userId}
- _DELETE_ : localhost:8080/v2/api/user/{userId}

- _POST_ : localhost:8080/v2/api/student/create
- _GET_ : localhost:8080/v2/api/student/all
- _GET_ : localhost:8080/v2/api/student/{studentId}
- _DELETE_ : localhost:8080/v2/api/student/{studentId}
