package com.ccy.utils;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

/**
 * Created by dsz on 17/6/20.
 */
public class AnalyseUtil {
    public static void main(String[] args) {
        PearsonsCorrelation pearsonsCorrelation = new PearsonsCorrelation();
        double result = pearsonsCorrelation.correlation(new double[]{1, 2.2, 3.3},
                new double[]{2.2, 3.3, 4.4});
        System.out.print(result);
    }
}
