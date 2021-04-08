package DatabaseFrm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ViewFrm extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        GridPane pane=new GridPane();
        pane.setPrefHeight(600);pane.setPrefWidth(300);

        VBox  vBox=new VBox();
        Font font=new Font(25);
        Button[] button=new Button[5];
        String[] strings=new String[5];
        strings[0]="航班服务大厅";strings[1]="宾馆服务大厅";strings[2]="大巴服务中心";
        strings[3]="个人中心";strings[4]="预定信息查询";
        for(int i=0;i<5;i++) {
            button[i]=new Button(strings[i]);button[i].setFont(font);
            button[i].setPrefHeight(120);button[i].setPrefWidth(300);
            //vBox.getChildren().add(button[i]);
        }
//        Button button1=new Button("noigang");
//        vBox.getChildren().add(button[0]);
        //pane.getChildren().add(vBox);
        pane.add(button[0],0,0);
        pane.add(button[1],0,1);
        pane.add(button[2],0,2);
        pane.add(button[3],0,3);
        pane.add(button[4],0,4);
       // pane.add(button[5],0,0);

        Scene scene=new Scene(pane);

        stage.setTitle("欢迎进入系统");
        stage.setScene(scene);
        stage.show();

        button[0].setOnAction(new action0());button[1].setOnAction(new action1());button[2].setOnAction(new action2());
        button[3].setOnAction(new action3());button[4].setOnAction(new action4());
    }

    class action0 implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event){
            try{
                FlightFrm flightFrm=new FlightFrm();
                flightFrm.start(new Stage());
            }catch (Exception e){
                System.out.println("跳转失败");
            }
        }
    }
    class action1 implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event){
            try{
                HotelsFrm hotelsFrm=new HotelsFrm();
                hotelsFrm.start(new Stage());

            }catch (Exception e){
                System.out.println("打开失败");
            }
        }
    }
    class action2 implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event){
            try{
                BusFrm busFrm=new BusFrm();
                busFrm.start(new Stage());
            }catch (Exception e){
                System.out.println("打开失败");
            }
        }
    }
    class action3 implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event){
            try{
                CustomerFrm customerFrm=new CustomerFrm();
                customerFrm.start(new Stage());

            }catch (Exception e){

            }
        }
    }
    class action4 implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event){
            try{
                ReservationFrm reservationFrm=new ReservationFrm();
                reservationFrm.start(new Stage());

            }catch (Exception e){

            }
        }
    }

}
