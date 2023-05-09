import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.RemoteException;


public class CinemaClientGUI extends JFrame {
    private CinemaServerImpl cinemaServer;
    private JLabel labelNumChairs;
    private JTextField fieldNumChairs;
    private JButton buttonCheck;
    private JButton buttonReserve;

    public CinemaClientGUI(CinemaServerImpl cinemaServer) {
        super("Cinema Client");
        this.cinemaServer = cinemaServer;

        labelNumChairs = new JLabel("Number of chairs:");
        fieldNumChairs = new JTextField(5);
        buttonCheck = new JButton("Check availability");
        buttonReserve = new JButton("Reserve chairs");

        JPanel inputPanel = new JPanel();
        inputPanel.add(labelNumChairs);
        inputPanel.add(fieldNumChairs);
        inputPanel.add(buttonCheck);
        inputPanel.add(buttonReserve);

        JTextArea outputArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        buttonCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numChairs = Integer.parseInt(fieldNumChairs.getText());
                try {
                    int availableChairs = cinemaServer.getNumChairs();
                    if (numChairs > availableChairs) {
                        outputArea.append("Não existem cadeiras suficientes para a quantidade solicitada.\n");
                    } else {
                        outputArea.append("Ainda existem " + availableChairs + " cadeiras disponíveis.\n");
                    }
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonReserve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numChairs = Integer.parseInt(fieldNumChairs.getText());
                try {
                    boolean result = cinemaServer.reserveChair(numChairs);
                    if (result) {
                        outputArea.append("Foram reservadas " + numChairs + " cadeiras com sucesso.\n");
                    } else {
                        outputArea.append("Falha ao reservar as cadeiras.\n");
                    }
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
