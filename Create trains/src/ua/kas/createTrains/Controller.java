package ua.kas.createTrains;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

	@FXML TextField textDATE;
	@FXML TextField textCITY_OUT;
	@FXML TextField textCITY_IN;
	@FXML TextField textTIME_OUT;
	@FXML TextField textTIME_IN;
	@FXML TextField textSEATS;
	
	public void add(ActionEvent e) throws SQLException{
		String t = "1";
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		java.sql.PreparedStatement myStmt = myConn
				.prepareStatement("insert into train(city_out,city_in,time_out,time_in,date,train) values (?,?,?,?,?,?)");
		myStmt.setString(1, textCITY_OUT.getText());
		myStmt.setString(2, textCITY_IN.getText());
		myStmt.setString(3, textTIME_OUT.getText());
		myStmt.setString(4, textTIME_IN.getText());
		myStmt.setString(5, textDATE.getText());
		myStmt.setString(6, t);
		myStmt.executeUpdate();
		System.out.println("Complet!");		
	}
	
	public void dell(ActionEvent e) throws SQLException{
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		String deleteSQL = "delete from train where city_out=? and city_in=? and time_out=? and time_in=? and date=? ";
		PreparedStatement preparedStatement = myConn.prepareStatement(deleteSQL);
		preparedStatement.setString(1, textCITY_OUT.getText());
		preparedStatement.setString(2, textCITY_IN.getText());
		preparedStatement.setString(3, textTIME_OUT.getText());
		preparedStatement.setString(4, textTIME_IN.getText());
		preparedStatement.setString(5, textDATE.getText());
		preparedStatement.executeUpdate();
		System.out.println("Complet!");		
	}
}
