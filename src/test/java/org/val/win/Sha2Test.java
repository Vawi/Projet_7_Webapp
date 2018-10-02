package org.val.win;

import org.junit.Assert;
import org.junit.Test;
import org.val.win.helper.Sha2;

public class Sha2Test {

    String titi = "mdptest";

    @Test
    public void Sha512Test() {
        String toto = Sha2.getSHA512(titi);
        System.out.println(toto);
    }
}
