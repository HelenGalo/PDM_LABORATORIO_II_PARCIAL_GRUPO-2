package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ingresar_notas.*
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import java.lang.StringBuilder

class RegistrarAlumno : AppCompatActivity() {
    var datos_Alumnos: HashMap<Int, String> = hashMapOf()
    var num = 0
    var status=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_alumno)
        btn_regresar.setOnClickListener { regresar() }
        btn_registrarA.setOnClickListener { guardar() }

        println(status)

        }


    private  fun guardar() {
        val parametro = StringBuilder()
        num += 1
        parametro.append("DATOS ALUMNOS").append("|")
        parametro.append(txt_nCuentaA.text.toString().trim()).append("|")
        parametro.append(txt_NombreA.text.toString().trim()).append("|")
        parametro.append(txt_CorreoA.text.toString().trim()).append("|")
        datos_Alumnos.put(num,parametro.toString())
        println(datos_Alumnos.toString())

        if (txt_nCuentaA.text.toString().isEmpty()) {
            Toast.makeText(this, "Debe de ingresar un Numero de cuenta", Toast.LENGTH_SHORT).show()
        }else {
            if (txt_NombreA.text.toString().isEmpty()) {
                Toast.makeText(this, "Debe de ingresar un Nombre", Toast.LENGTH_SHORT).show()
            } else {
                if(txt_CorreoA.text.toString().isEmpty()){
                    Toast.makeText(this, "Ingrese un Correo", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Alumno  Registrado", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }

    private fun enviar(){
        val intent = Intent(this, EnviarMatricula ::class.java)
        intent.putExtra("listado", datos_Alumnos)
        startActivity(intent)
    }

    fun regresar() {
        var status:String = "true"
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("listado", datos_Alumnos)
        intent.putExtra("status", status)
        startActivity(intent)
    }



}