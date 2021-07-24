package belajar.ngoding.swipeablevideos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import belajar.ngoding.swipeablevideos.databinding.ItemContainerVideoBinding

class VideoAdapter(private val listVideo: ArrayList<VideoItem>) :
    RecyclerView.Adapter<VideoAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemContainerVideoBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listVideo[position])
    }

    override fun getItemCount(): Int = listVideo.size

    inner class ListViewHolder(private val binding: ItemContainerVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(videoItem: VideoItem) {
            with(binding) {
                textVideoTitle.text = videoItem.videoTitle
                textVideoDescription.text = videoItem.videoDescription
                videoView.setVideoPath(videoItem.videoURL)
                videoView.setOnPreparedListener {
                    videoProgressBar.visibility = View.GONE
                    it.start()
                    val videoRatio = it.videoWidth / it.videoHeight.toFloat()
                    val screenRatio = videoView.width / videoView.height.toFloat()
                    val scale = videoRatio / screenRatio

                    if (scale >= 1f) videoView.scaleX = scale else videoView.scaleY = 1f / scale
                }

                videoView.setOnCompletionListener {
                    it.start()
                }
            }
        }
    }
}