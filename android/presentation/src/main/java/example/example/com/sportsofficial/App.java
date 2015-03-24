package example.example.com.sportsofficial;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class App extends Application {
    private ObjectGraph mObjectGraph;

    @Override public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(getModules().toArray());
        mObjectGraph.inject(this);
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }
}
