package celilcavus.JavaAndroid.phoneDirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import celilcavus.JavaAndroid.phoneDirectory.Model.PhoneNumbers;
import celilcavus.JavaAndroid.phoneDirectory.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {

    private PhoneNumbers UpdatePerson;
    private DatabaseContext context;
    private ActivityUpdateBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        context = new DatabaseContext(getApplicationContext());
        Intent intent = getIntent();
        UpdatePerson = (PhoneNumbers) intent.getSerializableExtra("updatePersonel");

        binding.txtName.setText(UpdatePerson.getName());
        binding.txtLastName.setText(UpdatePerson.getLastName());
        binding.txtPhoneNumber.setText(UpdatePerson.getPhoneNumber());
    }

    public void onClickUpdated(View view)
    {
        if (!binding.txtName.getText().toString().matches("") && !binding.txtPhoneNumber.getText().toString().matches("")){
            PhoneNumbers pers = new PhoneNumbers();
            pers.Name = binding.txtName.getText().toString();
            pers.LastName = binding.txtLastName.getText().toString();
            pers.PhoneNumber = binding.txtPhoneNumber.getText().toString();
            pers.Id  = UpdatePerson.getId();
            context.Update(pers);

            startActivity(new Intent(UpdateActivity.this, MainActivity.class));
        }
        else
        {
            Toast.makeText(this, "Isim ve telefon Numara alanı zorunludur!!", Toast.LENGTH_LONG).show();
        }

    }

}