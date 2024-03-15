package task1;

public class LoadMenu {
    private static LoadMenu instance;
     
    private LoadMenu(){
    }
    
    public static LoadMenu getLoaderInstance(){
        if(instance != null){
            return instance;
        } else {
            instance = new LoadMenu();
            return instance;
        }
    }
    public void mainMenu(){
        System.out.printf("%-22s%n","----------------------");
        System.out.printf("%-22s%n","Literature Prize Menu ");
        System.out.printf("%-22s%n","----------------------");
        System.out.printf("%-22s%n","List ................1");
        System.out.printf("%-22s%n","Select ..............2");
        System.out.printf("%-22s%n","Search ..............3");
        System.out.printf("%-22s%n","Exit.................0");
        System.out.printf("%-22s%n","----------------------");
    }
    public boolean processChoice(int choice){
        switch(choice){
            case 1:
                System.out.println("List selected");
                return true;
            case 2: 
                System.out.println("Select selected");
                return true;
            case 3: 
                System.out.println("Search selected");
                return true;
            case 0: 
                System.out.println("Exiting...");
                return true;
            default:
                return false;
        }
    }
}