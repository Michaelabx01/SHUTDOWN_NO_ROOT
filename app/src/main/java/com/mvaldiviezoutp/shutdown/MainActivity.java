package com.mvaldiviezoutp.shutdown;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton buttonPowerDialog = findViewById(R.id.buttonPowerDialog);
        ImageButton buttonAccessibility = findViewById(R.id.buttonaccesibility);

        buttonPowerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, AccessibilityService.class);
                startService(intent);
            }
        });

        buttonAccessibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si el servicio de accesibilidad ya está habilitado
                if (!AccessibilityService.isAccessibilityServiceEnabled(MainActivity.this, AccessibilityService.class)) {
                    // Si no está habilitado, abrir la pantalla de configuración de accesibilidad
                    AccessibilityService.requireAccessibility(MainActivity.this);
                } else {
                    // El servicio ya está habilitado, puedes agregar lógica adicional si es necesario.
                    // Por ejemplo, mostrar un mensaje indicando que ya está habilitado.
                }
            }
        });
    }
}
