package be.ehb.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    //variabelen voor wat in UI (scherm) staat
    private MaterialButton btnConfirm;
    private RadioGroup rgGender;
    private Switch swiAgree;
    private EditText etUser, etPass;
    private TextInputLayout ilUser, ilPass;

    //anonymous inner class
    private View.OnClickListener confirmListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Test", "geklikt op knop");
        }
    };

    private TextWatcher passwordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int input = etPass.getText().length();
            if (input >= 4 && input <= 20 ){
                ilPass.setError(null);
            }else{
                ilPass.setError("Must be between 4 and 20 characters");
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //verwijzing naar UI
        setContentView(R.layout.activity_main);
        //verwijzing naar componenten in UI
        btnConfirm = findViewById(R.id.btn_confirm);
        rgGender = findViewById(R.id.rg_gender);
        swiAgree = findViewById(R.id.swi_agree);
        etUser = findViewById(R.id.editText_user);
        etPass = findViewById(R.id.et_pass);
        ilUser = findViewById(R.id.inputLayout_user);
        ilPass = findViewById(R.id.il_pass);
        //listener toevoegen aan component
        btnConfirm.setOnClickListener(confirmListener);
        etPass.addTextChangedListener(passwordWatcher);

    }
}

