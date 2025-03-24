package ca.dal.cs.csci3130.a4.util;

import java.text.DecimalFormat;

public class NumberUtility {
    public static String format2Currency(double number){
        DecimalFormat decFormat=new DecimalFormat("0.00");
        return "$"+decFormat.format(number);
    }

}
