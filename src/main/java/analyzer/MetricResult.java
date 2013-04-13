package analyzer;

/**
 * This interface models a set of Metric results for a
 * MUMPS source code file located at a particular path
 * in the file system.
 * 
 * @author cbarthauer
 */
public interface MetricResult {
    /**
     * Get the value of the give metric as a double.
     * 
     * @param metric of interest.
     * @return The value associated with the given Metric.
     */
    public double getDouble(Metric metric);
    
    /**
     * Get the absolute path to the MUMPS source code file
     * whose results this object represents.
     * 
     * @return A String representation of the absolute 
     * file path.
     */
    public String getPath();
}
