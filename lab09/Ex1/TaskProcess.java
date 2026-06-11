package Ex1;

public class TaskProcess implements Runnable {
    Task task;
    
    public TaskProcess(Task task){
        this.task = task;
    }

    @Override
    public void run() {
        int durationMs = task.getDuration();
        int seconds = Math.max(1, durationMs / 1000);

        for (int i = 1; i <= seconds; i++) {
            double percentage = (double) i / seconds * 100;
            String status = (i < seconds) ? "processing" : "completed";
            synchronized(System.out) {
                System.out.printf("%ds ::: %s - %.2f%% - %s :::%n", i, task.getName(), percentage, status);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("%s interrupted%n", task.getName());
                break;
            }
        }
    }

    public Task getTask() { return task; }
}
