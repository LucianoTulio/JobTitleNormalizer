package com.tuliolab.job_title_normalizer.services;


import org.junit.Assert;
import org.junit.Test;

public class NormaliserServiceTest {



    @Test
    public void testNormalise() {
        NormaliserService normaliserService = new NormaliserService();

        Assert.assertEquals("Software engineer", normaliserService.normalise("Java engineer"));
        Assert.assertEquals("Software engineer", normaliserService.normalise("C# engineer"));
        Assert.assertEquals("Accountant", normaliserService.normalise("Chief Accountant"));
        Assert.assertEquals("Architect", normaliserService.normalise("Senior Architect"));
        Assert.assertEquals("Quantity surveyor", normaliserService.normalise("Junior Quantity surveyor"));
    }

}
