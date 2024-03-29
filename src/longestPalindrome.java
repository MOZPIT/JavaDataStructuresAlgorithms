/*
	 * Time Complexity: O(n ^ 2)
	 * Space Complexity:P O(n ^ 2)
*/

public class longestPalindrome {
	
	public String longestPalindrome(String s) {
		int length = s.length();
		
		if(s == null || length < 2) {
			return s;
		}else if(length > 1010) {
			return "Invalid length of string";
		}
		
		boolean[][] isPalindrome = new boolean[length][length];
		
		int left = 0;
		int right = 0;
		
		for(int j = 1; j < length; j++) {
			for(int i = 0; i < j; i++) {
				boolean isInnerWordPalindrome = isPalindrome[i + 1][j - 1] || j - i <= 2;
				
				if(s.charAt(i) == s.charAt(j) && isInnerWordPalindrome){
					isPalindrome[i][j] = true;
					
					if(j - i > right -left) {
						left = i;
						right = j;
					}
				}
			}
		}
		
		return s.substring(left, right+1);
	}
	
	public static void main(String[] args) {
		longestPalindrome p = new longestPalindrome();
		String s = "bananas";
		
		System.out.println("The longest palindrome of the stirng is: " + p.longestPalindrome(s));
	}
}
