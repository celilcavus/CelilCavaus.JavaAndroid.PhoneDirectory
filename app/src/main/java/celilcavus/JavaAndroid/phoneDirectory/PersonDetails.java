package celilcavus.JavaAndroid.phoneDirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import celilcavus.JavaAndroid.phoneDirectory.Model.PhoneNumbers;
import celilcavus.JavaAndroid.phoneDirectory.databinding.ActivityPersonDetailsBinding;

public class PersonDetails extends AppCompatActivity {

    private ActivityPersonDetailsBinding binding;
    private PhoneNumbers person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        try {
            Intent intent = getIntent();
            person = (PhoneNumbers) intent.getSerializableExtra("person");
            String FullName = person.Name.concat(" " + person.LastName);

            binding.txtFullName.setText(FullName);
            binding.txtPhoneNumbers.setText(person.PhoneNumber);
            Toast.makeText(getApplicationContext(), "Person Id " + person.Id, Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            System.out.println("Person Details Exception : " + ex);
        }
    }

    public void onClickDel(View view)
    {
        DatabaseContext databaseContext = new DatabaseContext(getApplicationContext());
        databaseContext.Delete(person.Id);
    }
}