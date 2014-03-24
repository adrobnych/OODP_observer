package com.droidbrew.oodp_webinars.koan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class COUT {
	private static final int HISTORYDEPTH = 25;

	private static class History{
		private static List<String> stack = new ArrayList();

		private static void addLine(String s){
			stack.add(s);
			if(stack.size() > HISTORYDEPTH) stack.remove(0); 
		}

		private synchronized static String getLastLines(int depth){
			StringBuilder sb = new StringBuilder();
			Iterator<String> it;

			if(depth >= stack.size())
				it = stack.iterator();
			else
				it = stack.subList(stack.size() - depth, stack.size()).iterator();

			while(it.hasNext())
			{
				sb.append(it.next() + "\n");
			}

			return sb.toString().trim();   //substring(0, sb.length()-1);
		}
	}

	//private static String last_line;

	public synchronized static void println(String s){
		History.addLine(new String(s));
		System.out.println(s);
	}

	public static String getLastLine(){
		//return last_line;
		return History.getLastLines(1);
	}

	public static String getLastLines(int depth){
		return History.getLastLines(depth);
	}
}