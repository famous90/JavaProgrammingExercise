package slottedAloha;

import java.util.*;

public class SlottedAloha {
	
	static double delta = 0;
	static double pvalue = 0;
	static int numStation = 0;
	static int slotThreshold = 0;
	
	public static void main(String[] args) {
		
		String message;
		boolean inputCheck = true;
		
		//Set System Parameter
		while(inputCheck)
		{
			System.out.println("Delta(<=1.0)  Pvalue(<=1.0)  NumberOfStation(>=1)  SlotThreshold(>=1)");
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("kk");

			message = scan.nextLine();
			System.out.println("kk");

			StringTokenizer st = new StringTokenizer(message, " ");
			System.out.println("kk");

			try
			{
				if(st.hasMoreTokens())
				{
					delta = Double.parseDouble(st.nextToken());
					if(st.hasMoreTokens() && delta <= 1.0 && delta >= 0.001)
					{
						pvalue = Double.parseDouble(st.nextToken());
						if(st.hasMoreTokens() && pvalue <= 1.0 && pvalue >= 0.001)
						{
							numStation = Integer.parseInt(st.nextToken());
							if(st.hasMoreTokens() && numStation >= 1)
							{
								slotThreshold = Integer.parseInt(st.nextToken());
								if(slotThreshold >= 1)
								{
									inputCheck = false;
								}
							}
						}
					}
				}
			}
			catch(Exception e){
				System.out.println("kk");

			}
		}
	
		//generate station list
		

		//run simulator for slotted ALOHA
		Simulator simulator = new Simulator(delta, pvalue, numStation, slotThreshold);
		simulator.run();
		simulator.showResult();
		
		
		//draw graph
		int xAxis = 0;
		inputCheck = true;
		while(inputCheck)
		{
			System.out.println("\nx-axis : delta(1), pvalue(2), numStation(3), slotThreshold(4)");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			message = scan.nextLine();
			try
			{
				xAxis = Integer.parseInt(message);
				if(xAxis <= 4 && xAxis >= 1)
				{
					inputCheck = false;
				}
			}
			catch(Exception e){
			}
		}

		graph(xAxis);
	}
	

	public static void graph(int xAxis)
	{
		int maxTrial = 22;
		int arraySize = 0;
		double[][] meanDelayList = null;
		double[][] throughputList = null;
		double unit = 0.0;
		switch(xAxis)
		{
			case 1 : //delta
				arraySize = (int)(delta*1000.0);
				meanDelayList = new double[maxTrial][arraySize];
				throughputList = new double[maxTrial][arraySize];
				for (int trial = 0; trial < maxTrial ; trial++) {
					unit = 0.0;
					for (int i = 0; i < arraySize ; i += 1) {
						unit += 0.001;
						Simulator simulator_t = new Simulator(unit, pvalue, numStation, slotThreshold);
						simulator_t.run();
						meanDelayList[trial][i] = simulator_t.getMeanDelay();
						throughputList[trial][i] = simulator_t.getThroughput();
					}
				}
				break;
		
			case 2 : //pvalue
				arraySize = (int)(pvalue*1000.0);
				meanDelayList = new double[maxTrial][arraySize];
				throughputList = new double[maxTrial][arraySize];
				for (int trial = 0; trial < maxTrial ; trial++) {
					unit = 0.0;
					for (int i = 0; i < arraySize ; i += 1) {
						unit += 0.001;
						Simulator simulator_t = new Simulator(delta, unit, numStation, slotThreshold);
						simulator_t.run();
						meanDelayList[trial][i] = simulator_t.getMeanDelay();
						throughputList[trial][i] = simulator_t.getThroughput();
					}
				}
				break;
		
			case 3 : //numStation
				arraySize = numStation;
				meanDelayList = new double[maxTrial][arraySize];
				throughputList = new double[maxTrial][arraySize];
				for (int trial = 0; trial < maxTrial ; trial++) {
					for (int i = 1; i <= numStation; i += 1) {
						Simulator simulator_t = new Simulator(delta, pvalue, i, slotThreshold);
						simulator_t.run();
						
						meanDelayList[trial][i-1] = simulator_t.getMeanDelay();
						throughputList[trial][i-1] = simulator_t.getThroughput();
					}
				}
				break;
		
			case 4 : //slotThreshold
				arraySize = slotThreshold;
				meanDelayList = new double[maxTrial][arraySize];
				throughputList = new double[maxTrial][arraySize];
				for (int trial = 0; trial < maxTrial ; trial++) {
					for (int i = 1; i <= slotThreshold; i += 1) {
						Simulator simulator_t = new Simulator(delta, pvalue, numStation, i);
						simulator_t.run();
						
						meanDelayList[trial][i-1] = simulator_t.getMeanDelay();
						throughputList[trial][i-1] = simulator_t.getThroughput();
					}
				}
				break;
		}

		double[] convolutedDelay = new double[arraySize];
		double[] convolutedThroughput = new double[arraySize];

		System.out.println("\nMean Delay");
		System.out.println("x	y");
		System.out.println("--------------------------------");
		for(int i = 0; i < arraySize; i++)
		{		
			convolutedDelay[i] = 0;
			for(int trial = 0; trial < maxTrial; trial++)
			{
				convolutedDelay[i] += meanDelayList[trial][i];
			}
	
			
			System.out.println(i+"	"+convolutedDelay[i]/maxTrial);
		}
		
		System.out.println("\nThroughput");
		System.out.println("x	y");
		System.out.println("--------------------------------");
		for(int i = 0; i < arraySize; i++)
		{		
			convolutedDelay[i] = 0;
			for(int trial = 0; trial < maxTrial; trial++)
			{
				convolutedThroughput[i] += throughputList[trial][i];
			}
	
			System.out.println(i+"	"+convolutedThroughput[i]/maxTrial);
		}
	}
}