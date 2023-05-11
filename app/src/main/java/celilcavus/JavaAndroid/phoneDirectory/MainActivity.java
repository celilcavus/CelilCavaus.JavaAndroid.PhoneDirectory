package celilcavus.JavaAndroid.phoneDirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;

import celilcavus.JavaAndroid.phoneDirectory.Adapter.ContextListAdapter;
import celilcavus.JavaAndroid.phoneDirectory.Model.PhoneNumbers;
import celilcavus.JavaAndroid.phoneDirectory.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private DatabaseContext dbContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        dbContext = new DatabaseContext(getApplicationContext());

        ArrayList<PhoneNumbers> item = dbContext.GetAll();
        System.out.println("item = " + item.get(1).Name);
        binding.RecylerViewMain.setLayoutManager(new LinearLayoutManager(this));
        ContextListAdapter adap = new ContextListAdapter(item);
        binding.RecylerViewMain.setAdapter(adap);
    }

    public void onClickAddNumber(View view) {
        try {
            startActivity(new Intent(MainActivity.this, PersonelAddActivity.class));
        }catch (Exception ex)
        {
            System.out.println("ex1 = " + ex);
        }
    }

}