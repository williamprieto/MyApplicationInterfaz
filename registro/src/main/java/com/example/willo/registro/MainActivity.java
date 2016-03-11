package com.example.willo.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    static int aux_op = 0;

    static String ciudades="";//variable q guarda las ciudades
    static String genero="";//guardar sexo
    //////CALENDARIO///////////////////////////////////
    static int y,m,d,mm;
    //////////////////////////////////////////////////////

    Spinner lista;
    //String []datos={"lista desplegable","Medellin","Ibague","Bogota","Cucuta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Definicion de los edit text
        final EditText elogin = (EditText) findViewById(R.id.elogin);
        final EditText epasw = (EditText) findViewById(R.id.epasw);
        final EditText erpasw = (EditText) findViewById(R.id.erpasw);
        final EditText eemail = (EditText) findViewById(R.id.eemail);
//Definicion de los radio
        final RadioButton rmasculino = (RadioButton) findViewById(R.id.rmasculino);
        final RadioButton rfemenino = (RadioButton) findViewById(R.id.rfemenino);
//Definicion de los check
        final CheckBox cmusica = (CheckBox) findViewById(R.id.cmusica);
        final CheckBox ccine= (CheckBox) findViewById(R.id.ccine);
        final CheckBox cbailar = (CheckBox) findViewById(R.id.cbailar);
        final CheckBox cdeporte = (CheckBox) findViewById(R.id.cdeporte);
//Definicion de los date
        final DatePicker date=(DatePicker)findViewById(R.id.date);
        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        //month = month + 1;
        final int day = c.get(Calendar.DAY_OF_MONTH);
//ver el registro
        final TextView tdatosr= (TextView) findViewById(R.id.tdatosr);


//-------------LISTA DE CIUDADES------------------------
        lista=(Spinner)findViewById(R.id.slista1);
        ArrayAdapter<CharSequence> adaptador= ArrayAdapter.createFromResource(this, R.array.ciudades_array,android.R.layout.simple_spinner_item);
        lista.setAdapter(adaptador);
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ciudades =   parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//-----------FIN LISTA DE CIUDADES---------------------------
//-------GENERO----------------------------------------------
        RadioGroup rgOpciones = (RadioGroup)findViewById(R.id.GrbGrupo1);
        rgOpciones.clearCheck();
        rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.rmasculino:
                        genero="masculino";
                        break;
                    case R.id.rfemenino:
                        genero="femenino";
                        break;
                }
            }
        });
//-----------------FIN DEL GENERO--------------------------------------
//---------------------------------------------------------------
//-----------------BOTON CALCULAR------------------------------------
        Button bCalcular=(Button)findViewById(R.id.bCalcular);
        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-------OBTENIENDO CHECK BOX hobbies---------------------
                StringBuffer hobbies = new StringBuffer();
                if(cmusica.isChecked()){hobbies.append("musica "); }
                if(cdeporte.isChecked()){hobbies.append(" deporte "); }
                if(cbailar.isChecked()){hobbies.append(" bailar "); }
                if(ccine.isChecked()){hobbies.append(" cine"); }

                //-------FIN HOBBIES---------------------

                //-------OBTENIENDO FECHA---------------------
                y = date.getYear();
                m = date.getMonth();
                mm = m+1;
                d = date.getDayOfMonth();
                //----FIN DE LA FECHA-----------------------
                //---------------LLENANDO LOS DATOS----------------------
                String usuario,clave,rclave,correo;
                usuario=String.valueOf(elogin.getText());
                clave=String.valueOf(epasw.getText());
                rclave=String.valueOf(erpasw.getText());
                correo=String.valueOf(eemail.getText());

                //numero1 = Double.parseDouble(eNumero1.getText().toString());
                if( ( usuario.equals(""))|( clave.equals(""))|( rclave.equals(""))|( correo.equals("")|genero.equals("")|ciudades.equals("Seleccionar"))                                                ){

                    //Toast.makeText(getApplicationContext(),"por favor llenar todos los campos", Toast.LENGTH_LONG).show();
                    tdatosr.setText("por favor llenar todos los campos ");
                }else{
                    if(clave.equals(rclave)){

                       /* Toast.makeText(getApplicationContext(),
                                "Datos:"+'\n'+"usuario: "+usuario+'\n'+"password: "+clave+'\n'
                                +"e-mail: "+correo+'\n'+"sexo: "+genero+'\n'
                                +"Fecha nacimiento: "+d+"/"+mm+"/"+y+'\n'
                                +"Lugar nacimiento: "+ciudades+'\n'
                                +"hobbies: "+hobbies.toString(), Toast.LENGTH_LONG).show();
                            */
                        tdatosr.setText("usuario: "+usuario+'\n'+"password: "+clave+'\n'
                                +"e-mail: "+correo+'\n'+"sexo: "+genero+'\n'
                                +"Fecha nacimiento: "+d+"/"+mm+"/"+y+'\n'
                                +"Lugar nacimiento: "+ciudades+'\n'
                                +"hobbies: "+hobbies.toString());
                    }else {
                        tdatosr.setText("clave incorrecta, intente de nuevo");

                        //Toast.makeText(getApplicationContext(),"clave incorrecta"+'\n'+"intente de nuevo", Toast.LENGTH_LONG).show();
                    }


                }

            }

        });
        aux_op=0;
        genero=("");

    }


}
