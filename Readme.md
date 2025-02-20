# Students Management Service

## Overview
This service manages universities and faculties, providing endpoints for retrieving and updating university and faculty data.

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
GET /faculties?page={page}&pageSize={pageSize}&?tuitionFee={tuitionFee}
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
- `SPRING_DATASOURCE_URL` - Database URL
- `SPRING_DATASOURCE_USERNAME` - Database username
- `SPRING_DATASOURCE_PASSWORD` - Database password

## License
This project is licensed under the MIT License.

