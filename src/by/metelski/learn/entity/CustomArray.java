package by.metelski.learn.entity;

import by.metelski.learn.exception.CustomArrayException;
import by.metelski.learn.validation.CheckArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArray {
    public final static Logger logger = LogManager.getLogger();

    private int[] array;

    public int[] getArray() {
        logger.log(Level.INFO, "get array");
        return array.clone();
    }

    public int getArrayElementByIndex(int index) throws CustomArrayException {
        if(index <= array.length-1 & index>=0) {
            logger.log(Level.INFO, "get element " + array[index] + " index: " + index);
            return array[index];
        }else {
            throw new CustomArrayException("Index Out of bond");
        }
    }

    public void setArrayElementNyIndex(int index, int element) throws CustomArrayException {
        if(index <= array.length-1 & index>=0) {
            array[index] = element;
            logger.log(Level.INFO, "set element " + element + " index: " + index);
        } else {
            throw new CustomArrayException("Index Out of bond");
        }
    }

    public void setArray(int[] array) {
        this.array = array;
        logger.log(Level.INFO, "set array");
    }

}
