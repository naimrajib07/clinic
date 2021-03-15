## Seed Data Preparation
For initial test, we are creating 5 test doctors and 5 patient with 5 initial appointment for each.

## Available API's
    1. Appointments
        1.1 Create
            URL: http://localhost:8080/appointments
            Method: POST
            RequestBody:
                {
                    "dateOfAppointment": "2021-03-14T12:00:36",
                    "doctor": {
                        "id": 4,
                        "firstName": "doctor-4",
                        "lastName": "lastname",
                        "email": "doctor-4.lastname@email.com",
                        "specialities": "General Practitioner"
                    },
                    "patient": {
                        "id": 2,
                        "firstName": "patient-2",
                        "lastName": "lastname",
                        "email": "patient-2.lastname@email.com"
                    }
                }
        1.2 All Appointments
            URL: http://localhost:8080/appointments
            Method: GET
        1.3 Doctors Appointment
            URL: http://localhost:8080/appointments/doctors/{doctorId}
                e.g http://localhost:8080/appointments/doctors/1
            Method: GET
        1.3 Patients Appointment
            URL: http://localhost:8080/appointments/patients/{patientId}
                e.g http://localhost:8080/appointments/patients/1
            Method: GET
    2. Doctors
        2.1 All Doctors
            URL: http://localhost:8080/doctors
            Method: GET
        2.2 Create
            URL: http://localhost:8080/doctors
            Method: POST
            RequestBody:
                {
                    "firstName": "dr. rajiv",
                    "lastName": "naim",
                    "email": "rajiv.naim@email.com",
                    "specialities": "General Practitioner"
                }
    3. Patients
        2.1 All Patients
            URL: http://localhost:8080/patients
            Method: GET
        2.2 Create
            URL: http://localhost:8080/patients
            Method: POST
            RequestBody:
                {
                    "firstName": "patient100000",
                    "lastName": "patientLastName",
                    "email": "patient100000.patientLastName@email.com"
                }

## Assumption and Implementation
    1. All appointments is last for 1 hour
    2. Exception handly only done for AppointmentConflictException
        other excetion might requires to handle but skiped for now due to time constraint
    3. Unit test and Integration test not covered because of time constraint
    4. Seed Data will be creat automatically startup of the application and no data will persist 
        except this seed data after each shutdown of webserver
