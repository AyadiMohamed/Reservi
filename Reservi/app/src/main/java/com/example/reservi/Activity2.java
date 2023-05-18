package com.example.reservi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Activity2 extends AppCompatActivity {
    public static String selectedGouvernorat,selectedDelegation; //variables to hold the values of selected gouvernorat and delegation
    public static View tvspinnerGouvernorat;
    public static View tvspinnerDelegtaion;
    //Declaring text views to disaplay errors when the choice of gouv or deleg is wrong.
    private Spinner gouvernoartSpinner, delegationSpinner; //drop dow liste for the gouvernorat and the delegation.
    private ArrayAdapter<CharSequence> gouvernoratAdapter, delegaionAdapter; // to convert the data from the data source to the drop dow lists
    private Button  reservationButton;
    @SuppressLint({"CutPasteId", "SetTextI18n", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        gouvernoartSpinner = findViewById(R.id.spinner_dispaly_gouvernorat); //path to the discrit list
        gouvernoratAdapter = ArrayAdapter.createFromResource(this, R.array.array_tunisian_Gouvernorat, R.layout.spinner_layout); //using the adapter to import the data from the arrays to the spinner
        gouvernoratAdapter.setDropDownViewResource(R.layout.selected_items);
        gouvernoartSpinner.setAdapter((gouvernoratAdapter));
        gouvernoartSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                delegationSpinner = findViewById(R.id.spinner_dispaly_delegation);
                selectedGouvernorat= gouvernoartSpinner.getSelectedItem().toString();
                int parentID = parent.getId();
                if(parentID == R.id.spinner_dispaly_gouvernorat )
                    switch(selectedGouvernorat){
                        case "Selectionner le gouvernorat" : delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_deffault_delegation,R.layout.spinner_layout);
                        break;
                        case"Ariana":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Ariana_delegation,R.layout.spinner_layout);
                        break;
                        case"BenArous":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_BenArous_delegation,R.layout.spinner_layout);
                        break;
                        case"Bizerte":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Bizerte_delegation,R.layout.spinner_layout);
                        break;
                        case"Béja":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Béja_delegation,R.layout.spinner_layout);
                        break;
                        case"Gabés":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Gabés_delegation,R.layout.spinner_layout);
                        break;
                        case"Gafsa":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Gafsa_delegation,R.layout.spinner_layout);
                        break;
                        case"Jendouba":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Jendouba_delegation,R.layout.spinner_layout);
                        break;
                        case"Kairoun":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Kairoun_delegation,R.layout.spinner_layout);
                        break;
                        case"Kesserine":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Kasserine_delegation,R.layout.spinner_layout);
                        break;
                        case"Kef":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Kef_delegation,R.layout.spinner_layout);
                        break;
                        case"Kbeli":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_KéBili_delegation,R.layout.spinner_layout);
                        break;
                        case"Mahdia":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Mahdia_delegation,R.layout.spinner_layout);
                        break;
                        case"Monastir":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Monastir_delegation,R.layout.spinner_layout);
                        break;
                        case"Medenine":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_MéDenine_delegation,R.layout.spinner_layout);
                        break;
                        case"Nabeul":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Nabeul_delegation,R.layout.spinner_layout);
                        break;
                        case"Sfax":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Sfax_delegation,R.layout.spinner_layout);
                        break;
                        case"SidiBouzid":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_SidiBouzid_delegation,R.layout.spinner_layout);
                        break;
                        case"Siliana":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Siliana_delegation,R.layout.spinner_layout);
                        break;
                        case"Sousse":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Sousse_delegation,R.layout.spinner_layout);
                        break;
                        case"Tataouine":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Tataouine_delegation,R.layout.spinner_layout);
                        break;
                        case"Touzeur":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Tozeur_delegation,R.layout.spinner_layout);
                        break;
                        case"Tunis":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Tunis_delegation,R.layout.spinner_layout);
                        break;
                        case"Zagouan":delegaionAdapter = ArrayAdapter.createFromResource(parent.getContext(),R.array.array_Zaghouan_delegation,R.layout.spinner_layout);
                        break;
                        default:break;
                    }
                delegaionAdapter.setDropDownViewResource(R.layout.selected_items);
                delegationSpinner.setAdapter(delegaionAdapter);
                delegationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        selectedDelegation=delegationSpinner.getSelectedItem().toString();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        reservationButton=findViewById(R.id.reservationbutton); // path to the button by id
        tvspinnerGouvernorat=findViewById(R.id.textview_tunisian_discrits); //to recuperate the item selected on the states list on text view
        tvspinnerDelegtaion=findViewById(R.id.textview_tunisian_discrits); //to recuperate the item selected on the discrit list on text view
        //insctruction that will happend when the client click on the reservation  button
        //use the double switch case with the selectedGouvernorat and the selectedDelegation strings to set the tickets value and display it in the third layout which you will create)
        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }
    public void openActivity3(){
        Intent intent=new Intent(Activity2.this,activity3.class);
        startActivity(intent);
    }
}