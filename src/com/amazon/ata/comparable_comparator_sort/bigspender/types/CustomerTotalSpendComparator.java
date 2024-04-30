package com.amazon.ata.comparable_comparator_sort.bigspender.types;

import java.util.Comparator;

public class CustomerTotalSpendComparator implements Comparator<CustomerTotalSpend> {
    @Override
    public int compare(CustomerTotalSpend cts1, CustomerTotalSpend cts2) {
        if (cts1.equals(cts2)) {
            return 0;
        } else {
            if (cts1.getTotalSpend() != cts2.getTotalSpend()){
                return (int) (cts1.getTotalSpend() - cts2.getTotalSpend());
            } else {
                return cts1.getCustomer().compareTo(cts2.getCustomer());
        }
        }
    }
}
