package com.bornstone.stonehenge.entity.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by king on 15-5-4.
 */
public class Mobile {
    public static boolean isMobile(String mobile) {
        Pattern p = Pattern.compile("^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(Mobile.isMobile("13400000000"));
    }
}
