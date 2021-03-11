package ga.catcat.livedatatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2() : AppCompatActivity() {
    companion object {
        const val TEST : String = "ga.catcat.livedatatest.TEST"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        button.setOnClickListener {
            val count = 10
            val intent = Intent()
            intent.putExtra(TEST,count)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}