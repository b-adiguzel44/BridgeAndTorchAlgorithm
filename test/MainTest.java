import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class MainTest {

    Main testInstance = new Main();

    @Test
    public void testBestCase_1() {

        testInstance.totalTime = 0;

        Person people[] = new Person[4];
        String[] names = {"Scrat", "Sid", "Diego", "Manny"};
        int[] timeToCross = {5, 5, 5, 5};

  
        // Set all the time costs and fill the array with people.
        for(int i = 0; i < people.length; i++) {
            people[i] = new Person(names[i], timeToCross[i]);
        }

        assertEquals(25, testInstance.bestCase(people));
        
    }

    @Test
    public void testWorstCase_1() {

        testInstance.totalTime = 0;

        Person people[] = new Person[4];
        String[] names = {"Scrat", "Sid", "Diego", "Manny"};
        int[] timeToCross = {5, 5, 5, 5};

  
        // Set all the time costs and fill the array with people.
        for(int i = 0; i < people.length; i++) {
            people[i] = new Person(names[i], timeToCross[i]);
        }

        assertEquals(25, testInstance.worstCase(people));

    }
    
    @Test
    public void testBestCase_2() {

        testInstance.totalTime = 0;

        Person people[] = new Person[4];
        String[] names = {"Scrat", "Sid", "Diego", "Manny"};
        int[] timeToCross = {4, 6, 7, 9};

  
        // Set all the time costs and fill the array with people.
        for(int i = 0; i < people.length; i++) {
            people[i] = new Person(names[i], timeToCross[i]);
        }

        assertEquals(31, testInstance.bestCase(people));
        
    }

    @Test
    public void testWorstCase_2() {

        testInstance.totalTime = 0;

        Person people[] = new Person[4];
        String[] names = {"Scrat", "Sid", "Diego", "Manny"};
        int[] timeToCross = {4, 6, 7, 9};

  
        // Set all the time costs and fill the array with people.
        for(int i = 0; i < people.length; i++) {
            people[i] = new Person(names[i], timeToCross[i]);
        }

        assertEquals(45, testInstance.worstCase(people));

    }

    @Test
    public void testBestCase_3() {

        testInstance.totalTime = 0;

        Person people[] = new Person[4];
        String[] names = {"Scrat", "Sid", "Diego", "Manny"};
        int[] timeToCross = {3, 5, 8, 13};

  
        // Set all the time costs and fill the array with people.
        for(int i = 0; i < people.length; i++) {
            people[i] = new Person(names[i], timeToCross[i]);
        }

        assertEquals(31, testInstance.bestCase(people));
        
    }

    @Test
    public void testWorstCase_3() {

        testInstance.totalTime = 0;

        Person people[] = new Person[4];
        String[] names = {"Scrat", "Sid", "Diego", "Manny"};
        int[] timeToCross = {3, 5, 8, 13};

  
        // Set all the time costs and fill the array with people.
        for(int i = 0; i < people.length; i++) {
            people[i] = new Person(names[i], timeToCross[i]);
        }

        assertEquals(65, testInstance.worstCase(people));

    }

}
