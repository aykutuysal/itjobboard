package aykutuysal.jewel.util;

import org.apache.log4j.Logger;

public class Stopwatch {
	
	private static final Logger logger = Logger.getLogger(Stopwatch.class);

	private String name;
    private long start;
    

    public Stopwatch(String name) {
    	this.name = name;
        this.start = System.nanoTime();
    }

    public void stop() {
        double elapsed = (System.nanoTime() - start) / 1000000.0;
        logger.info("STOPWATCH " + name + " took: " + elapsed + " ms");
    }
}
