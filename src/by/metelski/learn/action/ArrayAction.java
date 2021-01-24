package by.metelski.learn.action;

import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.validation.CheckArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayAction {
    public final static Logger logger = LogManager.getLogger();

    public void replaceAllNegativeElements(CustomArray customArray, int numberToReplace) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        logger.log(Level.INFO, "replaceAllNegativeElements, number to replace: " + numberToReplace);
        for (int i = 0; i < customArray.getArray().length; i++) {
            if (customArray.getArrayElementByIndex(i) < 0) {
                customArray.setArrayElementNyIndex(i, 0);
            }
        }
        logger.log(Level.INFO, "all negative elements replaced for number: " + numberToReplace);

    }

    public void replaceAllNumbersAboveNine(CustomArray customArray, int numberToReplace) throws CustomArrayException {
        if (!CheckArray.isArrayValid(customArray)) {
            throw new CustomArrayException("Illegal argument");
        }
        logger.log(Level.INFO, "replaceAllNumbersAboveNull, number to replace: " + numberToReplace);
        for (int i = 0; i < customArray.getArray().length; i++) {
            if (customArray.getArrayElementByIndex(i) > 9) {
                customArray.setArrayElementNyIndex(i, numberToReplace);
            }
        }
        logger.log(Level.INFO, "all elements above nine replaced for number: " + numberToReplace);

    }
}
