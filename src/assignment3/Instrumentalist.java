
package assignment3;

import javax.swing.JOptionPane;


class Instrumentalist extends Element
{
    String name;
    String favoriteComposers;
    String instrument;

    //setters 
    
    public void setName(String instrumentalistName)
    {
        name = new String(instrumentalistName);
    }
    
    public void setInstrument(String instrumentName)
    {
        instrument = new String(instrumentName);
    }
    
    public void setFavComposers(String compName)
    {
        
        favoriteComposers = favoriteComposers.concat(compName + "; ");
        System.out.println("favorite composers " + favoriteComposers);
    }
    
    //getters 
    
    public String getName()
    {
        return new String(name);
    }
    
    public String getInstrument()
    {
        return new String(instrument);
    }
    
    public String getFavComposers()
    {
       return favoriteComposers;     
    }
    
   
    public void display()
    {
        System.out.println("Instrumentalist: " + getName().toUpperCase());
        System.out.println("Instrument: " + getInstrument().toUpperCase());
        System.out.println("Favorite composers: " + getFavComposers().toUpperCase());
    }

  
    public Instrumentalist()
      {
         name = "";
         instrument = "";
         favoriteComposers = "";
      }
   
    // one argument constructor
       public Instrumentalist(String aName)
      {
         name = aName.toUpperCase();
         instrument = "";
         favoriteComposers = "";
      }
       
   
      public Instrumentalist(Instrumentalist originalInstrumentalist)
      {
         name = originalInstrumentalist.getName();
         favoriteComposers = originalInstrumentalist.getFavComposers();
         instrument = originalInstrumentalist.getInstrument();
      }

   
    public void readIn()
    {
      
        
        if(name.equals(""))
        {
        name = JOptionPane.showInputDialog("Please enter the instrumentalist's name");
        name = name.toUpperCase();
        setName(name);
        }
        
       
        instrument = JOptionPane.showInputDialog("Enter the instrumentalist's instrument");
        
        
        instrument = instrument.toUpperCase();
       
        
        setInstrument(instrument);
    
        String numOfComps = JOptionPane.showInputDialog("Enter how many favorite composers the instrumentalist has");
        int count = 1;
        
        int numComps = Integer.parseInt(numOfComps);
   
        favoriteComposers = "";
            for(int i = 0; i < numComps; i++)
            {
                String compName = JOptionPane.showInputDialog("Enter the #" + count + " composer.");
                count++;
                compName = compName.toUpperCase();
                favoriteComposers = favoriteComposers.concat(compName + "; ");
                favoriteComposers.toUpperCase();
            }   
    }
    
  
    @Override
    public Element clone()
    {
        Instrumentalist theClone = new Instrumentalist();
        theClone.name = name;
        
        theClone.instrument = instrument;
        
        theClone.favoriteComposers = favoriteComposers;
        
        return theClone;
    }
    
    @Override
    public boolean equals(Element otherInstrumentalist)
    {
        return name.equalsIgnoreCase(((Instrumentalist) otherInstrumentalist).name);
    }
}
