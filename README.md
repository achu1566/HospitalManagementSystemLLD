# Hospital Management System LLD (Low Level Design)

A comprehensive Hospital Management System built in Java that manages patients, doctors, and treatment records with role-based access control.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [System Architecture](#system-architecture)
- [User Roles](#user-roles)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Usage Guide](#usage-guide)
- [Authentication](#authentication)
- [Data Models](#data-models)

---

## Overview

This is a Low-Level Design (LLD) implementation of a Hospital Management System that handles:

- **Patient Management**: Register and manage patient information
- **Doctor Management**: Register and manage doctor information
- **Treatment Assignment**: Assign doctors to patients
- **History Tracking**: View treatment history for patients and doctors
- **Role-Based Access**: Different menus for Admin, Doctor, and Patient

---

## Features

### ✅ Core Functionalities

1. **User Authentication**
   - Admin login with credentials
   - Patient login with username/password
   - Doctor login with username/password
   - Secure credential validation

2. **Patient Management**
   - Create new patients with name, username, password, and mobile number
   - Automatic patient ID generation
   - Prevent duplicate usernames
   - View all patients list

3. **Doctor Management**
   - Create new doctors with name, username, and password
   - Automatic doctor ID generation
   - Prevent duplicate usernames
   - View all doctors list

4. **Treatment Management**
   - Assign doctors to patients with appointment dates
   - Track treatment records
   - View patient treatment history (all doctors treating the patient)
   - View doctor treatment history (all patients treated by the doctor)
   - View complete treatment information

5. **Input Validation**
   - Empty username/password prevention
   - Duplicate username prevention
   - Invalid ID handling

---

## System Architecture

### Design Patterns Used

- **Singleton Pattern**: HospitalService maintains single instance for data management
- **Authentication Pattern**: Auth abstract class handles all authentication logic
- **MVC-like Structure**: Hospital class acts as controller, HospitalService as service layer

### Data Flow

```
User Input (Hospital.java)
    ↓
Authentication (Auth.java)
    ↓
Business Logic (HospitalService.java)
    ↓
Data Models (Patient, Doctor, Treatment, Admin)
```

---

## User Roles

### 1. **ADMIN**

- **Credentials**: Username: `ADMIN` | Password: `123`
- **Permissions**:
  - Create patients
  - Create doctors
  - Assign doctors to patients
  - View patient history
  - View doctor history
  - View treatment information
  - View all patients
  - View all doctors

### 2. **DOCTOR**

- **Self-Register**: Via admin creation
- **Permissions**:
  - View own treatment history
  - View all patients' history (by patient ID)
  - View all doctors list
  - View all patients list
  - View treatment information

### 3. **PATIENT**

- **Self-Register**: Via admin creation
- **Permissions**:
  - View own treatment history
  - View all doctors list
  - View all patients list
  - View treatment information

---

## Project Structure

```
PatientTreatmentManagementSystem/
│
├── Hospital/
│   ├── Auth.java              # Abstract authentication class
│   ├── Hospital.java          # Main application with menu system
│   ├── HospitalService.java   # Business logic & data management
│   └── Treatment.java         # Treatment record model
│
├── User/
│   ├── Admin.java             # Admin user model
│   ├── doctor.java            # Doctor user model
│   └── patient.java           # Patient user model
│
├── TestFunctionality.java     # Comprehensive test suite
└── README.md                  # Project documentation
```

### File Descriptions

**Hospital Package:**

- **Auth.java**: Abstract class containing static methods for login validation of Admin, Doctor, and Patient
- **Hospital.java**: Main entry point with menu-driven interface for all three user types
- **HospitalService.java**: Singleton service class managing patients, doctors, and treatments
- **Treatment.java**: Model class representing a treatment assignment between doctor and patient

**User Package:**

- **Admin.java**: Model class for admin credentials (hardcoded: ADMIN/123)
- **doctor.java**: Model class for doctors with ID generation and treatment tracking
- **patient.java**: Model class for patients with ID generation and treatment tracking

---

## How to Run

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Terminal/Command Prompt

### Compilation

```bash
cd c:\Users\achut\Documents\Projects\PatientTreatmentManagementSystem
javac -d . Hospital/*.java User/*.java
```

### Running the Application

```bash
java -cp . Hospital.Hospital
```

### Running Tests

```bash
javac -d . TestFunctionality.java
java -cp . TestFunctionality
```

---

## Usage Guide

### Login Screen

The application starts with a login menu:

```
Login as:
 1. Admin
 2. Doctor
 3. Patient
```

### Admin Menu

```
1. Create patient
2. Create doctor
3. Assign doctor to patient
4. View patient history
5. View doctor history
6. View treatment information
7. Total patients
8. Total doctors
9. Move to login page
10. Exit
```

### Doctor Menu

```
1. View own treatment history
2. View all doctors
3. View patient history (by ID)
4. View all patients
5. View treatment information
6. Move to login page
7. Exit
```

### Patient Menu

```
1. View own treatment history
2. View all patients
3. View all doctors
4. View treatment information
5. Move to login page
6. Exit
```

---

## Authentication

### Admin Login

- **Username**: `ADMIN`
- **Password**: `123`
- Validated in: `Auth.loginAdmin()`

### Patient Login

- **Username**: Auto-created during patient creation
- **Password**: Auto-created during patient creation
- Validated in: `Auth.loginPatient()`
- Example: username: `johndoe`, password: `password123`

### Doctor Login

- **Username**: Auto-created during doctor creation
- **Password**: Auto-created during doctor creation
- Validated in: `Auth.loginDoctor()`
- Example: username: `drsmith`, password: `docpass123`

### Security Features

- Empty credential validation
- Duplicate username prevention
- Case-insensitive credential matching
- Trimmed whitespace comparison

---

## Data Models

### Patient

```java
- patientId (String): Auto-generated unique ID
- name (String): Patient's full name
- patientUserName (String): Login username
- password (String): Login password
- mobileno (String): Mobile number
- treatments (ArrayList<Treatment>): List of treatments
```

### Doctor

```java
- doctorId (String): Auto-generated unique ID
- name (String): Doctor's full name
- doctorUserName (String): Login username
- password (String): Login password
- treatments (ArrayList<Treatment>): List of treatments
```

### Treatment

```java
- treatmentId (long): Auto-generated unique ID
- patientId (String): Reference to patient
- doctorId (String): Reference to doctor
- assignmentDate (String): Appointment date
```

### Admin

```java
- username (String): "ADMIN" (hardcoded)
- password (String): "123" (hardcoded)
```

---

## Test Coverage

A comprehensive `TestFunctionality.java` file tests:

- ✅ Patient creation
- ✅ Doctor creation
- ✅ Duplicate prevention
- ✅ Empty credential prevention
- ✅ Patient listing
- ✅ Doctor listing
- ✅ Doctor-to-patient assignment
- ✅ Patient history retrieval
- ✅ Doctor history retrieval
- ✅ Treatment details
- ✅ Admin authentication
- ✅ Patient authentication
- ✅ Doctor authentication
- ✅ Invalid ID handling

**Test Result**: All 15 tests PASSED ✓

---

## Known Limitations

1. **In-Memory Storage**: All data is stored in-memory and lost when application terminates
2. **No Database**: No persistent storage mechanism
3. **Single Admin**: Admin credentials are hardcoded
4. **No Appointment Slots**: No validation for appointment availability
5. **No Doctor Specialization**: Doctors don't have specialization tracking
6. **No Patient Medical History**: Limited patient health information storage

---

## Future Enhancements

- [ ] Integrate database (MySQL, PostgreSQL)
- [ ] Add persistent data storage
- [ ] Implement appointment scheduling with conflict detection
- [ ] Add doctor specialization and availability
- [ ] Implement patient medical history
- [ ] Add prescription management
- [ ] Implement billing system
- [ ] Create GUI interface
- [ ] Add email notifications
- [ ] Implement role-based access control (RBAC)

---

## Author Notes

This is a Low-Level Design (LLD) implementation, suitable for learning and understanding system design concepts. For production use, consider implementing:

- Proper database management
- REST API endpoints
- Web-based frontend
- Enhanced security mechanisms
- Comprehensive error handling

---

## License

Open source for educational purposes.

---

**Status**: All functionalities tested and working ✓ (Last updated: May 11, 2026)
