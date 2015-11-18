/*
 * Mutation.java
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
public class Mutation extends UnicastRemoteObject
       implements DNAEngine 
{
    
    /** Creates a new instance of Mutation */
    public Mutation() throws RemoteException 
    {
       super();
    }

    // Check for DNA mutation 
    // Compares two sequences for a single character mutation
    // Returns 0 if no mutation found, otherwise ...
    // Returns the position in the sequence of the first mutation found
    public int check(String seq1, String seq2) throws RemoteException
    {
      int sequenceLength;
      
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
         else
           return i+1;  // Position 1 is start of sequence 
 
       } 
    }
    
}
