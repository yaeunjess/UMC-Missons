package com.example.myapplication7_1

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast
import com.example.myapplication7_1.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var time=0
        var started= false

        val handler = object: Handler(){  //handler 생성
            override fun handleMessage(msg: Message) {  //화면에 메세지를 출력하는 Handler
                super.handleMessage(msg)
                val minute = String.format("%02d", time/6000) //분 변수
                val second = String.format("%02d", time%6000/100) //초 변수
                val mili = String.format("%02d", time%100) //밀리초 변수
                binding.tvMain.text = "$minute:$second.$mili" //00:00.00
            }
        }
        val handler2 = Handler(Looper.getMainLooper()) //toast 띄우기 위한 handler2 생성
        val mSoundPool = SoundPool.Builder().build() //SoundPool 생성

        mSoundPool.setOnLoadCompleteListener{soundPool, sampleId, status->
            soundPool.play(R.raw.sound, 1.0f, 1.0f, 1, 0, 1f)
        }

        binding.btnStart.setOnClickListener{
            if(started == false){
                started = true
                var minute = Integer.parseInt(binding.etMinute.getText().toString())
                var second = Integer.parseInt(binding.etSecond.getText().toString())
                time = minute*6000 + second*100
                var sminute = String.format("%02d", time/6000) //분 변수
                var ssecond = String.format("%02d", time%6000/100) //초 변수
                binding.tvMain.text="$sminute:$ssecond.00"
                }
            Thread{
                while(started){
                    Thread.sleep(10)  //1초 지연
                    if(started){
                        time -= 1
                        if(time <= 0) {
                            started = false
                            handler2.post {
                                Toast.makeText(this, "타이머가 종료되었습니다.", Toast.LENGTH_SHORT).show()
                            }

                        }
                        handler?.sendEmptyMessage(0)
                    }
                }
            }.start()
        }
        //binding.btnStop.setOnClickListener{}
        //binding.초기화버튼.setOnClickListener{}
    }
}