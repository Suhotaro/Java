package Developer;

/**
 * Created by Suhotaro on 14.11.2015.
 */
public class RunDeveloper {
    public RunDeveloper() {;}

    public void run()
    {
        Developer[] list = {
                new JuniorDeveloper("Mike", 500, 0),
                new JuniorDeveloper("Jim", 500, 1),
                new JuniorDeveloper("Julia", 500, 2),
                new LeadDeveloper("Lee", 500, 4),
                new LeadDeveloper("Tom", 500, 4),
                new SeniorDeveloper("Jack", 500, 5),
                new SeniorDeveloper("Mao", 500, 6),
                new SeniorDeveloper("Bob", 500, 0),
                new SeniorDeveloper("Rob", 500, 0),
                new TeamLeadDeveloper("Robby", 500, 7)
        };
        StringBuilder sb;

        /* Task 3.2*/
        for (Developer d : list) {
            if ( d instanceof SeniorDeveloper && 1600 <= d.getSalary()) {
                sb = new StringBuilder() // !!!
                        .append(d.getName())
                        .append(": ")
                        .append(d.getBasicSalary())
                        .append(" -> ")
                        .append(d.getSalary());

                System.out.println(sb.toString());
            }
        }

        /* Task 3.3*/
        Developer []list_jun = new Developer[5];
        Developer []list_lead = new Developer[5];
        Developer []list_senior = new Developer[5];
        Developer []list_team_lead = new Developer[5];

        int jun_num = 0;
        int lead_num = 0;
        int senior_num = 0;
        int team_lead_num = 0;

        for (Developer d : list)
        {
            if ( d instanceof JuniorDeveloper)
                list_jun[jun_num++] = d;
            else if ( d instanceof LeadDeveloper)
                list_lead[lead_num++] = d;
            else if ( d instanceof SeniorDeveloper)
                list_senior[senior_num++] = d;
            else if ( d instanceof TeamLeadDeveloper)
                list_team_lead[team_lead_num++] = d;
        }

        System.out.println("\nJuns: ");
        for (int i = 0; i < jun_num; i ++)
            System.out.println("  " + list_jun[i].getName());

        System.out.println("\nLeads: ");
        for (int i = 0; i < lead_num; i ++)
            System.out.println("  " + list_lead[i].getName());

        System.out.println("\nSenoirs: ");
        for (int i = 0; i < senior_num; i ++)
            System.out.println("  " + list_senior[i].getName());

        System.out.println("\nTeam Leads: ");
        for (int i = 0; i < team_lead_num; i ++)
            System.out.println("  " + list_team_lead[i].getName());
    }

}
