package belajar.ngoding.swipeablevideos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import belajar.ngoding.swipeablevideos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<VideoItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(DataVideo.listData)
        binding.videosViewPager.adapter = VideoAdapter(list)
    }
}