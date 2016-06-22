/**
 *Created by GaBi on 31.03.2016.
 */

public class Main {

    public static void main(String[] args) {
        // Initialization
        View view = new View();
        Model model = new Model(view);
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }

}
