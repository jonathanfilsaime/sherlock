package com.sherlock.validation;

import com.sherlock.computation.SearchValues;
import com.sherlock.model.FinancialDataObject;
import com.sherlock.model.KeyStatsObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class Validation {

    public static boolean isNumeric(String value)
    {
      if(value != null && !value.equals("NaN"))
      {
          return true;
      }
      return false;
    }

    public static boolean validateFinancialDataObject(ResponseEntity<FinancialDataObject> financialDataObjectArray)
    {
        if(financialDataObjectArray.getBody().getFinancials() != null)
        {
            return true;
        }
        return false;
    }

    public static boolean validateKeyStatsObject(ResponseEntity<KeyStatsObject> keyStatsObject)
    {
        if(keyStatsObject.getBody() != null)
        {
            return true;
        }
        return false;
    }

    public static boolean validateMapSize(Map<Integer, String> map)
    {
        if((map.size() >= 4 )&& ((map.size() - 1) % 3 == 0))
        {
            return true;
        }

        return false;
    }

    public static boolean validateWhereCondition(Map<Integer, String> map)
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

    public static boolean validateLength(String[] string) {
        if ((string.length >= 4) && (string.length - 1) % 3 == 0)
        {
            return true;
        }
        return false;
    }

    public static boolean validateSyntax(String[] strings) {
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


}
