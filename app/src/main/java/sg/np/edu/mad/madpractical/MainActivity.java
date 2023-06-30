package sg.np.edu.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbutton = findViewById(R.id.fbutton);
        TextView nameBox = findViewById(R.id.namebox);
        TextView descBox = findViewById(R.id.descbox);

        Log.i("MAINACTIVITY", "BEFORE GET INTENT");

        User ranUser = (User) getIntent().getSerializableExtra("key");
        Log.i("MAINACTIVITY", "Get user");
        Log.i("MAINACTIVITY", ranUser.name);
        nameBox.setText(ranUser.name);
        descBox.setText(ranUser.description);


        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ranUser.followed == false){
                    fbutton.setText("Unfollow");
                    ranUser.followed = true;
                } else {
                    fbutton.setText("Follow");
                    ranUser.followed = false;
                }
            }
        });


    }
}