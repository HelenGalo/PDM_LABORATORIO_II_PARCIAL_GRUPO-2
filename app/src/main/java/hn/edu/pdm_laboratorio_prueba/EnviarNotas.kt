package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.os.Process
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_notas.*
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*

class EnviarNotas:AppCompatActivity() {
    var datos_nota: HashMap<Int, String> = hashMapOf()
    var datos_Clase: HashMap<Int, String> = hashMapOf()
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    var cont:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_notas)
        obtenerN()
        inicializarN()
        btn_regresarNota.setOnClickListener {
            regresar()
        }
        btn_Envio.setOnClickListener { guardar() }
        btn_salir.setOnClickListener { Salir() }

        txt_CuentaN.setRawInputType(InputType.TYPE_NULL)
        txt_nombreA.setRawInputType(InputType.TYPE_NULL)
        txt_NotaCla.setRawInputType(InputType.TYPE_NULL)
        txt_NotaE.setRawInputType(InputType.TYPE_NULL)

    }

    private fun regresar(){
        val p = Process.myPid()
        Process.killProcess(p)
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }




    private  fun guardar() {

        if(cont>0){
            Toast.makeText(this,"CLASE INSCRITA", Toast.LENGTH_LONG).show()
        }

        println(datos_nota.toString())
        var to = arrayOf<String>("edwin.espino@ujcv.edu.hn", "helen.orellana1@ujcv.edu.hn","miguel.torres@ujcv.edu.hn","Daniela.herrera@ujcv.edu.hn")
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,to)
        intent.putExtra(Intent.EXTRA_SUBJECT, "NOTAS")
        intent.putExtra(Intent.EXTRA_TEXT, datos_nota.toString())
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email"))




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
    fun Salir() {
        val p = Process.myPid()
        Process.killProcess(p)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }



}