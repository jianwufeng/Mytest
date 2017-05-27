package jian.com.demo.designmodel.strategy;

/**
 * Date: 2017年5月27日 上午10:43:10
 * 
 * @author Jihan
 */
public abstract class AbstractCalculator {

    public int[] split(String exp, String opt) {
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }

}
