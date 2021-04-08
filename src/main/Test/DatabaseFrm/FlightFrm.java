/*
* 参考博客： https://blog.csdn.net/weiqiangGG/article/details/82890204
* 窗口跳转： https://blog.csdn.net/wzdnhcz/article/details/84314926
*/


package DatabaseFrm;
import DCFlight.DeleteF;
import DCFlight.InsertF;
import DCFlight.UpdateF;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


import java.sql.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class FlightFrm extends Application {

    Text text1=new Text();

    TextField textField1=new TextField();
    TextField textField2=new TextField();
    TextField textField3=new TextField();
    TextField textField4=new TextField();
    TextField textField5=new TextField();
    TextField textField6=new TextField();
    @Override
    public void start(Stage primaryStage) throws Exception{
        int width=720;
        int width_testField=width/6;
        int width_label=width/6;
        Font font1 = new Font(17);
        HBox label_pane=new HBox();
        label_pane.setPrefHeight(50);label_pane.setPrefWidth(600);
        Label label1=new Label("航班号");  label1.setPrefWidth(width_label);label1.setFont(font1);//label1.setPrefHeight(40);
        Label label2=new Label("机票价格");   label2.setPrefWidth(width_label);label2.setFont(font1);//label1.setPrefHeight(40);
        Label label3=new Label("座位号");label3.setPrefWidth(width_label);label3.setFont(font1);//label1.setPrefHeight(40);
        Label label4=new Label("剩余座位数");label4.setPrefWidth(width_label);label4.setFont(font1);//label1.setPrefHeight(40);
        Label label5=new Label("始发地");label5.setPrefWidth(width_label);label5.setFont(font1);//label1.setPrefHeight(40);
        Label label6=new Label("目的地");label6.setPrefWidth(width_label);label6.setFont(font1);//label1.setPrefHeight(40);
        label_pane.getChildren().addAll(label1,label2,label3,label4,label5,label6);

        HBox textField_pane=new HBox();
        textField_pane.setPrefHeight(50);label_pane.setPrefWidth(600);
        textField1.setPromptText("输入航班号");    textField1.setPrefWidth(width_testField);textField1.setFont(font1);//textField1.setPrefHeight(40);
        textField2.setPromptText("输入机票价格");  textField2.setPrefWidth(width_testField);textField2.setFont(font1);//textField1.setPrefHeight(40);
        textField3.setPromptText("输入座位号");    textField3.setPrefWidth(width_testField);textField3.setFont(font1);//textField1.setPrefHeight(40);
        textField4.setPromptText("输入剩余座位数");textField4.setPrefWidth(width_testField);textField4.setFont(font1);//textField1.setPrefHeight(40);
        textField5.setPromptText("输入出发地");    textField5.setPrefWidth(width_testField);textField5.setFont(font1);//textField1.setPrefHeight(40);
        textField6.setPromptText("输入目的地");    textField6.setPrefWidth(width_testField);textField6.setFont(font1);//textField1.setPrefHeight(40);
        textField_pane.getChildren().addAll(textField1,textField2,textField3,textField4,textField5,textField6);//pane2显示第二行

        StackPane text_pane=new StackPane();

        text1.setFont(font1);
        text_pane.getChildren().add(text1);

        HBox button_pane=new HBox();
        //button_pane.setPrefHeight(50);label_pane.setPrefWidth(600);
        Button button1=new Button("添加信息");button1.setFont(font1);
        Button button2=new Button("删除信息");button2.setFont(font1);
        Button button3=new Button("修改信息");button3.setFont(font1);
        Button button4=new Button("查询航班");button4.setFont(font1);
        button_pane.getChildren().addAll(button1,button2,button3,button4);

        VBox pane=new VBox();
        pane.getChildren().addAll(label_pane,textField_pane,text_pane,button_pane);pane.setPrefWidth(width);textField_pane.setPrefHeight(400);

        Scene scene=new Scene(pane);
        primaryStage.setTitle("航班信息查询");
        primaryStage.setScene(scene);
        primaryStage.show();

        button1.setOnAction(new Add_action());
        button2.setOnAction(new Delete_action());
        button3.setOnAction(new Update_action());
        button4.setOnAction(new Search_action());

    }
    class Add_action implements EventHandler<ActionEvent>{
        //Connection con;
        public void handle(ActionEvent event) {
            try {
                InsertF insertF =new InsertF(textField1.getText(),Integer.valueOf(textField2.getText()),Integer.valueOf(textField3.getText()),Integer.valueOf(textField4.getText()),textField5.getText(),textField6.getText());
                insertF.insertInfo();
                text1.setText("添加信息成功");
            }catch (Exception e){
                text1.setText("添加信息失败，重新输入");
            }
        }
    }
    class Delete_action implements EventHandler<ActionEvent>{
        //Connection con;
        public void handle(ActionEvent event){
            try {
                DeleteF deleteF =new DeleteF(textField1.getText());
                deleteF.deleteInfo();
                text1.setText("删除信息成功");

            }catch (Exception e){
                text1.setText("删除信息失败，重新输入");
            }
        }
    }
    class Update_action implements EventHandler<ActionEvent>{
        Connection con;
        public void handle(ActionEvent event){
            try{
                UpdateF updateF =new UpdateF(textField1.getText(),Integer.valueOf(textField2.getText()),Integer.valueOf(textField3.getText()),
                        Integer.valueOf(textField4.getText()),textField5.getText(),textField6.getText());
                updateF.updateInfo();
                text1.setText("修改信息成功");
            }catch (Exception e){
                text1.setText("修改信息失败，检查格式后重新输入");
            }
        }
    }
    class Search_action implements EventHandler<ActionEvent>{
        Connection con;
        public void handle(ActionEvent event){
            try{
                FlightSearch flightSearch =new FlightSearch();
                flightSearch.start(new Stage());
            }catch (Exception e){
            }
        }
    }
}




