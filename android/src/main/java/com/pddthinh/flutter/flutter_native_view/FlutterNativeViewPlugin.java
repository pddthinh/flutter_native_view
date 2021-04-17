package com.pddthinh.flutter.flutter_native_view;

import com.pddthinh.flutter.flutter_native_view.ui.NativeViewFactory;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * FlutterNativeViewPlugin
 */
public class FlutterNativeViewPlugin implements FlutterPlugin, MethodCallHandler {
    private static final String NATIVE_VIEW_ID = "com.pddthinh.flutter.NATIVE_VIEW";

    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private MethodChannel channel;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        channel = new MethodChannel(binding.getBinaryMessenger(), "flutter_native_view");
        channel.setMethodCallHandler(this);

        binding.getPlatformViewRegistry().registerViewFactory(
                NATIVE_VIEW_ID,
                new NativeViewFactory(binding.getBinaryMessenger())
        );
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        if (call.method.equals("getPlatformVersion")) {
            result.success("Android " + android.os.Build.VERSION.RELEASE);
        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }
}
