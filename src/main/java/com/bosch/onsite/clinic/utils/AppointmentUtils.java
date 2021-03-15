package com.bosch.onsite.clinic.utils;

import com.bosch.onsite.clinic.entities.Appointment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentUtils {
    public static boolean hasAlreadyBookedAppointment(Appointment appointment, String appointmentDateTime) {
        String oldAppointment = appointment.getDateOfAppointment();
        LocalDateTime currentTime = LocalDateTime.now();

        // check current appointment not conflicting the current hour
        LocalDateTime oldAppointmentIso = LocalDateTime.parse(oldAppointment, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime bookedAppointmentIso = LocalDateTime.parse(appointmentDateTime, DateTimeFormatter.ISO_DATE_TIME);
        int oldAppointmentHour = oldAppointmentIso.getHour();

        // any appointment starting same hour or check was there ay appointment already booked
        if (oldAppointmentHour == currentTime.getHour() || oldAppointmentIso.isEqual(bookedAppointmentIso)) {
            // raise exception for appointment conflict
            return true;
        }

        return false;
    }

    public static boolean isTodaysAppointment(Appointment appointment) {
        return LocalDateTime.parse(appointment.getDateOfAppointment(), DateTimeFormatter.ISO_DATE_TIME)
                .isBefore(LocalDateTime.now().plusDays(1));
    }
}
