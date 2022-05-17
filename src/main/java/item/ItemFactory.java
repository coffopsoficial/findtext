package item;

import item.impl.ItemText;

public class ItemFactory {

    private ItemText itemText;

    public ItemSearch getImplementation(){
        if(itemText == null){
            itemText = new ItemText();
        }
        return itemText;
    }

}
