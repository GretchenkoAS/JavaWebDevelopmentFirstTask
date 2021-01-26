package by.metelski.learn.action;

import by.metelski.learn.entity.CustomArray;
import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.validation.CheckArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

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

    public void bubbleSortCustomArray(CustomArray customArray) {
        boolean isSorted = false;
        int temp;
        int[] array = customArray.getArray();
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
        }
        customArray.setArray(array);
        logger.log(Level.INFO,"sorted array: " + customArray.toString());
    }

    public void insertionSortCustomArray(CustomArray customArray) {
        int[] array = customArray.getArray();
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int position = i - 1;
            while (position >= 0 && current < array[position]) {
                array[position + 1] = array[position];
                position--;
            }
            array[position + 1] = current;
        }
        customArray.setArray(array);
        logger.log(Level.INFO,"sorted array: " + customArray.toString());
    }

    public void selectionSortCustomArray(CustomArray customArray) {
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int indexMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    indexMin = j;
                }
            }
            swap(array, i, indexMin);
        }
        customArray.setArray(array);
        logger.log(Level.INFO,"sorted array: " + customArray.toString());
    }

    private void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
