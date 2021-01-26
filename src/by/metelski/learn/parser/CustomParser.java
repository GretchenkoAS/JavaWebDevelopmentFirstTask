package by.metelski.learn.parser;

import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.validation.CheckStringFromFile;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParser {
    public static final String PATTERN_NUMBER = "-*\\d+";
    public final static Logger logger = LogManager.getLogger();

    public int[] parseArrayFromString(String string) throws CustomArrayException {

        Pattern pattern = Pattern.compile(PATTERN_NUMBER);
        Matcher matcher = pattern.matcher(string);
        int arraySize = findArraySize(pattern, string);
        int[] array = new int[arraySize];
        int counter = 0;

        while (matcher.find()) {
            array[counter] = Integer.parseInt(matcher.group());
            counter++;
        }
        logger.log(Level.INFO,"return parsed array" + Arrays.toString(array));
        return array;
    }

    private static int findArraySize(Pattern pattern, String string) {
        Matcher matcher = pattern.matcher(string);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }
}
