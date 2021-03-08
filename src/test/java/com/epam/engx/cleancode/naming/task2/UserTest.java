package com.epam.engx.cleancode.naming.task2;

import org.junit.Test;

import static com.epam.engx.cleancode.naming.task2.UserTestHelper.getAdminUser;
import static org.junit.Assert.assertEquals;

public class UserTest {

    private static final String EXPECTED_TO_STRING_VALUE_FOR_BOB = "User [dateOfBirth=14.02.1974, name=Bob, " +
            "isAdmin=false, subordinates=[], rating=0]";
    private static final String EXPECTED_TO_STRING_VALUE_FOR_SUBORDINATES = "User [dateOfBirth=19.08.1968, name=Alex, isAdmin=false, subordinates=" +
            "[User [dateOfBirth=14.02.1974, name=Bob, isAdmin=false, subordinates=[], rating=0], " +
            "User [dateOfBirth=22.05.1981, name=Tom, isAdmin=false, subordinates=" +
            "[User [dateOfBirth=08.06.1983, name=Peter, isAdmin=false, subordinates=[], rating=0]], rating=0]], rating=0]";
    private static final String EXPECTED_TO_STRING_VALUE_FOR_BOB_WITH_RATING = "User [dateOfBirth=14.02.1974, name=Bob," +
            " isAdmin=true, subordinates=[], rating=33]";

    private final User bob = new User("Bob", "14.02.1974", new User[0]);
    private final User peter = new User("Peter", "08.06.1983", new User[0]);
    private final User tom = new User("Tom", "22.05.1981", new User[]{peter});
    private final User alex = new User("Alex", "19.08.1968", new User[]{bob, tom});

    @Test
    public void shouldPrintUser() {
        assertEquals(EXPECTED_TO_STRING_VALUE_FOR_BOB, bob.toString());
    }

    @Test
    public void shouldPrintUserWithSubordinates() {
        assertEquals(EXPECTED_TO_STRING_VALUE_FOR_SUBORDINATES, alex.toString());
    }

    @Test
    public void shouldPrintAdminUserWithRating() {
        bob.setRating(33);
        assertEquals(EXPECTED_TO_STRING_VALUE_FOR_BOB_WITH_RATING, getAdminUser(bob).toString());
    }
}
