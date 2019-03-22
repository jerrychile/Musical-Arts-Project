
package assignment3;


import java.util.*;
import javax.swing.*;


public class Assignment3 
{
    static ElementSet anElementSet = new ElementSet();

    public static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        
        int choice;
        String decision;
        do
        {
        // menu display options
        displayMenu();
       
        decision = JOptionPane.showInputDialog("Enter the menu choice you would like");
        choice = Integer.parseInt(decision);
        
        mainMenu(choice);
        
         }while(!(choice == 8 ));
        
    }
       
    public static void displayMenu()
            
        {
            System.out.println("WEST CHESTER MUSICAL ARTS SOCIETY DATA MENU");
            System.out.println("1: Add an Instrumentalist or a Vocalist");
            System.out.println("2: Display the names of the Instrumentalists");
            System.out.println("3: Display the names of the Vocalists");
            System.out.println("4: Display the data for an Instrumentalist");
            System.out.println("5: Display the data for a Vocalist");
            System.out.println("6: Edit the data for an Instrumentalist or Vocalist");
            System.out.println("7: Remove an Instrumentalist or Vocalist");
            System.out.println("8: Quit the program.... that took so long to make....");
        }
    
    public static void mainMenu(int choice)
    {
      
       
       boolean check; 
                 
       
       int count = 0;
       Element anElement = null;
       String classId;
       
       try
       {
           
        switch(choice)
            {
            
            case 1: 
                
                    String input = JOptionPane.showInputDialog("Do you want to enter data for an Instrumentalist or for a Vocalist? Enter I for Instrumentalist and V for Vocalist.");
                    if(input.substring(0,1).toUpperCase().equals("I"))
                    {
                        do
                        {
                        Instrumentalist anInstrumentalist = new Instrumentalist();
                        anInstrumentalist.readIn();
                       
                        check = anElementSet.add(anInstrumentalist);
                       
                        if (check == false)
                        {
                            
                            JOptionPane.showMessageDialog(null,"Set is full. Cannot add.");
                        }
                       
                        input = JOptionPane.showInputDialog("Do you want to enter another instrumentalist?");
                        
                        }while((input.substring(0,1).toUpperCase().equals("Y")));
                    }
                    else if(input.substring(0,1).toUpperCase().equals("V"))
                    {
                     
                        do
                        {
                            
                        Vocalist aVocalist = new Vocalist();
                        aVocalist.readIn();
                        
                        
                        check = anElementSet.add(aVocalist);
                        
                        if (check == false)
                        {
                            
                            JOptionPane.showMessageDialog(null,"The set is full.");
                        }
                     
                        input = JOptionPane.showInputDialog("Do you want to enter another vocalist?");
                       
                        }while((input.substring(0,1).toUpperCase().equals("Y")));
                    }
                    else
                        
                    {
                        JOptionPane.showMessageDialog(null, "Try again!");
                    }
               break;
            
            case 2: 
                    for(int i = 0; i < anElementSet.size(); i++)
                        
                    {
                        anElement = anElementSet.getCurrent();
                        classId = anElement.getClassName();
                        
                       
                        if(classId.equals("Instrumentalist"))
                        {
                            anElement = (Instrumentalist) anElement;
                            System.out.println("Instrumentalist name: "+ anElement.getName());
                            count++;
                        }
                    }
                    if (count < 1)
                    {
                       
                        JOptionPane.showMessageDialog(null,"There was nothing to display! No instrumentalists in the set.");
                    }
               break;
            
            case 3: 
                count = 0;
                   
                    for(int i = 0; i < anElementSet.size(); i++)
                    {
                        anElement = anElementSet.getCurrent();
                        classId = anElement.getClassName();
                        
                     
                    if(classId.equals("Vocalist"))
                      {
                         anElement = (Vocalist)anElement;
                         System.out.println("Vocalist name: "+ anElement.getName());
                         count++;
                      }
                    }
                    if (count < 1)
                    {
                       
                        JOptionPane.showMessageDialog(null,"There was nothing to display! No vocalists in the set.");
                    }
             break;
            
            case 4: 
                anElement = new Instrumentalist();
                
                    input = JOptionPane.showInputDialog("Enter the name of the instrumentalist that you want to search for");
                    
                    boolean weFoundIt = false;
                    for(int i = 0; i < anElementSet.size(); i++)
                    {
                        anElement = anElementSet.getCurrent();
                        classId = anElement.getClassName();
                     
                        if(classId.equals("Instrumentalist"))
                        {
                          
                           
                            if(anElement.getName().toUpperCase().equals(input.toUpperCase()))
                            {
                          
                            anElement.display();
                            weFoundIt = true;
                            }
                        }
                    }
                    if(weFoundIt == false)
                    {
                      
                        JOptionPane.showMessageDialog(null,"That Instrumentalist is not in the set");
                    }
                    
             break;
             
            case 5: 
                        anElement = new Vocalist();
                        weFoundIt = false;
                
                    input = JOptionPane.showInputDialog("Enter the name of the vocalist that you want to search for");
                    for(int i = 0; i < anElementSet.size(); i++)
                    {
                        anElement = anElementSet.getCurrent();
                     
                        classId = anElement.getClassName();
                    
                        if(classId.equals("Vocalist"))
                        {
                       
                            if(anElement.getName().toUpperCase().equals(input.toUpperCase()))
                            {
                        
                            anElement.display();
                            weFoundIt = true;
                            }
                        }
                    }
                 
                    if(weFoundIt == false)
                    {
                      JOptionPane.showMessageDialog(null,"That Vocalist isn't in the set");
                    }
               break;
            
            case 6: 
                    String classID;
                    String editAnObjectName = "";
                    anElement = null;
                    
                    editAnObjectName = JOptionPane.showInputDialog("Enter a name to edit:");
                    
                    classID = JOptionPane.showInputDialog("Enter whether you're entering an instrumentalist or a vocalist: I or V");
                        if(classID.substring(0,1).toUpperCase().equals("I"))
                        {
                            classID = "Instrumentalist";
                            anElement = new Instrumentalist();
                            anElement.setName(editAnObjectName);
                            anElementSet.editAnObject(anElement);
                        }
                        else if(classID.substring(0,1).toUpperCase().equals("V"))
                        {
                            classID = "Vocalist";
                            anElement = new Vocalist();
                            anElement.setName(editAnObjectName);
                            anElementSet.editAnObject(anElement);

                        }
                    
                   
              break;
            
            case 7: 
                 
                   String nameToSearch = JOptionPane.showInputDialog("Enter name you would like to remove: ");
               
                   nameToSearch.toUpperCase();
                   anElementSet.removeAnObject(nameToSearch);
                 
                   JOptionPane.showMessageDialog(null, "Successfully removed");
                   anElementSet.display();
              break;
            
            case 8:
                    
                    input = JOptionPane.showInputDialog("Are you sure you want to quit this program? That took so long to make.. Y/N");
                    input = input.toUpperCase();
                    if(input.substring(0,1).equals("Y"))
                    {
                  
                        System.exit(0);
                    }
                    else
                    {
                        do
                        {
                      
                        displayMenu();
                      
                        String decision = JOptionPane.showInputDialog("Enter the menu choice number");
                        choice = Integer.parseInt(decision);
        
                        mainMenu(choice);
                    
                        }while(!(choice == 8 ));
                    }
             break;
            
            default:
                
                JOptionPane.showMessageDialog(null, "Sorry, that input is invalid. Please enter a number between 1 and 8.");
             
            }
        }
      
        catch(DuplicateObjectException e)
            {
                
                JOptionPane.showMessageDialog(null, "That object is already in the set");
            
            }
       
       
        catch(CannotEditException e)
            {
                
                JOptionPane.showMessageDialog(null, "That object was not in the set");
            
            } 
       
       
       
        catch(CannotRemoveException e)
            {
                
                JOptionPane.showMessageDialog(null, "That object wasn't in the set");
            
            }
    }   
    
}
