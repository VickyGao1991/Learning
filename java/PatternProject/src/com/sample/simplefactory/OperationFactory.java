package com.sample.simplefactory;

public class OperationFactory {

    public static Operation getOperation(String operate) {
        if ("+".equals(operate)) {
            return new AddOperation();
        } else if ("-".equals(operate)) {
            return new SubOperation();
        }
        return null;
    }
}
