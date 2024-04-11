package kr.ac.kopo.showpetpictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    lateinit var switchStart : Switch
    lateinit var rg : RadioGroup
    lateinit var linearSub : LinearLayout
    lateinit var imgV : ImageView
    lateinit var btnFinish : Button
    lateinit var btnInit : Button
//    lateinit var radioPuppy : RadioButton
//    lateinit var radioKitty : RadioButton
//    lateinit var radioBunny : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchStart = findViewById<Switch>(R.id.switchStart)
        rg = findViewById<RadioGroup>(R.id.rg)
        linearSub = findViewById<LinearLayout>(R.id.linearSub)
        imgV = findViewById<ImageView>(R.id.imgV)
        btnFinish = findViewById<Button>(R.id.btnFinish)
        btnInit = findViewById<Button>(R.id.btnInit)

        btnFinish.setOnClickListener(btnListener)
        btnInit.setOnClickListener(btnListener)

        linearSub.visibility = View.INVISIBLE

        switchStart.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                linearSub.visibility=View.VISIBLE
            }else{
                linearSub.visibility=View.INVISIBLE
            }
        }

        rg.setOnCheckedChangeListener { buttonView, isChecked ->
            when(rg.checkedRadioButtonId){
                R.id.radioPuppy -> imgV.setImageResource(R.drawable.puppy)
                R.id.radioKitty -> imgV.setImageResource(R.drawable.kitty)
                R.id.radioBunny -> imgV.setImageResource(R.drawable.bunny)
            }
        }




//        btnDone.setOnClickListener {
//            when(rg.checkedRadioButtonId){
//                R.id.radioPuppy -> imgV.setImageResource(R.drawable.puppy)
//                R.id.radioKitty -> imgV.setImageResource(R.drawable.kitty)
//                R.id.radioBunny -> imgV.setImageResource(R.drawable.bunny)
//            }
//        }
    }

    val btnListener = OnClickListener{
        when(it.id){
            R.id.btnFinish -> finish()
            R.id.btnInit -> {
                switchStart.isChecked = false
                linearSub.visibility = INVISIBLE
            }
        }
    }
}