package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import java.lang.StringBuilder

class RealizarMatricula : AppCompatActivity() {
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    var datos_alumno: HashMap<Int, String> = hashMapOf()
    var num = 0
    var cont:Int=0
    var cantidad:String=""
    var status=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

        btn_Matricular.setOnClickListener { guardar() }
        btn_regresar2.setOnClickListener { regresar1() }
        obtener()

        inicializar()


        }


    private  fun guardar() {

        if(cont>0){
            Toast.makeText(this,"CLASE INSCRITA", Toast.LENGTH_LONG).show()
        }

        println(datos_Matricula.toString())
        var to = arrayOf<String>("edwin.espino@ujcv.edu.hn", "helen.orellana1@ujcv.edu.hn")
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,to)
        intent.putExtra(Intent.EXTRA_SUBJECT, "MATRICULA")
        intent.putExtra(Intent.EXTRA_TEXT, datos_Matricula.toString()+" "+datos_alumno.toString())
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email"))



    }

    private fun obtener(){
        var intent = intent
         datos_alumno= intent.getSerializableExtra("clases") as HashMap<Int, String>
        datos_Matricula= intent.getSerializableExtra("alumno") as HashMap<Int, String>

        val bundle = intent.extras
        val pala = bundle?.get("cant")
        this.cantidad = getString(R.string.txvpalabraoficial, pala)


    }



    fun regresar1() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



    fun inicializar(){
        var a:String=""
        var b:String=""
        var c:Int=0




            for (valor in datos_alumno) {
                val list = valor.toString().split("|").toTypedArray()
                b =b+list[2].toString()+" "


            }


        for (valor in datos_Matricula) {
            val list = valor.toString().split("|").toTypedArray()
            a = list[1].toString()

        }

        txt_nCuentaMat.setText(a)
        txv_Seleccion.setText(b)

    }

}