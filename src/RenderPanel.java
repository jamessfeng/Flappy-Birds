import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RenderPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //
//        g.setColor(Color.BLACK);
//        g.fillRect(0,0, 200,500);
        Game game = Game.game;
        Bird bird = game.bird;
        BufferedImage birdPic = null;
        BufferedImage background = null;
        BufferedImage pipeDown = null;
        BufferedImage pipeUp = null;

        try {
            birdPic = ImageIO.read(new File("bird.png"));
            background = ImageIO.read(new File("background.png"));
            pipeDown = ImageIO.read(new File("pipeDown.png"));
            pipeUp = ImageIO.read(new File("pipeUp.png"));
        } catch (IOException e) {
            System.out.println("Picture not found");
            e.printStackTrace();
        }
        //Painting bird
//        File file = new File("test");
//        System.out.println(file.getAbsoluteFile());
        g.drawImage(background, 0, 0, null);
        g.drawImage(birdPic, bird.point.x, bird.point.y, null);

        for (Pipe curPipe: game.pipeList){
            g.drawImage(pipeDown, curPipe.point1.x, curPipe.point1.y, null);
            g.drawImage(pipeUp, curPipe.point2.x, curPipe.point2.y-250, null);

//            g.fillRect(curPipe.point1.x, curPipe.point1.y, 10, Game.height-curPipe.point1.y);
//            g.fillRect(curPipe.point2.x, 0, 10,curPipe.point2.y);
        }
        g.setColor(Color.black);
        g.drawString("Score " + game.score, 5, 20);

    }
}
