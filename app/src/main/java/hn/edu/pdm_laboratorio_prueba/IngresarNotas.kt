package hn.edu.pdm_laboratorio_prueba
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }

    private  fun guardar() {
        val parametro = StringBuilder()
        num += 1
        parametro.append(txt_nCuentaA3.text.toString().trim()).append("|")
        parametro.append(txt_NombreA2.text.toString().trim()).append("|")
        parametro.append(txt_Nota.text.toString().trim()).append("|")
        parametro.append(spinner_NClase2.toString().trim()).append("|")

        datos_nota.put(num, parametro.toString())
        Toast.makeText(this, "Nota Agregada", Toast.LENGTH_SHORT).show()
    }

    private fun regresar(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}