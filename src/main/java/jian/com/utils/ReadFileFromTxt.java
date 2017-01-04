package jian.com.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class ReadFileFromTxt {
    public static Map<String, String> readTxtFile(String filePath) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            String encoding = "utf-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (StringUtils.isNotEmpty(lineTxt)) {
                        String[] line = lineTxt.split(",");
                        map.put(line[0], line[1]);
                    }
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String argv[]) {
        String filePath = "C:\\Users\\aoc\\Desktop\\报表\\old_new.txt";
        // "res/";
        readTxtFile(filePath);
    }
}
