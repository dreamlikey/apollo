package com.wdq.stram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;

import static java.util.stream.Collectors.summingInt;

/**
 * @author wudq
 * @date 2020/7/7 0007
 * @Description: TODO
 */
public class CollectMap {

    public static void main(String[] args) {
        group();
    }

    public static void setMap() {
        Map<Long, Map> countMap = new HashMap<>();
        countMap.put(1L, new HashMap(){{put("nums", 1); put("marketPointId", 1);}});
        countMap.put(2L, new HashMap(){{put("nums", 4); put("marketPointId", 2);}});
        countMap.put(3L, new HashMap(){{put("nums", 32); put("marketPointId", 3);}});
        countMap.put(3L, new HashMap(){{put("nums", 2); put("marketPointId", 4);}});
        countMap.put(3L, new HashMap(){{put("nums", 3); put("marketPointId", 5);}});
        countMap.put(3L, new HashMap(){{put("nums", 4); put("marketPointId", 6);}});

        List<MarketPoint> marketPointList = new ArrayList();
        marketPointList.add(new MarketPoint(1L, "重庆_万州"));
        marketPointList.add(new MarketPoint(2L, "广东_广州"));
        marketPointList.add(new MarketPoint(3L, "四川_成都"));
        marketPointList.add(new MarketPoint(4L, "四川_成都"));
        marketPointList.add(new MarketPoint(5L, "四川_内江"));
        marketPointList.add(new MarketPoint(6L, "重庆_云阳"));

        Map<String, Map> resMap = new HashMap<>(countMap.size());
        //
        //        marketPointList.stream()
        //            .filter(p -> countMap.containsKey(p.getId()))
        //            .map(p -> resMap.put(p.getPointName(),
        //                new HashMap() {{
        //                    put("pointName", p.getPointName());
        //                    put("nums", countMap.get(p.getId()).get("nums")); }}));
        Long marketId = 0L;
        marketPointList.stream().forEach(marketPoint -> {
            Map<String, Object> numsMap = countMap.get(marketPoint.getId());
            if (numsMap != null || numsMap.size() > 0) {
                resMap.put(marketPoint.getPointName(),
                    new HashMap() {{
                        put("pointName", marketPoint.getPointName());
                        put("nums", numsMap.get("nums")); }});
            }
        });

        System.out.println(resMap);
    }

    public static void group() {
        List<Map<String, Object>> freightList = new ArrayList<>();
        freightList.add(new HashMap(){{put("tempCount", 1); put("marketPointId", 1L);}});
        freightList.add(new HashMap(){{put("tempCount", 3); put("marketPointId", 2L);}});
        freightList.add(new HashMap(){{put("tempCount", 2); put("marketPointId", 3L);}});
        freightList.add(new HashMap(){{put("tempCount", 34); put("marketPointId", 4L);}});
        freightList.add(new HashMap(){{put("tempCount", 54); put("marketPointId", 5L);}});
        freightList.add(new HashMap(){{put("tempCount", 12); put("marketPointId", 6L);}});


        List<MarketPoint> marketPointList = new ArrayList();
        marketPointList.add(new MarketPoint(1L, "重庆_万州"));
        marketPointList.add(new MarketPoint(2L, "广东_广州"));
        marketPointList.add(new MarketPoint(3L, "四川_成都"));
        marketPointList.add(new MarketPoint(4L, "四川_成都"));
        marketPointList.add(new MarketPoint(5L, "四川_内江"));
        marketPointList.add(new MarketPoint(6L, "重庆_云阳"));

//        marketPointList.stream()
//            .forEach(m -> freightList.stream()
//                    .forEach(f -> {
//                    if (m.getId().longValue() == (Long)f.get("marketPointId")) {
//                        m.setTempCount((Integer) f.get("tempCount"));
//                    }}));
//        marketPointList.forEach(System.out::println);
//        Map<Object, Integer> countMap = marketPointList.stream()
//            .collect(Collectors.groupingBy(m -> fetchGroupKey(m), summingInt(MarketPoint::getTempCount)));

        marketPointList.stream()
            .forEach(m -> freightList.stream()
                    .forEach(f -> {
                    if (m.getId().longValue() == (Long)f.get("marketPointId")) {
                        f.put("pointName", m.getPointName());
                    }}));

        freightList.forEach(System.out::println);


    }

    private static String fetchGroupKey(MarketPoint marketPoint) {
        return marketPoint.getPointName().split("_")[0];
    }

    private static String fetchGroupKey(Map<String, Object> map) {
        return  map.get("pointName").toString().split("_")[0];
    }

        @Data
    static class MarketPoint {
        Long id;
        String pointName;

        Integer tempCount;


        public MarketPoint(Long id, String pointName) {
            this.id = id;
            this.pointName = pointName;
        }


    }
}
