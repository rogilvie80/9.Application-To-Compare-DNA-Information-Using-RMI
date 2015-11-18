/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author nick
 */
public class ServerMain
{
    public static void main(String[] args)
    {
        DNAEngine engine1;
        DNAEngine engine2;
        DNAEngine engine3;
        DNAEngine engine4;
        Registry registry;

        try        // try to create registry
        {
            registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println("Registry created.");
        }
        catch (Exception e)
        {
            System.out.println("Registry not created: " + e.getMessage());
            return;
        }

        try
        {
            engine1 = new Deletion();
            engine2 = new Insertion();
            engine3 = new Mutation();
            engine4 = new Transposition();
            System.out.println("Engines created.");
        }
        catch (Exception e)
        {
            System.out.println("Engines not created: " + e.getMessage());
            return;
        }

        try        // try to bind name into registry
        {
            registry.bind("deletion_engine", engine1);
            registry.bind("insertion_engine", engine2);
            registry.bind("mutation_engine", engine3);
            registry.bind("transposition_engine", engine4);
            System.out.println("Engines registered.");
        }
        catch (Exception e)
        {
            System.out.println("Engines not registered: " + e.getMessage());
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

        try
      {
         TimeUnit.MINUTES.sleep(2);
         UnicastRemoteObject.unexportObject(engine1, true);
         UnicastRemoteObject.unexportObject(engine2, true);
         UnicastRemoteObject.unexportObject(engine3, true);
         UnicastRemoteObject.unexportObject(engine4, true);
      }
      catch (Exception e)
      {
         return;
      }
    }
}
