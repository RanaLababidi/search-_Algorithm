package Models;

public class Movement {
    int steps;
    boolean khal;
    boolean playAgain;

    public Movement(int steps, boolean khal, boolean playAgain) {
        this.steps = steps;
        this.khal = khal;
        this.playAgain = playAgain;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public boolean isKhal() {
        return khal;
    }

    public void setKhal(boolean khal) {
        this.khal = khal;
    }

    public boolean isPlayAgain() {
        return playAgain;
    }

    public void setPlayAgain(boolean playAgain) {
        this.playAgain = playAgain;
    }
}
