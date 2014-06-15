/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.danidemi.tutorial.datetime;

import static java.lang.String.format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

/**
 *
 * @author danidemi
 */
public class J001DateTime {
    
    public static void main(String[] args) {
        new J001DateTime().run();
    }

    private void run() {
        
        // Let's start with a date (date only! No seconds!)
        LocalDate today = LocalDate.now();
        System.out.println(today); // Prints something like '2014-06-15'
        
        // Many factory methods, throwing uncatched exceptions.
        try{
            LocalDate.of(1972, Month.NOVEMBER, 31);
        }catch(java.time.DateTimeException dte){
            dte.printStackTrace();
        }
        
        LocalDate.of(1972, Month.NOVEMBER, 14);
        
        // A month of a specific year.
        System.out.println(YearMonth.now()); // Prints something like 2014-06
        // A year
        Year year = Year.now();
        System.out.println(format("%s is leap ? %s", year, year.isLeap())  ); // Prints something like 2014
        
        System.out.println( LocalTime.now() ); // Prints something like 17:02:44.224
        
        System.out.println( LocalDateTime.now() ); // Prints something like 2014-06-15T17:03:38.396
        
    }
    
}
