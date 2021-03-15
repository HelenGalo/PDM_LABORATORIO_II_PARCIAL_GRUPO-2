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
    var datos_Matricula: HashMap<Int, String> = hashMapOf()
    var num = 0
    var cont:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_clase)
        btn_regresar3.setOnClickListener { regresar3() }
        btn_RegistrarClase.setOnClickListener { guardar() }
        recibir()

        val spinner_NClase = findViewById<Spinner>(R.id.spinner_N)
        val lista_NClases = resources.getStringArray(R.array.valoresClases)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_NClases)
        spinner_NClase.adapter =adaptador
        spinner_NClase.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {

            }
        }

        val spinner_Seccion = findViewById<Spinner>(R.id.spinner_Sec)
        val lista_Seccion = resources.getStringArray(R.array.valoresSeccion)
        val adaptadorSe = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Seccion)
        spinner_Seccion.adapter =adaptadorSe
        spinner_Seccion.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {

            }
        }

        val spinner_Hora = findViewById<Spinner>(R.id.spinner_Hora)
        val lista_Hora = resources.getStringArray(R.array.valoresHora)
        val adaptadorH = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Hora)
        spinner_Hora.adapter =adaptadorH
        spinner_Hora.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {

            }
        }
        val spinner_Aula = findViewById<Spinner>(R.id.spinner_Aula)
        val lista_Aula = resources.getStringArray(R.array.valoresAula)
        val adaptadorAu = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Aula)
        spinner_Aula.adapter =adaptadorAu
        spinner_Aula.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {

            }
        }
        val spinner_Edificio = findViewById<Spinner>(R.id.spinner_Edificio)
        val lista_Edificio = resources.getStringArray(R.array.valoresEdificio)
        val adaptadorEd = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista_Edificio)
        spinner_Edificio.adapter =adaptadorEd
        spinner_Edificio.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {

            }
        }
    }
    private  fun guardar() {
        cont = cont + 1
        val parametro = StringBuilder()
        num += 1
        parametro.append("DATOS CLASE").append("|")
        parametro.append(txt_nCuentaA2.text.toString().trim()).append("|")
        parametro.append(spinner_N.selectedItem.toString().trim()).append("|")
        parametro.append(spinner_Sec.selectedItem.toString().trim()).append("|")
        parametro.append(spinner_Aula.selectedItem.toString().trim()).append("|")
        parametro.append(spinner_Hora.selectedItem.toString().trim()).append("|")
        parametro.append(spinner_Edificio.selectedItem.toString().trim()).append("|")

        datos_Clase.put(num, parametro.toString())
        println(datos_Clase.toString())
        if (txt_nCuentaA2.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese un Numero de cuenta", Toast.LENGTH_SHORT).show()
        } else {
            if (spinner_N.selectedItem.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese una Clase", Toast.LENGTH_SHORT).show()
            } else {
                if (spinner_Sec.selectedItem.toString().isEmpty()) {
                    Toast.makeText(this, "Ingrese una seccion", Toast.LENGTH_SHORT).show()
                } else {
                    if (spinner_Aula.selectedItem.toString().isEmpty()) {
                        Toast.makeText(this, "Ingrese un aula", Toast.LENGTH_SHORT).show()
                    } else {
                        if (spinner_Hora.selectedItem.toString().isEmpty()) {
                            Toast.makeText(this, "Ingrese una hora", Toast.LENGTH_SHORT).show()
                        } else {
                            if (spinner_Edificio.selectedItem.toString().isEmpty()) {
                                Toast.makeText(this, "Ingrese un Edificio", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(this, "Clase  Registrada", Toast.LENGTH_SHORT).show()
                            }

                        }
                    }

                }
            }
        }
    }


    private fun enviar(){
        val intent = Intent(this, EnviarMatricula ::class.java)
        intent.putExtra("datos", datos_Clase)
        startActivity(intent)
    }

    fun regresar3() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("clases", datos_Clase)
        intent.putExtra("ESTADOCLASE","true")
        intent.putExtra("alumno",datos_Matricula)
        intent.putExtra("cantidad",cont.toString())
        startActivity(intent)
    }

    fun recibir(){
        var intent = intent
        datos_Matricula=intent.getSerializableExtra("studio") as HashMap<Int, String>

    }

}