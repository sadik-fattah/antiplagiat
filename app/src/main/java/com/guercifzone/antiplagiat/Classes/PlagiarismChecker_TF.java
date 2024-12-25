package com.guercifzone.antiplagiat.Classes;

import java.util.HashMap;
import java.util.Map;

public class PlagiarismChecker_TF {

    // Compute term frequency (TF) for a given document
    private Map<String, Integer> computeTF(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> tf = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            tf.put(word, tf.getOrDefault(word, 0) + 1);
        }
        return tf;
    }

    // Compute inverse document frequency (IDF)
    private double computeIDF(String term, String[] documents) {
        int numDocsContainingTerm = 0;
        for (String document : documents) {
            if (document.toLowerCase().contains(term.toLowerCase())) {
                numDocsContainingTerm++;
            }
        }
        return Math.log(documents.length / (1 + numDocsContainingTerm));
    }

    // Compute cosine similarity between two documents
    public double computeCosineSimilarity(String doc1, String doc2, String[] allDocuments) {
        Map<String, Integer> tf1 = computeTF(doc1);
        Map<String, Integer> tf2 = computeTF(doc2);

        double dotProduct = 0;
        double magnitude1 = 0;
        double magnitude2 = 0;

        // For each unique term in both documents, calculate the similarity
        for (String term : tf1.keySet()) {
            double idf = computeIDF(term, allDocuments);
            double tfidf1 = tf1.get(term) * idf;

            if (tf2.containsKey(term)) {
                double tfidf2 = tf2.get(term) * idf;
                dotProduct += tfidf1 * tfidf2;
            }
            magnitude1 += tfidf1 * tfidf1;
        }

        for (String term : tf2.keySet()) {
            double idf = computeIDF(term, allDocuments);
            double tfidf2 = tf2.get(term) * idf;
            magnitude2 += tfidf2 * tfidf2;
        }

        magnitude1 = Math.sqrt(magnitude1);
        magnitude2 = Math.sqrt(magnitude2);

        if (magnitude1 == 0 || magnitude2 == 0) return 0;

        return dotProduct / (magnitude1 * magnitude2);
    }
}
