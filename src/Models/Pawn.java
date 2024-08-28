package Models;

public class Pawn {
    int position;
    Player player;

    public Pawn(int position, Player player) {
        this.position = position;
        this.player = player;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
