package org.val.win.helper;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.Period;

public class CompareDate {

    public static boolean compareDate(XMLGregorianCalendar currentDate, XMLGregorianCalendar futureDate) {

        LocalDate dateDebut = currentDate.toGregorianCalendar().toZonedDateTime().toLocalDate();
        LocalDate dateFin = futureDate.toGregorianCalendar().toZonedDateTime().toLocalDate();

        boolean flag = true;
        Period p = Period.between(dateDebut, dateFin);
        if (p.getDays() > 56) {
            flag = false;
        }
        return flag;
    }
}
