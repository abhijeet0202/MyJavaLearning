package Practice;

public class Codility {
	
	

	void generateString(int A, int B) {
		String rt = "";
		while (0 < A || 0 < B) {

			// More 'b', append "bba"
			if (A < B) {
				if (0 < B--) {
					rt += ('b');
				}
				if (0 < B--) {
					rt += ('b');
				}
				if (0 < A--) {
					rt += ('a');
				}
			}

			// More 'a', append "aab"
			else if (B < A) {
				if (0 < A--) {
					rt += ('a');
				}
				if (0 < A--) {
					rt += ('a');
				}
				if (0 < B--) {
					rt += ('b');
				}
			}
			else {
				if (0 < A--) {
					rt += ('a');
				}
				if (0 < B--) {
					rt += ('b');
				}
			}
		}
		System.out.println(rt);
	}
	
	public static void main(String[] args) {
		Codility codility = new Codility();
		codility.generateString(10, 3);
	}
}
