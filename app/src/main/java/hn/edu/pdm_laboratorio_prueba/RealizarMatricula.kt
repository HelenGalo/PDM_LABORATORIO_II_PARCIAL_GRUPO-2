package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
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
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import java.lang.StringBuilder

class RealizarMatricula : AppCompatActivity() {
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    var datos_alumno: HashMap<Int, String> = hashMapOf()
    var matricula_final: HashMap<Int, String> = hashMapOf()
    var num = 0
    var cont:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

        btn_Matricular.setOnClickListener { guardar() }
        btn_regresar2.setOnClickListener { regresar1() }
        obtener()

        inicializar()

        txt_nCuentaMat.setRawInputType(InputType.TYPE_NULL)

        }


    private  fun guardar() {





        if (txt_nCuentaMat.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese el Numero de cuenta", Toast.LENGTH_SHORT).show()
        }else{
            if(cont>0){
                val parametro = StringBuilder()
                num += 1
                parametro.append("DATOS ALUMNOS-CLASE").append("|")
                parametro.append(datos_Matricula.toString().trim()).append("|")
                parametro.append(datos_alumno.toString().trim()).append("|")
                matricula_final.put(num,parametro.toString())
                println(matricula_final.toString())
                Toast.makeText(this, "Matricula realizada con Exito!", Toast.LENGTH_SHORT).show()


            }

        }


    }

    private fun obtener(){
        var intent = intent
         datos_alumno= intent.getSerializableExtra("clases") as HashMap<Int, String>
        datos_Matricula= intent.getSerializableExtra("alumno") as HashMap<Int, String>




    }



    fun regresar1() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("estadof", "false")
        intent.putExtra("matriculaf", matricula_final)
        startActivity(intent)
    }



    fun inicializar(){
        val bundle = intent.extras
        val pala = bundle?.get("cant")
        this.cont = getString(R.string.txvpalabraoficial, pala).toInt()
        println(cont.toString())

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