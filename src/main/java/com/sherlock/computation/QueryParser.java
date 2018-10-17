package com.sherlock.computation;

import java.util.HashMap;
import java.util.Map;

public class QueryParser {

    public String parse(String string)
    {
        String[] split = string.split("\\s+");

        if(validateLength(split) && validateSyntax(split))
        {
            createValueMap(split);
        }

        return "ok";
    }

    private boolean validateLength(String[] string)
    {
        if((string.length >= 4) && (string.length - 1) % 3 == 0)
        {
            System.err.println("validateLength: true" );
            return true;
        }
        System.err.println("validateLength: false" );
        return false;
    }

    private boolean validateSyntax(String[] strings)
    {
        boolean value = true;
        
        for (int i = 0; i < strings.length; i++ )
        {
            if(i == 0 && strings[i].substring(0,5).equals("Find:"))
            {
                System.err.println(strings[i].substring(0,5));
            }
            else if(((i==1) || (i > 1 && i % 3 == 1)) && strings[i].substring(0,6).equals("Where:"))
            {
                System.err.println(strings[i].substring(0,6));
            }
            else if(((i==2) || (i > 2 && i % 3 == 2)) && strings[i].substring(0,3).equals("is:"))
            {
                System.err.println(strings[i].substring(0,3));
            }
            else if(i>2 && i % 3 == 0 && strings[i].substring(0,5).equals("Than:"))
            {
                System.err.println(strings[i].substring(0,5));
            }
            else
            {
                System.err.println("failure");
                value = false;
            }
        }
        System.err.println("end point: " + value);
        return value;
    }

    private Map<Integer, String> createValueMap(String[] strings)
    {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++ )
        {
            if(i == 0)
            {
                System.err.println(strings[i].substring(5));
                map.put(i, strings[i].substring(5));
            }
            else if(((i==1) || (i > 1 && i % 3 == 1)))
            {
                System.err.println(strings[i].substring(6));
                map.put(i, strings[i].substring(6));
            }
            else if(((i==2) || (i > 2 && i % 3 == 2)))
            {
                System.err.println(strings[i].substring(3));
                map.put(i, strings[i].substring(3));
            }
            else if(i>2 && i % 3 == 0)
            {
                System.err.println(strings[i].substring(5));
                map.put(i, strings[i].substring(5));
            }
            else
            {
                System.err.println("failure");
            }
        }

        System.err.println("this is the map: " + map.toString());
        return map;
    }

    private String queryStringBuilder(Map map)
    {
        return "good stopping point";
    }


    public static void main(String[] args) {
        String test0 = "Find:Top10Stocks Where:GrossProfit is:greater Than:0.01 Where:CostOfRevenue is:less Than:100 Where:CashFlow is:less Than:$100,000,000";
        String test1 = "Find:Top10Stocks Where:GrossProfit is:greater Than:$10,000,000,000";
        String test3 = "Find:Top10Stocks Where:GrossProfit is:greater Than:0.01 Where:CostOfRevenue is:less Than:100 Where:CashFlow is:less Than:$100,000,000 Where:OperatingIncome is:greater Than:6 Where:CostOfRevenue is:greater Than:$100,000,000";
        String failTest0 = "Where:GrossProfit is:greater Than:$10,000,000 Find:Top10Stocks";
        String failTest1 = "Than:0.01 Find:Top10Stocks is:greater Where:GrossProfit";
        String failTest2 = "Find:Top10Stocks Where:GrossProfit";
        QueryParser q = new QueryParser();
//        q.parse(test0);
//        q.parse(test1);
//        q.parse(test3);
//        q.parse(failTest0);
//        q.parse(failTest1);
//        q.parse(failTest2);

    }
}


