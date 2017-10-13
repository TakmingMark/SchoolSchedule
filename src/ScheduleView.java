import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.security.PrivilegedActionException;

import javax.naming.InitialContext;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.omg.CORBA.PRIVATE_MEMBER;

public class ScheduleView {
	private ScheduleModel scheduleModel;
	private JFrame jFrame;
	private JPanel panelContainer;
	private JPanel topPanel,middlePanel,bottomPanel;
	private JCheckBox mandy;
	private JCheckBox tuesday;
	private JCheckBox wednesday;
	private JCheckBox thursday;
	private JCheckBox firday;
	private JCheckBox saturday;
	private JCheckBox sunday;
	
	private Time time;
	private JLabel labelHour;
	private JLabel labelMinute;
	private JLabel labelSecond;
	private JComboBox<Integer> hour;
	private JComboBox<Integer> minute;
	private JComboBox<Integer> second;
	
	private JTextArea remindEventText;
	
	private JButton insert,cancel,query;

	private ScheduleView(ScheduleModel scheduleModel){
		this.scheduleModel=scheduleModel;
		jFrame=new JFrame("Schedule");
		panelContainer=new JPanel();
		topPanel=new JPanel();
		middlePanel=new JPanel();
		bottomPanel=new JPanel();
		
		mandy=new JCheckBox("Mandy");
		tuesday=new JCheckBox("Tuesday");
		wednesday=new JCheckBox("Wednesday");
		thursday=new JCheckBox("Thursday");
		firday=new JCheckBox("Firday");
		saturday=new JCheckBox("Saturday");
		sunday=new JCheckBox("Sunday");
		
		time=Time.getTimeObject();
		labelHour=new JLabel("Hour");
		labelMinute=new JLabel("Minute");
		labelSecond=new JLabel("Second");
		hour=new JComboBox<>(time.hour.toArray(new Integer[time.hour.size()]));
		minute=new JComboBox<>(time.minute.toArray(new Integer[time.minute.size()]));
		second=new JComboBox<>(time.second.toArray(new Integer[time.second.size()]));
		
		remindEventText=new JTextArea(5, 20);
	
		insert=new JButton("Insert Event");
		cancel=new JButton("Cancel Event");
		query=new JButton("Query Event");
	}
	
	public void initialSCheduleView() {
		topPanel.setLayout(new BorderLayout());
		Box checkBoxContainer=Box.createHorizontalBox();
		checkBoxContainer.add(mandy);
		checkBoxContainer.add(tuesday);
		checkBoxContainer.add(wednesday);
		checkBoxContainer.add(thursday);
		checkBoxContainer.add(firday);
		checkBoxContainer.add(saturday);
		checkBoxContainer.add(sunday);
		topPanel.add(checkBoxContainer,BorderLayout.NORTH);
		Box timeContainer=Box.createHorizontalBox();
		
		timeContainer.add(Box.createHorizontalStrut(30));
		timeContainer.add(labelHour);
		timeContainer.add(hour);
		timeContainer.add(Box.createHorizontalStrut(30));
		timeContainer.add(labelMinute);
		timeContainer.add(minute);
		timeContainer.add(Box.createHorizontalStrut(30));
		timeContainer.add(labelSecond);
		timeContainer.add(second);
		timeContainer.add(Box.createHorizontalStrut(30));
		topPanel.add(timeContainer,BorderLayout.CENTER);

		
		middlePanel.setLayout(new BorderLayout());
		remindEventText.setFont(new Font("Arial",0,20));
		remindEventText.setLineWrap(true);
		remindEventText.setWrapStyleWord(true);

		middlePanel.add(Box.createRigidArea(new Dimension(30, 20)),BorderLayout.NORTH);
		middlePanel.add(remindEventText,BorderLayout.CENTER);
		middlePanel.add(Box.createRigidArea(new Dimension(30, 20)),BorderLayout.SOUTH);
		middlePanel.add(Box.createRigidArea(new Dimension(30, 20)),BorderLayout.EAST);
		middlePanel.add(Box.createRigidArea(new Dimension(30, 20)),BorderLayout.WEST);

		bottomPanel.add(insert);
		bottomPanel.add(query);
		bottomPanel.add(cancel);
		bottomPanel.add(Box.createHorizontalGlue());
		
		panelContainer.setLayout(new BorderLayout());
		panelContainer.add(topPanel, BorderLayout.NORTH);
		panelContainer.add(middlePanel, BorderLayout.CENTER);
		panelContainer.add(bottomPanel, BorderLayout.SOUTH);
		jFrame.add(panelContainer);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setResizable(false);
	}
	
	public static ScheduleView getSCheduleViewObject(ScheduleModel scheduleModel) {
		return new ScheduleView(scheduleModel);
	}
	
	public void addInsertListener(ActionListener actionListener) {
		insert.addActionListener(actionListener);
	}
	
	public String getDay() {
		String selectDay="";
		if(mandy.isSelected())
			selectDay+="1:";
		if(tuesday.isSelected())
			selectDay+="2:";
		if(wednesday.isSelected())
			selectDay+="3:";
		if(thursday.isSelected())
			selectDay+="4:";
		if(firday.isSelected())
			selectDay+="5:";
		if(saturday.isSelected())
			selectDay+="6:";
		if(sunday.isSelected())
			selectDay+="7:";
		if(selectDay.endsWith(":"))
			selectDay=selectDay.substring(0, selectDay.length()-1);
		return selectDay;
	}
	
	public String getTime() {
		String selectTime="";
		selectTime+=hour.getSelectedItem()+":"+minute.getSelectedItem()+":"+second.getSelectedItem();
		return selectTime;
	}
	
	public String getRemindEvent() {
		return remindEventText.getText();
	}
}
