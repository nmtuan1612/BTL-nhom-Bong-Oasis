package Main.Player;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Player  {
    private Image Coins ,life ;
    private int money  , Lìfe;
    private Text text , text2 , text3;
    private int Life ;
    public Player() {
        this.Life = 15 ;
        this.money = 15000;
        life = new Image("file:D:\\Cules\\BTL_1\\images\\heart.PNG") ;
        Coins = new  Image("file:D:\\Cules\\BTL_1\\images\\Coin.PNG") ;
        text = new Text() ;
        text2 = new Text() ;
        text3 = new Text() ;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(life , 1300 , 400 , 30 , 30);
        gc.drawImage(Coins, 1300 , 360 , 30, 30);
        gc.setFill(Color.DARKBLUE) ;
        Font font = Font.loadFont("file:D:\\Cules\\BTL_1\\font\\font.ttf" , 30) ;
        gc.setFont(font);
        text.setText(String.valueOf(money));
        text2.setText(String.valueOf(Life));
        gc.fillText(text.getText(),1340,385,50);
        gc.fillText(text2.getText() , 1340 , 425);
    }

    public void setMoney(int money) { this.money = money; }
    public int getMoney() { return money; }
    public void setLife(int life) { this.Life = life; }
    public int getLife() { return Life; }
}
