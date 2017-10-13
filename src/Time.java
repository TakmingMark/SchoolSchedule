import java.util.ArrayList;

public class Time {
	public ArrayList<Integer> hour=new ArrayList<>();
	public ArrayList<Integer> minute=new ArrayList<>();
	public ArrayList<Integer> second=new ArrayList<>();
	
	private Time(){
		initialTime();
	}
	
	public static Time getTimeObject() {
		return new Time();
	}
	
	private void initialTime() {
		for(int i=1;i<=24;i++)
			hour.add(i);
		for(int i=1;i<=60;i++)
			minute.add(i);
		second.addAll(minute);
	}
}
