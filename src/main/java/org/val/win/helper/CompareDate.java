package org.val.win.helper;

import java.time.LocalDate;
import java.time.Period;

public class CompareDate {

    public static boolean compareDate(LocalDate currentDate, LocalDate futureDate) {
        boolean flag = true;
        Period p = Period.between(currentDate, futureDate);
        if (p.getDays() > 56) {
            flag = false;
        }
        return flag;
    }
}
