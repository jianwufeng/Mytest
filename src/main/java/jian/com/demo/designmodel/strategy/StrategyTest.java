package jian.com.demo.designmodel.strategy;

/**
 * Date: 2017年5月27日 上午10:45:11
 * 
 * @author Jihan
 */
public class StrategyTest {

    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }

}
