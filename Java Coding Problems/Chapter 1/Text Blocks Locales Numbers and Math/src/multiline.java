import java.util.stream.Collectors;
import java.util.stream.Stream;

public class multiline {

	public static void main(String[] args) {
		// Before JDK 8
		// Probably the most common approach relies on straightforward concatenation via the well-known “+" 
		// operator. This way, we obtain a multiline string representation, as follows:
		String sql = 
		"UPDATE \"public\".\"office\"\n" 
		+ "SET (\"address_first\", \"address_second\", \"phone\") =\n"
		+ "  (SELECT \"public\".\"employee\".\"first_name\",\n"
		+ "  (SELECT \"public\".\"employee\".\"first_name\",\n"
		+ "          \"public\".\"employee\".\"last_name\", ?\n"
		+ "   FROM \"public\".\"employee\"\n"
		+ "   WHERE \"public\".\"employee\".\"job_title\" = ?";
		
		System.out.println(sql);
		
		// The compiler should be (and usually is) smart enough to internally transform the “+" operations 
		// into a StringBuilder/StringBuffer instance and use the append() method to build the final string. 
		// However, we can use StringBuilder (not thread-safe) or StringBuffer (thread-safe) directly, as in 
		// the following example:
		
		StringBuilder sql2 = new StringBuilder();
		sql2.append("UPDATE \"public\".\"office\"\n")
		.append("SET (\"address_first\", \"address_second\", \"phone\") =\n")
		.append("  (SELECT \"public\".\"employee\".\"first_name\",\n")
		.append("  (SELECT \"public\".\"employee\".\"first_name\",\n")
		.append("          \"public\".\"employee\".\"last_name\", ?\n")
		.append("   FROM \"public\".\"employee\"\n")
		.append("   WHERE \"public\".\"employee\".\"job_title\" = ?");
		
		System.out.println("\n" + sql2);
		
		// Another approach (typically not so popular as the previous two) consists of using the String.concat() method.
		
		String sql3 = "UPDATE \\\"public\\\".\\\"office\\\"\\n"
				.concat("SET...\n")
				.concat("   (SELECT...\n)");
		
		
		// Furthermore, we have the String.format() method. By simply using the %s format specifier, we can 
		// concatenate multiple strings (including null values) in a multiline string, as follows:
		
		String sql4 = String.format("%s%s%s%s%s%s%s",
				"UPDATE \"public\".\"office\"\n",
				"SET (\"address_first\", \"address_second\", \"phone\") =\n",
				"  (SELECT \"public\".\"employee\".\"first_name\",\n",
				"  (SELECT \"public\".\"employee\".\"first_name\",\n",
				"          \"public\".\"employee\".\"last_name\", ?\n",
				"   FROM \"public\".\"employee\"\n",
				"   WHERE \"public\".\"employee\".\"job_title\" = ?"
		);
		
		System.out.println("\n" + sql4);
		
		 // Finally, we cannot mention JDK 8 without touching on its mighty Stream API. More precisely, we are 
		 // interested in the Collectors.joining() collector. This collector works as String.join(), and in our 
		 // case, it looks as follows
		 String sql5 = Stream.of(
				 "UPDATE \"public\".\"office\"",
				 "SET (\"address_first\", \"address_second\", \"phone\") =",
				 "  (SELECT \"public\".\"employee\".\"first_name\",",
				 "          \"public\".\"employee\".\"last_name\", ?",
				 "   FROM \"public\".\"employee\"",
				 "   WHERE \"public\".\"employee\".\"job_title\" = ?;")
				 .collect(Collectors.joining(String.valueOf("\n")));
		 
		 System.out.println("\n" + sql5);
	}

}
