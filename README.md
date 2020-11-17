# strategy-pattern

## Problem
`SimUDuck` is a duck simulator game. `Duck` is abstract super class defines the behaviour. It's subclasses simply reuses the parent's behaviour or overrides it.

```
                +-----------------+
                |                 |
                |                 |
           +----+       Duck      +----+
           |    |                 |    |
           |    |                 |    |
           |    +-----------------+    |
           |                           |
           |                           |
           v                           v
  +-----------------+         +-----------------+
  |                 |         |                 |
  |                 |         |                 |
  |  Mallard Duck   |         |   Redhead Duck  |
  |                 |         |                 |
  |                 |         |                 |
  +-----------------+         +-----------------+

```


The `Duck` has following behaviours
* quack()
* swim()
* display()

After sometime, boss told you to make them `fly()`. Not that hard, right? Implement `fly()` in the `Duck` class right?
Lets assume there are 50 different ducks sub classing `Duck` and some of them don't fly (rubber duck). How do you make them not fly? Well, we could override `fly()`.
Few months went by, now boss wants ducks to make different sounds. Are we going to override `quack()` in 50 different ducks? Let's say group of ducks makes the same
sound. Now what? How do we reuse same sound (behaviour)?

We could abstract behaviours. For example we could define `FlyBehaviour` and `QuackBehaviour` interfaces to define the behaviour. Then, we can have 
concrete implementations of different behaviour.

```
                          +-----------------+
                          |                 |
                          |                 |
         +----------------+ QuackBehaviour  +---------------+
         |                |                 |               |
         |                |                 |               |
         |                +--------+--------+               |
         |                         |                        |
         |                         |                        |
         v                         v                        v
+--------+--------+       +--------+--------+      +--------+--------+
|                 |       |                 |      |                 |
|                 |       |                 |      |                 |
|      Quack      |       |      Squeak     |      |    MuteQuack    |
|                 |       |                 |      |                 |
|                 |       |                 |      |                 |
+-----------------+       +-----------------+      +-----------------+

```
Now, we can reuse any of these behaviour within a duck. Why `QuackBehaviour`? You will soon see the flexibility it adds to the application.

We have behaviours but how do we use it in exiting code? We got some changes to make to `Duck`.

1. Lets create some properties in `Duck` to hold `QuackBehaviour` and `FlyBehaviour`.
2. Also some methods to perform fly and quack.
3. Now, lets initialize concrete instances within duck implementations like `Redhead Duck`.

Since you have `quackBehaviour` instance stored in `Duck`, you can simply call `quackBehaviour.quack()` within `Duck.performQuack()` method.
According to the book, when we create for example `Squeak` instance we uses `new` and that's not good but for now we will stick to that.



