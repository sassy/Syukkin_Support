package jp.blogspot.sassylog.syukkinsupport;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SyukkinSupportActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syukkin_support);

        String[] data = {
                "窓は閉めましたか？",
                "ガスの元栓は閉めましたか？",
                "電気は消しましたか？",
                "鍵はかけましたか？"
        };

        final ListView list = (ListView)findViewById(R.id.main_list);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, data);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);
        
        Button button = (Button)findViewById(R.id.clear_button);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                list.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_syukkin_support, menu);
        return true;
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == R.id.menu_settings) {
        	Intent intent = new Intent(this, SettingsActivity.class);
        	startActivity(intent);
        	return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }
}
