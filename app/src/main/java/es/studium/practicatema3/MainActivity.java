package es.studium.practicatema3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnAceptar;
TextView cuadroFecha;
String fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAceptar = findViewById(R.id.btnAceptar);
        cuadroFecha = findViewById(R.id.cuadroFecha);

        btnAceptar.setOnClickListener(this);
        cuadroFecha.setOnClickListener(this);

        cuadroFecha.setShowSoftInputOnFocus(false);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==(R.id.cuadroFecha)){

            abrirCalendario();
        }

        if(view.getId()==(R.id.btnAceptar)){
            if(cuadroFecha.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,getString(R.string.fechaVacia),Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intentSecondaryActivity = new Intent(this,SecondaryActivity.class);
                String[] ArrayFecha = fecha.split("/");
                intentSecondaryActivity.putExtra("dia",ArrayFecha[0]);
                intentSecondaryActivity.putExtra("mes",ArrayFecha[1]);
                intentSecondaryActivity.putExtra("anyo",ArrayFecha[2]);
                startActivity(intentSecondaryActivity);
            }
        }

    }

    public void abrirCalendario(){
        Calendar calendario = Calendar.getInstance();
        int anyo = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(MainActivity.this,R.style.Estilo_ColoresCalendario,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int anyo, int mes, int dia) {
                        fecha = dia+"/"+(mes+1)+"/"+anyo;
                        cuadroFecha.setText(fecha);
                    }
                },anyo, mes, dia);
        dpd.show();
    }
}