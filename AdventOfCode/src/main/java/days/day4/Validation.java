package days.day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
interface Validation {
    Boolean isValid(String input);
}
