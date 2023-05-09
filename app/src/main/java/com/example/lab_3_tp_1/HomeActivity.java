package com.example.lab_3_tp_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.lab_3_tp_1.databinding.ActivityHomeBinding;
import com.example.lab_3_tp_1.databinding.ActivityLoginBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private HomeActivityViewModel mv;
    private LoginActivityViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(HomeActivityViewModel.class);
        loginViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);

        loginViewModel.getNombreMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String nombre) {
                binding.tvNombre.setText(nombre);
            }
        });

        loginViewModel.getClaveMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String clave) {
                binding.tvClave.setText(clave);
            }
        });

        loginViewModel.getMailMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mail) {
                binding.tvMail.setText(mail);
            }
        });

        loginViewModel.leerDatos();

    }
}
