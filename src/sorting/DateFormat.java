package sorting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) {
        String date = "13 Jul 2022";
        String format = "dd MMM YYYY";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String current = dateFormat.format(new Date());
        System.out.println(date.equals(current));
    }
}

// //my-portfolio[@id='custodyOverview']//div[contains(@class, 'portfolioBox')]//a/following-sibling::span[normalize-space()]