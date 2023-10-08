CREATE TABLE users
(
    id              SERIAL PRIMARY KEY,
    firstName       VARCHAR(255),
    lastName        VARCHAR(255),
    email           VARCHAR(255) UNIQUE,
    password        VARCHAR(255),
    date_of_birth   DATE,
    profile_picture TEXT,
    role            VARCHAR(255)
);

CREATE TABLE courses
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(255),
    description TEXT,
    user_id     BIGINT REFERENCES users (id),
    start_date  DATE,
    end_date    DATE
);

CREATE TABLE enrollments
(
    id              SERIAL PRIMARY KEY,
    user_id         BIGINT REFERENCES users (id),
    course_id       BIGINT REFERENCES courses (id),
    enrollment_date DATE
);

CREATE TABLE materials
(
    id        SERIAL PRIMARY KEY,
    course_id BIGINT REFERENCES courses (id),
    title     VARCHAR(255),
    content   TEXT,
    type      VARCHAR(255)
);

CREATE TABLE reviews
(
    id        SERIAL PRIMARY KEY,
    course_id BIGINT REFERENCES courses (id),
    user_id   BIGINT REFERENCES users (id),
    rating    INTEGER,
    review    TEXT
);
