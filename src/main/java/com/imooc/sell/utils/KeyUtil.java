package com.imooc.sell.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：sell
 * <dd>类名称：KeyUtil
 * <dd>类描述：
 * <dd>创建人：曹佩强
 * <dd>创建时间：2019/5/27
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 *
 * @version 1.0
 * @Author 曹佩强
 */
public class KeyUtil {

    private static String getLocalDateTime(){
        LocalDateTime time = LocalDateTime.now();
        String s = time.toString();
        return s;
    }

    private static String getLocalDate(){
        LocalDate date = LocalDate.now();
        String s = date.toString();
        String[] split = s.split("-");

        String localDate = "";

        for (String s1 : split) {
            localDate += s1;
        }
        return localDate + "-";
    }

    public static synchronized String getUniqueKey(){

        Random random = new Random();
        Integer number = random.nextInt(900000) + 10000;
        return   (getLocalDateTime() +"-"+ number);
    }



}
