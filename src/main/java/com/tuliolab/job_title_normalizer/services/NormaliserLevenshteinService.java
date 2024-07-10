package com.tuliolab.job_title_normalizer.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class NormaliserLevenshteinService {
    private Map<String, String> normalizedTitles;
    private LevenshteinDistance levenshteinDistance;

    public NormaliserLevenshteinService() {
        normalizedTitles = new HashMap<>();
        normalizedTitles.put("architect", "Architect");
        normalizedTitles.put("software engineer", "Software engineer");
        normalizedTitles.put("quantity surveyor", "Quantity surveyor");
        normalizedTitles.put("accountant", "Accountant");

        levenshteinDistance = new LevenshteinDistance();
    }

    public String normalise(String jobTitle) {
        log.info("Init method normalise with apache commons");
        //convert to lower case to ensure case-insensitive matching
        jobTitle = jobTitle.toLowerCase();

        int bestDistance = Integer.MAX_VALUE;
        String bestMatch = null;


        for (String key : normalizedTitles.keySet()) {

            //check de distance between input jobtitle and the predefined
            int distance = levenshteinDistance.apply(jobTitle, key);

            // the idea here is to keep the menor distance
            if (distance < bestDistance) {
                bestDistance = distance;
                bestMatch = normalizedTitles.get(key);
            }
        }
        log.info("End method normalise using apache commons");
        return bestMatch != null ? bestMatch : "Not Find";
    }
}
