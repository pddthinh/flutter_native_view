package com.pddthinh.flutter.flutter_native_view.ui;

import android.content.Context;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class NativeViewFactory extends PlatformViewFactory {
    private final BinaryMessenger mMessenger;

    public NativeViewFactory(BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);

        mMessenger = messenger;
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        return new NativeView(context, viewId, mMessenger);
    }
}
