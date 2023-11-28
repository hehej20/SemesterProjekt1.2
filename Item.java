public class Item {
    private String name;
    private String description;

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void grab(Context context) {
        // Implement the logic for grabbing the item
        // For example, you can remove the item from the current context
        context.getCurrent().getRoom().removeItem(name);
        System.out.println("You grabbed the item: " + this.getName());
        Game.inventory.addItem(name);
    }

    public String getName(){

        return name;
    }

    public void setName(String name){

        this.name = name;
    }

    public String getDescription(){

        return description;
    }

    public void setDescription(String description){

        this.description = description;
    }

}
