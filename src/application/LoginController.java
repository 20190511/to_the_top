package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

import org.jsoup.*;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

public class LoginController {
	
	protected static int new_check=0;
	protected static Map<String,String> cookies;
	protected static String ID_;
	protected static String PASS_;
	
	@FXML Label explain;   //FXML�� ���ν����� 
	@FXML TextField ID;
	@FXML TextField PASS;
	@FXML CheckBox CHECK;
	
	@FXML ChoiceBox<String> MAINBOX;
	
	private ObservableList<String> mainlist;  
	
	@FXML protected void OPEN(MouseEvent event){ 
		mainlist = FXCollections.observableArrayList();
		File folder = new File("c://SmartCampas");
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			File P = new File("c://SmartCampas//"+listOfFiles[i].getName()+"//PASSW.txt");
			if(P.exists()) {
				mainlist.add(listOfFiles[i].getName());
			}
		}
		
		MAINBOX.setItems(mainlist);
	}
	
	@FXML protected void LoginButton(ActionEvent on) { //�ش� ���ε� ��ư�� Ŭ�� �Ǿ����� 
		try {
			
			String tmp_=MAINBOX.getValue();
			if(tmp_!=null) {
				File P = new File("c://SmartCampas//"+tmp_+"//PASSW.txt");
				File SUBJECT_TITLE = new File("c://SmartCampas//"+tmp_+"//subject_title.txt");
				if(P.exists()) {
					if(SUBJECT_TITLE.exists()) {
						FileReader P_= new FileReader(P);
						BufferedReader P__ = new BufferedReader(P_);
						char[] array =P__.readLine().toCharArray();
						for (int j = 0; j < array.length; j++) {
						    array[j]-=2;
						}
						ID_=tmp_;
						PASS_=String.valueOf(array);
						P__.close();
						Parent login = FXMLLoader.load(getClass().getResource("Loding.fxml"));
						Scene scene = new Scene(login);
						Stage primaryStage = (Stage)PASS.getScene().getWindow(); // ���� ������ ��������
						primaryStage.setScene(scene);
						}
					}
				}
			
			File IMP = new File("c://SmartCampas//"+ID.getText());
			
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
					File PASSW = new File("c://SmartCampas//"+ID.getText()+"//PASSW.txt");
					if(!SmartCampas.exists()){
						SmartCampas.mkdirs();
			        }
					String PASSWORDS = PASS.getText();
					char[] array = PASSWORDS.toCharArray();
					for (int j = 0; j < array.length; j++) {
					    array[j]+=2;
					}
					PASSWORDS = String.valueOf(array);
					if(!IMP.exists()) {
						IMP.mkdirs();
						new_check++;
						if(CHECK.isSelected()==true) {
							if(!PASSW.exists()){
								FileWriter PASSW_= new FileWriter(PASSW);
								PASSW_.write(PASSWORDS);
								PASSW_.flush();
								PASSW_.close();
							}
						}
					}
					else {
						if(CHECK.isSelected()==true) {
							if(!PASSW.exists()){
								FileWriter PASSW_= new FileWriter(PASSW);
								PASSW_.write(PASSWORDS);
								PASSW_.flush();
								PASSW_.close();
					        }
						}
					}
					ID_=ID.getText();
					PASS_=PASS.getText();
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
