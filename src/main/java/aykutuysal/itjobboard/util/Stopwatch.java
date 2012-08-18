package aykutuysal.itjobboard.util;

public class Stopwatch {
	
	private String name;
    private long start;

    public Stopwatch(String name) {
    	this.name = name;
        this.start = System.nanoTime();
    }

    public void stop() {
        double elapsed = (System.nanoTime() - start) / 1000000.0;
        System.out.println("STOPWATCH " + name + " took: " + elapsed + " ms");
    }
}
