class Solution {
    public int myAtoi(String s) {
        
        //Null case
    	if (s.isEmpty()) return 0;
        
        //Init Var
    	StringBuilder number = new StringBuilder();
        boolean isNegative = false;
        boolean plusSign = false;
        int j = 0;
        
         //Skip the initial white spaces and leading zeros
        while((int) s.charAt(j) == 32 || (int) s.charAt(j) == 48 )
        {	
        	j++;
            if (j >= s.length()) return 0;
            else if(s.charAt(j-1) == '0' && s.charAt(j) == ' ' ) return 0;
        	continue;
        }
        
        //Minus
        if (s.charAt(j) == '-' ) 
        {
            isNegative = true;
            if( j != 0 && s.charAt(j-1) == '0') return 0;
            j++;
            
        }
        
        
        //Plus sign
        else if (s.charAt(j) == '+' ) 
        {
            plusSign = true;
            if( j != 0 && s.charAt(j-1) == '0') return 0;
            j++;
        }
        
        for (int i = j; i < s.length(); i++) 
        {
            int ch = s.charAt(i);  
            char c = s.charAt(i);
            
            //Check if there is another sign 
            if (c == '+' || c == '-' && (isNegative || plusSign)) break;   
            	
            //Break if there's a whitespace or period
            else if (ch == 32 || ch == 46) break;
            
            //Letters, Other characters
            else if ( ch > 57 || ch < 48) break; 
            
            //Append numbers
            else
            {
                char a = (char)ch;
                number.append(String.format("%s",a));     
            }
        }
        
        //Check if string builder holds nothing
        if (number.length() == 0) return 0;
        
        int sol  = 0;
        
        //Try to parse String to an integer
        try
        {
        	sol = Integer.parseInt(number.toString());
        }
        catch (NumberFormatException e) 
        {
        	if(isNegative) return Integer.MIN_VALUE;
        	else return Integer.MAX_VALUE;
        }
        
        //Negative case
        if (isNegative) sol = sol * -1;
        
        //Return solution
        return sol;
    }
}