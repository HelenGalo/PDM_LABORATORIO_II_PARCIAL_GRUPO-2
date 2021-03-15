package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_matricula.*
import kotlinx.android.synthetic.main.activity_realizar_matricula.*

class EnviarMatricula:AppCompatActivity() {
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    var datos_alumno: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_matricula)

        btn_regresarE.setOnClickListener {
            regresar()

        }
        obtener()

        inicializar()



    }


    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun obtener(){
        var intent = intent
        datos_alumno= intent.getSerializableExtra("clases") as HashMap<Int, String>
        datos_Matricula= intent.getSerializableExtra("alumno") as HashMap<Int, String>

    }
    fun inicializar(){
        var a:String=""
        for(valor in datos_Matricula) {
            val list = valor.toString().split("|").toTypedArray()
            a = list[1].toString()
        }

        txt_CuentaEv.setText(a)

    }





}