package DatabaseFrm;

import DCGoddess.GoddessFlights;
import DCFlight.getFlights;
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
import java.sql.Connection;

public class FlightSearch extends Application {
    Text flights=new Text();
    Text price=new Text();
    Text numSeats=new Text();
    Text numAvail=new Text();

    TextField textField1=new TextField();TextField textField2=new TextField();

    public String getFromcity() {
        return textField1.getText();
    }
    public String getArivcity() {
        return textField2.getText();
    }
    @Override
    public void start(Stage primaryStage) {
        Font font=new Font(18);
        HBox pane1=new HBox();
        Label label=new Label("出发点：");
        label.setFont(font);

        textField1.setFont(font);

        Label labe2=new Label("目的地：");
        labe2.setFont(font);

        textField2.setFont(font);

        pane1.getChildren().addAll(label,textField1,labe2,textField2);

        VBox pane2=new VBox(10);

        HBox pane21=new HBox();
        Label label21=new Label("航班号：");
        label21.setFont(font);
        pane21.getChildren().addAll(label21,flights);

        HBox pane22=new HBox();
        Label label22=new Label("价格：");
        label22.setFont(font);
        pane22.getChildren().addAll(label22,price);

        HBox pane23=new HBox();
        Label label23=new Label("座位号：");
        label23.setFont(font);
        pane23.getChildren().addAll(label23,numSeats);

        HBox pane24=new HBox();
        Label label24=new Label("剩余票数：");
        label24.setFont(font);
        pane24.getChildren().addAll(label24,numAvail);

        flights.setFont(font);
        price.setFont(font);
        numSeats.setFont(font);
        numAvail.setFont(font);

        pane2.getChildren().addAll(pane21,pane22,pane23,pane24);

        Button button=new Button("查询");button.setFont(font);

        VBox pane=new VBox(15);
        pane.getChildren().addAll(pane1,pane2,button);

        Scene scene = new Scene(pane, 700, 300);
        primaryStage.setTitle("查询界面");
        primaryStage.setScene(scene);
        primaryStage.show();
        button.setOnAction(new action());
    }
    class action implements EventHandler<ActionEvent> {
        Connection con;
        public void handle(ActionEvent event){
            try{
                getFlights getFlights =new getFlights();
                GoddessFlights goddessFlights = getFlights.read(textField1.getText(),textField2.getText());
                flights.setText(goddessFlights.getFlightNum());
                price.setText(Integer.toString(goddessFlights.getPrice()));
                numSeats.setText(Integer.toString(goddessFlights.getNumSeats()));
                numAvail.setText(Integer.toString(goddessFlights.getNumAvail()));
            }catch (Exception e){
                System.out.println(textField1.getText());
                System.out.println("Frm异常");
            }
        }
    }
}
