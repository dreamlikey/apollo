package com.wdq;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wudq
 * @date 2019/2/27
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(TimeUnit.MINUTES.toMillis(10));
        String key = "aedqwert";
        int h = key.hashCode();
        h = (h >>> 16);
        System.out.println("h = " + h);

        List<String> platformList = new ArrayList<>();

        platformList.add("CSDN");
        platformList.add("博客园");
        platformList.add("博客园");
        platformList.add("掘金");

//        for (int i = 0; i < platformList.size(); i++) {
//            String item = platformList.get(i);
//            if ("博客园".equals(item)) {
//                platformList.remove(i);
//                i = i - 1;
//            }
//        }

        platformList.removeIf(l -> "博客园".equals(l));

        System.out.println(platformList);

//        List<String> platformList = new ArrayList<>();
//        platformList.add("博客园");
//        platformList.add("博客园");
//        platformList.add("CSDN");
//        platformList.add("掘金");
//
//        for (String platform : platformList) {
//            if (platform.equals("博客园")) {
//                platformList.remove(platform);
//            }
//        }
//
//        System.out.println(platformList);
    }

}
