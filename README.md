




# 🎓 Smart Result Web App

A modern Spring Boot + Thymeleaf web application to manage student results.  
This app allows admins to add students along with their marks across multiple subjects, and lets students view their detailed mark sheet using their roll number.

---

## ✨ Features

✅ **Admin Panel**
- Add new students with details: name, roll number, email, gender, DOB, school name.
- Enter subject-wise marks, grades, and remarks.
- Automatically calculates total marks, percentage, overall grade, and gives personalized feedback.

✅ **Student Portal**
- Students can view their mark sheet by simply entering their roll number.
- Displays detailed subject marks, total, percentage, grade, and feedback.

✅ **Responsive UI**
- Built using Tailwind CSS for a clean, classic look.
- Works smoothly on mobile, tablet, and desktop devices.

---

## 🚀 Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL** (or any JPA-compatible DB)
- **Thymeleaf**
- **Tailwind CSS**

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Manojkhanavalkar/Smart-result-web-app.git
cd Smart-result-web-app
````

### 2️⃣ Configure the Database

Update your database credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

💡 **Make sure your database exists.**
You can create it using:

```sql
CREATE DATABASE your_database;
```

### 3️⃣ Run the Application

Use Maven Wrapper or your IDE to start the app:

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

---

## 📚 Usage

### ➡️ Admin Operations

* Go to `/admin/add-student` to add a new student with their subjects and marks.
* Supports adding multiple subjects dynamically on the form.
* Stores all data in MySQL.

### ➡️ Student Result

* Go to `/view-result`
* Enter the student's roll number to see their mark sheet.

---

## 📸 Screenshots

Add screenshots of your application here to showcase the UI.

| Add Student Page                                
| ----------------------------------------------- |
<img width="1054" height="774" alt="image" src="https://github.com/user-attachments/assets/dfba5ef9-9774-4bb3-a00f-34670037484b" />

| --------------------------------------------- |

| Student Marksheet Page                        |
| <img width="1143" height="809" alt="image" src="https://github.com/user-attachments/assets/6789a1f9-a134-4f97-9f99-abed10491a79" /> |

> 

---

## 💡 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📝 License

This project is open-source under the [MIT License](LICENSE).

---

## ✍️ Author

**👨‍💻 Manoj Khanavalkar**

* [GitHub](https://github.com/Manojkhanavalkar)

---

## 🙌 Thanks for checking this project out!

If you like this project, please ⭐ the repo to show your support!

```




