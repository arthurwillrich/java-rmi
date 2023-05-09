import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class TerminalCinemaClient {

    public static void main(String[] args) {
        try {
            CinemaServer cinemaServer = (CinemaServer) Naming.lookup("CinemaServer");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Digite 1 para verificar disponibilidade de cadeiras ou 2 para fazer uma reserva:");
                int opcao = scanner.nextInt();

                if (opcao == 1) {
                    int numChairs = cinemaServer.getNumChairs();
                    System.out.println("Número de cadeiras disponíveis: " + numChairs);

                } else if (opcao == 2) {
                    System.out.println("Digite o número de cadeiras que deseja reservar:");
                    int numChairs = scanner.nextInt();
                    boolean result = cinemaServer.reserveChair(numChairs);

                    if (result) {
                        System.out.println("Reserva de " + numChairs + " cadeiras realizada com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar a reserva de " + numChairs + " cadeiras.");
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
