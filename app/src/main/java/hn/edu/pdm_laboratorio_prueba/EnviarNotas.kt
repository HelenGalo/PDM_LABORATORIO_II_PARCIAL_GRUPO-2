package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_notas.*
import kotlinx.android.synthetic.main.activity_realizar_matricula.*

class EnviarNotas:AppCompatActivity() {
    var datos_nota: HashMap<Int, String> = hashMapOf()
    var datos_Clase: HashMap<Int, String> = hashMapOf()
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_notas)
        obtenerN()
        inicializarN()
        btn_regresarNota.setOnClickListener {
            regresar()
        }


    }

    private fun regresar(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
    private fun obtenerN(){
        var intent = intent
       datos_nota = intent.getSerializableExtra("notas")as HashMap<Int, String>




    }
    fun inicializarN(){

        var c:String=""
        var d:String=""
        var e:String=""
        var f:String=""

        for (valor in datos_nota) {
            val list = valor.toString().split("|").toTypedArray()
            c = list[1].toString()
            d = list[2].toString()
            e = list[3].toString()
            f = list[4].toString()
        }

        txt_CuentaN.setText(c)
        txt_nombreA.setText(d)
        txt_NotaCla.setText(e)
        txt_NotaE.setText(f)


    }

}