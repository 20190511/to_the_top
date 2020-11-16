package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import org.jsoup.*;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

public class LoginController {
	
	protected static int new_check;
	protected static Map<String,String> cookies;
	protected static String ID_;
	
	@FXML Label explain;   //FXML�� ���ν����� 
	@FXML TextField ID;
	@FXML TextField PASS;
	
	@FXML protected void LoginButton(ActionEvent on) { //�ش� ���ε� ��ư�� Ŭ�� �Ǿ����� 
		try {
			
			Response loginResponse = (Response)Jsoup.connect("https://myclass.ssu.ac.kr/login/index.php")  //�켱�����δ� �α���
					.data("username", ID.getText())
					.data("password" , PASS.getText())
					.method(Method.POST)
					.execute();
				
			cookies = loginResponse.cookies();
				
			Document login_check = Jsoup.connect("http://myclass.ssu.ac.kr/")   //�ش� ��Ű�� ������
					.cookies(cookies)
					.get();
				
			String log = login_check.toString();   //�񱳺�
			String check_str =  "���̵� / ��й�ȣ ã��";
			int check_str_index = log.indexOf(check_str);
			if(check_str_index == -1)  //������ ���� â���� ���� �������־ �Ѿ��
			{
				try{
					File SmartCampas = new File("c://SmartCampas");
					if(!SmartCampas.exists()){
						SmartCampas.mkdirs();
			        }
					File IMP = new File("c://SmartCampas//"+ID.getText());
					if(!IMP.exists()) {
						IMP.mkdirs();
						new_check=1;
					}
					else {
						new_check=0;
					}
					
					ID_=ID.getText();

				    Parent login = FXMLLoader.load(getClass().getResource("Loding.fxml"));
				    Scene scene = new Scene(login);
				    Stage primaryStage = (Stage)PASS.getScene().getWindow(); // ���� ������ ��������
				    primaryStage.setScene(scene);
				 } catch(Exception e){
					 
				}
			}
			else {
				explain.setLayoutY(180);   //���̺� ��ġ �������� �ش� ���̺� ���� ����
				explain.setLayoutX(47);
				explain.setText("���̵�� ��й�ȣ�� Ʋ�Ƚ��ϴ�. Ȯ�����ּ���.");
			}
			ID.clear();   //Ʋ�ȱ⿡ �Էµ��ִ� ���̵�� ����� ������
			PASS.clear();
			
		}	catch(IOException a) {
			
		}
		}
	
	@FXML protected void DeleteButton(ActionEvent on){  //����� ��ư�� ������ �� �ؽ�Ʈ �ʵ��� ������ ������
		ID.clear();
		PASS.clear();
		}

}
