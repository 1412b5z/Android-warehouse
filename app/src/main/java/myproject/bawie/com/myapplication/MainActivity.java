package myproject.bawie.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new LogicView(this));
        LogicView logic = new LogicView(this);
        Log.d("TAG","自定义控件监听"+logic);
        logic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","自定义控件监听");
            }
        });
        Log.d("TRAG","uihhhhhhhhhhhhhhhhhhhhhh");
    }
}
