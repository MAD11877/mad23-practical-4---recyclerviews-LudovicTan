package sg.np.edu.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < 21; i++){
            User newUser = CreateNewUser();
            userList.add(newUser);
            Log.i("ListActivity", Integer.toString(i));
        }
        //userList.remove()

        RecyclerView recyclerView = findViewById(R.id.recycler);
        Adapter mAdapter = new Adapter(ListActivity.this, userList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    private int randomOTP(){
        Random rannum = new Random();
        int val = rannum.nextInt(999999999);
        return val;
    }

    private User CreateNewUser(){
        User ranUser = new User();
        int rannum1 = randomOTP();
        int rannum2 = randomOTP();
        ranUser.name = "Name" + rannum1;
        ranUser.followed = false;
        ranUser.description = "Description " + rannum2;
        Log.i("CREATENEWUSER", "Name: " + ranUser.name + " Desc: " + ranUser.description);
        return ranUser;
    }

}