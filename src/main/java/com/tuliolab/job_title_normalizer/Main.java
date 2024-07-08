package com.tuliolab.job_title_normalizer;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.tuliolab.job_title_normalizer.services.NormaliserLevenshteinService;
import com.tuliolab.job_title_normalizer.services.NormaliserService;

public class Main {


    public static void main(String[] args) {
        NormaliserService normaliserService = new NormaliserService();
        NormaliserLevenshteinService normaliserLevenshteinService = new NormaliserLevenshteinService();

        String jobTitle = "Java engineer";
        String secondJobTitle = "C# engineer";
        String terthJobTitle = "Chief Accountant";
        String fourJobTitle = "Policeman";

        System.out.println("_______ METHOD Manual compare String ________");
        System.out.println(normaliserService.normalise(jobTitle));
        System.out.println(normaliserService.normalise(secondJobTitle));
        System.out.println(normaliserService.normalise(terthJobTitle));
        System.out.println(normaliserService.normalise(fourJobTitle));




        //show a different way to do the same thing using Apache Common Language with LevenshteinService
        System.out.println("_______ METHOD LEVENSHTEIN DISTANCE ________");
        System.out.println(normaliserLevenshteinService.normalise(jobTitle));
        System.out.println(normaliserLevenshteinService.normalise(secondJobTitle));
        System.out.println(normaliserLevenshteinService.normalise(terthJobTitle));
        System.out.println(normaliserLevenshteinService.normalise(fourJobTitle));
    }
}