package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.toggleButton.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                Toast.makeText(this, "활성화 완료!",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "비활성화되었습니다",Toast.LENGTH_SHORT).show();
            }

        }

        binding.intentToggle.setOnClickListener{
            val intent = Intent(this,ToggleActivity::class.java)
            startActivity(intent)

        }


    }

    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }

}