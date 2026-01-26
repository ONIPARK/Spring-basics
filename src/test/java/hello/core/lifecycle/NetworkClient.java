package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("コンストラクタ呼び出し、url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // サービス開始時、呼び出し
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // サービス終了後、呼び出し
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("初期化接続メッセージ");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
