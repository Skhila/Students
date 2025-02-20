CREATE TABLE IF NOT EXISTS students.university
(
    ID       BIGINT       NOT NULL PRIMARY KEY,
    NAME     VARCHAR(255) NOT NULL,
    LOCATION VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS students.faculty
(
    ID                              BIGINT         NOT NULL PRIMARY KEY,
    NAME                            VARCHAR(255)   NOT NULL,
    TUITION_FEE                     DECIMAL(10, 2) NOT NULL,
    CREDITS_REQUIRED_FOR_GRADUATION INTEGER        NOT NULL,
    UNIVERSITY_ID                   BIGINT         NOT NULL REFERENCES students.university (ID)
);

CREATE TABLE IF NOT EXISTS students.student
(
    ID         BIGINT              NOT NULL PRIMARY KEY,
    FIRST_NAME VARCHAR(255)        NOT NULL,
    LAST_NAME  VARCHAR(255)        NOT NULL,
    EMAIL      VARCHAR(255) UNIQUE NOT NULL,
    AGE        INT                 NOT NULL,
    FACULTY_ID BIGINT              NOT NULL REFERENCES students.faculty (ID),
    CREDITS    INT                 NOT NULL,
    GPA        DECIMAL(3, 2)       NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS students.university_seq INCREMENT 1 START 1000;
CREATE SEQUENCE IF NOT EXISTS students.faculty_seq INCREMENT 1 START 1000;
CREATE SEQUENCE IF NOT EXISTS students.student_seq INCREMENT 1 START 1000;
