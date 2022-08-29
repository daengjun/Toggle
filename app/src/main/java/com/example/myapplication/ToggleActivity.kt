package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityToggleBinding

class ToggleActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityToggleBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle)
        mBinding = ActivityToggleBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        //람다식을 사용하여 처리
//        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked) {
//                binding.textView1.text = "스위치1 : $isChecked"
//            } else {
//                binding.textView1.text = "스위치1 미사용"
//            }
//        }


        //inner class를 사용하여 처리
        binding.switch1.setOnCheckedChangeListener(MyCheckedChangeListener())
        binding.switch2.setOnCheckedChangeListener(MyCheckedChangeListener())

        binding.toggleButton.setOnCheckedChangeListener(MyCheckedChangeListener())
        binding.toggleButton2.setOnCheckedChangeListener(MyCheckedChangeListener())


        // .toggle() 메서드를 사용하여 반대값으로 변경처리
//        binding.button.setOnClickListener {
//            binding.switch1.toggle()
//            binding.switch2.toggle()
//
//            binding.toggleButton.toggle()
//            binding.toggleButton2.toggle()
//        }

    }

    inner class MyCheckedChangeListener : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when (buttonView?.id) {
                R.id.switch1 ->
                    if (isChecked) {
                        Toast.makeText(baseContext, "알림설정 활성화 완료!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(baseContext, "알림설정 비활성화", Toast.LENGTH_SHORT).show();
                    }
                R.id.switch2 ->
                    if (isChecked) {
                        Toast.makeText(baseContext, "방해금지모드 활성화 완료!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(baseContext, "방해금지모드 비활성화", Toast.LENGTH_SHORT).show();
                    }

                R.id.toggleButton ->
                    if (isChecked) {
                        Toast.makeText(baseContext, "진동 활성화 완료!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(baseContext, "진동 비활성화", Toast.LENGTH_SHORT).show();
                    }

                R.id.toggleButton2 ->
                    if (isChecked) {
                        Toast.makeText(baseContext, "구독 설정 완료!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(baseContext, "구독 비활성화", Toast.LENGTH_SHORT).show();
                    }
            }
        }
    }

    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }

}