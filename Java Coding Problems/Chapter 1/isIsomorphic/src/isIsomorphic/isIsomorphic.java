package isIsomorphic;

import java.util.HashMap;
import java.util.Map;

public class isIsomorphic {

	public static void main(String[] args) {
		String s1 = """
				abbcdd
				    baaaad
				ccddaa
				""";
		String s2 = """
				qwwerr
				    wqqqqr
				eerrqq
				""";
		System.out.println(isIsomorphic(s1, s2));

	}
	
	public static boolean isIsomorphic(String s1, String s2) {
		// step 1
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		
		// step 2
		Map<Character, Character> map = new HashMap<>();
		
		// step 3
		for (int i = 0; i < s1.length(); i++) {
			char chs1 = s1.charAt(i);
			char chs2 = s2.charAt(i);
			
			// step 4
			if (map.containsKey(chs1)) {
				// step 5
				if (map.get(chs1) != chs2) {
					return false;
				}
			} else {
				// step 6
				if (map.containsValue(chs2)) {
					return false;
				}
				
				// step 7
				map.put(chs1,  chs2);
			}
		}
		// step 8
		return true;
	}

}
