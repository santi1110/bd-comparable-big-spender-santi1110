package com.amazon.ata.comparable_comparator_sort.bigspender.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer nedflixCustomer;
    private LocalDate nedflixJoinDate;
    private LocalDate laterJoinDate;

    @BeforeEach
    void setUp() throws Exception {
        nedflixJoinDate = LocalDate.of(2008, 10, 11);
        laterJoinDate = LocalDate.of(2009, 1, 1);
        nedflixCustomer = new Customer("nedflix", nedflixJoinDate);
    }

    // PARTICIPANTS: add implementations to these tests of compareTo:

    @Test
    void compareTo_withAnEqualCustomer_returnsZero() {
        // GIVEN
        Customer equalCustomer = new Customer("nedflix",nedflixJoinDate);
        // WHEN
        int result = nedflixCustomer.compareTo(equalCustomer);
        // THEN
        assertEquals(0,result, "Expected compareTo to return 0 for equal customer");
    }

    @Test
    void compareTo_withLaterCustomerName_returnsNegative() {
        // GIVEN
        Customer customerWithLaterName = new Customer("tedflix", nedflixJoinDate);
        // WHEN
        int result = nedflixCustomer.compareTo(customerWithLaterName);

        // THEN
        assertTrue(result < 0, "Expected compareTo to return negative for customer with later name");
    }

    @Test
    void compareTo_withEarlierCustomerName_returnsPositive() {
        //THEN
        Customer customerWithLaterName = new Customer("edflix", nedflixJoinDate);
        // WHEN
        int result = nedflixCustomer.compareTo(customerWithLaterName);

        // THEN
        assertTrue(result > 0, "Expected compareTo to return positive for customer with later name");
    }

    @Test
    void compareTo_withSameCustomerNameLaterJoinDate_returnsNegative() {
        // GIVEN
        Customer customerWithLaterName = new Customer("tom",LocalDate.of(2024,5,1));
        // WHEN
        int result = nedflixJoinDate.compareTo(customerWithLaterName.getJoinDate());

        // THEN
        assertTrue(result < 0, "Expected compareTo to return negative for join date");
    }

    @Test
    void compareTo_withSameCustomerNameEarlierJoinDate_returnsPositive() {
        // GIVEN
        Customer customerWithLaterName = new Customer("tom",LocalDate.of(2005,5,1));
        // WHEN
        int result = nedflixJoinDate.compareTo(customerWithLaterName.getJoinDate());

        // THEN
        assertTrue(result > 0, "Expected compareTo to return negative for join date");
    }

    // PARTICIPANTS: leave these tests below alone

    @Test
    void equals_inputObjectNull_returnsFalse() throws Exception {
        // WHEN
        boolean result = nedflixCustomer.equals(null);

        // THEN
        assertFalse(result, "Customer should not be equal to null!");
    }

    @Test
    void equals_inputObjectDifferentType_returnsFalse() {
        // WHEN
        boolean result = nedflixCustomer.equals("nedflix");

        // THEN
        assertFalse(result, "Customer should not be equal to a different type!");
    }

    @Test
    void equals_sameObject_returnsTrue() {
        // WHEN
        boolean result = nedflixCustomer.equals(nedflixCustomer);

        // THEN
        assertTrue(result, "Customer should be equal to a itself!");
    }

    @Test
    void equals_equalAttributes_returnsTrue() throws Exception {
        // GIVEN
        Customer same = new Customer("nedflix", nedflixJoinDate);

        // WHEN
        boolean result = nedflixCustomer.equals(same);

        // THEN
        assertTrue(result, "Customer should be equal to one with same attributes!");
    }

    @Test
    void equals_notEqualName_returnsFalse() {
        // GIVEN
        Customer other = new Customer("reddthem", nedflixJoinDate);

        // WHEN
        boolean result = nedflixCustomer.equals(other);

        // THEN
        assertFalse(result, "Customer should not be equal to one with a different name!");
    }

    @Test
    void equals_notEqualDate_returnsFalse() {
        // GIVEN
        Customer other = new Customer("nedflix", laterJoinDate);

        // WHEN
        boolean result = nedflixCustomer.equals(other);

        // THEN
        assertFalse(result, "Customer should not be equal to one with a different join date!");
    }
}