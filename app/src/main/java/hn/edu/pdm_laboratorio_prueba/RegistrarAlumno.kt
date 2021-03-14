package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registrar_alumno.*

class RegistrarAlumno : AppCompatActivity() {
    var datos: HashMap<Int, String> = hashMapOf()
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_alumno)
        btn_regresar.setOnClickListener { regresar() }
        }

    fun regresar() {
        val intent = Intent(this, RecyclerAdapter::class.java)
        startActivity(intent)
    }

}