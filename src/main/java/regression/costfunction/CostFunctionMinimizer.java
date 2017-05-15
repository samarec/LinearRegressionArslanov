package regression.costfunction;

import org.jblas.DoubleMatrix;

public interface CostFunctionMinimizer {

    public DoubleMatrix minimizeCostFunction(DoubleMatrix features, DoubleMatrix values);
}
