public class MainActivity {
	ScheduleModel scheduleModel;
	ScheduleView scheduleView;
	ScheduleController scheduleController;

	public static void main(String[] args) {
		new MainActivity().initialSchedule();
	}
	private void initialSchedule() {
		scheduleModel=ScheduleModel.getSCheduleModelObject();
		scheduleView=ScheduleView.getSCheduleViewObject(scheduleModel);
		scheduleView.initialSCheduleView();
		scheduleController=ScheduleController.getSCheduleController(scheduleView,scheduleModel);
		scheduleController.setModelFilePath();
	}

}
