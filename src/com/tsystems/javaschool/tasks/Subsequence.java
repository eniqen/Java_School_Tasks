/**
 * Java School at T-Systems CIS, 2012
 */
package com.tsystems.javaschool.tasks;

import java.util.List;

/**
 * Interface for Subsequence task
 */
public interface Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     * 
     * @param x
     *            first sequence
     * @param y
     *            second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    boolean find(List x, List y);

}
