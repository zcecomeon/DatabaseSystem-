package DatabaseFrm;

import DCGoddess.GoddessBuses;
import DCBus.getBuses;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BusSearch extends Application {
    Text location=new Text();
    Text price=new Text();
    Text numRooms=new Text();
    Text numAvail=new Text();
    TextField textField1=new TextField();

    @Override
    public void start(Stage primaryStage) {
        Font font=new Font(18);
        HBox pane1=new HBox();
        Label label=new Label("输入城市：");
        label.setFont(font);

        textField1.setFont(font);

        pane1.getChildren().addAll(label,textField1);

        VBox pane2=new VBox(10);

        HBox pane21=new HBox();
        Label label21=new Label("城市：");
        label21.setFont(font);
        pane21.getChildren().addAll(label21,location);

        HBox pane22=new HBox();
        Label label22=new Label("车费：");
        label22.setFont(font);
        pane22.getChildren().addAll(label22,price);

        HBox pane23=new HBox();
        Label label23=new Label("大巴车票数量：");
        label23.setFont(font);
        pane23.getChildren().addAll(label23,numRooms);

        HBox pane24=new HBox();
        Label label24=new Label("可预订车票数量：");
        label24.setFont(font);
        pane24.getChildren().addAll(label24,numAvail);

        location.setFont(font);
        price.setFont(font);
        numRooms.setFont(font);
        numAvail.setFont(font);

        pane2.getChildren().addAll(pane21,pane22,pane23,pane24);

        Button button=new Button("查询");button.setFont(font);

        VBox pane=new VBox(15);
        pane.getChildren().addAll(pane1,pane2,button);

        Scene scene = new Scene(pane, 700, 300);
        primaryStage.setTitle("大巴查询界面");
        primaryStage.setScene(scene);
        primaryStage.show();
        button.setOnAction(new action());
    }

    class action implements EventHandler<ActionEvent> {
        // Connection con;
        public void handle(ActionEvent event){
            try{
                 getBuses getBuses=new getBuses();
                GoddessBuses goddessBuses = getBuses.read(textField1.getText());
                location.setText(goddessBuses.getLocation());
                price.setText(Integer.toString(goddessBuses.getPrice()));
                numRooms.setText(Integer.toString(goddessBuses.getNumBuses()));
                numAvail.setText(Integer.toString(goddessBuses.getNumAvail()));
                System.out.println("Frm正常");
            }catch (Exception e){
                System.out.println(textField1.getText());
                System.out.println("BusSearch异常");
            }

        }
    }
}

