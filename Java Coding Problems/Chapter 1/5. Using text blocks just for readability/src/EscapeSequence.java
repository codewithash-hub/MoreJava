
public class EscapeSequence {

	public static void main(String[] args) {
		String sql = """
	             SELECT "public"."employee"."first_name" \
	             FROM "public"."employee" \
	             WHERE "public"."employee"."job_title" = ?\
	             """;
		System.out.println(sql);

	}

}
