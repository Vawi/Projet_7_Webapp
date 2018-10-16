package org.val.win.helper;

import java.time.LocalDate;
import java.time.Period;

public class CompareDate {

    public static boolean compareDate(LocalDate currentDate, LocalDate futureDate) {
        boolean flag = true;
        Period p = Period.between(currentDate, futureDate);
        if (p.getMonths() >= 2) {
            flag = false;
        }
        return flag;
    }
}
