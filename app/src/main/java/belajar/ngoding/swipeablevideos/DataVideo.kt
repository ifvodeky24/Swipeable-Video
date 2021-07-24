package belajar.ngoding.swipeablevideos

object DataVideo {
    private val videoURL = arrayOf(
        "https://media.istockphoto.com/videos/unrecognizable-woman-grabs-a-handful-of-dry-sand-and-lets-it-fall-video-id941094504",
        "https://media.istockphoto.com/videos/unrecognizable-woman-grabs-a-handful-of-dry-sand-and-lets-it-fall-video-id941094504"
    )

    private val videoTitle = arrayOf(
        "Tes1",
        "Tes2"
    )

    private val videoDescription = arrayOf(
        "Tes1",
        "Tes2"
    )

    val listData: ArrayList<VideoItem>
        get() {
            val list = arrayListOf<VideoItem>()
            for (position in videoTitle.indices) {
                val videoItem = VideoItem()
                videoItem.videoURL = videoURL[position]
                videoItem.videoTitle = videoTitle[position]
                videoItem.videoDescription = videoDescription[position]
                list.add(videoItem)
            }
            return list
        }
}