package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_enviar_matricula_correo.*

class EnviarMatriculaCorreo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_matricula_correo)
        btn_Envio2.setOnClickListener { envio() }
    }

    fun envio() {

        val intent = Intent(this, ::class.java)
        startActivity(intent)
    }

}