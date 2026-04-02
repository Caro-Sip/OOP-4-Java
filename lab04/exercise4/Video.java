package lab04.exercise4;

public class Video {
    private String title;
    private String uploader;
    private String length;
    private String type;

    public Video(String title, String uploader, String length, String type) {
        this.title = title;
        this.uploader = uploader;
        this.length = length;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getUploader() {
        return uploader;
    }

    public String getLength() {
        return length;
    }

    public String getType() {
        return type;
    }

    public void display(int index) {
        System.out.println((index + 1) + ". " + title + " by " + uploader);
    }
}
