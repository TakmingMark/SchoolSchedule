import java.io.File;

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
	
	public void writeToDoList() {
		
	}
	
	public boolean checkDayAndTime(String selectDay,String selectTime) {
		if((selectDay=="" ||selectDay.equals("")) &&(selectTime=="" || selectTime.equals(""))) {
			return false;
		}
		return true;
	}
}
