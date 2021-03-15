package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import java.lang.StringBuilder

class RegistrarClase : AppCompatActivity() {
    var datos_Clase: HashMap<Int, String> = hashMapOf()
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_clase)
        btn_regresar3.setOnClickListener { regresar3() }
        btn_RegistrarClase.setOnClickListener { guardar() }

        val spinner_NClase = findViewById<Spinner>(R.id.spinner_N)
        val lista_NClases = resources.getStringArray(R.array.valoresClases)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_NClases)
        spinner_NClase.adapter =adaptador
        spinner_NClase.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                txv_SeleccionClase.text= "Seleccione una opcion"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                txv_SeleccionClase.text= lista_NClases[position].toString()
            }
        }

        val spinner_Seccion = findViewById<Spinner>(R.id.spinner_Seccion)
        val lista_Seccion = resources.getStringArray(R.array.valoresSeccion)
        val adaptadorSe = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Seccion)
        spinner_Seccion.adapter =adaptadorSe
        spinner_Seccion.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                txv_SeleccionSeccion.text= "Seleccione una opcion"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                txv_SeleccionSeccion.text= lista_Seccion[position].toString()
            }
        }

        val spinner_Hora = findViewById<Spinner>(R.id.spinner_Hora)
        val lista_Hora = resources.getStringArray(R.array.valoresHora)
        val adaptadorH = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Hora)
        spinner_Hora.adapter =adaptadorH
        spinner_Hora.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                txv_SeleccionHora.text= "Seleccione una opcion"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                txv_SeleccionHora.text= lista_Hora[position].toString()
            }
        }
        val spinner_Aula = findViewById<Spinner>(R.id.spinner_Aula)
        val lista_Aula = resources.getStringArray(R.array.valoresAula)
        val adaptadorAu = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Aula)
        spinner_Aula.adapter =adaptadorAu
        spinner_Aula.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                txv_SeleccionAula.text= "Seleccione una opcion"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                txv_SeleccionAula.text= lista_Aula[position].toString()
            }
        }
        val spinner_Edificio = findViewById<Spinner>(R.id.spinner_Edificio)
        val lista_Edificio = resources.getStringArray(R.array.valoresEdificio)
        val adaptadorEd = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Edificio)
        spinner_Edificio.adapter =adaptadorEd
        spinner_Edificio.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                txv_SeleccionEdificio.text= "Seleccione una opcion"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                txv_SeleccionEdificio.text= lista_Edificio[position].toString()
            }
        }
    }
    private  fun guardar() {
        val parametro = StringBuilder()
        num += 1
        parametro.append(txt_nCuentaA2.text.toString().trim()).append("|")
        parametro.append(txv_SeleccionClase.text.toString().trim()).append("|")
        parametro.append(txv_SeleccionSeccion.text.toString().trim()).append("|")
        parametro.append(txv_SeleccionHora.text.toString().trim()).append("|")
        parametro.append(txv_SeleccionEdificio.text.toString().trim()).append("|")
        parametro.append(txv_SeleccionAula.text.toString().trim()).append("|")
        datos_Clase.put(num, parametro.toString())
        Toast.makeText(this, "Clase guardada", Toast.LENGTH_SHORT).show()

    }

    private fun enviar(){
        val intent = Intent(this, EnviarMatricula ::class.java)
        intent.putExtra("datos", datos_Clase)
        startActivity(intent)
    }

    fun regresar3() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}