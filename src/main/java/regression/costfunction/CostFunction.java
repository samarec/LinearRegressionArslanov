package regression.costfunction;

import org.jblas.DoubleMatrix;

public interface CostFunction {

    public double computeCost(DoubleMatrix features, DoubleMatrix values, DoubleMatrix theta);

}
