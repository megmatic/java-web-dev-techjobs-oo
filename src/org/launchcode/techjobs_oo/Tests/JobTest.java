package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.launchcode.techjobs_oo.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class JobTest {

    Job test_job1;
    Job test_job2;

    @Before
    public void createJobObjects() {
        test_job1 = new Job();
        test_job2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertTrue(test_job1.getId() != test_job2.getId() && (test_job2.getId() - test_job1.getId()) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job3.getName() == "Product tester");
        assertTrue(test_job3.getEmployer() instanceof Employer && test_job3.getEmployer().getValue() == "ACME");
        assertTrue(test_job3.getLocation() instanceof Location && test_job3.getLocation().getValue() == "Desert");
        assertTrue(test_job3.getPositionType() instanceof PositionType && test_job3.getPositionType().getValue() == "Quality control");
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency && test_job3.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job test_job4 = new Job("Drying Paint Watcher", new Employer("something something llc"), new Location("a wall"), new PositionType("person who watches paint dry"), new CoreCompetency("patience"));
        Job test_job5 = new Job("Drying Paint Watcher", new Employer("something something llc"), new Location("a wall"), new PositionType("person who watches paint dry"), new CoreCompetency("patience"));
        assertFalse(test_job4.equals(test_job5));
    }

}
