import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.locks.ReentrantLock;

public class CinemaServerImpl extends UnicastRemoteObject implements CinemaServer {
    private int numChairs;
    private ReentrantLock lock;

    public CinemaServerImpl(int numChairs) throws RemoteException {
        super();
        this.numChairs = numChairs;
        this.lock = new ReentrantLock();
    }

    public synchronized int getNumChairs() throws RemoteException {
        return this.numChairs;
    }

    public boolean reserveChair(int num) throws RemoteException {
        boolean result = false;
        try {
            lock.lock();
            if (num <= this.numChairs) {
                this.numChairs -= num;
                result = true;
            }
        } finally {
            lock.unlock();
        }
        return result;
    }
}
