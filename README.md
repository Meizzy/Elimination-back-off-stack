>Assignment for Architecture for Parallel Computer Systems course @LETI university 2022/23 academic session
### Contributors
**Yaseer Buruji Ibrahim** - ibyaseer@mail.ru

[Buruji Yaseer](https://github.com/Meizzy)

# Overview
Elimination-backoff stack is an unbounded lock-free LIFO
linked list, that eliminates concurrent pairs of pushes
and pops with exchanges.  It uses compare-and-set (CAS)
atomic operation to provide concurrent access with
obstruction freedom. In order to support even greater
concurrency, in case a push/pop fails, it tries to
pair it with another pop/push to eliminate the operation
through exchange of values.

```java
push():
1. Create a new node with given value.
2. Try pushing it to stack.
3a. If successful, return.
3b. Otherwise, try exchanging on elimination array.
4a. If found a matching pop, return.
4b. Otherwise, retry 2.
```

```java
pop():
1. Try popping a node from stack.
2a. If successful, return node's value
2b. Otherwise, try exchanging on elimination array.
3a. If found a matching push, return its value.
3b. Otherwise, retry 1.
```

```java
tryPush():
1. Get stack top.
2. Set node's next to top.
3. Try push node at top (CAS).
```

```java
tryPop():
1. Get stack top, and ensure stack not empty.
2. Try pop node at top, and set top to next (CAS).
```

```java
EliminationArray.visit():
1. Try exchanging value on a random exchanger.
```

```java
Exchanger.exchange():
1. Calculate last wait time.
2. If wait time exceeded, then throw expection.
3. Get slot value and stamp.
4a. If slot is EMPTY (no value):
4b. Try adding 1st value to slot, else retry 2.
4c. Try getting 2nd value from slot, within time limit.
5a. If slot is WAITING (has 1st value):
5b. Try adding 2nd value to slot, else retry 2.
5c. Return 1st value.
6a. If slot is BUSY (has 2nd value):
6b. Retry 2.
```
