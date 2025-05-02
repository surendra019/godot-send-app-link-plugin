package com.example.sendcontentplugin;

import android.app.Activity;
import android.content.Intent;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;
import org.godotengine.godot.plugin.SignalInfo;
import org.godotengine.godot.plugin.UsedByGodot;

import java.util.Set;

public class GodotAndroidPlugin extends GodotPlugin {
    /**
     * Base constructor passing a {@link Godot} instance through which the plugin can access Godot's
     * APIs and lifecycle events.
     *
     * @param godot
     */
    private Activity activity;

    @Nullable
    @Override
    public View onMainCreate(Activity activity) {
        this.activity = activity;
        return super.onMainCreate(activity);
    }

    public GodotAndroidPlugin(Godot godot) {
        super(godot);
    }

    @NonNull
    @Override
    public String getPluginName() {
        return "SendContentPlugin";
    }

    @NonNull
    @Override
    public Set<SignalInfo> getPluginSignals() {
        Set<SignalInfo> set = new ArraySet<>();
        return set;
    }

    @UsedByGodot
    void sendAppLink(String subject){
        try{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + activity.getPackageName());
            activity.startActivity(Intent.createChooser(intent, "Share by"));

        }catch (Exception e){
            Log.e("PLUGIN ERROR", "exception during creating intent");
        }
    }

}
