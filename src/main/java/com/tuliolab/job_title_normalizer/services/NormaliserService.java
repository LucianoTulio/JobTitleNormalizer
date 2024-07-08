package com.tuliolab.job_title_normalizer.services;

import java.util.HashMap;
import java.util.Map;

public class NormaliserService {
    private Map<String, String> normalizedTitles;


    //contructor  in charge to initializes the normalizedTitles map with predefined job titles
    public NormaliserService() {
        normalizedTitles = new HashMap<>();
        normalizedTitles.put("architect", "Architect");
        normalizedTitles.put("software engineer", "Software engineer");
        normalizedTitles.put("quantity surveyor", "Quantity surveyor");
        normalizedTitles.put("accountant", "Accountant");
    }

    public String normalise(String jobTitle) {

        //convert to lower case to ensure case-insensitive matching
        jobTitle = jobTitle.toLowerCase();

        //variables used to logic to identify the best matching job title
        double qualityScore = 0.0;
        String bestMatch = null;

        //loop to interate all job title predefined
        for (String key : normalizedTitles.keySet()) {

            //check if the job title passed by parameter matches with the predefines
            double score = getSimilarityScore(jobTitle, key);

            //check the quality score value is bigger
            if (score > qualityScore) {
                qualityScore = score;
                bestMatch = normalizedTitles.get(key);
            }
        }

        return bestMatch != null ? bestMatch : jobTitle;
    }

    //Method in charge to check score of matching words using the rule "where 0.0 <= q <= 1.0".
    // the idea here is check the input string match with one of predifined title worlds
    private double getSimilarityScore(String input, String normalized) {

        //Separe the worlds in array of input string
        String[] inputWords = input.split(" ");

        //separe the worlds in array of normalized job titles
        String[] normalizedWords = normalized.split(" ");

        //logic to check the input worlds matches with the worlds predifined
        int matchCount = 0;
        for (String inputWord : inputWords) {
            for (String normalizedWord : normalizedWords) {
                if (inputWord.equals(normalizedWord)) {
                    matchCount++;
                }
            }
        }

        return (double) matchCount / normalizedWords.length;
    }
}
