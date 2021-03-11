package ga.catcat.livedatatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        myNumberViewModel.currentValue.observe(this, Observer {
            tv_text.text = it.toString()
            Log.d("확인2 ","${tv_text.text}")
        })

        Log.d("확인 ","${myNumberViewModel}")

        button2.setOnClickListener {
           val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent, RESULT_FIRST_USER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RESULT_FIRST_USER && resultCode == RESULT_OK){
            val item = data?.getIntExtra(MainActivity2.TEST,22)
            myNumberViewModel.updateValue(ActionType.SET,item!!)
        }
    }
}