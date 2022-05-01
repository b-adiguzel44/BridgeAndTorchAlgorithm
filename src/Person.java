public class Person {
   
    //#region Class attributes

    private String name;
    private int timeToCross;
    private boolean isCrossed;

    //#endregion

    //#region Constructors

    /**
     * Sets the name of the person and the time to cross over the fallen tree.
     * @param name - the name of the person
     * @param timeToCross - the time to cross the fallen tree
     */
    public Person(String name, int timeToCross)
    {
        this.name = name;
        this.timeToCross = timeToCross;
        this.isCrossed = false;
    }

    /**
     * Sets the name of the person, the time to cross over the fallen tree and whether the person has crossed over the fallen tree.
     * @param name - the name of the person
     * @param timeToCross - the time to cross over the fallen tree
     * @param isCrossed - whether the person has crossed over the fallen tree
     */
    public Person(String name, int timeToCross, boolean isCrossed)
    {
        this.name = name;
        this.timeToCross = timeToCross;
        this.isCrossed = isCrossed;
    }

    //#endregion

    //#region Instance methods

    /**
     * Returns the name of the person.
     * @return the name of the person
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the time needed to cross.
     * @return this person's time to cross
     */
    public int getTimetoCross() {
        return this.timeToCross;
    }

    /**
     * Returns whether the person has crossed the fallen tree. (True : Crossed to the other side, False : Not crossed)
     * @return whether the person has crossed the fallen tree
     */
    public boolean getCrossed() {
        return this.isCrossed;
    }

    /**
     * Toggles the crossed status of the person. (True : crossed to the other side, False : did not cross)
     */
    public void crossTheFallenTree()
    {
        this.isCrossed = !this.isCrossed;
    }

    //#endregion

}
