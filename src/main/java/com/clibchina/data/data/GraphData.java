package com.clibchina.data.data;

import com.sun.tools.javac.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by changlifeng on 2017/9/6.
 */
public class GraphData {

    private static int pointNum = 0;
    private static Map<Integer, Pair<Integer, Integer>> pointMap = new HashMap<Integer, Pair<Integer, Integer>>();

    public static Map<Integer, Pair<Integer, Integer>> getPointMap() {
        return pointMap;
    }

    public static void putPointMap(Pair<Integer, Integer> point) {
        pointMap.put(pointNum, point);
        pointNum ++;
    }

    public static void removePointMap(int index) {
        pointMap.remove(index);
    }

    public static void removeAllPointMap() {
        pointMap = new HashMap<Integer, Pair<Integer, Integer>>();
    }
}
