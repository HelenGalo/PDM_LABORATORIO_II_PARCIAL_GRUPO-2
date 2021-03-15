package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_enviar_matricula_correo.*

class EnviarMatriculaCorreo : AppCompatActivity() {
    var datos_Matricula:HashMap<Int,String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_matricula_correo)
        obtener()
        btn_Envio2.setOnClickListener { enviar() }
    }


    fun enviar(){
        var to = arrayOf<String>(txt_Correo.text.toString(), "helen.orellana1@ujcv.edu.hn")
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,to)
        intent.putExtra(Intent.EXTRA_SUBJECT, txt_ASUNTO.text)
        intent.putExtra(Intent.EXTRA_TEXT, datos_Matricula.toString())
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email"))
    }




    fun obtener() {
        var intent = intent
        datos_Matricula = intent.getSerializableExtra("set") as HashMap<Int, String>
        println("TOTA"+ datos_Matricula.toString())



    }

}