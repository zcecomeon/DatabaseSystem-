package DatabaseFrm;

import DCGoddess.GoddessReservations;
import DCReservation.getReservations;
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

public class ReservationSearch extends Application {
    Text custName=new Text();
    Text resvType=new Text();
    Text resvKey=new Text();
    TextField textField1=new TextField();
    @Override
    public void start(Stage primaryStage) {
        Font font=new Font(18);
        HBox pane1=new HBox();
        Label label=new Label("输入订单号：");
        label.setFont(font);

        textField1.setFont(font);textField1.setPromptText("输入待查询单号");

        pane1.getChildren().addAll(label,textField1);

        VBox pane2=new VBox(10);

        HBox pane21=new HBox();
        Label label21=new Label("订单姓名：");
        label21.setFont(font);
        pane21.getChildren().addAll(label21,custName);

        HBox pane22=new HBox();
        Label label22=new Label("预定类型：");
        label22.setFont(font);
        pane22.getChildren().addAll(label22,resvType);

        HBox pane23=new HBox();
        Label label23=new Label("预定单号：");
        label23.setFont(font);
        pane23.getChildren().addAll(label23,resvKey);

//        HBox pane24=new HBox();
//        Label label24=new Label("可预订车票数量：");
//        label24.setFont(font);
//        pane24.getChildren().addAll(label24,numAvail);

        custName.setFont(font);
        resvType.setFont(font);
        resvKey.setFont(font);

        pane2.getChildren().addAll(pane21,pane22,pane23);

        Button button=new Button("查询");button.setFont(font);

        VBox pane=new VBox(15);
        pane.getChildren().addAll(pane1,pane2,button);

        Scene scene = new Scene(pane, 700, 300);
        primaryStage.setTitle("预定信息");
        primaryStage.setScene(scene);
        primaryStage.show();
        button.setOnAction(new action());
    }

    class action implements EventHandler<ActionEvent> {
        // Connection con;
        public void handle(ActionEvent event){
            try{
                getReservations getReservations=new getReservations();
                GoddessReservations goddessReservations= getReservations.read(textField1.getText());
                custName.setText(goddessReservations.getCustName());
                resvType.setText(goddessReservations.getResvType());
                resvKey.setText(goddessReservations.getResvKey());
                System.out.println("Frm正常");
            }catch (Exception e){
                System.out.println(textField1.getText());
                System.out.println("Reservations异常");
            }

        }
    }
}

