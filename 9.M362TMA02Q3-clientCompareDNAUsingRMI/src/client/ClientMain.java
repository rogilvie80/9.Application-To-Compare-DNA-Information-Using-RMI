/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import engine.DNAEngine;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain
{
   public static void main(String[] args)
   {
      DNAEngine engine1;
      DNAEngine engine2;
      DNAEngine engine3;
      DNAEngine engine4;
      Registry registry;

      final String ORIGINAL_SEQUENCE =      "ACTAGCTGT";

      // Sample sequences demonstrating each type of DNA error
      // as discussed in TMA02 Q3a
      final String MUTATION_SEQUENCE =      "ACTATCTGT";
      final String TRANSPOSITION_SEQUENCE = "ACTAGTCGT";
      final String INSERTION_SEQUENCE =     "ACTAGACTG";
      final String DELETION_SEQUENCE =      "ACTGCTGTA";

      // Sequences to be compared for DNA errors
      final String SEQUENCE_A =      "AAGCTGTCACGTTTTTCAAGCTGTCACG";
      final String SEQUENCE_B =      "AAGCTGTCACTGTTTTCAAGCTGTCACG";

      try        // try to locate registry
      {
         registry = LocateRegistry.getRegistry();
         System.out.println("Registry stub created.");
      }
      catch (Exception e)
      {
         System.out.println("Registry stub not created: " + e.getMessage());
         return;
      }

      try        // try to list names in the registry
      {
          System.out.println("Bound names: ");
          for (String s : registry.list())
          {
              System.out.println(s);
          }
      }
      catch (Exception e)
      {
          System.out.println("Registry listing error: " + e.getMessage());
          return;
      }

      try        // try to look up the remote object
      {
         engine1 = (DNAEngine) registry.lookup("deletion_engine");
         engine2 = (DNAEngine) registry.lookup("insertion_engine");
         engine3 = (DNAEngine) registry.lookup("mutation_engine");
         engine4 = (DNAEngine) registry.lookup("transposition_engine");
         System.out.println("Engines found.");
      }
      catch (Exception e)
      {
         System.out.println("Engines not found: " + e.getMessage());
         return;
      }

      System.out.println("\nSample sequences demonstrating each type of DNA "
              + "error as discussed in TMA02 Q3a: \n");


      try
      {
         if(engine1.check(ORIGINAL_SEQUENCE, DELETION_SEQUENCE) == 0)
         {
             System.out.println("Deletion sequence: No error was found");
         }
         else
         {
             System.out.println("Deletion sequence: Error found at position "
                     + engine1.check(ORIGINAL_SEQUENCE, DELETION_SEQUENCE));
         }
      }
      catch (Exception e)
      {
          System.out.println("check not computed: " + e.getMessage());
      }

      try
      {
         if(engine1.check(ORIGINAL_SEQUENCE, INSERTION_SEQUENCE) == 0)
         {
             System.out.println("Insertion sequence: No error was found");
         }
         else
         {
             System.out.println(engine1.toString() + "Insertion sequence: "
                     + "Error found at position "
                     + engine1.check(ORIGINAL_SEQUENCE, DELETION_SEQUENCE));
         }
      }
      catch (Exception e)
      {
          System.out.println("check not computed: " + e.getMessage());
      }

      try
      {
         if(engine1.check(ORIGINAL_SEQUENCE, MUTATION_SEQUENCE) == 0)
         {
             System.out.println("Mutation sequence: No error was found");
         }
         else
         {
             System.out.println(engine1.toString() + "Mutation sequence: "
                     + "Error found at position "
                     + engine1.check(ORIGINAL_SEQUENCE, DELETION_SEQUENCE));
         }
      }
      catch (Exception e)
      {
          System.out.println("check not computed: " + e.getMessage());
      }

      try
      {
         if(engine1.check(ORIGINAL_SEQUENCE, TRANSPOSITION_SEQUENCE) == 0)
         {
             System.out.println("Transposition sequence: No error was found");
         }
         else
         {
             System.out.println(engine1.toString() + "Transposition sequence: "
                     + "Error found at position "
                     + engine1.check(ORIGINAL_SEQUENCE, DELETION_SEQUENCE));
         }
      }
      catch (Exception e)
      {
          System.out.println("check not computed: " + e.getMessage());
      }

      System.out.println("\nSequences to be compared for DNA error: \n" );

      try
      {
         if(engine1.check(SEQUENCE_A, SEQUENCE_B) == 0)
         {
             System.out.println("Deletion sequence: No error was found");
         }
         else
         {
             System.out.println("Deletion sequence: Error found at position "
                     + engine1.check(ORIGINAL_SEQUENCE, DELETION_SEQUENCE));
         }
      }
      catch (Exception e)
      {
          System.out.println("check not computed: " + e.getMessage());
      }

      try
      {
         if(engine2.check(SEQUENCE_A, SEQUENCE_B) == 0)
         {
             System.out.println("Insertion sequence: No error was found");
         }
         else
         {
             System.out.println("Insertion sequence: Error found at position "
                     + engine1.check(ORIGINAL_SEQUENCE, DELETION_SEQUENCE));
         }
      }
      catch (Exception e)
      {
          System.out.println("check not computed: " + e.getMessage());
      }

      try
      {
         if(engine3.check(SEQUENCE_A, SEQUENCE_B) == 0)
         {
             System.out.println("Mutation sequence: No error was found");
         }
         else
         {
             System.out.println("Mutation sequence: Error found at position "
                     + engine1.check(ORIGINAL_SEQUENCE, DELETION_SEQUENCE));
         }
      }
      catch (Exception e)
      {
          System.out.println("check not computed: " + e.getMessage());
      }

      try
      {
         if(engine4.check(SEQUENCE_A, SEQUENCE_B) == 0)
         {
             System.out.println("Transposition sequence: No error was found");
         }
         else
         {
             System.out.println("Transposition sequence: Error found at "
           + "position " + engine1.check(ORIGINAL_SEQUENCE, DELETION_SEQUENCE));
         }
      }
      catch (Exception e)
      {
          System.out.println("check not computed: " + e.getMessage());
      }
    }
}
  