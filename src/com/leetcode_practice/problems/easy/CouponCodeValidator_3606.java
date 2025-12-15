package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class CouponCodeValidator_3606 {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> validCoupons = new ArrayList<>();
        Set<String> validBusinesses = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        int n = code.length;
        for (int i = 0; i < n; i++) {
            if (!isActive[i] || !validBusinesses.contains(businessLine[i]) || code[i].length() == 0)
                continue;
            boolean isValid = true;
            for (int j = 0; j < code[i].length(); j++) {
                char ch = code[i].charAt(j);
                if (!(Character.isLetterOrDigit(ch) || ch == '_')) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                validCoupons.add(new Coupon(code[i], businessLine[i]));
            }
        }

        Collections.sort(validCoupons, Comparator.comparing((Coupon a) -> a.business).thenComparing(a -> a.code));
        List<String> res = new ArrayList<>();
        for (Coupon coupon : validCoupons) {
            res.add(coupon.code);
        }
        return res;
    }
}

class Coupon {
    String code;
    String business;

    public Coupon(String code, String business) {
        this.code = code;
        this.business = business;
    }
}
