package com.example.lishan.answerapp.common;

import java.util.regex.Pattern;

/**
 * Created by lishan on 2018/2/27.
 */

public class MyTool {
    public final static String PHONE_PATTERN = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    /**
     * 判断是否是合法手机号码（手机号码段详见：http://baike.baidu.com/view/781667.htm#2）
     *
     * @param phone：手机号码
     * @return boolean
     */
    public static boolean isPhoneRegex(String phone) {
        return Pattern.matches(PHONE_PATTERN, phone);
    }

}
