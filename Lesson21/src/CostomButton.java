import javax.swing.*;

public class CostomButton extends JButton {
    private int stepX;
    private int stepY;
    private boolean notGameEnd = true;

    public int getStepX() {
        return stepX;
    }

    public void setStepX(int stepX) {
        this.stepX = stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public void setStepY(int stepY) {
        this.stepY = stepY;
    }
    public void gameEnd(){
        UI.notGameEnd = false;
    }
    public void gameOver(){
        notGameEnd = false;
    }

    public boolean isNotGameEnd() {
        return notGameEnd;
    }
}

