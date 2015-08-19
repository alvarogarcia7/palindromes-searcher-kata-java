import org.junit.Test;

import java.util.Stack;

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
			char last;
			char current;
			int palindromes = 0;
			Stack<Character> stack = new Stack<>();
			for (int i=1; i < candidate.length(); i++) {
				last = candidate.charAt(i - 1);
				current = candidate.charAt(i);
				if (last == current || (!stack.isEmpty() && stack.peek() == current)){
					palindromes++;
					stack.pop();
				}
				stack.push(last);
			}
			return palindromes;
		}
	}
}
