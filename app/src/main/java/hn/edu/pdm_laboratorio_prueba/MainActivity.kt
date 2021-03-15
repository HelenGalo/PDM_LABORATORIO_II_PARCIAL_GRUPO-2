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
    var status:String="false"
    var cont:Int = 0


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

    }



    fun getVariable(): String {
        val bundle = intent.extras
        val pala = bundle?.get("status")
        this.status = getString(R.string.txvpalabraoficial, pala)
        return status

    }

    fun goAlum(v:String){

        adapter.enviarDatos(v)





    }

    fun obt():String{
        var a=""
        var b=""
        for(i in data){
            val list = i.toString().split("|").toTypedArray()
             a = list[1].toString()
             b = list[2].toString()
        }
        return a
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