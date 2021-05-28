package com.kodlama.io.hrms.core.utilities.business;

import com.kodlama.io.hrms.core.utilities.results.Result;

public class BusinessRules {
	 public static Result run(Result... logics)
     {
         for (Result result : logics)
         {
             if (!result.isSuccess())
             {
                 return result;
             }
         }

         return null;
     }
}
