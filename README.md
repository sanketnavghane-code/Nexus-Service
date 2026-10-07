# Service Nexus - Bus Fleet & Route Management System 🚍

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/uiswing/)

**Service Nexus** is a comprehensive desktop enterprise application built with Java Swing and MySQL, designed to streamline bus depot operations, route scheduling, vehicle inventory, employee crew management, and daily service allocations for public and private transport organizations (such as MSRTC).

---

## 📌 Table of Contents

- [Features](#-features)
- [Architecture & Tech Stack](#-architecture--tech-stack)
- [Project Directory Structure](#-project-directory-structure)
- [Database Schema & Setup](#-database-schema--setup)
- [Prerequisites](#-prerequisites)
- [Installation & Running](#-installation--running)
- [Default Login Credentials](#-default-login-credentials)
- [Screenshots & UI Assets](#-screenshots--ui-assets)
- [Contributing & Author](#-contributing--author)

---

## 🌟 Features

### 1. 🔐 Authentication & Role Management
- Secure user login with show/hide password toggle.
- Dynamic animated banner and sliding announcements.
- Dedicated dashboard with quick access to all modules.

### 2. 🗺️ Multi-Tier Location Hierarchy
- Deep geographical structure: **Country ➡️ State ➡️ District ➡️ Taluka ➡️ Village / Area**.
- Smart place finder module with instant search and filtering.
- In-app Google Maps integration (`goonline/`) for visualizing routes and depot locations.

### 3. 🚌 Fleet & Vehicle Management
- Detailed vehicle registration (Bus Number, capacity, type, fuel, model).
- Vehicle type classification (Ordinary, Semi-Luxury, AC Shivneri, Sleeper, etc.).
- Real-time fleet status tracking and report generation.

### 4. 👨‍✈️ Employee & Crew Administration
- Staff master management for drivers, conductors, mechanics, and administrative staff.
- Designation master with role assignments and privilege controls.
- Employee shift and contact details management.

### 5. 🛣️ Route & Stop Network Planning
- Route planning from origin to destination with distance metrics.
- Intermediate stop configuration with stop sequencing and timing details.
- Comprehensive route and stop reports with printable formatting.

### 6. 📅 Daily Service Allocation Engine
- Intelligent allocation combining **Route + Bus + Driver + Conductor + Date**.
- Avoids conflicting vehicle/crew scheduling.
- Search and report generation for daily and monthly allocations.

### 7. 🎨 Modern Swing UI & Media Components
- Custom gradient background panels (`myDesign/GradientPanel.java`).
- Smooth rounded panels and button styling (`myDesign/RoundedPanel.java`).
- Real-time animated marquees (`myUtility/ScrollLabel.java`, `myUtility/MovingLabel.java`).
- Integrated slideshows and video playback capabilities.

---

## 🛠️ Architecture & Tech Stack

- **Presentation Layer**: Java Swing, Java AWT, Custom 2D Graphics
- **Business & Data Access Layer**: 
  - `cls*` classes: Data model representation
  - `dls*` classes: Data logic services & database interactions
- **Database Engine**: MySQL 8.x / 9.x
- **Database Connector**: MySQL Connector/J (`com.mysql.cj.jdbc.Driver`)
- **Query Engine**: `QueryExecutor.java` (Centralized connection pool & statement execution)

---

## 📂 Project Directory Structure

```plaintext
Service_Nexus/
├── appsetting/         # Color palettes, theme settings, and UI styling configs
├── DataBase/           # Complete MySQL database dumps and schema scripts (dbProjectData.sql)
├── goonline/           # Google Maps browser launcher and embedded map frames
├── imagesrc/           # Image assets, icons, logos, GIFs, and screenshots
├── myDesign/           # Custom Swing UI widgets (Gradient panels, rounded buttons, slideshows)
├── myUtility/          # Utility modules (Date picker, animations, marquees, video panels)
├── ReportUtility/      # Tabular report generators and text alignment tools
├── screensetting/      # Screen geometry, layout managers, and responsive positioning
├── videosrc/           # Video files and animated media assets
├── cls*.java           # Model entity classes (Allocation, Route, Vehicle, Employee, etc.)
├── dls*.java           # Data Logic Services handling SQL queries for each entity
├── frm*.java           # JFrame form controllers and interactive screens
├── rpt*.java           # Report display windows and data visualizers
├── FrmLogin.java       # Application entry point (Login Screen)
├── QueryExecutor.java  # Core JDBC execution helper
├── README.md           # Project documentation
└── .gitignore          # Git exclusion rules
```

---

## 🗄️ Database Schema & Setup

The database schema is organized into normalized relational tables under `dbProjectData`:

- `tblCountry`, `tblState`, `tblDistrict`, `tblTaluka`, `tblVillage`, `tblVillageArea`
- `tbldesignation`, `tblemployee`
- `tblvehicletype`, `tblvehicle`
- `tblroot`, `tblrootstop`
- `tblallocation`
- `tbluserlogin`

### Database Setup Steps:

1. Start your **MySQL Server**.
2. Open your terminal or MySQL Workbench:
   ```sql
   CREATE DATABASE dbProjectData;
   ```
3. Import the SQL dump file:
   ```bash
   mysql -u root -p dbProjectData < DataBase/dbProjectData.sql
   ```
4. Verify the database credentials in [`QueryExecutor.java`](QueryExecutor.java):
   ```java
   String url = "jdbc:mysql://localhost:3306/dbProjectData";
   Connection con = DriverManager.getConnection(url, "root", "your_password");
   ```

---

## ⚙️ Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher (JDK 17/21 recommended)
- **MySQL Server**: Version 8.0 or newer
- **MySQL Connector/J JAR**: `mysql-connector-j-8.x.jar` (placed in classpath or `lib/`)

---

## 🚀 Installation & Running

### Option 1: Using Command Line

1. **Clone the repository:**
   ```bash
   git clone https://github.com/sanketnavghane-code/Nexus-Service.git
   cd Nexus-Service
   ```

2. **Compile the Java sources:**
   ```bash
   javac -cp ".;lib/*" *.java appsetting/*.java goonline/*.java myDesign/*.java myUtility/*.java ReportUtility/*.java screensetting/*.java
   ```

3. **Run the Application:**
   ```bash
   java -cp ".;lib/*" FrmLogin
   ```

### Option 2: Using Eclipse / IntelliJ IDEA / VS Code

1. Open **Eclipse** or **IntelliJ IDEA**.
2. Select **Open Project** and navigate to the cloned project directory.
3. Add `mysql-connector-j.jar` to the project's Build Path (`Referenced Libraries`).
4. Set [`FrmLogin.java`](FrmLogin.java) as the Main Class.
5. Click **Run**.

---

## 🔑 Default Login Credentials

| Username | Password | Role |
| :--- | :--- | :--- |
| **`Admin`** | **`12345`** | Administrator |

---

## 📸 Screenshots & UI Assets

All icons, graphics, and background artwork are located in the [`imagesrc/`](imagesrc/) directory.

---

## 👤 Author & Contributions

- **Repository**: [sanketnavghane-code/Nexus-Service](https://github.com/sanketnavghane-code/Nexus-Service)
- Developed by **Sanket Navghane** ([@sanketnavghane-code](https://github.com/sanketnavghane-code))