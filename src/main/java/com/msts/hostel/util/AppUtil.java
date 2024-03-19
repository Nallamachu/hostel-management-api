package com.msts.hostel.util;

import java.util.List;

public class AppUtil {

    public boolean isValid(String value) {
        return value != null && !value.trim().isBlank() && value.trim().length()>0;
    }

    public boolean isEmpty(List list) {
        return list !=null && list.size()>0;
    }
}
