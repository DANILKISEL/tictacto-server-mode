package tictacto.web;

public class Move {
    private int x;
    private int y;
    private String player; // "X" or "O"

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getPlayer() {
        return player;
    }
    public void setX(int setVal) {
        x = setVal;
    }
    public void setY(int setVal) {
        y = setVal;
    }
    public void setPlayer(String setVal) {
        player = setVal;
    }
    public Move(int X, int Y, String Player){
        this.x = X;
        this.y = Y;
        this.player = Player;
    }

}
