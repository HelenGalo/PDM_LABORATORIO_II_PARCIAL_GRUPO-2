package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_matricula.*

class EnviarMatricula:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_matricula)
        btn_regresar4.setOnClickListener {
            regresar()
        }

    }

    fun regresar(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


}