package com.tuliolab.job_title_normalizer;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.tuliolab.job_title_normalizer.services.NormaliserLevenshteinService;
import com.tuliolab.job_title_normalizer.services.NormaliserService;

public class Main {


    public static void main(String[] args) {
        NormaliserService normaliserService = new NormaliserService();
        NormaliserLevenshteinService normaliserLevenshteinService = new NormaliserLevenshteinService();

        String [] jobTitle = {"Java engineer","C# engineer" , "Chief Accountant" , "Python Engine"  };


        System.out.println("_______ METHOD Manual compare String ________");
        System.out.println(normaliserService.normalise(jobTitle[0]));
        System.out.println(normaliserService.normalise(jobTitle[1]));
        System.out.println(normaliserService.normalise(jobTitle[2]));
        System.out.println(normaliserService.normalise(jobTitle[3]));


        //show a different way to do the same thing using Apache Common Language with LevenshteinService
        System.out.println("_______ METHOD LEVENSHTEIN DISTANCE ________");
        System.out.println(normaliserLevenshteinService.normalise(jobTitle[0]));
        System.out.println(normaliserLevenshteinService.normalise(jobTitle[1]));
        System.out.println(normaliserLevenshteinService.normalise(jobTitle[2]));
        System.out.println(normaliserLevenshteinService.normalise(jobTitle[3]));
    }
}