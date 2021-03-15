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
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import java.lang.StringBuilder

class RealizarMatricula : AppCompatActivity() {
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    var num = 0
    var status=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

        btn_Matricular.setOnClickListener { guardar() }
        btn_regresar2.setOnClickListener { regresar1() }
        recibir()


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
        val parametro = StringBuilder()
        num += 1
        parametro.append(txt_nCuentaMat.text.toString().trim()).append("|")
        parametro.append(txv_Seleccion.text.toString().trim()).append("|")

        datos_Matricula.put(num, parametro.toString())
        Toast.makeText(this, "Matricula Realizada", Toast.LENGTH_SHORT).show()
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

    fun recibir(){
        val bundle = intent.extras
        val pala = bundle?.get("studio")
        val h = getString(R.string.txvpalabraoficial, pala)
        txt_nCuentaMat.setText(h)
        println(h.toString())
    }

}