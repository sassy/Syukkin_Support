package jp.blogspot.sassylog.syukkinsupport;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;

public class SettingsActivity extends Activity {
	private AlarmManager mAlarmManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		mAlarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		
		Button register_button = (Button)findViewById(R.id.register_button);
		register_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				
				TimePicker timePicker = (TimePicker)findViewById(R.id.time_picker);
				calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
				calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				
				Intent intent = new Intent(getApplicationContext(), SyukkinSupportActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(SettingsActivity.this, 0, intent, 0);
				mAlarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), pendingIntent);
			}
		});
		Button unregister_button = (Button)findViewById(R.id.unregister_button);
		unregister_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), SyukkinSupportActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(SettingsActivity.this, 0, intent, 0);
				mAlarmManager.cancel(pendingIntent);

			}
		});
	}
}
