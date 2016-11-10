package com;

import org.apache.commons.lang.math.NumberUtils;

public class Calculator {

    public static void main(String[] args) {
        if (args.length > 1) {

            if (NumberUtils.isNumber(args[0]) && NumberUtils.isNumber(args[1])) {
                int numberF = Integer.valueOf(args[0]);
                int numberS = Integer.valueOf(args[1]);
                int sum = numberF + numberS;
                System.out.println(numberF + " + " + numberS + " = " + sum);

            } else {

                System.out.println("Please input numbers");

            }

        } else {

            System.out.println("Please input 2 arguments");

        }
    }
}
