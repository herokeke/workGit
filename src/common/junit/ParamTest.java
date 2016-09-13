package common.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParamTest {
	
    int expected=0;
    int input1 = 0;
    int input2 = 0;
    
    @Parameters
    public static Collection<Object[]> t(){
    	return Arrays.asList(new Object[][]{{3,6,2},{5,10,2}});
    }
    public ParamTest(int expected,int input1,int input2){
    	this.expected = expected;
    	this.input1 = input1;
    	this.input2 = input2;
    }
    @Test
    public void testfun(){
    	assertEquals(expected,new BasicClass().divide(input1,input2)); 
    }
    
}
