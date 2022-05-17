import javax.swing.*;
import java.io.File;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String mainFolder = JOptionPane.showInputDialog("Digite o diretório inicial para a leitura dos arquivos .TXT");
        File mainDirectory = new File(mainFolder);
        DirectorySearch directorySearch = new DirectorySearch();
        HashSet<String> itens = directorySearch.search(new HashSet<>(), mainDirectory);
        itens.forEach(System.out::println);
    }
}
