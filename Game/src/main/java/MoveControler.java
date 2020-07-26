public class MoveControler {
    public MoveControler(boolean move) {
        this.move = move;
    }

    boolean move;

    public void nextMove (){
        if (move == true){
            move = false;
        }else {
            move = true;
        }

    }
}
