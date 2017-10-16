import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ScheduleModel {
	private String selectDay;
	private String selectTime;
	private String remindEvent;
	
	private File file=null;
	private ScheduleModel() {
	
		// TODO Auto-generated constructor stub
	}
	
	public static ScheduleModel getSCheduleModelObject() {
		return new ScheduleModel();
	}
	
	public void setInformation(String selectDay,String selectTime,String remindEvent) {
		this.selectDay=selectDay;
		this.selectTime=selectTime;
		this.remindEvent=remindEvent;
	}
	
	public void setFilePath(String filePath) {
		file=new File(filePath);
	}
	
	public void outPutFileToDoList() {
		BufferedWriter bufferedWriter;
		try {
			bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			bufferedWriter.write("test");
			bufferedWriter.newLine();
			bufferedWriter.write("§A¦n0");
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean checkDayAndTime(String selectDay,String selectTime) {
		if((selectDay=="" ||selectDay.equals("")) &&(selectTime=="" || selectTime.equals(""))) {
			return false;
		}
		return true;
	}
}
