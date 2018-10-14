package com.sherlock.computation;

import com.sherlock.model.FinancialDataObject;
import com.sherlock.model.KeyStatsObject;
import org.springframework.http.ResponseEntity;

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


}
