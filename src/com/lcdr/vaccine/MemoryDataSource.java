package com.lcdr.vaccine;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MemoryDataSource implements VaccineDataStore{

    protected List<VaccineEntry> entires;


    @Override
    public List<VaccineEntry> getAllDogs() {
       return entires;
    }

    @Override
    public List<VaccineEntry> getDog(String name) {
        List<VaccineEntry> result = new LinkedList<>();
        for(VaccineEntry entry : entires) {
            if(entry.Name().equals(name)) {
                result.add(entry);
            }
        }
        return result;
    }

    @Override
    public List<VaccineEntry> getDogsWithVaccinesDue() {
        List<VaccineEntry> result = new LinkedList<>();
        for(VaccineEntry entry: entires) {
            if(entry.schedule().getVaccinesDue().size() > entry.schedule().getNumberOfVaccinesAdministered()) {
                result.add(entry);
            }
        }
        return result;
    }

    @Override
    public List<VaccineEntry> getDogsWithVaccinesDue(Date startDate, Date endDate) {
       return getDogsWithVaccinesDue(startDate, endDate, false);
    }

    @Override
    public List<VaccineEntry> getDogsWithVaccinesDue(Date startDate, Date endDate, boolean onlyIncludeNextDueVaccine) {
        List<VaccineEntry> result = new LinkedList<>();
        for(VaccineEntry entry: entires) {
            if(!onlyIncludeNextDueVaccine) {
                for (Date duedate : entry.schedule().getVaccinesDue()) {
                    if(duedate.after(startDate) && duedate.before(endDate)) {
                        result.add(entry);
                        break;
                    }
                }
            } else {
                Date nextDue = entry.schedule().getNextDueVaccine();
                if(nextDue.after(startDate) && nextDue.before(endDate)) {
                    result.add(entry);
                }
            }
        }
        return result;
    }
}
