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
        try {
            birdPic = ImageIO.read(new File("bird.png"));
            background = ImageIO.read(new File("background.png"));
        } catch (IOException e) {
            System.out.println("Picture not found");
            e.printStackTrace();
        }
        //Painting bird
//        File file = new File("test");
//        System.out.println(file.getAbsoluteFile());
        g.drawImage(background, 0, 0, null);
        g.drawImage(birdPic, bird.point.x, bird.point.y, null);

        g.setColor(Color.RED.brighter());
        g.fillRect(game.pipe.point1.x, game.pipe.point1.y, 10, Game.height-game.pipe.point1.y);

    }
}
