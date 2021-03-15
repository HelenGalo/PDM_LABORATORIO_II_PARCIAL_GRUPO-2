package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_matricula.*

class EnviarMatricula:AppCompatActivity() {
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_matricula)

        btn_regresarE.setOnClickListener {
            regresar()
        }


    }


    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }





}