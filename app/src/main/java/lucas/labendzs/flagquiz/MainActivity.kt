package lucas.labendzs.flagquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
    fun goNextActivity(view: View){
        val intent= Intent(this, MainActivity2::class.java)
        val pegaNome=findViewById<EditText>(R.id.nome)
        val nome=pegaNome.text.toString()
        if (nome.isEmpty()) {
            Toast.makeText(this, "Digite seu nome para começar!", Toast.LENGTH_SHORT).show()
            return
        }
        intent.putExtra("usuario",nome)
        startActivity(intent)
        finish()
    }
}