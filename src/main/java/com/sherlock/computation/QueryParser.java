package com.sherlock.computation;

public class QueryParser {
//    Find:Top10Stocks Where:GrossProfit is:greater Than:$10,000,000,000
    public String parse(String string)
    {
        String[] split = string.split("\\s+");
        if(validateLength(split) && validateSyntax(split))
        {
            for (int i = 0; i < split.length; i++ )
            {
                if(i==0)
                {
                    System.err.println("***" + split[i]);
                }
                else
                {
                    System.err.println(split[i]);
                }
            }
        }

        return "ok";
    }

    private boolean validateLength(String[] string)
    {
        if((string.length - 1) % 3 == 0)
        {
            return true;
        }
        return false;
    }

    private boolean validateSyntax(String[] strings)
    {
        
        for (int i = 0; i < strings.length; i++ )
        {
            if(i == 0 && !strings[i].substring(0,5).equals("Find:"))
            {
                System.err.println(strings[i].substring(0,5));
                return false;
            }
            if(i>0 && i % 1 == 0 && !strings[i].substring(0,6).equals("Where:"))
            {
                System.err.println(strings[i].substring(0,6));
                return false;
            }
            if(i>1 && i % 2 == 0 && !strings[i].substring(0,3).equals("is:"))
            {
                System.err.println(strings[i].substring(0,3));
                return false;
            }
            if(i>2 && i % 3 == 0 && !strings[i].substring(0,5).equals("Than:"))
            {
                System.err.println(strings[i].substring(0,5));
                return false;
            }
        }
        System.err.println("success");
        return true;
    }

    public static void main(String[] args) {
        String test ="Find:Top10Stocks Where:GrossProfit is:greater Than:$10,000,000,000";
        QueryParser q = new QueryParser();
        q.parse(test);

    }
}


