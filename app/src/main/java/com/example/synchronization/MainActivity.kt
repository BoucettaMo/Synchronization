package com.example.synchronization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.synchronization.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter1:MyAdapter
    private lateinit var adapter2:MyAdapter
    private val list= arrayOf(3,9,11,15,19,21,27)
    private val hashMap= hashMapOf<Int,Array<Int>>(0 to list,1 to symmetry(list))
    private var position=0

    private val countDownTimer=object :CountDownTimer(2000,1000) {
        override fun onTick(millisUntilFinished: Long) {
            adapter1= MyAdapter(applicationContext,hashMap[position]!!)
            adapter2= MyAdapter(applicationContext,symmetry(hashMap[position]!!))
            binding.recyclerview1.layoutManager=GridLayoutManager(applicationContext,7)
            binding.recyclerview2.layoutManager=GridLayoutManager(applicationContext,7)
            binding.recyclerview1.adapter=adapter1
            binding.recyclerview2.adapter=adapter2
            position=(position+1)%2

        }

        override fun onFinish() {
            position=0
            this.start()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        countDownTimer.start()


    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }

    override fun onStop() {
        super.onStop()
        countDownTimer.cancel()
    }

    override fun onRestart() {
        super.onRestart()
        position=0
        countDownTimer.start()
    }


    private fun symmetry(list:Array<Int>): Array<Int> {
        val permutation = arrayOf(4,3,2,1,0)
        val result=Array<Int>(list.size) {0}
        for (i in list.indices) {
            result[i]=permutation[ list[i]/7]*7+list[i]%7
        }

        return result

    }
}