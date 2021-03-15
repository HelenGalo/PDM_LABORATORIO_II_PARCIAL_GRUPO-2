package hn.edu.pdm_laboratorio_prueba
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ingresar_notas.*

class IngresarNotas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_notas)
        btn_IngresarNota.setOnClickListener {
            regresar()
        }

    }


    private fun regresar(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}