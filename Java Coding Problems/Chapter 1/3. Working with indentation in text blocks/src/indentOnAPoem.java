
public class indentOnAPoem {

	public static void main(String[] args) {
		 String poem = """
	              I would want to establish strength; root-like,
	              anchored in the hopes of solidity.    
	              Forsake the contamination of instability.
	              Prove I'm the poet of each line of prose.
	         
		 """.indent(6).stripTrailing();
		 
		 System.out.print(poem);

	}

}
