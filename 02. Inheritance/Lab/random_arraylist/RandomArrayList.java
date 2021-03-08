package random_arraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement(){
        int index = this.getRandomIndex();
        return super.remove(getRandomIndex());
    }

    private int getRandomIndex() {
        Random random = new Random();
        return random.nextInt(super.size());
    }
}
