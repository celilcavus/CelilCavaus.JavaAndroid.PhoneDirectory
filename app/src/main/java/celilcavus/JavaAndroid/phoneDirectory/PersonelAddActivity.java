package celilcavus.JavaAndroid.phoneDirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import celilcavus.JavaAndroid.phoneDirectory.Model.PhoneNumbers;
import celilcavus.JavaAndroid.phoneDirectory.databinding.ActivityPersonelAddBinding;

public class PersonelAddActivity extends AppCompatActivity {

    private ActivityPersonelAddBinding binding;
    private DatabaseContext context;
    private PhoneNumbers person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonelAddBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        context = new DatabaseContext(getApplicationContext());

        person = new PhoneNumbers();
    }

    public void onClickPersonAdd(View view){
        if (!binding.txtName.getText().toString().matches("") && !binding.txtPhoneNumber.getText().toString().matches("")){
            person.Name = binding.txtName.getText().toString();
            person.LastName = binding.txtLastName.getText().toString();
            person.PhoneNumber = binding.txtPhoneNumber.getText().toString();
            context.Add(person);
            startActivity(new Intent(PersonelAddActivity.this, MainActivity.class));
        }
        else {
            Toast.makeText(this, "isim ve telefon numarası alanı Zorunludur!", Toast.LENGTH_LONG).show();
        }
    }
}