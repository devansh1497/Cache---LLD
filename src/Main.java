import strategies.LRUStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        CacheManager cacheManager = CacheManager.getInstance();
        cacheManager.<String, Integer>create("cache1", 3, new LRUStrategy<>(3));
        cacheManager.put("cache1", "first", 1);
        cacheManager.put("cache1", "second", 2);
        cacheManager.put("cache1", "third", 3);
        System.out.println(cacheManager.get("cache1", "first"));
        System.out.println(cacheManager.get("cache1", "second"));
        System.out.println(cacheManager.get("cache1", "third"));

        cacheManager.put("cache1", "fourth", 4);
        System.out.println(cacheManager.get("cache1", "first"));
        System.out.println(cacheManager.get("cache1", "fourth"));
        System.out.println(cacheManager.get("cache1", "second"));

    }
}