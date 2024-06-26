package com.cthiebaud.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * This WebView example shows how to enable a zoom function by
 * scrolling the mouse wheel while holding CTRL down. The mouse wheel zoom code
 * was provided by Friedhold Matz @FriedholdMatz :
 */

public class WebViewMouseWheelZoomExample extends Application {

    public static class MyObject {

        public void doIt() {
            System.out.println("doIt() called");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX WebView Example");

        WebView webView = new WebView();

        WebEngine webEngine = webView.getEngine();

        // webEngine.load("http://tutorials.jenkov.com");
        webEngine.loadContent(
                "<!DOCTYPE html><html><body>Hello World!<script type=\"text/javascript\">function hmm() { return 'Hey!'; }; document.write(hmm()); </script><button onclick='window.myObject.doIt();'>Do It</button></body></html>",
                "text/html");

        webView.addEventFilter(ScrollEvent.SCROLL, (ScrollEvent e) -> {
            double deltaY = e.getDeltaY();
            if (e.isControlDown() && deltaY > 0) {
                webView.setZoom(webView.getZoom() * 1.1);
                e.consume();
            } else if (e.isControlDown() && deltaY < 0) {
                webView.setZoom(webView.getZoom() / 1.1);
                e.consume();
            }
        });

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}