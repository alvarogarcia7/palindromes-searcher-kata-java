package com.example.kata.palindromesearcher;

public class PalindromeSearcher {
	private final String candidate;

	public PalindromeSearcher (final String candidate) {
		this.candidate = removeAllSpaces(candidate);
	}

	/**
	 * Searches for palindromes in the string.
	 *
	 * Every non-space character is considered a palindrome of length 1. Further palindromes can be present as well.
	 *
	 * This method has cost O(n^2) being n the string length
	 * @return
	 */
	public int search () {
		int palindromes = 0;
		for (int pivot = 0; pivot < candidate.length(); pivot++) {
			palindromes += matchesPairPalindromes(pivot);
			palindromes += matchesEvenPalindromes(pivot);
		}
		return palindromes;
	}

	private String removeAllSpaces (final String candidate) {
		return candidate.replaceAll(" ", "");
	}

	private int matchesEvenPalindromes (final int pivot) {
		int palindromes = 0;
		for (int i = 0; i <= pivot; i++) {
			final int start = pivot - i;
			final int end = pivot + i;
			if (areTheSameCharacter(start, end)) {
				palindromes++;
			}
		}
		return palindromes;
	}

	private int matchesPairPalindromes (final int pivot) {
		int palindromes = 0;
		for (int i = 0; i <= pivot; i++) {
			final int start = pivot - i - 1;
			final int end = pivot + i;
			if (areTheSameCharacter(start, end)) {
				palindromes++;
			}
		}
		return palindromes;
	}

	private boolean areTheSameCharacter (final int start, final int end) {
		return withinBounds(start, end) && get(start) == get(end);
	}

	private boolean withinBounds (final int start, final int end) {
		return start >= 0 && end < candidate.length();
	}

	private char get (final int i) {
		return candidate.charAt(i);
	}
}
