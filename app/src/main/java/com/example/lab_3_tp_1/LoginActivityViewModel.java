package com.example.lab_3_tp_1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<Boolean> loginSuccess;
    private MutableLiveData<String> nombreMutable;
    private MutableLiveData<String> mailMutable;
    private MutableLiveData<String> claveMutable;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Boolean> getLoginSuccess() {
        loginSuccess = new MutableLiveData<>();
        return loginSuccess;
    }
    public LiveData<String> getNombreMutable() {
        if (nombreMutable == null) {
            nombreMutable = new MutableLiveData<>();
        }
        return nombreMutable;
    }
    public LiveData<String> getMailMutable() {
        if (mailMutable == null) {
            mailMutable = new MutableLiveData<>();
        }
        return mailMutable;
    }
    public LiveData<String> getClaveMutable() {
        if (claveMutable == null) {
            claveMutable = new MutableLiveData<>();
        }
        return claveMutable;
    }

    public void confirmarLogin(String mail, String clave) {
        SharedPreferences preferencias = context.getSharedPreferences("datos.xml", 0);
        String mailGuardado = preferencias.getString("mail", "");
        String claveGuardada = preferencias.getString("clave", "");

        if (mailGuardado.equals(mail) && claveGuardada.equals(clave)) {
            loginSuccess.setValue(true);
        } else {
            loginSuccess.setValue(false);
        }
    }

    public void leerDatos(){
        SharedPreferences preferencias = context.getSharedPreferences("datos.xml",0);
        String mailGuardado = preferencias.getString("mail", "");
        String claveGuardada = preferencias.getString("clave", "");

        nombreMutable.setValue(preferencias.getString("nombre", ""));
        mailMutable.setValue(mailGuardado);
        claveMutable.setValue(claveGuardada);
    }


}

