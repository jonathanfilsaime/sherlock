package com.sherlock.computation;

import com.sherlock.model.ConditionRequestObject;
import com.sherlock.model.RequestObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class QueryParser {



    public String parse(String string) {
        String[] split = string.split("\\s+");
        String sqlString = null;

        if (validateLength(split) && validateSyntax(split)) {
            sqlString = queryStringBuilder(createValueMap(split));
        }

        System.err.println(sqlString);
        return sqlString;
    }

    public String parseRequest(RequestObject requestObject)
    {
        Map<Integer, String> map = createValueMapFromRequestObject(requestObject);
        if(validateMapSize(map) && validateWhereCondition(map))
        {
            return queryStringBuilder(map);
        }
        return null;
    }

    public Map<Integer, String> createValueMapFromRequestObject(RequestObject requestObject)
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, requestObject.getFind());
        int index = 0;
        for (ConditionRequestObject condition : requestObject.getConditionRequestObjects())
        {
            index++;
            map.put(index, condition.getWhere());
            index++;
            map.put(index, condition.getIsGreater() /*? "true" : "false"*/);
            index++;
            map.put(index, condition.getAmount());
        }
        System.err.println("inside map" + map.toString());
        return map;
    }

    private boolean validateMapSize(Map<Integer, String> map)
    {
        if((map.size() >= 4 )&& ((map.size() - 1) % 3 == 0))
        {
            return true;
        }

        return false;
    }

    private boolean validateWhereCondition(Map<Integer, String> map)
    {
        boolean value = false;
        SearchValues searchValues = new SearchValues();

        if( map.get(0).equals("TOP_10_STOCKS") || map.get(0).equals("TOP_50_STOCKS") ||
                map.get(0).equals("TOP_100_STOCKS") || map.get(0).equals("ALL_STOCKS"))
        {
            value = true;
        }
        else
        {
            return false;
        }

        for(int i = 0; i < map.size(); i++)
        {
            if(searchValues.getValues().contains(map.get(i)))
            {
                value = true;
            }
            else if (((i == 1) || (i > 1 && i % 3 == 1)) && !(map.get(i).equalsIgnoreCase("true"))
                        && !(map.get(i).equalsIgnoreCase("false"))
                        && !(StringUtils.isNumeric(map.get(i).replaceAll("[$,]",""))))
            {
                value = true;
            }
            else if (((i == 2) || (i > 2 && i % 3 == 2)) &&
                    ((map.get(i).equalsIgnoreCase("true")) || (map.get(i).equalsIgnoreCase("false"))))
            {
                value = true;
            }
            else if (i > 2 && i % 3 == 0 && (StringUtils.isNumeric(map.get(i).replaceAll("[$,]",""))))
            {
                value = true;
            }
            else
            {
                return false;
            }
        }

        return value;
    }

    private boolean validateLength(String[] string) {
        if ((string.length >= 4) && (string.length - 1) % 3 == 0)
        {
            return true;
        }
        return false;
    }

    private boolean validateSyntax(String[] strings) {
        boolean value = false;

        for (int i = 0; i < strings.length; i++) {
            if (i == 0 && strings[i].substring(0, 5).equals("Find:")) {
                value = true;
            } else if (((i == 1) || (i > 1 && i % 3 == 1)) && strings[i].substring(0, 6).equals("Where:")) {
                value = true;
            } else if (((i == 2) || (i > 2 && i % 3 == 2)) && strings[i].substring(0, 3).equals("is:")) {
                value = true;
            } else if (i > 2 && i % 3 == 0 && strings[i].substring(0, 5).equals("Than:")) {
                value = true;
            } else {
                value = false;
            }
        }
        return value;
    }

    private Map<Integer, String> createValueMap(String[] strings) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++)
        {
            if (i == 0) {
                map.put(i, strings[i].substring(5));
            } else if (((i == 1) || (i > 1 && i % 3 == 1))) {
                map.put(i, strings[i].substring(6));
            } else if (((i == 2) || (i > 2 && i % 3 == 2))) {
                map.put(i, strings[i].substring(3));
            } else if (i > 2 && i % 3 == 0) {
                map.put(i, strings[i].substring(5).replaceAll("[$,]",""));
            }
            else {
            }
        }

        return map;
    }

    private String queryStringBuilder(Map map) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("SELECT * FROM financial_data WHERE");

        for (int i = 0; i < map.size(); i++) {
            if (i == 1) {
                stringBuilder.append(" ");
                stringBuilder.append(map.get(i));
            }
            if (i > 1 && i % 3 == 1) {
                stringBuilder.append(" AND ");
                stringBuilder.append(map.get(i));
            }
            if (i > 1 && i % 3 == 2) {
                if (map.get(i).equals("greater") || map.get(i).equals("true") || map.get(i).equals("True")) {
                    stringBuilder.append(" >");
                }
                if (map.get(i).equals("less") || map.get(i).equals("false") || map.get(i).equals("False")) {
                    stringBuilder.append(" <");
                }
            }
            if (i > 2 && i % 3 == 0) {
                stringBuilder.append(" ");
                stringBuilder.append(map.get(i));
            }
        }

        if (map.get(0).equals("TOP_10_STOCKS")) {
            stringBuilder.append(" LIMIT 10;");
        }
        if (map.get(0).equals("TOP_50_STOCKS")) {
            stringBuilder.append(" LIMIT 50;");
        }
        if (map.get(0).equals("TOP_100_STOCKS")) {
            stringBuilder.append(" LIMIT 100;");
        }
        if (map.get(0).equals("ALL_STOCKS")) {
            stringBuilder.append(";");
        }


        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String test0 = "Find:TOP_100_STOCKS Where:GrossProfit is:greater Than:0.01 Where:CostOfRevenue is:less Than:100 Where:CashFlow is:less Than:$100,000,000";
        String test1 = "Find:TOP_50_STOCKS Where:GrossProfit is:greater Than:$10,000,000,000";
        String test3 = "Find:TOP_10_STOCKS Where:GrossProfit is:greater Than:0.01 Where:CostOfRevenue is:less Than:100 Where:CashFlow is:less Than:$100,000,000 Where:OperatingIncome is:greater Than:6 Where:CostOfRevenue is:greater Than:$100,000,000";
        String test4 = "Find:ALL_STOCKS Where:GrossProfit is:greater Than:$10,000,000,000";
        String failTest0 = "Where:GrossProfit is:greater Than:$10,000,000 Find:Top10Stocks";
        String failTest1 = "Than:0.01 Find:Top10Stocks is:greater Where:GrossProfit";
        String failTest2 = "Find:Top10Stocks Where:GrossProfit";
        QueryParser q = new QueryParser();
        q.parse(test0);
        q.parse(test1);
        q.parse(test3);
        q.parse(test4);
        q.parse(failTest0);
        q.parse(failTest1);
        q.parse(failTest2);

    }
}





