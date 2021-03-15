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
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import java.lang.StringBuilder

class RealizarMatricula : AppCompatActivity() {
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    var num = 0
    var cont:Int=0
    var status=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

        btn_Matricular.setOnClickListener { guardar() }
        btn_regresar2.setOnClickListener { regresar1() }

        inicializar()


        val spinnerClase = findViewById<Spinner>(R.id.spinner_C)
        val listaClases = resources.getStringArray(R.array.valoresClases)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item, listaClases)
        spinnerClase.adapter =adaptador
        spinnerClase.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                txv_Seleccion.text= "Seleccione una opcion"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                txv_Seleccion.text= listaClases[position].toString()
            }
        }
    }

    private  fun guardar() {
        cont = cont+1
        val parametro = StringBuilder()
        num += 1
        parametro.append(txv_Seleccion.text.toString().trim()).append("|")
        datos_Matricula.put(1, datos_Matricula.get(1)+parametro.toString())
        if(cont>0){
            Toast.makeText(this,"CLASE INSCRITA", Toast.LENGTH_LONG).show()
        }

        println(datos_Matricula.toString())
    }

    private fun enviar(){
        val intent = Intent(this, EnviarMatricula ::class.java)
        intent.putExtra("datos", datos_Matricula)
        startActivity(intent)
    }



    fun regresar1() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



    fun inicializar(){
        var a:String=""
        for(valor in datos_Matricula) {
            val list = valor.toString().split("|").toTypedArray()
            a = list[1].toString()
        }

        txt_nCuentaMat.setText(a)

    }

}