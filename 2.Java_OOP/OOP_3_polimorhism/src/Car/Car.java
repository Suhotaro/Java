package Car;


class Car
{
        public String getName()
        {
            return "atomobile ";
        }
}

class BMW extends Car
{
    @Override
    public String getName()
    {
        return "BMW";
    }
}

class Porche extends Car
{
    @Override
    public String getName()
    {
        return "Porche";
    }
}

class BMW_M extends BMW
{
    @Override
    public String getName()
    {
        return super.getName() + "_M";
    }
}

