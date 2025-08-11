# Workout App - Backend

A modern Spring Boot based workout web application that helps users create, save, manage, and track their strength workout routines. Built with Java Spring Boot
and the three-tier architecture and REST APIs, and incorporating MySQL database using JPA Hibernate.

## Live Application

The fully deployed application, Workout Blocks, is available at: https://workout-app-pink.vercel.app/

## Backend Source Code

The repository is available on GitHub at: https://github.com/SanjaPejic/workout-app-backend

# Technology Stack

- _Framework_: **Spring Boot** `3.5.3`
- _Language_: **Java** `21`
- _Database_: **MySQL** `8.0`
- _ORM_: **Spring Data JPA with Hibernate**
- _Build Tool_: **Maven** `3.9.10`
- _Architecture_: **RESTful API with layered architecture**
- _Deployment_: **AWS (Amazon Web Serices)**

## Local Setup

### Prerequisites

- _Java Development Kit (JDK) 21_ or higher
- _Maven 3.6+_ for dependency management
- _MySQL 8.0+_ database server
- _Git_ for version control

### Installation

1. Clone the Repository

```bash
git clone https://github.com/SanjaPejic/workout-app-backend
cd workout-app-backend-main
```

2. Database Setup

- Create a MySQL database named workoutdb
- Ensure your MySQL server is running and accessible
- Update the database configuration in application.properties if necessary

3. Build the Project

```bash
mvn clean install
```

4. Running the Application

```bash
mvn spring-boot:run
```

## Project Structure

```
src/main/java/com/workoutapp/workoutbackend/

├── config/                             # Application configuration classes (e.g. CORS settings for frontend–backend communication)
├── controller/                         # REST API controllers
├── dto/                                # Data Transfer Objects
├── exception/                          # Custom exception handling
├── mappers/                            # Entity–DTO mapping utilities
├── model/                              # Database entity classes
├── repository/                         # Data access layer
├── service/                            # Business logic layer
└── WorkoutbackendApplication.java      # Main Spring Boot class that starts the application

src/main/resources/
├── static/                             # Static resources (not used in this project)
├── templates/                          # Server-side templates (not used in this project)
└── application.properties              # Application name, database connection, and JPA/Hibernate configuration
```

## Database Schema

The application utilises the following core entities:

- _User_: User accounts and profiles
- _Exercise_: Exercise definitions and metadata
- _Workout_: Workout routines and schedules
- _WorkoutExercise_: Junction table linking workouts and exercises
- _Muscle_: Muscle group definitions
- _ExerciseTargetMuscle_: Junction table linking exercises and target muscles
- _Injury_: User injury records
- _HowToStep_: Step-by-step exercise instructions

# License

This project was developed as part of my Master’s dissertation and is not licensed for public use.

---
