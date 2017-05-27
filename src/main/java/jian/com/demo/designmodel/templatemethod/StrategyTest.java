package jian.com.demo.designmodel.templatemethod;

/**
 * Date: 2017年5月24日 下午3:11:43
 * 
 * @author Jihan
 */
public class StrategyTest {

    public static void main(String[] args) {
        String exp = "8+8";

        AbstractClass cal = new Subtract();
        int result = cal.calculate(exp, "\\+");

        System.out.println(result);
    }
}
