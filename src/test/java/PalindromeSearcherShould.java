import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PalindromeSearcherShould {
	@Test
	public void find_whole_word_length_3 () {
		assertThat(search("ugu"), is(3 + 1));
	}

	@Test
	public void find_whole_word_with_length_greater_than_3 () {
		assertThat(search("sugus"), is(5 + 2));
	}

	private int search (final String candidate) {
		return candidate.length() + palindromes(candidate);
	}

	private int palindromes (final String candidate) {

		return new PalindromeSearcher(candidate).search();
	}

	private class PalindromeSearcher {
		private final String candidate;

		public PalindromeSearcher (final String candidate) {
			this.candidate = candidate;
		}

		public int search () {
			char pivot;
			char current;
			int palindromes = 0;
			int i=-1, j;
			while(true) {
				i++;
				if(i >= candidate.length()){
					break;
				}
				j=i;
				pivot = get(j);
				current = get(i);
				while (pivot == current) {
					if(i-j > 0) {
						System.out.println("found [" + j + "," + i + "] = " + get(candidate, j, i));
						palindromes++;
					}
					j--;
					if (j >= 0) {
						pivot = get(j);
					} else {
						break;
					}
					i++;
					if(i >= candidate.length()){
						break;
					}
					current = get(i);

				}

			}
			return palindromes;
		}

		private String get (String string, final int start, final int end) {
			return string.substring(start, end + 1);
		}

		private char get (final int j) {
			final char pivot;
			pivot = candidate.charAt(j);
			return pivot;
		}
	}
}
