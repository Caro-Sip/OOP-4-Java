package lab04.exercise4;

public class VideoManager {
    private Video[] videos;
    private int count;

    public VideoManager(int size) {
        videos = new Video[size];
        count = 0;
    }

    public void addVideo(String title, String uploader, String length, String type) {
        if (count < videos.length) {
            videos[count++] = new Video(title, uploader, length, type);
            System.out.println("Video added successfully!");
        } else {
            System.out.println("Storage is full!");
        }
    }

    public void viewAll() {
        if (count == 0) {
            System.out.println("No videos found.");
            return;
        }
        System.out.println("\n==== All Videos ====");
        for (int i = 0; i < count; i++) {
            videos[i].display(i);
        }
    }

    public void search(String keyword) {
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (videos[i].getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                if (found == 0) {
                    System.out.println(count + " videos found:");
                }
                videos[i].display(found);
                found++;
            }
        }
        if (found == 0) {
            System.out.println("0 video found. Try again");
        }
    }
}
