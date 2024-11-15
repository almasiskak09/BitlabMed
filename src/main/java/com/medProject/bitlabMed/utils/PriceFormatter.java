package com.medProject.bitlabMed.utils;


import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormatter {

    public static String formatPrice(int price) {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("ru","RU"));
        return formatter.format(price);
    }
}
