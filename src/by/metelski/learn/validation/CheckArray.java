package by.metelski.learn.validation;

import by.metelski.learn.entity.CustomArray;

public class CheckArray {
    public static boolean isArrayValid(CustomArray customArray) {
        int[] array = customArray.getArray();
        return array != null && array.length > 0;
    }

}
