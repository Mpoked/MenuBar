import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GUI extends JFrame {

    private JTextArea txArea;
    private JPanel pnMain;
    private String cesta;
    private String nazevSouboru;


    public GUI(){
        initComponent();
    }

    private void initComponent(){
        setContentPane(pnMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);


        JMenuBar menuBar = new JMenuBar();
        menuBar.getAccessibleContext().setAccessibleDescription("textová popiska menu");

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

        openItem.addActionListener(e -> vyberSoubor());
        saveItem.addActionListener(e -> zapisSouboru());
    }

    public void zapis(){
        txArea.append("Ahoj\n");
    }

    public void vyberSoubor(){
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            cesta = fc.getSelectedFile().getAbsolutePath();
            File selectedFile = fc.getSelectedFile();
            System.out.println("Uživatel vybral soubor: "+selectedFile.getPath());
            vypisSouboru(selectedFile);
        } else {
            JOptionPane.showMessageDialog(this,"Uživatel ukončil dialog bez výběru souboru.");

        }
    }

    public void vypisSouboru(File soubor){
        try(BufferedReader br = new BufferedReader(new FileReader(soubor))){
            String radek;
            while((radek = br.readLine()) != null){
                txArea.append(radek+"\n");
            }
        } catch (Exception e) {
            System.err.println("Chyba při čtení souboru: "+e);
        }
    }

    public void zapisSouboru(){
        try(FileWriter fw = new FileWriter( cesta)){
            fw.write(txArea.getText());
        } catch (Exception e) {
            System.err.println("Chyba při zápisu souboru: "+e);
        }
    }
}
