package br.fecaccp.calculadoraimc;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Obesidade1 extends AppCompatActivity {
    InformacoesUser infos;

    ImageButton btnFechar = findViewById(R.id.imgButtonFechar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade1);

        // Função do botão Fechar
        btnFechar.setOnClickListener(view -> {
            finish();
        });

        Bundle bundle = getIntent().getExtras();
        String imc = infos.getImc();
        String peso = infos.getPeso();
        String altura = infos.getAltura();

        TextView pesoAltura = findViewById(R.id.textInfos);
        String informacoesUser = "Peso: " + peso + "\nAltura: " + altura;
        pesoAltura.setText(informacoesUser);

        TextView resultado = findViewById(R.id.textResultado);
        String textResultado = imc + " - Obesidade 1";
        resultado.setText(textResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}