package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import kotlinx.android.synthetic.main.activity_enviar_matricula_correo.*

class EnviarMatriculaCorreo : AppCompatActivity() {
    var datos_Matricula:HashMap<Int,String> = hashMapOf()
    var nota:HashMap<Int,String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_matricula_correo)
        obtener()
        btn_Envio2.setOnClickListener { enviar() }
        btn_regresarEn.setOnClickListener {regresar() }
        btn_salir2.setOnClickListener {Salir() }
    }


    fun enviar(){
        var to = arrayOf<String>(txt_Correo.text.toString(), "helen.orellana1@ujcv.edu.hn","miguel.torres@ujcv.edu.hn","Daniela.herrera@ujcv.edu.hn","edwin.espino@ujcv.edu.hn")
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,to)
        intent.putExtra(Intent.EXTRA_SUBJECT, txt_ASUNTO.text.toString())
        intent.putExtra(Intent.EXTRA_TEXT, datos_Matricula.toString())
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email"))
    }




    fun obtener() {
        var intent = intent
        datos_Matricula = intent.getSerializableExtra("set") as HashMap<Int, String>
        nota = intent.getSerializableExtra("go") as HashMap<Int, String>

        println("TOTA"+ datos_Matricula.toString()+ "GO "+nota.toString())



    }

    private fun regresar(){

        val intent= Intent(this,MainActivity::class.java)
        intent.putExtra("end", nota)
        startActivity(intent)
    }
    fun Salir() {
        val p = Process.myPid()
        Process.killProcess(p)

    }

}