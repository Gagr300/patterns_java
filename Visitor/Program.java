import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.max;

public class Program {
    public static void main(String[] args) {
        List<IGame> sessions = new ArrayList<IGame>();
        try {
            sessions = Arrays.asList(
                    new Tetris(1100), new Tetris(1200), new Cards(0, 3),
                    new Cards(1, 2), new Puzzle(120), new Cards(4, 5),
                    new Tetris(1100), new Puzzle(20), new Puzzle(105),
                    new Tetris(1145), new Puzzle(200), new Puzzle(-15)

            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        GamePartitioner partitioner = new GamePartitioner();
        for (IGame session : sessions) session.accept(partitioner);
        System.out.println("Tetris\tCount: " + partitioner.getTetris() + "\tMax Score: " + partitioner.getTetrisMaxScore());
        System.out.println("Cards\tCount: " + partitioner.getCards() + "\tMax Score: " + partitioner.getCardsMaxScore());
        System.out.println("Puzzle\tCount: " + partitioner.getPuzzle() + "\tMax Score: " + partitioner.getPuzzleMaxScore());

    }
}
interface IVisitor
{
    public void visit(Tetris game);
    public void visit(Cards game);
    public void visit(Puzzle game);
}
class IGame {
    public void accept(IVisitor visitor) {}
}
class Tetris extends IGame
{
    private int score;
    public int getScore(){
        return score;
    }
    public Tetris(int score)throws IllegalArgumentException {
        if (score<0) throw new IllegalArgumentException("Exception! Невозможен отрицательный счет");
        this.score=score;
    }
    @Override
    public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }
}
class Cards extends IGame
{
    private int wins;
    private int sets;
    public int getWins() {
        return wins;
    }
    public Cards(int wins, int sets) throws IllegalArgumentException {
        if (wins<0 || sets<0) throw new IllegalArgumentException("Exception! Невозможно отрицательное количество игр");
        this.wins=wins;
        this.sets=sets;
    }
    @Override
    public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }
}
class Puzzle extends IGame
{
    private int score;

    public int getScore(){
        return score;
    }
    public Puzzle(int score)throws IllegalArgumentException {
        if (score<0) throw new IllegalArgumentException("Exception! Невозможен отрицательный счет");
        this.score=score;
    }
    @Override
    public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }
}

class GamePartitioner implements IVisitor {
    private List<Tetris> Tetris;
    private List<Cards> Cards;
    private List<Puzzle> Puzzle;

    public int getTetrisMaxScore (){
        int ret = 0;
        for (Tetris t : Tetris) ret = max(ret, t.getScore());
        return  ret;
    }
    public int getCardsMaxScore (){
        int ret = 0;
        for (Cards c : Cards) ret = max(ret, c.getWins());
        return  ret;
    }
    public int getPuzzleMaxScore (){
        int ret = 0;
        for (Puzzle p : Puzzle) ret = max(ret, p.getScore());
        return  ret;
    }
    public int getTetris (){
        return Tetris.size();
    }
    public int getCards (){
        return Cards.size();
    }
    public int getPuzzle (){
        return Puzzle.size();
    }
    public GamePartitioner() {
        Tetris = new ArrayList<Tetris>();
        Cards = new ArrayList<Cards>();
        Puzzle = new ArrayList<Puzzle>();
    }
    @Override
    public void visit(Tetris game) {
        Tetris.add(game);
    }
    @Override
    public void visit(Cards game) {
        Cards.add(game);
    }
    @Override
    public void visit(Puzzle game) {
        Puzzle.add(game);
    }
}
