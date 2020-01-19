package com.liuqidong;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        String str = "{\"primaryProvinceScore\":\"\",\"primaryCityScore\":\"\",\"primaryAreaScore\":\"\",\"primaryExcellentScore\":\"\",\"primaryWellScore\":\"\",\"primaryCommonScore\":\"\",\"primaryBadScore\":\"\",\"onePrimaryDistanceEnd\":\"\",\"onePrimaryDistanceScore\":\"\",\"twoPrimaryDistanceBegin\":\"\",\"twoPrimaryDistanceScore\":\"\",\"juniorProvinceScore\":\"\",\"juniorCityScore\":\"\",\"juniorAreaScore\":\"\",\"juniorExcellentScore\":\"\",\"juniorWellScore\":\"\",\"juniorCommonScore\":\"\",\"juniorBadScore\":\"\",\"kindergartenExampleScore\":\"\",\"kindergartenProvinceScore\":\"\",\"kindergartenCityScore\":\"\",\"kindergartenAreaScore\":\"\",\"kindergartenPublicrunScore\":\"\",\"kindergartenCivilrunScore\":\"\",\"kindergartenOneNumScore\":\"\",\"kindergartenTwoNumScore\":\"\"}";
//        System.out.println(str.length());
//        JSONObject jsonObject = JSON.parseObject(str);
//        System.out.println(jsonObject.get("oneSaleRateEnd"));

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyyMM")));
        localDate = localDate.minusMonths(11);
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyyMM")));

        BigDecimal bigDecimal = new BigDecimal(100);
        bigDecimal = bigDecimal.add(new BigDecimal("200"));
        System.out.println(bigDecimal);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Stream<Integer> stream = list.stream().filter(num -> num ==5);
        System.out.println(stream.count());
        String str1 = "PUBLICRUN";
        String str2 = "PUBLICRUN";

        BigDecimal bigDecimal1 = new BigDecimal(0);
        BigDecimal bigDecimal2 = new BigDecimal(Double.MIN_VALUE);
        System.out.println(bigDecimal1.compareTo(bigDecimal2));


    }
}
