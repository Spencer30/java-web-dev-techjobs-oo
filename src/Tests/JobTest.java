package Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void emptyTest() {
        assertEquals(true, true);
    }

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.equals(job2));
        assertTrue(job2.getId() -job1.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job myJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality" +
                " control"), new CoreCompetency("Persistence"));
        assertTrue(myJob instanceof Job);
        assertTrue(myJob.getName() == "Product tester");
        assertTrue(myJob.getEmployer().getValue() == "ACME");
        assertTrue(myJob.getLocation().getValue() == "Desert");
        assertTrue(myJob.getPositionType().getValue() == "Quality control");
        assertTrue(myJob.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job myJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality" +
                " control"), new CoreCompetency("Persistence"));
        Job myJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality" +
                " control"), new CoreCompetency("Persistence"));

        assertFalse(myJob1.equals(myJob2));
    }
}
