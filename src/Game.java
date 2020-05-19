import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Game implements ActionListener, KeyListener {
    public static Game game;

    public JFrame frame;
    public RenderPanel renderPanel;
    public boolean running;
    public Timer timer = new Timer(100, this);
    public static int xScale = 15, yScale = 10, width = 260, height = 400;
    public Bird bird;
    public List <Pipe> pipeList = new ArrayList<>();
    public Pipe pipe;

    public Game(){
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.add(renderPanel = new RenderPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(this);
        running = true;
        timer.setDelay(20);
        timer.start();

        startGame();
    }
    public void startGame(){
        bird = new Bird(20,50);
        pipe = new Pipe(width, 200);
    }

    public static void main(String[] args){
        game = new Game();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (running){
            renderPanel.repaint();
            bird.movement();
            pipe.movement();

            if (bird.collided()){
                running = false;
                System.out.println("u deded");
            }
            if (pipeList.get(0).point1.x < 0){
                pipeList.remove(0);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int i = keyEvent.getKeyCode();
        if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP || i == KeyEvent.VK_SPACE)){
            bird.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
