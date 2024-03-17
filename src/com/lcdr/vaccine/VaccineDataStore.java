package com.lcdr.vaccine;

import java.util.Date;
import java.util.List;

public interface VaccineDataStore {
    List<VaccineEntry> getAllDogs();
    List<VaccineEntry> getDog(String name);

    List<VaccineEntry> getDogsWithVaccinesDue();

    List<VaccineEntry> getDogsWithVaccinesDue(Date startDate, Date endDate);
    List<VaccineEntry> getDogsWithVaccinesDue(Date startDate, Date endDate, boolean onlyIncludeNextDueVaccine);

}
