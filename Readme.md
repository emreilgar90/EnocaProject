# Getting Started

### Requirements
- JDK(17)
- PostgreSQL
- IDE (IntelliJ IDEA)
- Docker Desktop

### Technologies
- Java
- Spring Boot(3.1.1)
- PostgresSQL
- Docker (Dockerfile and Docker Compose)

### Architecture
- Monolithic

### Stages
##### 1-Clone the project
` git clonehttps://github.com/emreilgar90/EnocaProject `

##### 2-Go inside the project file
`cd enoca`

##### 3- Run PROJECT
`docker-compose up -d`

##### 4-Ready for Using the project
- http://localhost:8081/v1/company/registerCompany
- http://localhost:8081/v1/company/findall
- http://localhost:8081/v1/company/deleteById/{Id}
- http://localhost:8081/v1/company/updateById/{Id}
- http://localhost:8081/v1/employee/registerEmployee
- http://localhost:8081/v1/employee/updateById/{employeeId}
- http://localhost:8081/v1/employee/findall/{companyId}

### Entity Classlari
#### Company
id -> Long

companyName -> String

companyAddress -> String

password -> String

repassword -> String

employeList -> List[EmployeeList]

#### Employee

id -> Long

name -> String

surName -> String

email -> String

job -> String

Company -> Company
