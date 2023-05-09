import java.rmi.Naming;
import java.rmi.RemoteException;

public class CinemaClient {
    public static void main(String[] args) {
        try {
            CinemaServerImpl cinemaServer = new CinemaServerImpl(50);
            Naming.rebind("CinemaServer", cinemaServer);
            CinemaClientGUI clientGUI = new CinemaClientGUI(cinemaServer);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
