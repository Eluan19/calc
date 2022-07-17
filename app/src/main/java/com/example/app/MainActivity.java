package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.w3c.dom.Text;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button nZero,nUm,nDois,nTres,nQuatro,nCinco,nSeis,nSete,nOito,nNove,ponto,adicao,diminuir,
    multiplicar,divisao,igual,bt_limpar;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        nZero.setOnClickListener(this);
        nUm.setOnClickListener(this);
        nDois.setOnClickListener(this);
        nTres.setOnClickListener(this);
        nQuatro.setOnClickListener(this);
        nCinco.setOnClickListener(this);
        nSeis.setOnClickListener(this);
        nSete.setOnClickListener(this);
        nOito.setOnClickListener(this);
        nNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        adicao.setOnClickListener(this);
        diminuir.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        divisao.setOnClickListener(this);

    }

    private void IniciarComponentes(){
        nZero = findViewById(R.id.zero);
        nUm = findViewById(R.id.um);
        nDois = findViewById(R.id.dois);
        nTres = findViewById(R.id.tres);
        nQuatro = findViewById(R.id.quatro);
        nCinco = findViewById(R.id.cinco);
        nSeis = findViewById(R.id.seis);
        nSete = findViewById(R.id.sete);
        nOito = findViewById(R.id.oito);
        nNove = findViewById(R.id.nove);
        ponto = findViewById(R.id.ponto);
        adicao = findViewById(R.id.adicao);
        diminuir = findViewById(R.id.diminuir);
        multiplicar = findViewById(R.id.multiplicar);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        bt_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);

        bt_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              TextView expressao = findViewById(R.id.txt_expressao);
              String string = expressao.getText().toString();

              if (!string.isEmpty()){

                  byte var0 = 0;
                  int var1 = string.length()-1;
                  String txtExpressao = string.substring(var0,var1);
                  expressao.setText(txtExpressao);
              }
              txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));

                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });

    }

    public void AcrescentarUmaExpressao(String string,boolean limpar_dados){

        if(txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zero:
                AcrescentarUmaExpressao("0",true);
                break;

            case R.id.um:
                AcrescentarUmaExpressao("1",true);
                break;

            case R.id.dois:
                AcrescentarUmaExpressao("2",true);
                break;

            case R.id.tres:
                AcrescentarUmaExpressao("3",true);
                break;

            case R.id.quatro:
                AcrescentarUmaExpressao("4",true);
                break;

            case R.id.cinco:
                AcrescentarUmaExpressao("5",true);
                break;

            case R.id.seis:
                AcrescentarUmaExpressao("6",true);
                break;

            case R.id.sete:
                AcrescentarUmaExpressao("7",true);
                break;

            case R.id.oito:
                AcrescentarUmaExpressao("8",true);
                break;

            case R.id.nove:
                AcrescentarUmaExpressao("9",true);
                break;

            case R.id.ponto:
                AcrescentarUmaExpressao(".",true);
                break;

            case R.id.adicao:
                AcrescentarUmaExpressao("+",false);
                break;

            case R.id.diminuir:
                AcrescentarUmaExpressao("-",true);
                break;

            case R.id.multiplicar:
                AcrescentarUmaExpressao("*",true);
                break;

            case R.id.divisao:
                AcrescentarUmaExpressao("/",true);
                break;
        }
    }
}