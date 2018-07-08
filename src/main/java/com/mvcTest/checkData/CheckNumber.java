package com.mvcTest.checkData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CheckNumber {

    public static int checkPhone(String number){
        Pattern p = Pattern.compile("^\\+380\\d{9}$");
        Matcher m = p.matcher(number);
        if (m.matches()) {
            return 0;
        } else {
            return 1;
        }
    }
}

