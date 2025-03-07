import javax.swing.*;

public class GUI extends JFrame {

    private JTextArea txArea;
    private JPanel pnMain;

    public GUI(){
        setContentPane(pnMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);


        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
    }
}
