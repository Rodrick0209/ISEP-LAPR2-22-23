package pt.ipp.isep.dei.esoft.project.domain;


public class RegressionResults {
    private double slope;
    private double intercept;
    private double[] parameters;

    public RegressionResults(double slope, double intercept) {
        this.slope = slope;
        this.intercept = intercept;
    }

    public RegressionResults(double[] parameters) {
        this.parameters = parameters;
    }

    public double getSlope() {
        return slope;
    }

    public double getIntercept() {
        return intercept;
    }

    public double[] getParameters() {
        return parameters;
    }


}
