package org.random.automation.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class MapUtil {

    public static Integer getMaxValue(Map<Integer, Integer> map) {
        return Collections.max(map.entrySet(), Comparator.comparing(Map.Entry::getValue)).getValue();
    }

    public static Integer getMinValue(Map<Integer, Integer> map) {
        return Collections.min(map.entrySet(), Comparator.comparing(Map.Entry::getValue)).getValue();
    }
}
