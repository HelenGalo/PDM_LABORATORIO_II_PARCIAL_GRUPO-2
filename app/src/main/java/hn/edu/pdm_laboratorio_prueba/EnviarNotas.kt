package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_notas.*
import kotlinx.android.synthetic.main.activity_realizar_matricula.*

class EnviarNotas:AppCompatActivity() {
    var datos_nota: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_enviar_notas)
        btn_regresarNota.setOnClickListener {
            regresar()
        }
        inicializarN()
        obtenerN()

    }

    private fun regresar(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
    private fun obtenerN(){
        var intent = intent

        datos_nota = intent.getSerializableExtra("notas") as HashMap<Int, String>




    }
    fun inicializarN(){

        var c:String=""




        for (valor in datos_nota) {
            val list = valor.toString().split("|").toTypedArray()
            c = list[1].toString()

        }

        txt_CuentaN.setText(c)


    }

}