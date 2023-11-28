public class CommandGrabItem extends BaseCommand implements Command{
    public CommandGrabItem(){
        description = "saml et item op";
    }
    Item item; // Ensure that Item class and its methods are properly defined

    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (guardEq(parameters, 1)) {
            System.out.println("Missing item to grab");
            return;
        }

        // Assuming context.getCurrent().item(parameters[0]) returns an Item object
        boolean itemExists = context.getCurrent().getRoom().hasItem(parameters[0]);
        if(!itemExists){
            System.out.println("Are you high???");
            return;
        }
        Item currentItem = context.getCurrent().getRoom().getItem(parameters[0]);
        currentItem.grab(context);
    }
}


