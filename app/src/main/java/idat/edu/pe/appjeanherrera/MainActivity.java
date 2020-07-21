package idat.edu.pe.appjeanherrera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import idat.edu.pe.appjeanherrera.model.Cliente;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tvDNI,tvPassword;
    TextView tvError;
    Button btnIngresar;

    List<Cliente> listaClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaClientes = new ArrayList<>();

        tvDNI = findViewById(R.id.tvDNI);
        tvPassword = findViewById(R.id.tvPassword);
        btnIngresar = findViewById(R.id.btnVerificar);
        tvError = findViewById(R.id.tvError);

        listaClientes.add(new Cliente("73967075","123","Jean","Herrera"));
        listaClientes.add(new Cliente("80759520","123","Juan","Lopez"));
        listaClientes.add(new Cliente("75448201","123","Pedro","Diaz"));

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int contador = 0;

                String dni = tvDNI.getEditText().getText().toString();
                String password = tvPassword.getEditText().getText().toString();

                for (Cliente cli : listaClientes){
                    if(dni.equals(cli.getDNI()) && password.equals(cli.getPassword())){
                        Intent intent = new Intent(MainActivity.this,NavigationActivity.class);
                        intent.putExtra("cliente",cli);
                        startActivity(intent);
                        finish();
                        break;
                    }
                    contador++;
                }

                if(contador == listaClientes.size()){
                    tvError.setText("El usuario o contraseña incorrectos");
                }

            }
        });
    }
}