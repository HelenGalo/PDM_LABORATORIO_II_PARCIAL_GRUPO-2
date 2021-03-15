package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.os.Process
import android.view.MotionEvent
import android.view.View
import android.widget.Button
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
        btn_regresarE2.onBackPressed()

        println(datos_Matricula.toString())
        var to = arrayOf<String>("edwin.espino@ujcv.edu.hn", "helen.orellana1@ujcv.edu.hn")
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,to)
        intent.putExtra(Intent.EXTRA_SUBJECT, "MATRICULA")
        intent.putExtra(Intent.EXTRA_TEXT, datos_Matricula.toString()+" "+datos_alumno.toString())
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email"))




    }


    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun Salir() {
        val p = Process.myPid()
        Process.killProcess(p)
    }




}

private fun Button.onBackPressed() {
    val p = Process.myPid()
    Process.killProcess(p)
}
