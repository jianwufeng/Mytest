package jian.com.demo.designmodel.strategy;

/**
 * Date: 2017年5月27日 上午10:44:04
 * 
 * @author Jihan
 */
public class Minus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "-");
        return arrayInt[0] - arrayInt[1];
    }

}
