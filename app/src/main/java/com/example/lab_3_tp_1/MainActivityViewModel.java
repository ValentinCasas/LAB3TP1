package com.example.lab_3_tp_1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void registrarUsuario(String nombre,String mail,String clave){
        SharedPreferences preferencias = context.getSharedPreferences("datos.xml",0);
        String mailGuardado = preferencias.getString("mail", "");
        if (!mailGuardado.equals(mail)) { // Verificar si el correo electrónico ya está registrado
            SharedPreferences.Editor editor= preferencias.edit();
            editor.putString("nombre", nombre);
            editor.putString("mail", mail);
            editor.putString("clave", clave);
            editor.commit();

            Intent intent=new Intent(context, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            // Mostrar un mensaje de error indicando que el correo electrónico ya está registrado
        }
    }


}
