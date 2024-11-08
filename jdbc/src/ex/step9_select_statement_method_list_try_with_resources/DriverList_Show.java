package ex.step9_select_statement_method_list_try_with_resources;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DriverList_Show {

    public static void main(String[] args) {
        //클래스패스에 있는 모든 JDBC 드라이버는 자동으로 DriverManager.getDrivers();
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        //등록된 드라이버 목록 출력
        while(drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();

            //Driver: oracle.jdbc.OracleDriver
            System.out.println("Driver: " + driver.getClass().getName());
        }
    }
}
