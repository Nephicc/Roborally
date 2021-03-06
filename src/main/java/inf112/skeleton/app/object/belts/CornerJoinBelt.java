package inf112.skeleton.app.object.belts;

import inf112.skeleton.app.enums.Direction;
import inf112.skeleton.app.enums.LeftRight;

public class CornerJoinBelt extends Belt {
    
    private LeftRight lr;

    public CornerJoinBelt(Direction dir, LeftRight lr) {
        super(dir);
        this.lr = lr;
    }
    
    public CornerJoinBelt(Direction dir, int strength, LeftRight lr) {
        super(dir,strength);
        this.lr = lr;
    }

    //Used for drawing on board
    public LeftRight getTurn() {
        return lr;
    }
    
    @Override
    public String getName() {
        return strength+""+lr+"join"+dir;
    }
}
