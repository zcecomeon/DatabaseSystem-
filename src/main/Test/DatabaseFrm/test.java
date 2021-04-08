/*
 *参考博客： https://www.cnblogs.com/bigsai/p/13501559.html
 *窗口跳转： https://blog.csdn.net/wzdnhcz/article/details/84314926
 * git取消版本控制：进入project的根目录中，右击鼠标打开Git Bash
 * 输入 find . -name ".git" | xargs rm -Rf
 * */
package DatabaseFrm;
import DatabaseInfo.flights;
import DatabaseManage.Sql;
import DCFlight.UpdateF;
import org.junit.Test;

import java.sql.SQLException;

public class test {
    @Test
    public void insertTest() throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        Sql.insertflights(new flights("10011", 350, 001, 200, "Xian", "Beijing"));
        //Sql.insertflights(new flights(str1,str2,str3,str4,str5,str6));

    }

    @Test
    public void deleteTest() throws SQLException, ClassNotFoundException {
        Sql Sql = new Sql();
        Sql.deleteflights("1002");
    }
    @Test
    public void readtest() throws SQLException,ClassNotFoundException{
//        getFlights getFlights=new getFlights();
//        GoddessFlights goddess;
//        //goddess=getFlights.read();
//        System.out.println(goddess.getFlightNum());
//        System.out.println(goddess.getFromCity());System.out.println(goddess.getArivCity());
    }
    @Test
    public void updatetest() throws SQLException,ClassNotFoundException{
        UpdateF updateF =new UpdateF("A-3024",421,54,42,"吉林","石家庄");
        updateF.updateInfo();
    }

}
