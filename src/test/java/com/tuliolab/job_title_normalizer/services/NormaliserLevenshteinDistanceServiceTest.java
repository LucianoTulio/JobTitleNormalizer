package com.tuliolab.job_title_normalizer.services;


import org.junit.Assert;
import org.junit.Test;

public class NormaliserLevenshteinDistanceServiceTest {



    @Test
    public void testNormalise() {
        NormaliserLevenshteinService normaliserLevenshteinService = new NormaliserLevenshteinService();

        Assert.assertEquals("Software engineer", normaliserLevenshteinService.normalise("Java engineer"));
        Assert.assertEquals("Software engineer", normaliserLevenshteinService.normalise("C# engineer"));
        Assert.assertEquals("Accountant", normaliserLevenshteinService.normalise("Chief Accountant"));
        Assert.assertEquals("Architect", normaliserLevenshteinService.normalise("Senior Architet"));
        Assert.assertEquals("Quantity surveyor", normaliserLevenshteinService.normalise("Junior Quantity surveyor"));
    }

}
