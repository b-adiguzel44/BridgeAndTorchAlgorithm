public class Main {

    //#region Static variables

    // To calculate the time needed to cross over the fallen tree.
    public static int totalTime = 0;
    public static final int MAX_PEOPLE = 4;

    //#endregion


    public static void main(String[] args) throws Exception {

      
        Person people[] = new Person[MAX_PEOPLE];
        String[] names = {"Scrat", "Sid", "Diego", "Manny"};
        int[] timeToCross = {10, 12, 15, 14};

        // Set all the time costs and fill the array with people.
        for(int i = 0; i < MAX_PEOPLE; i++) {
            people[i] = new Person(names[i], timeToCross[i]);
        }


        //#region Cases


        //#region Best Case

        int optimum_time = bestCase(people);
        System.out.println("Optimum time: " + optimum_time + "s");


        //#endregion
        
        // Resetting the total time and the crossed status of the people.
        totalTime = 0;
        for (Person person : people) {
            person.crossTheFallenTree();
        }

        //#region Worst Case

        int worst_time = worstCase(people);
        System.out.println("Worst time: " + worst_time + "s"); 
       
        //#endregion

        //#endregion


    }
    //#region Methods

    /**
     * Crossing the fastest two people in the group first.
     * @param people - Array of people
     */
    private static void crossFastest(Person[] people) { 
        int first = -1;
        int second = -1;

        for(int i = 0; i < people.length; i++) {
            // Checking only the people who have not crossed yet
            if(!people[i].getCrossed()) {
                if(first == -1) {
                    first = i;
                } 
                else {
                    
                    // Compare the current person to first person
                    if(people[i].getTimetoCross() < people[first].getTimetoCross()) {
                        second = first;
                        first = i;
                    }
                    else if(second == -1 || people[i].getTimetoCross() < people[second].getTimetoCross()) {
                        second = i;
                    }
                    
                    
                }

            }
        }

        // Crossing the two fastest people in the group over the fallen tree.
        people[first].crossTheFallenTree();
        people[second].crossTheFallenTree();
        // Adding the time needed to cross over the fallen tree to the total time.
        totalTime += people[second].getTimetoCross();

        System.out.println(people[first].getName() + " and " + people[second].getName() + " crossed over the fallen tree.\n" + "Total time: " + totalTime + "s\n");

    }

    /**
     * Crossing the slowest two people in the group first.
     * @param people - Array of people
     */
    private static void crossSlowest(Person[] people) { 
        int first = -1;
        int second = -1;

        for(int i = 0; i < people.length ; i++) {
            // Checking only the people who have not crossed yet
            if(!people[i].getCrossed()) {

                if(first == -1) {
                    first = i;
                }
                else {

                    // Compare the current person to first person
                    if(people[i].getTimetoCross() > people[first].getTimetoCross()) {
                        second = first;
                        first = i;
                    }
                    else if(second == -1 || people[i].getTimetoCross() > people[second].getTimetoCross()) {
                        second = i;
                    }

                }

            }

        }

        // Crossing the two slowest people in the group over the fallen tree.
        people[first].crossTheFallenTree();
        people[second].crossTheFallenTree();
        // Adding the time needed to cross over the fallen tree to the total time.
        totalTime += people[first].getTimetoCross();

        System.out.println(people[first].getName() + " and " + people[second].getName() + " crossed over the fallen tree.\n" + "Total time: " + totalTime + "s\n");

    }

    /**
     * Returns the fastest person back to the other side.
     * @param people - Array of people
     */
    private static void returnFastest(Person[] people) { 
        int fastest = -1;
        
        for(int i = 0; i < people.length; i++) {
            // Checking only the people who have crossed
            if(people[i].getCrossed()) {

                if (fastest == -1) {
                    fastest = i;
                }
                else {

                    // Compare the current person to first person
                    if(people[i].getTimetoCross() < people[fastest].getTimetoCross()) {
                        fastest = i;
                    }

                }

            }

        }

        // Cross the fastest person back to the other side
        people[fastest].crossTheFallenTree();
        // Add the current person's time to cross over to the total time
        totalTime += people[fastest].getTimetoCross();

        System.out.println(people[fastest].getName() + " returned back to the other side.\n" + "Total time: " + totalTime + "s\n");

    }

    /**
     * Return the slowest person back to the other side.
     * @param people - Array of people
     */
    private static void returnSlowest(Person[] people) { 
        int slowest = -1;

        for(int i = 0; i < people.length; i++) {
            // Checking only the people who have crossed
            if(people[i].getCrossed()) {

                
                if(slowest == -1)
                    slowest = i;
                else {
                    // Compare the current person to first person
                    if(people[i].getTimetoCross() > people[slowest].getTimetoCross())
                        slowest = i;
                }

            }
        
        }

        // Cross the slowest person back to the other side
        people[slowest].crossTheFallenTree();
        // Add the current person's time to cross over to the total time
        totalTime += people[slowest].getTimetoCross();

        System.out.println(people[slowest].getName() + " returned back to the other side.\n" + "Total time: " + totalTime + "s\n");

    }

    /**
     * Checks if all the people have crossed over the fallen tree.
     * @param people - Array of people
     * @return returns a boolean value. If all the people have crossed over the fallen tree, returns true. Otherwise, returns false.
     */
    private static boolean allCrossed(Person[] people) {

        for (Person person : people) {
            if(!person.getCrossed()) {
                return false;
            }
        }

        return true;
    }

    public static int bestCase(Person[] people) {
        
        System.out.println("Best Case Scenario");
        System.out.println("------------------");
        while (true) {

             if(allCrossed(people))
                 break;

            // 1st Iteration (pair up)
            crossFastest(people);
            returnFastest(people);

            // 2nd Iteration
            crossSlowest(people);
            returnFastest(people);

            // 3rd Iteration
            crossFastest(people);

        }

        System.out.println("------------------");

        return totalTime;
    }

    public static int worstCase(Person[] people) {
        
        System.out.println("\nWorst Case Scenario");
        System.out.println("------------------");
        while (true) {

            if(allCrossed(people))
                break;

           // 1st Iteration (pair up the slowest two people and return the slowest person after crossing over the fallen tree)
           crossSlowest(people);
           returnSlowest(people);

           // 2nd Iteration (pair up the slowest two people and return the slowest person after crossing over the fallen tree)
           crossSlowest(people);
           returnSlowest(people);

           // 3rd Iteration (cross over the fallen tree with last two people left on the other side)
           crossSlowest(people);

       }
        System.out.println("------------------");

        

        return totalTime;
    }
    
    //#endregion

}
