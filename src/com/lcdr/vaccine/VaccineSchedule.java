package com.lcdr.vaccine;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class VaccineSchedule {
    List<Date> vaccinesDue;
    int numberOfVaccinesAdministered;

    public int getNumberOfVaccinesAdministered() {
        return numberOfVaccinesAdministered;
    }

    public void setNumberOfVaccinesAdministered(int numberOfVaccinesAdministered) {
        this.numberOfVaccinesAdministered = numberOfVaccinesAdministered;
    }



    public List<Date> getVaccinesDue() {
        return vaccinesDue;
    }

    public int addVaccineDueDate(Date dueDate) {
        vaccinesDue.add(dueDate);
        return vaccinesDue.size();
    }

    public Date getNextDueVaccine() {
        return vaccinesDue.get(numberOfVaccinesAdministered);
    }

    public VaccineSchedule(List<Date> vaccinesDue, int numberOfVaccinesAdministered) {
        this.vaccinesDue = vaccinesDue;
        this.numberOfVaccinesAdministered = numberOfVaccinesAdministered;
    }

    public VaccineSchedule() {
        this.numberOfVaccinesAdministered = 0;
        this.vaccinesDue = new LinkedList<>();
    }
}
