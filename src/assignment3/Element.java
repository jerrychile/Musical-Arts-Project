
package assignment3;


abstract class Element {
    

    String getClassName() 
    {
        return getClass().getSimpleName();
    }
   
    
    //Abstract Methods
    public abstract void readIn();
    public abstract void display();
    public abstract boolean equals(Element otherInstrumentalist);
    @Override
    public abstract Element clone();
    public abstract String getName();
    public abstract void setName(String aName);
}