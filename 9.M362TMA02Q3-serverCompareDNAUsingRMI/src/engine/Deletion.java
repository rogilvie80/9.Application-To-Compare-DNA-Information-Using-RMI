/*
 * Insertion.java
 *
 * Created on 18 November 2009, 22:49
 *
 */

package engine;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.lang.Math.*; 

/**
 *
 * @author M362 Course Team
 */
public class Deletion extends UnicastRemoteObject
        implements DNAEngine 
{
    
    /**
     * Creates a new instance of Deletion
     */
    public Deletion() throws RemoteException 
    {
        super();
    }

    // Check for DNA deletion 
    // Compares two sequences for a single deletion error
    // Returns 0 if no deletion found, otherwise ...
    // Returns the position in the sequence of the first deletion found
    public int check(String seq1, String seq2) throws RemoteException
    {
      int sequenceLength;

      // Min number of matching positions after the deletion
      // i.e. if there is one deleted base and the strings match for this many
      // subsequent positions, then it is classified as a deletion
      final int matchingLength = 5;  // set to low value as using short strings
      
      if (seq1.equals(seq2))
        return 0;
      else
      {
         sequenceLength = seq1.length();
         int i = 0;   
         while (i<sequenceLength && (seq1.charAt(i) == seq2.charAt(i)))
           i++;
         if (i >= sequenceLength)
           return 0;
         else // different characters at index i
         {
           int deletionPosition = i+1; //possibly!
           i++; 
           int endOfSearch = Math.min(sequenceLength, deletionPosition+matchingLength);          
           while (i<endOfSearch && (seq1.charAt(i) == seq2.charAt(i-1)))
             i++;
           if (i >= endOfSearch)
             return deletionPosition;
           else
             return 0;
             
         } 
       } 
    }    
    
}    
  
    
