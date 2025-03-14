import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GUI extends JFrame {

    private JTextArea txArea;
    private JPanel pnMain;
    private String cesta;


    public GUI(){
        initComponent();
    }

    private void initComponent(){
        setContentPane(pnMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);

        JMenuBar jmenuBar = new JMenuBar();
        setJMenuBar(jmenuBar);

        JMenu menu = new JMenu("Soubor");
        jmenuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Otevřít");
        JMenuItem saveItem = new JMenuItem("Uložit");

        menu.add(openItem);
        menu.add(saveItem);

        saveItem.addActionListener(e -> zapisSouboru());
        openItem.addActionListener(e -> vyberSoubor());
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
