package org.val.win.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.Period;

public class CompareDate {

    public static final Logger logger = LogManager.getLogger(CompareDate.class);

    /**
     * Methode qui servira a comparer l'écart entre deux dates
     * @param debutEmprunt la date de début d'un emprunt
     * @param finEmprunt la date de fin d'un emprunt
     * @return un boolean : true si l'écart est inférieur a 2 mois, false s'il est supérieur
     */
    public static boolean compareDate(XMLGregorianCalendar debutEmprunt, XMLGregorianCalendar finEmprunt) {

        LocalDate dateDebut = debutEmprunt.toGregorianCalendar().toZonedDateTime().toLocalDate();
        LocalDate dateFin = finEmprunt.toGregorianCalendar().toZonedDateTime().toLocalDate();

        boolean flag = true;
        Period p = Period.between(dateDebut, dateFin);
        if (p.getMonths() > 2) {
            flag = false;
        }
        logger.info("les dates : " + dateDebut + " et " + dateFin + " on été comparées, le résultat est " + flag );
        return flag;

    }
}
