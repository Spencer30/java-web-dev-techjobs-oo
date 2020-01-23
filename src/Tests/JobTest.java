package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job myJob;
    Job myJob2;
    Job myJob3;
    Job myJob4;

    @Before
    public void init(){
        myJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality" +
                " control"), new CoreCompetency("Persistence"));
        myJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality" +
                " control"), new CoreCompetency("Persistence"));
        myJob3 = new Job(" ", new Employer(" "), new Location(" "), new PositionType(
                " "), new CoreCompetency(" "));
        myJob4 = new Job("Product tester", new Employer("ACME"), new Location(" "), new PositionType(
                "Quality" + " control"), new CoreCompetency("Persistence"));
    }

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
        assertTrue(myJob instanceof Job);
        assertTrue(myJob.getName() == "Product tester");
        assertTrue(myJob.getEmployer().getValue() == "ACME");
        assertTrue(myJob.getLocation().getValue() == "Desert");
        assertTrue(myJob.getPositionType().getValue() == "Quality control");
        assertTrue(myJob.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(myJob.equals(myJob2));
    }

    @Test
    public void testToStringReturnsEmptyLines(){
        String myJobString = myJob.toString();
        String[] myJobStringArr = myJobString.split("\n");
        assertTrue(myJobStringArr[0].isBlank() && myJobStringArr[myJobStringArr.length -1 ].isBlank());
    }

    @Test
    public void testToStringReturnsSeparateLines(){
        String myJobString = myJob.toString();
        String[] myJob1StringArr = myJobString.split("\n");
        assertTrue(myJob1StringArr.length == 8);
    }

    @Test
    public void testToStringReturnsEmptyFieldMessage(){
        String myJob4String = myJob4.toString();
        String[] myJob4StringArr = myJob4String.split("\n");
//        System.out.println(myJob4StringArr[4]);
//        System.out.println(myJob4StringArr[4] == "location: Data not available");
        assertFalse(myJob4StringArr[4] == "location: ");
    }

    @Test
    public void testToStringAllFieldsEmpty(){
        String myJob3String = myJob3.toString();
        assertTrue(myJob3String == "OOPS! This job does not seem to exist.");
    }
}
