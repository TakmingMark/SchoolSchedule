import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleController {
	private ScheduleView scheduleView;
	private ScheduleModel scheduleModel;
	private String filePath="C:\\schedule.txt";
	public ScheduleController(ScheduleView scheduleView,ScheduleModel scheduleModel) {
		this.scheduleView=scheduleView;
		this.scheduleModel=scheduleModel;
		scheduleView.addInsertListener(new InsertAction());
	}
	
	public static ScheduleController getSCheduleController(ScheduleView scheduleView,ScheduleModel scheduleModel) {
		return new ScheduleController(scheduleView,scheduleModel);
	}
	
	public void setModelFilePath() {
		scheduleModel.setFilePath(filePath);
	}
	
	class InsertAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			scheduleModel.setInformation(scheduleView.getDay(),scheduleView.getTime(),scheduleView.getRemindEvent());
			scheduleModel.writeToDoList();
		}	
	}
}
