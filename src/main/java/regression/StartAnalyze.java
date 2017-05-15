package regression;

import org.jblas.DoubleMatrix;
import regression.linearregression.GradientDescentCostFunctionMinimizer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jblas.DoubleMatrix.*;

@SuppressWarnings("serial")
public class StartAnalyze extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        GradientDescentCostFunctionMinimizer minimizer = new GradientDescentCostFunctionMinimizer(0.01, 1500, false);
        DoubleMatrix dataMatrix = loadCSVFile("linearregression/ex1data1.txt");
        DoubleMatrix features = concatHorizontally(ones(dataMatrix.rows), dataMatrix.getColumn(0));
        DoubleMatrix values = dataMatrix.getColumn(1);

        DoubleMatrix theta = minimizer.minimizeCostFunction(features, values);
        PrintWriter out = resp.getWriter();
        //Assert.assertEquals(theta.get(0, 0), -3.6302914394044015);
        //Assert.assertEquals(theta.get(1, 0), 1.1663623503355864);
        out.println(theta.get(0, 0));
        out.println(theta.get(1, 0));

    }
}
