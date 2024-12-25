package com.guercifzone.antiplagiat.Classes;

import java.util.HashSet;
import java.util.Set;

public class PlagiarismChecker_nGrams {

    // Generate n-grams from the text
    public Set<String> generateNGrams(String text, int n) {
        Set<String> ngrams = new HashSet<>();
        String[] words = text.split("\\s+");

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder ngram = new StringBuilder();
            for (int j = 0; j < n; j++) {
                ngram.append(words[i + j]).append(" ");
            }
            ngrams.add(ngram.toString().trim());
        }

        return ngrams;
    }

    // Compare two texts using n-grams
    public double compareNGrams(String text1, String text2, int n) {
        Set<String> ngrams1 = generateNGrams(text1, n);
        Set<String> ngrams2 = generateNGrams(text2, n);

        Set<String> intersection = new HashSet<>(ngrams1);
        intersection.retainAll(ngrams2);

        Set<String> union = new HashSet<>(ngrams1);
        union.addAll(ngrams2);

        return (double) intersection.size() / union.size();
    }
}

