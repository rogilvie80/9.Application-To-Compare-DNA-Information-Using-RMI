/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engine;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author nick
 */
public interface DNAEngine extends Remote
{
    public int check(String seq1, String seq2) throws RemoteException;
}
