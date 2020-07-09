package algo.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	public static void main(String[] args) {

//		numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
//				"testemail+david@lee.tcode.com" });

		numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.email@leetcode.com" });

	}

	public static int numUniqueEmails(String[] emails) {
		Set<String> uniqueSet = new HashSet<>();
		for (String email : emails) {

			String prefix = email.substring(0, email.indexOf('@'));
			if (prefix.contains("+")) {
				prefix = prefix.substring(0, email.indexOf('+'));

			}
			prefix = prefix.replace(".", "");
			String postfix = email.substring(email.indexOf('@') + 1, email.length());
			uniqueSet.add(prefix + "@" + postfix);
		}
		System.out.println(uniqueSet);
		return uniqueSet.size();
	}

}
