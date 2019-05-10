package com.adalto.quiz_2019_1;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView tvAfirmacao;
    private ImageView ivEsquerda, ivDireita;
    private String tipo;
    private String[] afirmacoes;
    private boolean[] gabarito;
    private LinearLayout layout;
    private int contador, acertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        afirmacoes = new String[] {
                "A terra é redonda",
                "Esta aula é chata",
                "O Rei do Gado é de 2000"
        };

        gabarito = new boolean[]{  true, true, false};

        tipo = getIntent().getExtras().getString("tipo");
        contador = 0;

        layout = (LinearLayout) findViewById(R.id.layout);
        tvAfirmacao = (TextView) findViewById(R.id.tvAfirmacao);
        ivDireita = (ImageView) findViewById(R.id.ivDireita);
        ivEsquerda = (ImageView) findViewById(R.id.ivEsquerda);

        if (tipo.equals("vertical")){
            ivEsquerda.setImageResource(R.drawable.abaixo);
            ivDireita.setImageResource(R.drawable.acima);
        }

        tvAfirmacao.setText( afirmacoes[contador] );

        layout.setOnTouchListener( new OnSwipeTouchListener(this){

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if( gabarito[contador]){
                    acertos ++;
                }
                contador ++;
                tvAfirmacao.setText( afirmacoes[contador]);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if( !gabarito[contador]){
                    acertos ++;
                }
                contador ++;
                tvAfirmacao.setText( afirmacoes[contador]);
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
            }
        });


    }


}


















