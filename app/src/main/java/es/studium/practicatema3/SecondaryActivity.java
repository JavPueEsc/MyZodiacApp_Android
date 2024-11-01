package es.studium.practicatema3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;


public class SecondaryActivity extends AppCompatActivity {
    int dia;
    int mes;
    int anyo;
    int edad;
    String horoscopo ="";
    TextView txt_mostrarFecha;
    TextView txt_mostrarEdad;
    TextView txt_mostrarHoroscopo;
    TextView txt_mostrarTextoHoroscopo;
    ImageView imagen;
    Calendar fechaActual;
    Calendar fechaNacimiento;
    String lblAnios;
    String eres_Sera;
    String descripcionHoroscopo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        txt_mostrarFecha = findViewById(R.id.mostrarFecha);
        txt_mostrarEdad = findViewById(R.id.mostrarEdad);
        txt_mostrarHoroscopo = findViewById(R.id.mostrarHoroscopo);
        txt_mostrarTextoHoroscopo = findViewById(R.id.mostrarTextoHoroscopo);
        imagen= findViewById(R.id.imagenHoroscopo);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            dia = Integer.parseInt(extras.getString("dia"));
            mes = Integer.parseInt(extras.getString("mes"));
            anyo = Integer.parseInt(extras.getString("anyo"));
            edad = calcularEdad(dia,mes,anyo);

