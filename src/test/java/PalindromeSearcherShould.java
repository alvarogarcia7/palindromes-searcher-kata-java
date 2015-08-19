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
		return  palindromes(candidate);
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
			int palindromes = 0;
			for (int pivot = 0; pivot < candidate.length(); pivot++) {
				for (int i = 0; i <= pivot; i++) {
					final int start = pivot - i;
					final int end = pivot + i;
					if (withinBounds(candidate, start, end) && get(start) == get(end)) {
						palindromes++;
						get(candidate, start, end);
					}
				}
			}
			return palindromes;
		}

		private boolean withinBounds (final String candidate, final int start, final int end) {
			return start >= 0 && end < candidate.length();
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
