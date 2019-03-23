
package assignment3;

import javax.swing.JOptionPane;


public class Vocalist extends Element
{
    String name;
    String voice = "";
    String recentPiece;

    //setters 
    
    public void setName(String instrumentalistName)
    {
        name = new String(instrumentalistName);
    }
    
    public void setVoice(String aVoice)
    {
        voice = new String(aVoice);
    }
    
    public void setRecentPiece(String aRecentPiece)
    {
        recentPiece = new String(aRecentPiece);
    }
    
    //getters 
    
    public String getName()
    {
        return new String(name);
    }
    
    public String getVoice()
    {
        return new String(voice);
    }
    
    public String getRecentPiece()
    {
       return new String(recentPiece);     
    }
    
  
    public void display()
    {
        System.out.println("Vocalist: " + getName().toUpperCase());
        System.out.println("Voice: " + getVoice().toUpperCase());
        System.out.println("Recent Piece: " + getRecentPiece().toUpperCase());
    }


    public Vocalist()
      {
         name = "";
         voice = "";
         recentPiece = "";
      }
   
  
       public Vocalist(String aName)
      {
         name = aName.toUpperCase();
         voice = "";
         recentPiece = "";
      }
   
      public Vocalist(Vocalist originalVocalist)
      {
         name = originalVocalist.getName();
         voice = originalVocalist.getVoice();
         recentPiece = originalVocalist.getRecentPiece();
      }

    public void readIn()
    {
        
        
        if (name.equals(""))
        {
        name = JOptionPane.showInputDialog("Please enter the vocalists's name");
        name = name.toUpperCase();
        setName(name);
        }

   
        voice = JOptionPane.showInputDialog("Enter the vocalist's voice"); //gets vocalist voice
        voice = voice.toUpperCase();
        setVoice(voice);
        
      
        recentPiece  = JOptionPane.showInputDialog("Enter the vocalist's most recent piece"); //gets vocalist piece
        recentPiece = recentPiece.toUpperCase();
    }
   
    @Override
    
    public Element clone()
    {
        Vocalist vocalistClone = new Vocalist();
        vocalistClone.name = name;
        vocalistClone.voice = voice;
        vocalistClone.recentPiece = recentPiece;
        return vocalistClone;
    }
    

 
    @Override
    public boolean equals(Element otherVocalist)
    {
        return name.equalsIgnoreCase(((Vocalist) otherVocalist).name);
    }
}
