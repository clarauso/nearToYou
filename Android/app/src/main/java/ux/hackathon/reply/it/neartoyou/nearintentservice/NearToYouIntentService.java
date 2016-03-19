package ux.hackathon.reply.it.neartoyou.nearintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by c.rauso on 19/03/2016.
 */
public class NearToYouIntentService  extends IntentService {

    private ScheduledThreadPoolExecutor executor;

    public NearToYouIntentService() {
        super("NearToYouIntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public NearToYouIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("NearToYouIntentService", "NearToYouIntentService start scheduling task");
        executor = new ScheduledThreadPoolExecutor(0);
        executor.scheduleAtFixedRate(new GetInfoRunnable(), 0, 30, TimeUnit.SECONDS);
        Log.d("NearToYouIntentService", "Task scheduled");
    }
}
