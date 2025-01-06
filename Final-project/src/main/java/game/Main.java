package game;

public class Main {
    public void main(String[] args){
        Controller controller = new Controller();
        UI ui = new UI(controller);
        Model model = new Model(controller);
        controller.setUi(ui);
        controller.setModel(model);

        ui.getMainLand().addKeyListener(model);
        ui.getMainLand().setFocusable(true);
        ui.getMainLand().requestFocusInWindow();
    }
}
