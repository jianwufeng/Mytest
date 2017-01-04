package jian.com.utils.textUtil;

public class TextUtil {
    public static boolean isEmpty(Object obj) {
        if ("".equals(obj) || obj == null) {
            return true;
        }
        return false;
    }
}
