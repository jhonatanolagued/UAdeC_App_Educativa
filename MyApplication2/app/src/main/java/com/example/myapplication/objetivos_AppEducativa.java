package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class objetivos_AppEducativa extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_objetivos__app_educativa);

        setPrevText("Atras");
        setNextText("Siguiente");
        setFinishText("Empezar");
        setCancelText("Cancelar");



        addFragment(new Step.Builder().setTitle("Perfil")
                .setContent("¡Construye y presenta tu perfil único de programador en la App!")
                .setSummary("Continua y aprende más sobre App")
                .setBackgroundColor(Color.parseColor("#ffc107"))
                .setDrawable(R.drawable.screen_1).build());

        addFragment(new Step.Builder().setTitle("Aprende")
                .setContent("Todos los temas de la carrera de ing en sistemas computacionales reunidos en una sola aplicación")
                .setSummary("Continua y aprende más sobre App")
                .setBackgroundColor(Color.parseColor("#00bcd4"))
                .setDrawable(R.drawable.screen_3).build());

        addFragment(new Step.Builder().setTitle("Compite")
                .setContent("Compite para saber quien es el mejor programador dentro de la aplicacion")
                .setSummary("Continua y aprende más sobre App")
                .setBackgroundColor(Color.parseColor("#8bc34a"))
                .setDrawable(R.drawable.screen_4).build());
    }

    public void finishTutorial() {
        Intent moveToLogin = new Intent(objetivos_AppEducativa.this,Menu_AppEducativa.class);
        startActivity(moveToLogin);
    }
    @Override
    public void currentFragmentPosition(int position) {

    }
}
