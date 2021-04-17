import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class NativeView extends StatelessWidget {
  static const ROUTE_NAME = "/nativeView";
  static const VIEW_ID = "com.pddthinh.flutter.NATIVE_VIEW";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Native View")),
      body: AndroidView(
        viewType: VIEW_ID,
        onPlatformViewCreated: (id) {
          print("Native view with id: $id is created");
        },
      ),
    );
  }
}
