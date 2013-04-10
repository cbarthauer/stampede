package analyzer;

public interface MetricResult {
    public double getDouble(Metric metric);
    public String getPath();
}
