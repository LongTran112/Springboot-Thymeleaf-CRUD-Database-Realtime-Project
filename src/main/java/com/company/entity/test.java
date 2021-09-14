package com.company.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

public class test {
    public static void main(String[] args) {
        Date now = new Date(System.currentTimeMillis());
        System.out.println(now);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
    }
}
