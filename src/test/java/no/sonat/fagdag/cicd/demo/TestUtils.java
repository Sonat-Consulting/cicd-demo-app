package no.sonat.fagdag.cicd.demo;

import java.util.concurrent.ThreadLocalRandom;

public class TestUtils {

    public static String generateRandomString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int lenght = 10;

        StringBuilder buffer = new StringBuilder(lenght);

        for (int i = 0; i < lenght; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (ThreadLocalRandom.current().nextFloat() * ((rightLimit - leftLimit) + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }
}
