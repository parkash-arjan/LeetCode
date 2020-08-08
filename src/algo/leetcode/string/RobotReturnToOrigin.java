package algo.leetcode.string;

public class RobotReturnToOrigin {

    
    
    
    public boolean judgeCircle(String moves) {
		if(moves == null || moves.length()==0)
				return true;

		int x = 0 ;
		int y = 0;

		for(int i = 0 ; i < moves.length();i++){

			switch(moves.charAt(i) ){
             case 'R':
                    x++;
                    break;
             case 'L':  
                    x--;
                    break;
             case 'U':  
                    y++;
                    break;
             case 'D':
                    y--;
                    break;
            }
        }

		return ( x == 0 && y == 0 );        
    }    
    
    /*
    public boolean judgeCircle(String moves) {
		if(moves == null || moves.length()==0)
				return true;

		int x = 0 ;
		int y = 0;

		for(int i = 0 ; i < moves.length();i++){

			char move = moves.charAt(i);

			if(move == 'R' ||move == 'r')
				x++;
			else if(move == 'L' ||move == 'l')
				x--;
			else if(move == 'U' ||move == 'u')
				y++;
			else if(move == 'D' ||move == 'd')
				y--;
			else
				return false;

		}	

		return ( x == 0 && y == 0 );        
    }
    */
}
