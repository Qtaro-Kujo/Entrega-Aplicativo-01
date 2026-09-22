package lucas.labendzs.flagquiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val flags = listOf(
            R.drawable.albania,
            R.drawable.argelia,
            R.drawable.cabo_verde,
            R.drawable.croacia,
            R.drawable.cuba,
            R.drawable.dinamarca,
            R.drawable.gra_bretania,
            R.drawable.holanda,
            R.drawable.indonesia,
            R.drawable.panama,
            R.drawable.portugal,
            R.drawable.qatar,
            R.drawable.srilanka,
            R.drawable.suecia,
            R.drawable.usa

        )
        val nomesPaises = arrayOf(
            "Albânia",
            "Argélia",
            "Cabo Verde",
            "Croácia",
            "Cuba",
            "Dinamarca",
            "Grã-Bretanha",
            "Holanda",
            "Indonésia",
            "Panamá",
            "Portugal",
            "Catar",
            "Sri Lanka",
            "Suécia",
            "Estados Unidos"
        )
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nomePais = findViewById<EditText>(R.id.editTextText2)
        var controle = 1
        var pontuacao=0;
        var indiceAtual = flags.indices.random()
        val imgFlag: ImageView = findViewById(R.id.imgFlag)
        imgFlag.setImageResource(flags[indiceAtual])
        val button: Button = findViewById(R.id.btnConfirma)
        val resultado: TextView = findViewById(R.id.mensagem)
        val control: TextView = findViewById(R.id.contador)
        button.setOnClickListener {
            control.setText ("${controle+1} de 5")
            val resposta = nomePais.text.toString().trim()

            if (nomesPaises[indiceAtual].equals(resposta, ignoreCase = true)) {
                resultado.text = "Acertou!"
                resultado.setTextColor(Color.rgb(46, 125, 50))
                pontuacao+=20;
            } else {
                resultado.text = "Errou!"
                resultado.setTextColor(Color.RED)
            }
            indiceAtual = flags.indices.random()
            imgFlag.setImageResource(flags[indiceAtual])
            nomePais.text.clear()
            controle++
            if (controle>5){
                val intentFinal= Intent(this, MainActivity3::class.java)
                val nomeUsuario = intent.getStringExtra("usuario").orEmpty()
                intentFinal.putExtra("usuario",nomeUsuario)
                intentFinal.putExtra("pontuacao",pontuacao)
                startActivity(intentFinal)
                finish()
            }
        }
    }

}
