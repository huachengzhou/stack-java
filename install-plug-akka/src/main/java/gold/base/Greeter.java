package gold.base;

import akka.actor.UntypedActor;

/**
 * @author: zch
 * @date: 2019/5/31 10:35
 * @description:
 */
public class Greeter extends UntypedActor {

    public static enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive(Object msg) throws InterruptedException {
        if (msg == Msg.GREET) {
            System.out.println("Hello World!");
            Thread.sleep(1000);
            getSender().tell(Msg.DONE, getSelf());
        } else {
            unhandled(msg);
        }
    }

}