# Students Management Service

## Overview
This service manages universities, faculties, and students, providing endpoints for retrieving and updating university, faculty, and student data.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- PostgreSQL
- Maven

## Endpoints

### University Service

#### Get all universities
```http
GET /universities?page={page}&pageSize={pageSize}&location={location}
```
- Returns a paginated list of universities.
- If `location` is provided, filters universities by location.

#### Get university by ID
```http
GET /universities/{id}
```
- Returns details of a university by ID.

### Faculty Service

#### Get all faculties
```http
GET /faculties?page={page}&pageSize={pageSize}
```
- Returns a paginated list of faculties.

#### Get faculties by university name
```http
GET /faculties?page={page}&pageSize={pageSize}&universityName={universityName}
```
- Returns a paginated list of faculties belonging to a specific university.

#### Get faculties by tuition fee
```http
GET /faculties?page={page}&pageSize={pageSize}&tuitionFee={tuitionFee}
```
- Returns a paginated list of faculties filtered by tuition fee.

#### Add a new faculty
```http
POST /faculties
```
##### Request Body
```json
{
    "name": "Computer Science",
    "tuitionFee": 3200,
    "creditsRequiredForGraduation": 240,
    "universityId": 1000
}
```
- Creates a new faculty.

#### Update an existing faculty
```http
PUT /faculties/{id}
```
##### Request Body
```json
{
    "name": "Updated Name",
    "tuitionFee": 3500,
    "creditsRequiredForGraduation": 250,
    "universityId": 1000
}
```
- Updates faculty details.

#### Delete a faculty
```http
DELETE /faculties/{id}
```
- Deletes a faculty by ID.

### Student Service

#### Get all students
```http
GET /students?page={page}&pageSize={pageSize}
```
- Returns a paginated list of students.

#### Get students by university name
```http
GET /students?page={page}&pageSize={pageSize}&universityName={universityName}
```
- Returns a paginated list of students filtered by university name.

#### Get students by faculty name
```http
GET /students?page={page}&pageSize={pageSize}&facultyName={facultyName}
```
- Returns a paginated list of students filtered by faculty name.

#### Get students by location
```http
GET /students?page={page}&pageSize={pageSize}&location={location}
```
- Returns a paginated list of students filtered by university location.

#### Get student by ID
```http
GET /students/{id}
```
- Returns details of a student by ID.

#### Add a new student
```http
POST /students
```
##### Request Body
```json
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "age": 20,
    "gpa": 3.7,
    "credits": 60,
    "facultyId": 100
}
```
- Creates a new student.

#### Update an existing student
```http
PUT /students/{id}
```
##### Request Body
```json
{
    "firstName": "Updated FirstName",
    "lastName": "Updated LastName",
    "email": "updated.email@example.com",
    "age": 21,
    "gpa": 3.8,
    "credits": 90,
    "facultyId": 100
}
```
- Updates student details.

#### Delete a student
```http
DELETE /students/{id}
```
- Deletes a student by ID.

## How to Run
1. Clone the repository:
   ```sh
   git clone <repository_url>
   ```
2. Navigate to the project directory:
   ```sh
   cd students-management
   ```
3. Build the project:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Environment Variables
- `JAVA_COURSE_DB_URL` - Database URL
- `JAVA_COURSE_DB_USER` - Database username
- `JAVA_COURSE_DB_PASSWORD` - Database password