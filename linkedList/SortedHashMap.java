package linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class SortedHashMap {
  public static void main(String args[]) {
    HashMap<String, Double> map = new HashMap<String, Double>();
    map.put("Bristol", 23.45);
    map.put("London", 345.122);
    map.put("Manchester", 12.3);
    map.put("Edinburgh", 11.4);
    for (String cityName : map.keySet()) {
      System.out.println(cityName + " " + map.get(cityName));
    }
    System.out.println("-------------------");
    HashMap<String, Double> nmap = new SortedHashMap().sortHashMap(map);
    for (String cityName : nmap.keySet()) {
      System.out.println(cityName + " " + nmap.get(cityName));
    }
  }

  public HashMap<String, Double> sortHashMap(HashMap<String, Double> input) {
//    Map<String, Double> tempMap = new HashMap<String, Double>();
//    for (String wsState : input.keySet()) {
//      tempMap.put(wsState, input.get(wsState));
//    }

    List<String> mapKeys = new ArrayList<String>(input.keySet());
    List<Double> mapValues = new ArrayList<Double>(input.values());
    HashMap<String, Double> sortedMap = new LinkedHashMap<String, Double>();
    TreeSet<Double> sortedSet = new TreeSet<Double>(mapValues);
    Object[] sortedArray = sortedSet.toArray();
    int size = sortedArray.length;
    for (int i = 0; i < size; i++) {
      sortedMap.put(mapKeys.get(mapValues.indexOf(sortedArray[i])), (Double) sortedArray[i]);
    }
    return sortedMap;
  }
}
