package org.val.win.helper;

import java.time.LocalDate;
import java.time.Period;

public class CompareDate {

    public static boolean compareDate(LocalDate currentDate, LocalDate futureDate) {
        boolean flag = false;
        Period p = Period.between(currentDate, futureDate);
        if (p.getMonths() <= 1) {
            flag = true;
        }
        return flag;
    }
}
