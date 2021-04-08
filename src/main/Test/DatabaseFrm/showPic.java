package DatabaseFrm;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class showPic extends Application {

    @Override
    public void  start(Stage stage){
        Pane stackPane=new Pane();
        stackPane.setPrefSize(300, 300);
// x|y 填充起始坐标
// width|height proportional 为true 代表缩放比例, 为false 代表实际尺寸
//        ImagePattern imagePattern = new ImagePattern(new Image("file:11.jpg"), 0, 0, 0.5, 0.5, true);
//        stackPane.setBackground(new Background(new BackgroundFill(imagePattern, CornerRadii.EMPTY, Insets.EMPTY)));
        Image image=new Image("file:C://Users//cozce//Pictures//Saved Pictures//11.jpg");
        ImageView imageView=new ImageView(image);
        //imageView.setImage(image);
        stackPane.getChildren().add(imageView);
        Scene scene=new Scene(stackPane);
        stage.setTitle("呵呵呵");
        stage.setScene(scene);
        stage.show();

    }
}
