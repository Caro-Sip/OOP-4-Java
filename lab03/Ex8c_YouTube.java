class User {
    String userId;
    String username;
    String email;
    int subscribers;
    
    public User() {}
    
    public User(String userId, String username, String email, int subscribers) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.subscribers = subscribers;
    }
}

class Video {
    String videoId;
    String title;
    String description;
    int views;
    User uploader;
    
    public Video() {}
    
    public Video(String videoId, String title, String description, int views, User uploader) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.views = views;
        this.uploader = uploader;
    }
    
    public void setValues(String videoId, String title, String description, int views, User uploader) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.views = views;
        this.uploader = uploader;
    }
    
    public void display() {
        System.out.printf("Video ID: %s | Title: %-20s | Views: %d | Uploader: %s (%d subs)%n", 
            videoId, title, views, uploader.username, uploader.subscribers);
    }
}

public class Ex8c_YouTube {
    public static void main(String[] args) {
        User user1 = new User("U001", "TechChannel", "tech@youtube.com", 500000);
        User user2 = new User("U002", "CodingMaster", "coding@youtube.com", 250000);
        
        Video vid1 = new Video();
        vid1.setValues("V001", "Java Basics Tutorial", "Learn Java from scratch", 125000, user1);
        
        Video vid2 = new Video();
        vid2.setValues("V002", "Advanced OOP", "Object-oriented programming in depth", 89000, user1);
        
        Video vid3 = new Video();
        vid3.setValues("V003", "Python for Beginners", "Start coding with Python", 156000, user2);
        
        Video[] videos = new Video[3];
        videos[0] = vid1;
        videos[1] = vid2;
        videos[2] = vid3;
        
        System.out.println("\n=== YouTube Videos ===");
        for (Video video : videos) {
            video.display();
        }
    }
}
