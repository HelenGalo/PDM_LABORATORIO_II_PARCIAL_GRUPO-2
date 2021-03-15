package hn.edu.pdm_laboratorio_prueba
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerAdapter = RecyclerAdapter()
    var  data: HashMap<Int, String> = hashMapOf()
    var  data_clases: HashMap<Int, String> = hashMapOf()
    var status:String="false"
    var cont:Int = 0
    var estado_Clase="false"
    var nota:HashMap<Int, String> = hashMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        collapsing_toolbar.title = "UJCV"
        collapsing_toolbar.setContentScrimColor(Color.BLACK)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter=adapter





        validar()
        println("THIS IS" +status.toString())






    }

    fun validar(){
        var tem=getVariable().toString()



        var intent = intent
        if(tem=="true"){
            data = intent.getSerializableExtra("listado") as HashMap<Int, String>
            println(data.toString())
            goAlum(obt())
        }

        var estadotem=getEstadoCLase().toString()
        if(estadotem=="true"){
            getClases()
            adapter.enviarClases(data,data_clases)
        }

    }



    fun getVariable(): String {
        val bundle = intent.extras
        val pala = bundle?.get("status")
        this.status = getString(R.string.txvpalabraoficial, pala)
        return status

    }

    fun getEstadoCLase():String{
        val bundle = intent.extras
        val pala = bundle?.get("ESTADOCLASE")
        this.estado_Clase = getString(R.string.txvpalabraoficial, pala)
        return estado_Clase

    }

    fun goAlum(v:HashMap<Int, String>){

        adapter.enviarDatos(v)





    }

    fun getClases(){
        var intent = intent
        data_clases = intent.getSerializableExtra("clases") as HashMap<Int, String>
        data = intent.getSerializableExtra("alumno") as HashMap<Int, String>
        nota = intent.getSerializableExtra("notas") as HashMap<Int, String>
        println("LAS CLASES SON "+data_clases.toString())
        println("El alumno es "+ data.toString())
        println("notas "+ nota.toString())

    }

    fun obt():HashMap<Int, String>{

        return data
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}