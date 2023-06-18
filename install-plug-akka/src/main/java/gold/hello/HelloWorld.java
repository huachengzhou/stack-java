package gold.hello;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import gold.base.Greeter;

/**
 * @author: zch
 * @date: 2019/5/31 10:33
 * @description:
 */
public class HelloWorld extends UntypedActor {
    @Override
    public void preStart() throws Exception {
        // create the greeter actor
        final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
        // tell it to perform the greeting
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object o) throws Exception {

    }
}
