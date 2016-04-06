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
	@FXML TextField textNUMBER;
	
	public void add(ActionEvent e) throws SQLException{
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		java.sql.PreparedStatement myStmt = myConn
				.prepareStatement("insert into train(city_out,city_in,time_out,time_in,date,¹) values (?,?,?,?,?,?)");
		myStmt.setString(1, textCITY_OUT.getText());
		myStmt.setString(2, textCITY_IN.getText());
		myStmt.setString(3, textTIME_OUT.getText());
		myStmt.setString(4, textTIME_IN.getText());
		myStmt.setString(5, textDATE.getText());
		myStmt.setString(6, textNUMBER.getText());
		myStmt.executeUpdate();
		System.out.println("Complet!");		
	}
	
	public void dell_train(ActionEvent e) throws SQLException{
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		String deleteSQL_train  = "delete from train where city_out=? and city_in=? and time_out=? and time_in=? and date=? and ¹=? ";
		PreparedStatement preparedStatement_train = myConn.prepareStatement(deleteSQL_train);
		preparedStatement_train.setString(1, textCITY_OUT.getText());
		preparedStatement_train.setString(2, textCITY_IN.getText());
		preparedStatement_train.setString(3, textTIME_OUT.getText());
		preparedStatement_train.setString(4, textTIME_IN.getText());
		preparedStatement_train.setString(5, textDATE.getText());
		preparedStatement_train.setString(6, textNUMBER.getText());
		preparedStatement_train.executeUpdate();
		
		String deleteSQL_booking = "delete from seats where city_out=? and city_in=? and time_out=? and time_in=? and date=? and ¹=?";
		PreparedStatement preparedStatement_booking = myConn.prepareStatement(deleteSQL_booking);
		preparedStatement_booking.setString(1, textCITY_OUT.getText());
		preparedStatement_booking.setString(2, textCITY_IN.getText());
		preparedStatement_booking.setString(3, textTIME_OUT.getText());
		preparedStatement_booking.setString(4, textTIME_IN.getText());
		preparedStatement_booking.setString(5, textDATE.getText());
		preparedStatement_booking.setString(6, textNUMBER.getText());
		preparedStatement_booking.executeUpdate();
		
		System.out.println("Complet!");	
	}
	
	public void dell_booking(ActionEvent e) throws SQLException{
		
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/freemove", "root", "root");
		String deleteSQL_booking = "delete from seats where city_out=? and city_in=? and time_out=? and time_in=? and date=? and ¹=?";
		PreparedStatement preparedStatement_booking = myConn.prepareStatement(deleteSQL_booking);
		preparedStatement_booking.setString(1, textCITY_OUT.getText());
		preparedStatement_booking.setString(2, textCITY_IN.getText());
		preparedStatement_booking.setString(3, textTIME_OUT.getText());
		preparedStatement_booking.setString(4, textTIME_IN.getText());
		preparedStatement_booking.setString(5, textDATE.getText());
		preparedStatement_booking.setString(6, textNUMBER.getText());
		preparedStatement_booking.executeUpdate();
		
		System.out.println("Complet!");	
	}
}
