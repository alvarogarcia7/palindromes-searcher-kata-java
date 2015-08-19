package com.example.kata.palindromesearcher;

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

	@Test
	public void find_palindromes_in_more_than_one_word () {
		assertThat(search("ab a"), is(3 + 1));
	}

	@Test
	public void find_palindromes_of_length_2 () {
		assertThat(search("aa"), is(2 + 1));
	}

	@Test
	public void find_palindromes_of_length_even () {
		assertThat(search("an na"), is(4+2));
	}

	private int search (final String candidate) {

		return new PalindromeSearcher(candidate).search();
	}

}
