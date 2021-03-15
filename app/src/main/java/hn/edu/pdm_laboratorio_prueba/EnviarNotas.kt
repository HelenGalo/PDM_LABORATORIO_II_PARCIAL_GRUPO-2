package hn.edu.pdm_laboratorio_prueba

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_notas.*

class EnviarNotas:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_enviar_notas)
        btn_regresar5.setOnClickListener {
            regresar()
        }
    }

    private fun regresar(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


}