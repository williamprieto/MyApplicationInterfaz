package com.example.willo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    static String opcion = "";
    static int aux_op = 0;
    static double resultado = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eNumero1 = (EditText) findViewById(R.id.eNumero1);
        final EditText eNumero2 = (EditText) findViewById(R.id.eNumero2);

        final RadioButton RbSuma = (RadioButton) findViewById(R.id.Rbsuma);
        final RadioButton RbResta = (RadioButton) findViewById(R.id.Rbresta);
        final RadioButton Rbmultiplicacion = (RadioButton) findViewById(R.id.Rbmultiplicacion);
        final RadioButton Rbdivision=(RadioButton)findViewById(R.id.Rbdivision);

        final EditText eResultado = (EditText) findViewById(R.id.eResultado);

        final TextView lbopcion = (TextView) findViewById(R.id.Lbopcion);



//-----------operaciones---------
        View.OnClickListener list= new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                switch(view.getId()) {

                    case R.id.Rbsuma:
                        eNumero1.setText("");
                        eNumero2.setText("");
                        opcion = "opción 1";
                        aux_op=1;//es para entrar a el caso de los botones
                        eResultado.setText("Resultado");

                        break;
                    case R.id.Rbresta:
                        eNumero1.setText("");
                        eNumero2.setText("");
                        opcion = "opción 2";
                        aux_op=2;
                        eResultado.setText("Resultado");
                        break;
                    case R.id.Rbmultiplicacion:
                        eNumero1.setText("");
                        eNumero2.setText("");
                        opcion = "opción 3";
                        aux_op=3;
                        eResultado.setText("Resultado");
                        break;
                    case R.id.Rbdivision:
                        eNumero1.setText("");
                        eNumero2.setText("");
                        opcion = "opción 4";
                        aux_op=4;
                        eResultado.setText("Resultado");
                        break;
                }
                lbopcion.setText("ID opción seleccionada: " + opcion);

            }

        };

        RbSuma.setOnClickListener(list);
        RbResta.setOnClickListener(list);
        Rbmultiplicacion.setOnClickListener(list);
        Rbdivision.setOnClickListener(list);
//-----------boton de calcular--------------------------
        Button bCalcular=(Button)findViewById(R.id.bCalcular);
        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero1,numero2;//profesor
                double numero11,numero22;
                numero1 = String.valueOf(eNumero1.getText());
                numero2 = String.valueOf(eNumero2.getText());

                if(numero1.equals("")|numero2.equals("")){
                    eResultado.setText("Faltan datos por ingresar");
                }
                    else {
                        numero11=Double.parseDouble(numero1);
                        numero22=Double.parseDouble(numero2);
                        switch (aux_op) {
                            case 1:

                                resultado = (numero11 + numero22);
                                break;
                            case 2:
                                resultado = (numero11 - numero22);
                                break;
                            case 3:
                                resultado = (numero11 * numero22);
                                break;
                            case 4:
                                resultado = (numero11 / numero22);
                                break;
                            default:
                                break;
                        }
                        if (aux_op == 1 | aux_op == 2 | aux_op == 3 | aux_op == 4) {
                            eResultado.setText(String.valueOf(resultado));
                        } else {
                            eResultado.setText("Escoger alguna operación");
                        }
                    }
                }

        });
        aux_op=0;

    }


}


