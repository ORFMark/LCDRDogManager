package com.lcdr.vaccine;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VaccineScheduleTest {

    @Test
    void getNumberOfVaccinesAdministered() {
        VaccineSchedule testSchedule = new VaccineSchedule();
        assertEquals(0, testSchedule.getNumberOfVaccinesAdministered());
    }

    @Test
    void setNumberOfVaccinesAdministered() {
        VaccineSchedule testSchedule = new VaccineSchedule();
        testSchedule.setNumberOfVaccinesAdministered(4);
        assertEquals(4, testSchedule.getNumberOfVaccinesAdministered());
    }

    @Test
    void getVaccinesDue() {
        VaccineSchedule testSchedule = new VaccineSchedule();
        assertEquals(Collections.emptyList(), testSchedule.getVaccinesDue());
    }

    @Test
    void addVaccineDueDate() {
        Date firstDue = new Date();
        VaccineSchedule testSchedule = new VaccineSchedule();
        testSchedule.addVaccineDueDate(firstDue);
        assertEquals(firstDue, testSchedule.getNextDueVaccine());
    }

    @Test
    void getNextDueVaccine() {
        List<Date> testVaccineDates = new LinkedList<>();
        Date firstDue = new Date();
        testVaccineDates.add(firstDue);
        VaccineSchedule testSchedule = new VaccineSchedule(testVaccineDates, 0);
        assertEquals(firstDue, testSchedule.getNextDueVaccine());
    }
}