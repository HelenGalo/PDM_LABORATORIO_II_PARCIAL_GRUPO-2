package hn.edu.pdm_laboratorio_prueba
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_notas.*
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import java.lang.StringBuilder

class IngresarNotas : AppCompatActivity() {
    var datos_nota: HashMap<Int, String> = hashMapOf()

    var datos_MatriculaF: HashMap<Int, String> = hashMapOf()
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_notas)
        btn_IngresarNota.setOnClickListener {
            guardar()
        }
        btn_regresarN.setOnClickListener{
            regresar()
        }
        recibir()

        val spinnerClaseN = findViewById<Spinner>(R.id.spinner_NClase2)
        val listaClases = resources.getStringArray(R.array.valoresClases)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaClases)
        spinnerClaseN.adapter = adaptador
        spinnerClaseN.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

    }




    private  fun guardar() {

        if (txt_nCuentaA3.text.toString().isEmpty()) {
            Toast.makeText(this, "Debe de ingresar un Numero de cuenta", Toast.LENGTH_SHORT).show()
        }else {
            if (txt_NombreA2.text.toString().isEmpty()) {
                Toast.makeText(this, "Debe de ingresar un Nombre", Toast.LENGTH_SHORT).show()
            } else {
                if(txt_Nota.text.toString().isEmpty()){
                    Toast.makeText(this, "Ingrese una nota", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Nota Registrada!", Toast.LENGTH_SHORT).show()

                    val parametro = StringBuilder()
                    num += 1
                    parametro.append("DATOS ALUMNOS").append("|")
                    parametro.append(txt_nCuentaA3.text.toString().trim()).append("|")
                    parametro.append(txt_NombreA2.text.toString().trim()).append("|")
                    parametro.append(spinner_NClase2.selectedItem.toString().trim()).append("|")
                    parametro.append(txt_Nota.text.toString().trim()).append("|")

                    datos_nota.put(num, parametro.toString())
                    println(datos_nota.toString())
                }

            }
        }
    }

    private fun regresar(){

        val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("ESTADOCLASE","false")
            intent.putExtra("alm",datos_MatriculaF)
            intent.putExtra("no",datos_nota)
            intent.putExtra("estadonota", "true")
            intent.putExtra("state", "true")

            startActivity(intent)
        val p = Process.myPid()
        Process.killProcess(p)
        }



    private fun recibir(){
        var intent = intent
        datos_MatriculaF= intent.getSerializableExtra("mf") as HashMap<Int, String>
        println(datos_MatriculaF.toString())
    }

    }
