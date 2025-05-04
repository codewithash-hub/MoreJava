
public class TextBlock {

	public static void main(String[] args) {
		 // All the previous examples have a bunch of shortcomings in common. The most important of these is 
		 // that none of these examples represents a truly multiline string literal, and the degree of readability 
		 // is seriously affected by the escaping characters and extra quotes needed for each line demarcation. 
		 // Fortunately, starting with JDK 13 (as a future preview) and ending with JDK 15 (as a final feature), the 
		 // new text blocks have become the standard for representing multiline string literals. Let’s see how.

		// Introducing text blocks (JDK 13/15)
		// JDK 13 (JEP 355) offers a preview feature that aims to add support for multiline string literals. Over 
		// two versions, in JDK 15 (JEP 378), the text block feature has become final and permanent for use. But 
		// that’s enough history; let’s quickly see how text blocks shape our multiline SQL string:
		
		String sql="""
		           UPDATE "public"."office"
		           SET ("address_first", "address_second", "phone") =
		             (SELECT "public"."employee"."first_name",
		                     "public"."employee"."last_name", ?
		              FROM "public"."employee"
		              WHERE "public"."employee"."job_title" = ?""";
		
		System.out.println(sql);
		
		 // Here is another example that embeds a piece of JSON information:
		
		String json = """
	              {
	                "widget": {
	                  "debug": "on",
	                  "window": {
	                    "title": "Sample Widget 1",
	                    "name": "back_window"
                  },
                  "image": {
                    "src": "images\\sw.png"
                  },
                  "text": {
                    "data": "Click Me",
                    "size": 39
                  }
                }
              }""";
				
		System.out.println(json);
		
		// How about representing a piece of HTML as a text block? Sure, here it is:
		
		String html = """
	              <table>
	                <tr>
	                  <thcolspan="2">Name</th>
	                  <th>Age</th>
	                </tr>
	                <tr>
	                  <td>John</td>
	                  <td>Smith</td>
	                  <td>22</td>
	                </tr>
	              <table>""";
		
		System.out.println(html);
	}

}
