import item.ItemFactory;
import item.ItemSearch;

import java.io.File;
import java.util.HashSet;

public class DirectorySearch {

    private final ItemSearch itemSearch;

    public DirectorySearch(){
        itemSearch = new ItemFactory().getImplementation();
    }

    public HashSet<String> search(HashSet<String> itens, File mainDirectory) {
        File[] directoryItens = mainDirectory.listFiles();
        if(directoryItens != null) {
            searchItens(itens, directoryItens);
        }
        return itens;
    }

    private void searchItens(HashSet<String> itens, File[] directoryItens){
        for (File item : directoryItens) {
            if (item.isDirectory()) {
                search(itens, item);
            } else {
                itens.addAll(itemSearch.getValue(item));
            }
        }
    }
}
