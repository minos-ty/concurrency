##两种方法的对比
 - 实现Runnable接口的方式(方法一)比继承Thread的方式(方法二)**更好**
>通常情况下是不考虑方法方法2的

```
// from Thread

/* What will be run. */
private Runnable target;

@Override
    public void run() {
        if (target != null) {
            target.run();
       }
  }
```

- 两种方法的**本质**比较
>方法一：最终调用target.run()
>
>方法二：run()整个被重写
