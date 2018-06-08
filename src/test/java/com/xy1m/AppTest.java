package com.xy1m;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        List<List<Integer>> result = combine(5,2);

        for (List<Integer> list:result){
            for (Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        assertTrue( true );
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if(n<k||k<1){
            return result;
        }
        dfs(n,k,1,0,path,result);
        return result;
    }

    public static void dfs(int n,int k,int start,int cur,List<Integer> path,List<List<Integer>> result){
        if(cur==k){
            result.add(new ArrayList<Integer>(path));
        }
        for(int i=start;i<=n;++i){
            path.add(i);
            dfs(n,k,i+1,cur+1,path,result);
            path.remove(path.size()-1);
        }
    }
}
