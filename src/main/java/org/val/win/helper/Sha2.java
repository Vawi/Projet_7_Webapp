package org.val.win.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Sha2 {

    public static final Logger logger = LogManager.getLogger(CompareDate.class);

    /**
     * Methode pour crypter le mot de passe et le pseudonyme de l'utilisateur
     * @param input la chaine de caractère à crypter
     * @return la chaine de caractère cryptée
     */
    public static String getSHA512(String input){

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("La chaine de caractère : " + input + " a bien été cryptée");

        return toReturn;
    }

}
