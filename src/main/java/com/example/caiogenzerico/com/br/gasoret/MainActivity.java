package com.example.caiogenzerico.com.br.gasoret;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private double value = 3.00;
    private double valGas;
    private double valEt;
    private double Total;
    private double Totalb;

    private TextView valGasTextView;
    private SeekBar gasSeekBar;
    private TextView valEtTextView;
    private SeekBar etSeekBar;
    private TextView combTextView;
    private ImageView combImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valGasTextView = findViewById(R.id.valGasTextView);
        gasSeekBar =  findViewById(R.id.gasSeekBar);
        valEtTextView = findViewById(R.id.valEtTextView);
        etSeekBar = findViewById(R.id.etSeekBar);
        combTextView = findViewById(R.id.combTextView);
        combImageView = findViewById(R.id.combImageView);
        gasSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        etSeekBar.setOnSeekBarChangeListener(etSeekBarChangeListener);

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener;

    {
        seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress / 1.;
                valGasTextView.setText(currencyFormat.format(value));
                valGas = value;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Total = valEt / valGas;

                if (Total >= 0.7) {
                    combTextView.setText("Gasolina");
                    combImageView.setImageDrawable((getResources().getDrawable(R.drawable.gasolina)));

                } else {
                    combTextView.setText("Etanol");
                    combImageView.setImageDrawable((getResources().getDrawable(R.drawable.etanol)));

                }

            }
        };
    }

    private SeekBar.OnSeekBarChangeListener etSeekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    value = progress / 1.;
                    valEtTextView.setText(currencyFormat.format(value));
                    valEt=value;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    Total =  valEt /valGas;

                    if (Total >= 0.7) {
                        combTextView.setText("Gasolina");
                        combImageView.setImageDrawable((getResources().getDrawable(R.drawable.gasolina)));

                    } else {
                        combTextView.setText("Etanol");
                        combImageView.setImageDrawable((getResources().getDrawable(R.drawable.etanol)));
                    }

                }
            };

}

