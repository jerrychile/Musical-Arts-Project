
package assignment3;


import javax.swing.JOptionPane;

public class ElementSet 
{
private Element[] theList;

private int currentIndex = 0;
private int currentSize = 0;
private final int MAXSETSIZE = 100;



    public ElementSet()
    {
        theList = new Element[MAXSETSIZE];
        currentIndex = -1;
        currentSize = 0;
    
    }

        public boolean isMemberOf(Element anElement)
      {
        
         String paramClass = anElement.getClassName();
         String currClass;

      
         for (int i = 0; i < currentSize; i++)
         {
            currClass = theList[i].getClassName();

         
            if (currClass.equals(paramClass))
            {
               if (theList[i].equals(anElement))
               {
                  return true;
               }
            }
         }

     
         return false;
      }


       public boolean isFull()
      {
         return currentSize == MAXSETSIZE;
      }

  

       public boolean isEmpty()
      {
         return currentSize == 0;
      }

   

       public int size()
      {
         return currentSize;
      }

 
       public Element getCurrent()
      {
         
         int saveIndex = currentIndex;

      
        if(currentIndex == currentSize - 1)
        {
            currentIndex = 0;
        }
        else
        {
            currentIndex++;
        }

     
         return theList[saveIndex].clone();
      }

  

    

     
       
       public boolean add(Element anElement) throws DuplicateObjectException
               
               
      {
        
         if (currentSize == MAXSETSIZE)
         {
            return false;  
         }
         else if (this.isMemberOf(anElement))
         {
            throw new DuplicateObjectException(); // already in there
         }

         
         theList[currentSize] = anElement.clone();

       
         currentSize++;

       
         if (currentSize == 1) currentIndex = 0;

       
         return true;
      }

 

       public void clear()
      {
    
         for (int i = 0; i < currentSize; i++)
         {
            theList[i] = null;
         }

      
         currentIndex = -1;
         currentSize = 0;
      }

 

       public void display()
      {
         if (currentSize == 0)
         {
            System.out.println("There are no objects in the set. ");
         }
         else
         {
            System.out.println("Here are the objects in the set: \n");
            for (int i = 0; i < currentSize; i++)
            {
               theList[i].display();
               System.out.println("\n");
            }
         }
      }
      
      public void editAnObject(Element objectToEdit) throws CannotEditException
      {
          Element ElementToCompare = null;
         
          if(isMemberOf(objectToEdit))
          {
          
            for(int i = 0; i < currentSize; i++)
            {
                ElementToCompare = theList[i].clone();
                
                if(ElementToCompare.getClassName().equalsIgnoreCase(objectToEdit.getClassName()))
              
                {     
                   
                    if (ElementToCompare.equals(objectToEdit));
                    
                    {
                       
                        theList[i].readIn();
                        System.out.println("Object was edited");
                        break;
                    }
                }   
            }
            currentIndex = 0;
          }
          else
          {
          
            throw new CannotEditException();
          }
            
        }
      public void removeAnObject(String objectToRemoveName) throws CannotRemoveException
     
      {
         
          
          boolean result = false;
          
          String input = null;
          
         
          
          
         Element removeElement = null;
        
         Element objectToCompare = null;
          
          
              input = JOptionPane.showInputDialog("Is the object you want to remove an instrumentalist or vocalist? Enter I or V");
                
              if((input.equalsIgnoreCase("I")))
                {
           
                removeElement = new Instrumentalist();
                
                input = "Instrumentalist";
                }
                else if((input.equalsIgnoreCase("V")))
                {
             
                    
                removeElement = new Vocalist();
                input = "Vocalist";
                }
                
             
                removeElement.setName(objectToRemoveName);
                
                if(isMemberOf(removeElement))
                { 
                    for(int i = 0; i < currentSize; i++)
                    {
                        
                       objectToCompare = theList[i].clone();
                        
                 if(objectToCompare.getClassName().equalsIgnoreCase(input))
                        {
                 if(objectToCompare.equals(removeElement))
                            {
                            
                                theList[i] = theList[i+1];
                                result = true;
                                currentSize = currentSize - 1;
                            }
                        }
                        
                        if(result)
                        {
                            theList[i] = theList[i+1];
                        }
                                   
                    }
                }
        if(!result)
        {
            throw new CannotRemoveException();
        }
                    
    }
      
      
}
  