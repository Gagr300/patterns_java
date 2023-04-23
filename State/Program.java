import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        StateCounter context = new StateCounter();
        context.plus(10);
        context.minus(12);
        context.plus(2);
        context.plus(2);
    }
}

interface State {
    String getDesciption();
    void minus(StateCounter context);
    void plus(StateCounter context);
}

class ZeroState implements State {
    public String getDesciption() {return "zero";}
    public void minus(StateCounter context) {}
    public void plus(StateCounter context) {}
}

class NegativeState implements State {
    public String getDesciption() {return "negative";}
    public void minus(StateCounter context) {}
    public void plus(StateCounter context) {}
}
class PositiveState implements State {
    public String getDesciption() {return "positive";}
    public void minus(StateCounter context) {}
    public void plus(StateCounter context) {}
}

class StateCounter {
    private State state = new ZeroState();
    protected int cnt = 0;

    public void minus(int mn) {
        System.out.println("Minus " + mn + " in "  + cnt + " of " + state.getDesciption());
        cnt -= mn;
        state.minus(this);
        changeState();
    }

    public void plus(int pl) {
        System.out.println("Plus " + pl + " in " + cnt + " of " + state.getDesciption() );
        cnt += pl;
        state.plus(this);
        changeState();
    }

    public void setState(State state) {
        System.out.println("Changing state to " + state.getDesciption());
        this.state = state;
    }

    public void changeState() {
        if (cnt == 0) setState(new ZeroState());
        else if (cnt < 0) setState(new NegativeState());
        else setState(new PositiveState());
    }

    public State getState() {
        return state;
    }
}
