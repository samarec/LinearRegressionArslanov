package regression.linearregression;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;
import regression.costfunction.CostFunction;

public class SquaredDifferenceCostFunction implements CostFunction {

    public double computeCost(DoubleMatrix features, DoubleMatrix values, DoubleMatrix theta) {
        int size = values.getRows();
        DoubleMatrix predictions = features.mmul(theta);
        DoubleMatrix sub = predictions.sub(values);
        DoubleMatrix sqrErrors = MatrixFunctions.pow(sub, 2);
        return sqrErrors.sum() / (2*size);
    }
}
