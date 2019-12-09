package Main.Button;

//import Main.Manager;
import Main.Main;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BuildButton extends Group {
  //  Manager BGObj = new Manager();
    int buttonX;
    int buttonY;
    int buttonWidth;
    int buttonHeight;

    public BuildButton(int buttonX, int buttonY, String img) {
          ImageView iv = new ImageView(new Image("img"));
          iv.setFitWidth(80);
          iv.setFitHeight(80);
          Button tower = new Button("", iv);
          tower.setStyle("-fx-border-color: #FF8C00; -fx-background-color: #DAA520;");
          tower.setLayoutX(14 * 96 + 65);
          tower.setLayoutY(8 * 96 + 48);
          tower.setOnMouseEntered(e->{
              tower.setStyle("-fx-background-color: #FFFAF0;");
          });
          tower.setOnMouseExited(e->{
              tower.setStyle("-fx-background-color: #DAA520");
          });
          tower.setOnMouseClicked(e-> {

          });
    }
}
