/*
 * Transposition.java
 *
 * Created on 18 November 2009, 22:49
 *
 */

package engine;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author M362 Course Team
 */
public class Transposition extends UnicastRemoteObject 
       implements DNAEngine 
{
    
    /** Creates a new instance of Transposition */
    public Transposition() throws RemoteException 
    {
        super();
    }
    
    // Check for DNA transposition 
    
    // Compares two sequences for a character transposition
    // Returns 0 if no transposition found, otherwise ...
    // Returns the position in the sequence of the first transposition found
    public int check(String seq1, String seq2) throws RemoteException
    {
      int sequenceLength;
      
      if (seq1.equals(seq2))
        return 0;
      else
      {
         sequenceLength = seq1.length();
         int i = 0;  
         while (true) /// keep going until find end
         {
         while (i<sequenceLength && (seq1.charAt(i) == seq2.charAt(i)))
           i++;
         if (i >= sequenceLength)
           return 0;
         else // sequences differ - check if it's a transposition
         {
           char seq1Char = seq1.charAt(i);
           char seq2Char = seq2.charAt(i);
           int next = i+1;
           if (next >= sequenceLength)
             return 0;  // end of sequence so no transposition
           else
           {
             char seq1NextChar = seq1.charAt(next);
             char seq2NextChar = seq2.charAt(next);
             if ((seq1Char == seq2NextChar) && (seq2Char == seq1NextChar))
               return (i+1); 
             else
              i++;
           }
         }
         }
       } 
      
    }
 
    
}
