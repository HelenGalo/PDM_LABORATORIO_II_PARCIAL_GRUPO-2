package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import java.lang.StringBuilder

class RealizarMatricula : AppCompatActivity() {
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)
        btn_Matricular.setOnClickListener { guardar() }
        btn_regresar2.setOnClickListener { regresar1() }
    }

    private  fun guardar() {
        val parametro = StringBuilder()
        num += 1
        parametro.append(txt_nCuentaMat.text.toString().trim()).append("|")

        datos_Matricula.put(num, parametro.toString())

    }

    private fun enviar(){
        val intent = Intent(this, EnviarMatricula ::class.java)
        intent.putExtra("datos", datos_Matricula)
        startActivity(intent)
    }



    fun regresar1() {
        val intent = Intent(this, RecyclerAdapter::class.java)
        startActivity(intent)
    }

}