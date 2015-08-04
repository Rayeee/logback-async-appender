package br.org.roger.util;

/*************************************************************************
 *  Compilation:  javac Stopwatch.java
 *  Execution:    none
 *  Dependencies: none
 *
 *  A utility class to measure the running time (wall clock) of a
 *  program.
 *
 *************************************************************************/

/**
 *  The <tt>Stopwatch</tt> data type is for measuring
 *  the time that elapses between the start and end of a
 *  programming task (wall-clock time).
 *
 *  See {@link StopwatchCPU} for a version that measures CPU time.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */


public class Stopwatch { 

    private final long start;

    /**
     * Initialize a stopwatch object.
     */
    public Stopwatch() {
        start = System.currentTimeMillis();
    } 


    /**
     * Returns the elapsed time (in seconds) since this object was created.
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    /**
     * Returns the elapsed time (in milliseconds) since this object was created.
     */
    public double elapsedTimeInMillis() {
        long now = System.currentTimeMillis();
        return (now - start);
    }
} 