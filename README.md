# Observer-pattern

## Problem

The book has taken weather monitoring system where single weather station
is responsible for updating multiple devices at the same time.
Weather station has different measurements from different devices and different
displays show different measurements. Assume in tree displays weather manager
show current condition, statistics and forecast.

```java
                                                                                +----------------+
                                                                                |                |
                                                             +----------------->+     Display    |
           +-----+                                           |                  |     Devices    |
           |     +---------------+                           |                  |                |
           |     |               v                           |                  +----------------+
           +-----+      +--------+---------+                 |
                        |                  |                 |                  +----------------+
           +-----+      |                  |         +--------+--------+        |                |
Sensor     |     |      |                  |         |                 |        |     Display    |
Devices    |     +----->+ Weather station  +-------->+ Weather manager +------->+     Devices    |
           +-----+      |                  |         |                 |        |                |
                        |                  |         +--------+--------+        +----------------+
                        |                  |                 |
           +-----+      +--------+---------+                 |                  +----------------+
           |     |               ^                           |                  |                |
           |     +---------------+                           |                  |     Display    |
           +-----+                                           +----------------->+     Devices    |
                                                                                |                |
                                                                                +----------------+
```

Weather manager has following methods

* getTemperature()
* getHumidity()
* getPressure()
* measurementsChanged()

measurementsChanged() will be called when weather station has different reading
of the weather. This way, Weather manager can request required data and update
the display (Book is not clear about whether measurementChanged gives us the
property that got changed)

Following Weather manager implementation is from the book.

```java
measurementChanged() {
    temp = getTemperature();
    humidity = getHumidity();
    pressure = getPressure();

    currentConditionsDisplay.update(temp, humidity, pressure);
    statisticsDisplay.update(temp, humidity, pressure);
    forecastDisplay.update(temp, humidity, pressure);
}
```

### What is wrong with current implementation

Even though code id using `update()` common pattern (book states that
displays are does not implement an interface), adding more displays will add more
code to measurementChanged() method. for example, if a new user wants
to use the weather service in their display, then implementation would be
something like below.

```java
measurementChanged() {
    ...

    currentConditionsDisplay.update(temp, humidity, pressure);
    statisticsDisplay.update(temp, humidity, pressure);
    forecastDisplay.update(temp, humidity, pressure);
    user1CustomDisplay.update(temp, humidity, pressure);
}
```

If 10 more displays wants to use the weather data, new 10 lines of code has to
be added to the code. Since that part of the code is changing, that has to be
encapsulated. One more disadvantage is you can not add or remove displays at
runtime.

## Solution

```java
  +------------------------+
  |      <<interface>>     |
  |         Subject        |                  +--------------------+
  +------------------------+                  |    <<interface>>   |
  |                        |                  |       Observer     |
  |   registerObserver()   |                  +--------------------+
  |   removeObserver()     |                  |                    |
  |   notifyObserver()     |                  |   update()         |
  |                        |                  |                    |
  +------------+-----------+                  +----------+---------+
               ^                                         ^
               |                                         |
               |                                         |
               |                                         |
+--------------+----------------+            +-----------+-----------+
|    Concrete Subject           |            |   Concrete Observer   |
+-------------------------------+            +-----------------------+
|                               |            |                       |
|    registerObserver() {...}   |            |   update() {...}      |
|    removeObserver() {...}     |            |                       |
|    notifyObserver() {...}     |            +-----------------------+
|                               |
|    getState()                 |
|    setState()                 |
|                               |
+-------------------------------+
```

### Why Observer pattern is better

* Only thing subject knows about subject is, it implements Observer interface
* We can add new observers at any time
* Modifications is not needed to new Observers
* Subject or Observer can be reused

Notice the loosely coupled code with observer pattern. Now we don't have
displays hard coded in the code instead those who wants to observe can register
to the subject and get updates. If user 2 comes and wants to listen to weather,
all he needs to do is to add the observer. It doesn't change a thing in Concrete
Subject implementation. Here, registerObserver and removeObserver expect an
Observer type. Subject only knows the very little it should know. That is
Observer has a method called update().

Please check the java project for full implementation