            if(fechaActual.compareTo(fechaNacimiento)>0){
                lblAnios= getString(R.string.lbl_FechaNacNato);
                txt_mostrarFecha.setText(lblAnios+" "+String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(anyo));
                String aniosNato = getString(R.string.AniosNato);
                String palabraAnios = getString(R.string.PalabraAnios);
                txt_mostrarEdad.setText(aniosNato+" "+ String.valueOf(edad)+" "+palabraAnios);
                eres_Sera = getString(R.string.Eres);
            }
            else if(fechaActual.compareTo(fechaNacimiento)<0){
                lblAnios= getString(R.string.lbl_FechaNacNoNato);
                txt_mostrarFecha.setText(lblAnios+" "+String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(anyo));
                txt_mostrarEdad.setText(R.string.AniosNoNato);
                eres_Sera = getString(R.string.Sera);
            }
            else{
                lblAnios= getString(R.string.lbl_FechaNacNatoEseDia);
                txt_mostrarFecha.setText(lblAnios);
                txt_mostrarEdad.setText(R.string.AniosNatoEsDia);
                eres_Sera = getString(R.string.Eres);
            }
            horoscopo = calcularHoroscopo(dia, mes);
            txt_mostrarHoroscopo.setText(horoscopo);
            txt_mostrarTextoHoroscopo.setText(descripcionHoroscopo);
        }

    }

    public  int calcularEdad(int dia, int mes, int anyo) {

        fechaActual = Calendar.getInstance();

        fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(anyo, mes - 1, dia);

        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);

        if (fechaActual.get(Calendar.MONTH) < fechaNacimiento.get(Calendar.MONTH) ||
                (fechaActual.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH) &&
                        fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimiento.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }

        return edad;
    }

    public String calcularHoroscopo( int dia, int mes){
        switch (mes) {
            case 1:
                if (dia <= 19) {
                    horoscopo = eres_Sera+" "+getString(R.string.Capricornio);
                    imagen.setImageResource(R.drawable.capricornio);
                    descripcionHoroscopo = getString(R.string.descrip_Capricornio);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Acuario);
                    imagen.setImageResource(R.drawable.acuario);
                    descripcionHoroscopo = getString(R.string.descrip_Acuario);
                }
                break;
            case 2:
                if (dia <= 18) {
                    horoscopo = eres_Sera+" "+getString(R.string.Acuario);
                    imagen.setImageResource(R.drawable.acuario);
                    descripcionHoroscopo = getString(R.string.descrip_Acuario);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Piscis);
                    imagen.setImageResource(R.drawable.piscis);
                    descripcionHoroscopo = getString(R.string.descrip_Piscis);
                }
                break;
            case 3:
                if (dia <= 20) {
                    horoscopo = eres_Sera+" "+getString(R.string.Piscis);
                    imagen.setImageResource(R.drawable.piscis);
                    descripcionHoroscopo = getString(R.string.descrip_Piscis);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Aries);
                    imagen.setImageResource(R.drawable.aries);
                    descripcionHoroscopo = getString(R.string.descrip_Aries);
                }
                break;
            case 4:
                if (dia <= 19) {
                    horoscopo = eres_Sera+" "+getString(R.string.Aries);
                    imagen.setImageResource(R.drawable.aries);
                    descripcionHoroscopo = getString(R.string.descrip_Aries);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Tauro);
                    imagen.setImageResource(R.drawable.tauro);
                    descripcionHoroscopo = getString(R.string.descrip_Tauro);
                }
                break;
            case 5:
                if (dia <= 20) {
                    horoscopo = eres_Sera+" "+getString(R.string.Tauro);
                    imagen.setImageResource(R.drawable.tauro);
                    descripcionHoroscopo = getString(R.string.descrip_Tauro);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Geminis);
                    imagen.setImageResource(R.drawable.geminis);
                    descripcionHoroscopo = getString(R.string.descrip_Geminis);
                }
                break;
            case 6:
                if (dia <= 20) {
                    horoscopo = eres_Sera+" "+getString(R.string.Geminis);
                    imagen.setImageResource(R.drawable.geminis);
                    descripcionHoroscopo = getString(R.string.descrip_Geminis);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Cancer);
                    imagen.setImageResource(R.drawable.cancer);
                    descripcionHoroscopo = getString(R.string.descrip_Cancer);
                }
                break;
            case 7:
                if (dia <= 22) {
                    horoscopo = eres_Sera+" "+getString(R.string.Cancer);
                    imagen.setImageResource(R.drawable.cancer);
                    descripcionHoroscopo = getString(R.string.descrip_Cancer);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Leo);
                    imagen.setImageResource(R.drawable.leo);
                    descripcionHoroscopo = getString(R.string.descrip_Leo);
                }
                break;
            case 8:
                if (dia <= 22) {
                    horoscopo = eres_Sera+" "+getString(R.string.Leo);
                    imagen.setImageResource(R.drawable.leo);
                    descripcionHoroscopo = getString(R.string.descrip_Leo);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Virgo);
                    imagen.setImageResource(R.drawable.virgo);
                    descripcionHoroscopo = getString(R.string.descrip_Virgo);
                }
                break;
            case 9:
                if (dia <= 22) {
                    horoscopo = eres_Sera+" "+getString(R.string.Virgo);
                    imagen.setImageResource(R.drawable.virgo);
                    descripcionHoroscopo = getString(R.string.descrip_Virgo);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Libra);
                    imagen.setImageResource(R.drawable.libra);
                    descripcionHoroscopo = getString(R.string.descrip_Libra);
                }
                break;
            case 10:
                if (dia <= 22) {
                    horoscopo = eres_Sera+" "+getString(R.string.Libra);
                    imagen.setImageResource(R.drawable.libra);
                    descripcionHoroscopo = getString(R.string.descrip_Libra);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Escorpio);
                    imagen.setImageResource(R.drawable.escorpio);
                    descripcionHoroscopo = getString(R.string.descrip_Escorpio);
                }
                break;
            case 11:
                if (dia <= 21) {
                    horoscopo = eres_Sera+" "+getString(R.string.Escorpio);
                    imagen.setImageResource(R.drawable.escorpio);
                    descripcionHoroscopo = getString(R.string.descrip_Escorpio);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Sagitario);
                    imagen.setImageResource(R.drawable.sagitario);
                    descripcionHoroscopo = getString(R.string.descrip_Sagitario);
                }
                break;
            case 12:
                if (dia <= 21) {
                    horoscopo = eres_Sera+" "+getString(R.string.Sagitario);
                    imagen.setImageResource(R.drawable.sagitario);
                    descripcionHoroscopo = getString(R.string.descrip_Sagitario);
                } else {
                    horoscopo = eres_Sera+" "+getString(R.string.Capricornio);
                    imagen.setImageResource(R.drawable.capricornio);
                    descripcionHoroscopo = getString(R.string.descrip_Capricornio);
                }
                break;
        }
        return horoscopo;
    }
}