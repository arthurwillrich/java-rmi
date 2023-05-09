import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CinemaServer extends Remote {
    public int getNumChairs() throws RemoteException;
    public boolean reserveChair(int num) throws RemoteException;
}
