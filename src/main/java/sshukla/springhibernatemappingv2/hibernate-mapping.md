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
### OneToOne:
- _POST_ : localhost:8080/onetoone/v1/api/employee/create
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
- _GET_ : localhost:8080/onetoone/v1/api/employee/all
- _GET_ : localhost:8080/onetoone/v1/api/employee/{employeeId}
- _DELETE_ : localhost:8080/onetoone/v1/api/employee/{employeeId}
- _GET_ : localhost:8080/onetoone/v1/api/employeeInfo/all
- _GET_ : localhost:8080/onetoone/v1/api/employeeInfo/{employeeInfoId}
- _DELETE_ : localhost:8080/onetoone/v1/api/employeeInfo/{employeeInfoId}

- _POST_ : localhost:8080/onetoone/v1/api/user/create
   ```
  {
    "name": "Hello World1234567899",
    "userProfile": {
        "phoneNumber": "76543",
        "gender": "FEMALE"
    }
  }
  ```
- _GET_ : localhost:8080/onetoone/v2/api/user/all
- _GET_ : localhost:8080/onetoone/v2/api/user/{userId}
- _DELETE_ : localhost:8080/onetoone/v2/api/user/{userId}
- _GET_ : localhost:8080/onetoone/v2/api/userProfile/all
- _GET_ : localhost:8080/onetoone/v2/api/userProfile/{userId}
- _DELETE_ : localhost:8080/onetoone/v2/api/userProfile/{userId}

- _POST_ : localhost:8080/onetoone/v2/api/student/create
- _GET_ : localhost:8080/onetoone/v2/api/student/all
- _GET_ : localhost:8080/onetoone/v2/api/student/{studentId}
- _DELETE_ : localhost:8080/onetoone/v2/api/student/{studentId}
- _GET_ : localhost:8080/onetoone/v1/api/studentInfo/all
- _GET_ : localhost:8080/onetoone/v1/api/studentInfo/{studentId}
- _DELETE_ : localhost:8080/onetoone/v1/api/studentInfo/{studentId}

### OneToMany:
- _POST_ : localhost:8080/onetomany/v1/api/post/create
```
{
    "content": "hello Worrld I am for delete",
    "description": "Hello World I am for delete",
    "title": "HelloWorld I am for delete"
}
```

- _PUT_ : localhost:8080/onetomany/v1/api/post/update
- _GET_ : localhost:8080/onetomany/v1/api/post/all
- _GET_ : localhost:8080/onetomany/v1/api/post/{postId}
- _DELETE_ : localhost:8080/onetomany/v1/api/post/{postId}

- _POST_ : localhost:8080/onetomany/v1/api/comment/create?postId={postId}
```
{
   "text": "First comment"
}
```

- _PUT_ : localhost:8080/onetomany/v1/api/comment/update
- _GET_ : localhost:8080/onetomany/v1/api/comment/all
- _GET_ : localhost:8080/onetomany/v1/api/comment/{commentId}
- _DELETE_ : localhost:8080/onetomany/v1/api/comment/{commentId}
