package hn.edu.pdm_laboratorio_prueba
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_notas.*
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import java.lang.StringBuilder

class IngresarNotas : AppCompatActivity() {
    var datos_nota: HashMap<Int, String> = hashMapOf()
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
        val spinnerClaseN = findViewById<Spinner>(R.id.spinner_NClase2)
        val listaClases = resources.getStringArray(R.array.valoresClases)
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaClases)
        spinnerClaseN.adapter = adaptador
        spinnerClaseN.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                txv_SelecNomClaseIN.text = "Seleccione una opcion"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                txv_SelecNomClaseIN.text= listaClases[position].toString()
            }
        }

    }




    private  fun guardar() {
        val parametro = StringBuilder()
        num += 1
        parametro.append(txt_nCuentaA3.text.toString().trim()).append("|")
        parametro.append(txt_NombreA2.text.toString().trim()).append("|")
        parametro.append(txt_Nota.text.toString().trim()).append("|")
        parametro.append(txv_SelecNomClaseIN.text.toString().trim()).append("|")

        datos_nota.put(num, parametro.toString())
        Toast.makeText(this, "Nota Agregada", Toast.LENGTH_SHORT).show()
    }

    private fun regresar(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}