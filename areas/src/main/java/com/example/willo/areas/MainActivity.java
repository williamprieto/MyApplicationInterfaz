package com.example.willo.areas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    static int aux_op = 0,error=0;
    static double resultado = 0;
    double PI=3.1416;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton Rbcuadro = (RadioButton) findViewById(R.id.Rbcuadro);
        final RadioButton Rbtriangulo = (RadioButton) findViewById(R.id.Rbtriangulo);
        final RadioButton Rbrectangulo = (RadioButton) findViewById(R.id.Rbrectangulo);
        final RadioButton Rbcirculo=(RadioButton)findViewById(R.id.Rbcirculo);

        final TextView tlado= (TextView) findViewById(R.id.Tlado);
        final TextView tbase= (TextView) findViewById(R.id.Tbase);
        final TextView taltura= (TextView) findViewById(R.id.Taltura);
        final TextView tradio= (TextView) findViewById(R.id.Tradio);

        final EditText elado= (EditText) findViewById(R.id.elado);
        final EditText ebase= (EditText) findViewById(R.id.ebase);
        final EditText ealtura= (EditText) findViewById(R.id.ealtura);
        final EditText eradio= (EditText) findViewById(R.id.eradio);

        final EditText eResultado = (EditText) findViewById(R.id.eResultado);

        RadioGroup rg = (RadioGroup) findViewById(R.id.rggrupo1);
        //opcion para ocultar todas las variables
        //  tlado.setVisibility(View.INVISIBLE);
        elado.setVisibility(View.INVISIBLE);
        //  tbase.setVisibility(View.INVISIBLE);
        ebase.setVisibility(View.INVISIBLE);
        // taltura.setVisibility(View.INVISIBLE);
        ealtura.setVisibility(View.INVISIBLE);
        // tradio.setVisibility(View.INVISIBLE);
        eradio.setVisibility(View.INVISIBLE);
        eResultado.setEnabled(false);


//-------escoger la operaciones------------
        View.OnClickListener list= new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                // numero1 = Double.parseDouble(eNumero1.getText().toString());
                // numero2 = Double.parseDouble(eNumero2.getText().toString());
                switch(view.getId()) {

                    case R.id.Rbcuadro:
                        elado.setText("");
                        aux_op=1;//es para entrar a el caso de los botones
                        tlado.setVisibility(View.VISIBLE); elado.setVisibility(View.VISIBLE);
                        //tbase.setVisibility(View.INVISIBLE);
                        ebase.setVisibility(View.INVISIBLE);
                        //  taltura.setVisibility(View.INVISIBLE);
                        ealtura.setVisibility(View.INVISIBLE);
                        //   tradio.setVisibility(View.INVISIBLE);
                        eradio.setVisibility(View.INVISIBLE);
                        eResultado.setText("AREA");
                        break;
                    case R.id.Rbtriangulo:
                        ebase.setText("");
                        ealtura.setText("");
                        aux_op=2;
                        tbase.setVisibility(View.VISIBLE);
                        ebase.setVisibility(View.VISIBLE);
                        taltura.setVisibility(View.VISIBLE);
                        ealtura.setVisibility(View.VISIBLE);
                        // tlado.setVisibility(View.INVISIBLE);
                        elado.setVisibility(View.INVISIBLE);
                        //  tradio.setVisibility(View.INVISIBLE);
                        eradio.setVisibility(View.INVISIBLE);
                        eResultado.setText("AREA");
                        break;
                    case R.id.Rbrectangulo:
                        ebase.setText("");
                        ealtura.setText("");
                        aux_op=3;
                        tbase.setVisibility(View.VISIBLE);
                        ebase.setVisibility(View.VISIBLE);
                        taltura.setVisibility(View.VISIBLE);
                        ealtura.setVisibility(View.VISIBLE);
                        // tlado.setVisibility(View.INVISIBLE);
                        elado.setVisibility(View.INVISIBLE);
                        // tradio.setVisibility(View.INVISIBLE);
                        eradio.setVisibility(View.INVISIBLE);
                        //base= Double.parseDouble(ebase.getText().toString());
                        //altura=Double.parseDouble(ealtura.getText().toString());

                        eResultado.setText("AREA");
                        break;
                    case R.id.Rbcirculo:
                        eradio.setText("");
                        aux_op=4;
                        tradio.setVisibility(View.VISIBLE);
                        eradio.setVisibility(View.VISIBLE);
                        //    tlado.setVisibility(View.INVISIBLE);
                        elado.setVisibility(View.INVISIBLE);
                        //   tbase.setVisibility(View.INVISIBLE);
                        ebase.setVisibility(View.INVISIBLE);
                        //  taltura.setVisibility(View.INVISIBLE);
                        ealtura.setVisibility(View.INVISIBLE);

                        eResultado.setText("AREA");
                        break;
                }

            }

        };

        Rbcuadro.setOnClickListener(list);
        Rbtriangulo.setOnClickListener(list);
        Rbrectangulo.setOnClickListener(list);
        Rbcirculo.setOnClickListener(list);
//------------fin de las opciones-------------------
//-----------boton de calcular------------------
        Button bCalcular=(Button)findViewById(R.id.bCalcular);
        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error=0;
                String lado, base, altura, radio;//
                double lado1,base1,altura1,radio1;
                switch (aux_op) {
                    case 1:
                        lado=String.valueOf(elado.getText());
                        //lado = Double.parseDouble(elado.getText().toString());
                        if(lado.equals("")){ eResultado.setText("Falta llenar los campos ");
                            error=1;
                        }else {lado1=Double.parseDouble(lado);
                            resultado = lado1 * lado1;}

                        break;
                    case 2:
                        base = String.valueOf(ebase.getText());
                        altura = String.valueOf(ealtura.getText());
                        if( base.equals("")|altura.equals("") ){ eResultado.setText("Falta llenar los campos ");
                            error=1;
                        }else {base1=Double.parseDouble(base);altura1=Double.parseDouble(altura);
                            resultado = (base1 * altura1) / 2;}

                        break;
                    case 3:
                        base = String.valueOf(ebase.getText());
                        altura = String.valueOf(ealtura.getText());
                        if( base.equals("")|altura.equals("") ){ eResultado.setText("Falta llenar los campos ");
                            error=1;
                        }else {base1=Double.parseDouble(base);altura1=Double.parseDouble(altura);
                            resultado = base1 * altura1;}

                        break;
                    case 4:
                        radio=String.valueOf(eradio.getText());
                        if(radio.equals("")){ eResultado.setText("Falta llenar los campos ");
                            error=1;
                        }else { radio1=Double.parseDouble(radio);
                            resultado = PI * radio1 * radio1;}
                        break;
                    default:
                        eResultado.setText(" Escoger alguna opción ");
                        error=1;
                        break;
                }
                if(error==0){eResultado.setText(String.valueOf(resultado)+" cm");}



            }

        });
        aux_op=0;
        error=0;


    }


}


