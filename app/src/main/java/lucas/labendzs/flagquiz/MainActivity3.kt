package lucas.labendzs.flagquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nomeUsuario = intent.getStringExtra("usuario").orEmpty()
        val nomeUsu = findViewById<TextView>(R.id.seuNome)
        val pont = intent.getIntExtra("pontuacao", 0)

        val pontosFinais = findViewById<TextView>(R.id.finalPontos)
        pontosFinais.text = "Pontuação: $pont"
        nomeUsu.text="Seu nome: $nomeUsuario"

        findViewById<Button>(R.id.btnRecomeca).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
