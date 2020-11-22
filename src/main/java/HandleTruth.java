import java.util.*;

public class HandleTruth {
    public static TreeMap<Integer, Set<String>> wordCount(String msg) {

        msg =  msg.trim(); // Bug Fix

        // Bug Fix
        if (msg.length() == 0) {
            return new TreeMap<Integer, Set<String>>();
        }

        // split the message into word set
        String string = msg.replaceAll("\\s+"," "); // Bug Fix
        String[] words = string.split(" "); // Bug Fix

        // use map to count the occurrences of each word
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
                continue;
            }
            wordMap.put(word, 1);
        }

        // sort the map based on number of occurrences
        TreeMap<Integer, Set<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            int key = entry.getValue();
            Set<String> values = sortedMap.containsKey(key) ?
                    sortedMap.get(key) : new HashSet<>();
            values.add(entry.getKey());
            sortedMap.put(entry.getValue(), values);
        }
        return sortedMap;
    }

}