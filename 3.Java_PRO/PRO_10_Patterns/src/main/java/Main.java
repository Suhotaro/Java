
public class Main {

    public static void main(String []args)
    {
/*---------- Behavioral patterns ----------*/

        /* Iterator */
        IteratorPattern iteratorPattern = new IteratorPattern();
        iteratorPattern.run();

        /* Chain of Responsibility  */
        ChainOfResponsibilityPattern chainOfResponsibility = new ChainOfResponsibilityPattern();
        chainOfResponsibility.run();

        /* Observer */
        ObserverPattern observerPattern = new ObserverPattern();
        observerPattern.run();

        /* Command */
        CommandPattern commandPattern = new CommandPattern();
        commandPattern.run();

        /* Memento */
        MementoPattern mementoPattern = new MementoPattern();
        mementoPattern.run();

        /* State */
        StatePattern statePattern = new StatePattern();
        statePattern.run();

        /* Template method */
        TemplateMethodPattern templateMethodPattern = new TemplateMethodPattern();
        templateMethodPattern.run();

        /* Visitor */
        VisitorPattern visitorPattern = new VisitorPattern();
        visitorPattern.run();

/*---------- Creational patterns ----------*/

        /* Singleton */
        SingletonPattern singletonPattern = new SingletonPattern();
        singletonPattern.run();

        /* Multitone */
        MultitonePattern multitonePattern = new MultitonePattern();
        mementoPattern.run();

        /* Object pool */
        ObjectPoolPattern objectPoolPattern = new ObjectPoolPattern();
        objectPoolPattern.run();

        /* Factory */
        FactoryPattern factoryPattern = new FactoryPattern();
        factoryPattern.run();

        /* Abstarct Factory */
        AbstractFactoryPattern abstractFactoryPattern = new AbstractFactoryPattern();
        abstractFactoryPattern.run();

        /* Builder */
        BuilderPattern builderPattern = new BuilderPattern();
        builderPattern.run();

        /* Prototype */
        PrototypePattern prototypePattern = new PrototypePattern();
        prototypePattern.run();

/*---------- Structural patterns ----------*/

        /* Adapter */
        AdapterPattern adapterPattern = new AdapterPattern();
        adapterPattern.run();

        /* Decorator */
        DecoratorPattern decoratorPattern = new DecoratorPattern();
        decoratorPattern.run();

        /* Composite */
        CompositePattern compositePattern = new CompositePattern();
        commandPattern.run();

        /* Bridge */
        BridgePattern bridgePattern = new BridgePattern();
        bridgePattern.run();
    }
}
