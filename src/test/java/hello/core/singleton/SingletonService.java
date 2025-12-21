package hello.core.singleton;

public class SingletonService {

    //1. static 領域にオブジェクトを1つのみ生成しておく。
    private static final SingletonService instance = new SingletonService();

    //2. publicでインスタンスが必要とする場合、このstaticメソッドを通じて参照できるようにする。
    public static SingletonService getInstance() {
        return instance;
    }

    //3. コンストラクタをprivateを宣言し、外でnewキーワードを使用したオブジェクト生成を防ぐ

    private SingletonService() {
    }

    public void logic() {
        System.out.println("Singletonオブジェクトロジック呼び出し");
    }
}
