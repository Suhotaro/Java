package Developer;


public class LeadDeveloper extends Developer{
    public LeadDeveloper(String name, int basicSalary, int experiance)
    {
        super(name, basicSalary, experiance);
    }
    
    @Override
    public double getSalary()
    {
        return (basicSalary *2) + (experience > 0 ? basicSalary*experience*0.1 : 0);
    }
}
