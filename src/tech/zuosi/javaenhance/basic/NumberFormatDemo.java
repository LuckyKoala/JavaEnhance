package tech.zuosi.javaenhance.basic;

import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * Created by iwar on 2017/6/24.
 */
public class NumberFormatDemo {
    public static void main(String[] args) {
        String str = "-123.5";
        System.out.println(isNumeric(str));
        System.out.println("Test finished!");
        /*
        //Tried to look up to source code of implement applied here
        Locale locale = Locale.getDefault(Locale.Category.FORMAT);
        LocaleProviderAdapter adapter = LocaleProviderAdapter.getAdapter(NumberFormatProvider.class, locale);
        NumberFormatProvider provider = adapter.getNumberFormatProvider();
        NumberFormat numberFormat = provider.getNumberInstance(locale);
        */
    }
    private static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
