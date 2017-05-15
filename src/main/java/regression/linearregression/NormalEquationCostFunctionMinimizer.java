package regression.linearregression;

import org.jblas.DoubleMatrix;
import org.jblas.Solve;
import regression.costfunction.CostFunctionMinimizer;

public class NormalEquationCostFunctionMinimizer implements CostFunctionMinimizer {

    public DoubleMatrix minimizeCostFunction(DoubleMatrix features, DoubleMatrix values) {
        DoubleMatrix featureTranspose = features.transpose();
        DoubleMatrix featureMultiplyFeatureTranspose = featureTranspose.mmul(features);
        DoubleMatrix inverse = Solve.solve(featureMultiplyFeatureTranspose, DoubleMatrix.eye(featureMultiplyFeatureTranspose.rows));
        DoubleMatrix featureTransposeMultiplyValues = featureTranspose.mmul(values);
        return inverse.mmul(featureTransposeMultiplyValues);
    }
}
