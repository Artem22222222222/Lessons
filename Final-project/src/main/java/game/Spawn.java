package game;

public class Spawn {
    UI ui;
    Thread mainThread;
    private final Object syncObject = new Object();
    private int monstersRemained;
    public Spawn(UI ui, int monstersRemained){
        this.ui = ui;
        this.monstersRemained = monstersRemained;
        mainThread = new Thread(this::spawn);
        mainThread.start();
    }
    private void spawn(){
        while (!ui.getHero().isGameEnd() && !(monstersRemained < 1)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ui.getController().getModel().getMonsters().add(new MonsterButton(ui, 50, 50));
            ui.getMainLandBackground().add(ui.getController().getModel().getMonsters().getLast());
            monstersRemained -= 1;
        }
    }
}
