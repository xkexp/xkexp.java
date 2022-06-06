package com.xkyss.mockneat;

import net.andreinc.mockneat.abstraction.MockUnitString;
import net.andreinc.mockneat.types.enums.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static net.andreinc.mockneat.unit.networking.URLs.urls;
import static net.andreinc.mockneat.unit.objects.From.fromStrings;
import static net.andreinc.mockneat.unit.regex.Regex.regex;
import static net.andreinc.mockneat.unit.text.Strings.strings;
import static net.andreinc.mockneat.unit.time.LocalDates.localDates;
import static net.andreinc.mockneat.unit.types.Ints.ints;

public class MockNeatTest {

    @Test
    public void test_01() {
        System.out.println(areaCode().get());
        System.out.println(xp().get());
        System.out.println(phone().get());
        System.out.println(localDates().between(LocalDate.now().minusYears(5), LocalDate.now()).mapToDate().get());
    }

    @Test
    public void test_02() {
        System.out.println(regex("[A-Z]{1}\\d{3}").get());
    }

    public MockUnitString xp() {
        return urls()
                .append("/")
                .append(strings().size(ints().range(5, 10)).get().toLowerCase())
                .append(".")
                .append(fromStrings(new String[] {"jpg", "png", "jpeg"}).get())
                ;
    }

    public MockUnitString areaCode() {
        return strings()
                .size(8)
                .type(StringType.NUMBERS)
                .prepend("430")
                ;
    }

    public MockUnitString phone() {
        return regex("13\\d{9}");
    }
}
