# InterviewFlow

InterviewFlow is a backend system designed to manage interview processes, including interview drives, rounds, and structured candidate evaluations. The project focuses on clean API design, proper data modeling, and real-world backend architecture.

---

## 🚀 Project Goals
- Design a scalable backend for interview process management
- Implement clean and secure REST APIs
- Apply role-based access control
- Model real-world interview workflows
- Build the system incrementally with clear phases

---

## 🧩 Core Features

### Phase 1 (In Progress)
- User authentication using JWT
- Role-based access (Recruiter / Interviewer)
- Create and manage interview drives
- Create and manage interview rounds
- Secure REST APIs with proper validation

### Planned Phases
- Candidate management
- Interviewer assignment to rounds
- Candidate evaluation with ratings and feedback
- Interview status tracking (Selected / Rejected / On Hold)
- Aggregated evaluation summaries

---

## 🏗️ Tech Stack
- **Backend:** Spring Boot
- **Authentication:** JWT
- **ORM:** Spring Data JPA
- **Database:** PostgreSQL
- **API Documentation:** Swagger (planned)
- **Testing:** Postman

---

## 🗄️ High-Level Domain Model
- User
- InterviewDrive
- InterviewRound
- Candidate
- Evaluation

(Entities will be expanded incrementally as features are implemented.)

---

## 📂 Project Structure
```

InterviewFlow/
│── src/main/java/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   ├── dto/
│   └── config/
│
│── src/main/resources/
│── README.md

```

---

## 🔒 Security
- JWT-based authentication
- Role-based authorization
- Secure access to APIs based on user roles

---

## 📈 Future Enhancements
- Event-driven architecture using Apache Kafka
- Notifications and analytics via asynchronous events
- Advanced filtering, pagination, and reporting

---

## 📌 Status
This project is actively under development and is being built in phases with a focus on clean architecture and interview-ready backend design.

---

## 🤝 Contributions
This is a personal learning and portfolio project. Suggestions and discussions are welcome.

---

## 📄 License
MIT License