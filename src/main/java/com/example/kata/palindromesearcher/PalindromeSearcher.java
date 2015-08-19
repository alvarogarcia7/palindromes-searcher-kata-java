package com.example.kata.palindromesearcher;

public class PalindromeSearcher {
	private final String candidate;

	public PalindromeSearcher (final String candidate) {
		this.candidate = removeAllSpaces(candidate);
	}

	public int search () {
		int palindromes = 0;
		for (int pivot = 0; pivot < candidate.length(); pivot++) {
			palindromes += matchesLastOnly(pivot);
			palindromes += matchingAnyLeftAndRight(pivot);
		}
		return palindromes;
	}

	private String removeAllSpaces (final String candidate) {
		return candidate.replaceAll(" ", "");
	}

	private int matchingAnyLeftAndRight (final int pivot) {
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

	private int matchesLastOnly (final int pivot) {
		if (areTheSameCharacter(pivot - 1, pivot)) {
			return 1;
		}
		return 0;
	}

	private boolean areTheSameCharacter (final int start, final int end) {
		int palindromes = 0;
		return withinBounds(candidate, start, end) && get(start) == get(end);
	}

	private boolean withinBounds (final String candidate, final int start, final int end) {
		return start >= 0 && end < candidate.length();
	}

	private String get (String string, final int start, final int end) {
		return string.substring(start, end + 1);
	}

	private char get (final int j) {
		return candidate.charAt(j);
	}
}