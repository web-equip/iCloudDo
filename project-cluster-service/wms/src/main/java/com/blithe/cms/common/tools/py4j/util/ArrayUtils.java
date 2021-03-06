package com.blithe.cms.common.tools.py4j.util;

import java.util.HashSet;

/**
 * @author jnyou
 */
public class ArrayUtils {

    private ArrayUtils() {}

    public static String[] distinct(String[] arr) {
        if(arr==null || arr.length==0) {
            return arr;
        }
        HashSet<String> set = new HashSet<>();
        for (String str : arr) {
            set.add(str);
        }
        return set.toArray(new String[0]);
    }
}
