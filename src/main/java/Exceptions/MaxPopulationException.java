package Exceptions;

import java.util.ArrayList;

public class MaxPopulationException extends Exception {
    public MaxPopulationException(String name, ArrayList arrayList, int maxSize) {
        super(name + " size: " + Integer.toString(arrayList.size()) + ", exceeded max size: " + Integer.toString(maxSize));
    }
}
