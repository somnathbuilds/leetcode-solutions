class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        // Knowledge ko HashMap me store karo
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            // Normal character
            if (s.charAt(i) != '(') {
                ans.append(s.charAt(i));
                i++;
            }

            // Bracket pair
            else {
                i++; // '(' ko skip karo

                StringBuilder key = new StringBuilder();

                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                // ')' ko skip karo
                i++;

                String k = key.toString();

                if (map.containsKey(k)) {
                    ans.append(map.get(k));
                } else {
                    ans.append("?");
                }
            }
        }

        return ans.toString();
    }
}