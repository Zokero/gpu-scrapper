package com.cpuscrp.scrapp.model;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Slf4j
@UtilityClass
public class PriceFormatter {

    public Optional<Double> getPriceFromString(String string) {
        NumberFormat format = NumberFormat.getInstance(new Locale("pl", "PL"));
        try {
            return Optional.of(format.parse(removeWhiteSpaces(replaceDotsForComma(string.replace("od", "")))).doubleValue());
        } catch (ParseException e) {
            log.error("Cannot parse the price" + string);
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private String replaceDotsForComma(String priceString) {
        return priceString.replace(".", ",");
    }

    private String removeWhiteSpaces(String string) {
        return string.replace(" ", "");
    }
}
