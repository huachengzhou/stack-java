
wait() 执行后 就在所在的代码处停止执行,直到接到通知或中断为止
notify() 执行后,当前线程不会马上释放该对象锁,呈wait()状态的线程也不能够马上获得该对象锁,要等到执行notify()方法的线程将程序执行完,
也就是推出synchronized代码块后，当前线程才会释放锁