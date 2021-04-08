package DatabaseFrm;

import DCGoddess.GoddessCustomers;
import DCCustomer.getCustomers;
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

public class CustomerSearch extends Application {
    Text custName =new Text();
    Text custID =new Text();
    TextField textField1=new TextField();

    @Override
    public void start(Stage primaryStage) {
        Font font=new Font(18);
        HBox pane1=new HBox();
        Label label=new Label("输入订单者姓名：");
        label.setFont(font);

        textField1.setFont(font);

        pane1.getChildren().addAll(label,textField1);

        VBox pane2=new VBox(10);

        HBox pane21=new HBox();
        Label label21=new Label("订单者姓名：");
        label21.setFont(font);
        pane21.getChildren().addAll(label21, custName);

        HBox pane22=new HBox();
        Label label22=new Label("订单者ID：");
        label22.setFont(font);
        pane22.getChildren().addAll(label22, custID);

        custName.setFont(font);
        custID.setFont(font);

        pane2.getChildren().addAll(pane21,pane22);

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
                getCustomers getCustomers=new getCustomers();
                GoddessCustomers goddessCustomers = getCustomers.read(textField1.getText());
                custName.setText(goddessCustomers.getCastName());
                custID.setText(goddessCustomers.getCustID());
                System.out.println("Frm正常");
            }catch (Exception e){
                System.out.println(textField1.getText());
                System.out.println("BusSearch异常");
            }
        }
    }
}
