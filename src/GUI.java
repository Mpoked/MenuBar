import javax.swing.*;

public class GUI extends JFrame {

    private JTextArea txArea;
    private JPanel pnMain;

    public GUI(){
        setContentPane(pnMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);


        JMenuBar menuBar = new JMenuBar();

        // Vytvoření menu
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        // Vytvoření položek menu
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Přidání položek do menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Přidání menu do menu baru
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Nastavení menu baru do hlavního okna
        setJMenuBar(menuBar);

        newItem.addActionListener(e -> zapis());
    }

    public void zapis(){
        txArea.append("Ahoj\n");
    }
}
