import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (!anagrams.containsKey(sortedStr)) {
                anagrams.put(sortedStr, new ArrayList<>());
            }

            anagrams.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = ga.groupAnagrams(strs);

        for (List<String> list : result) {
            System.out.println("Anagrams: " + list);
            System.out.println("Explanation: These strings are anagrams of each other because they contain the same characters in a different order.");
            System.out.println();
        }
    }
}
