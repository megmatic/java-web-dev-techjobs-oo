package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.launchcode.techjobs_oo.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;



public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    Job test_job5;

    @Before
    public void createJobObjects() {
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Drying Paint Watcher", new Employer("something something llc"), new Location("a wall"), new PositionType("person who watches paint dry"), new CoreCompetency("patience"));
        test_job5 = new Job("Drying Paint Watcher", new Employer("something something llc"), new Location("a wall"), new PositionType("person who watches paint dry"), new CoreCompetency("patience"));

    }

    @Test
    public void testSettingJobId() {
        assertTrue(test_job1.getId() != test_job2.getId() && (test_job2.getId() - test_job1.getId()) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(test_job3.getName() == "Product tester");
        assertTrue(test_job3.getEmployer() instanceof Employer && test_job3.getEmployer().getValue() == "ACME");
        assertTrue(test_job3.getLocation() instanceof Location && test_job3.getLocation().getValue() == "Desert");
        assertTrue(test_job3.getPositionType() instanceof PositionType && test_job3.getPositionType().getValue() == "Quality control");
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency && test_job3.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job4.equals(test_job5));
    }

    @Test
    public void jobToStringStartsAndEndsWithEmptyLine() {
        assertTrue(test_job5.toString().substring(0,1).equals("\n") && test_job5.toString().endsWith("\n"));
    }

    @Test
    public void testJobToStringAccuracy() {
        String stringToTestAgainst = "\nID: " + test_job5.getId() + "\nName: Drying Paint Watcher\nEmployer: something something llc\nLocation: a wall\nPosition Type: person who watches paint dry\nCore Competency: patience\n";
        assertEquals(test_job5.toString(), stringToTestAgainst);
    }

}
