# URL Shortener

This is a simple full-stack URL shortener application built using Spring Boot, MySQL, and basic frontend technologies.  
The goal of this project is to convert long URLs into short links and redirect users back to the original URL.

---

## Features

- Convert long URLs into short links
- Redirect short URLs to the original website
- Simple and clean user interface
- Copy short URL functionality

---

## Tech Stack

- Backend: Spring Boot (Java)
- Database: MySQL
- Frontend: HTML, CSS, JavaScript

---

## How it Works

1. User enters a long URL in the input box  
2. Backend generates a unique short code  
3. The mapping is stored in the database  
4. A short URL is returned  
5. When the short URL is opened, it redirects to the original URL  

---

## How to Run the Project

1. Clone the repository: git clone https://github.com/NagaVenkateswaraRaoGanta/url-shortener.git

2. Go to the project folder: cd urlshortener

3. Run the application: .\mvnw.cmd spring-boot:run

4. Open your browser and go to: http://localhost:8080

---

## About

This project was built to understand how backend APIs, databases, and frontend interact in a real-world application.