package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcoholPrice, editGasolinePrice;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcoholPrice  = findViewById(R.id.editAlcoholPrice);
        editGasolinePrice = findViewById(R.id.editGasolinePrice);
        textResult        = findViewById(R.id.textResult);
    }

    public void resultHandler( View view ){
        String alcoholPrice = editAlcoholPrice.getText().toString();
        String gasolinePrice = editGasolinePrice.getText().toString();

        if (validateFields(alcoholPrice, gasolinePrice)){
            Double result = calculate(alcoholPrice, gasolinePrice);

            if (result >= 0.7){
                textResult.setText("É melhor usar gasolina");
            }
            else {
                textResult.setText("É melhor usar álcool");
            }

        }else {
            textResult.setText("Preencha todos os campos de preço");
        }

    }

    public Boolean validateFields(String alcoholPrice, String gasolinePrice){

        Boolean isValid = true;

        if (alcoholPrice == null || alcoholPrice.equals("")){
            isValid = false;
        }
        else if(gasolinePrice == null || gasolinePrice.equals("")){
            isValid = false;
        }

        return  isValid;
    }

    public Double calculate(String alcoholPrice, String gasolinePrice){

        Double alcohol = Double.parseDouble(alcoholPrice);
        Double gasoline = Double.parseDouble(gasolinePrice);

        Double result = alcohol / gasoline;

        return result;
    }
}