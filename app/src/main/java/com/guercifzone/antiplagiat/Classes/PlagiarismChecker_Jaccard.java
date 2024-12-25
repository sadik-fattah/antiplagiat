package com.guercifzone.antiplagiat.Classes;

import java.util.HashSet;
import java.util.Set;

public class PlagiarismChecker_Jaccard {

    // Compute Jaccard similarity between two texts
    public double computeJaccardSimilarity(String text1, String text2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        // Convert text into sets of words
        for (String word : text1.split("\\s+")) {
            set1.add(word.toLowerCase());
        }

        for (String word : text2.split("\\s+")) {
            set2.add(word.toLowerCase());
        }

        // Find intersection and union of the sets
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }
}
