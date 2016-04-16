package slottedAloha;

import java.util.ArrayList;
import java.util.Random;

public class Simulator {
	
	private int txIdleTime = 0;
	private int txCollisionTime = 0;
	private int txSuccessTime = 0;	
	
	private double delta = 0;
	private double pvalue = 0;
	private int numStation = 0;
	private int slotThreshold = 0;

	private int totalDelay = 0;	
	private double throughput;
	public double meanDelay;

	private ArrayList<Station> stationList;
	
	public Simulator(double delta, double pvalue, int numStation, int slotThreshold)
	{
		this.delta = delta;
		this.pvalue = pvalue;
		this.numStation = numStation;
		this.slotThreshold = slotThreshold;
		
		stationList = new ArrayList<Station>();
		for(int i = 0; i < numStation; i++) {
			stationList.add(new Station());
		}
	}
		
	public void run() {
		int slotTime;
		int txTrial;
		Station station;
		int txSationNumber = 0;
		Random random = new Random();
		
		for(slotTime = 0; slotTime < slotThreshold ; slotTime++) {
			txTrial = 0;
			txSationNumber = 0;
			
			
			for(int i = 0; i < numStation; i++) {
				station = stationList.get(i);
				
				//when station has no packet to transmit
				//it generates a packet with probability less than 'delta'
				if(!station.getPacketGeneration()) {
					if(random.nextDouble() <= delta) {
						station.setPacketGeneration(true);
						station.setPacketGenerationTime(slotTime);
					}
				}
				
				//when station has a packet to transmit
				//it transmit the packet with probability less than 'pvalue'
				if(station.getPacketGeneration()) {
					if(random.nextDouble() <= pvalue) {
						txTrial++;
						txSationNumber = i;
					}
				}
			}

			
			//when the number of stations trying to transmit a packet is more than 1,
			//the collision occurs, and all the station should do retransmission.
			
			if(txTrial == 0) { //idle 
				txIdleTime++;
			}
			else if(txTrial > 1) { //collision
				txCollisionTime++;
			}
			else { //transmission success
				txSuccessTime++;
				station = stationList.get(txSationNumber);
				station.setPacketGeneration(false);
				station.updateNumTxPacket();
				station.updatePacketDelay(slotTime);
			}	
		}
		
		for(int i = 0; i < numStation; i++)
		{
			station = stationList.get(i);
			totalDelay += station.getPacketDelay();
		}

		meanDelay = (double) totalDelay/txSuccessTime;
		throughput = (double) txSuccessTime/slotThreshold;
	}
	
	
	public void showResult() {
		Station station;
		
		System.out.println("	total dealy	tx packet");
		for(int i = 0; i < numStation; i++)
		{
			station = stationList.get(i);
			System.out.println("["+i+"]	"+station.getPacketDelay()+"		"+station.getnumTxPacket());
		}
		
		System.out.println("\nsimulating duration	: "+(txIdleTime+txCollisionTime+txSuccessTime));
		
		System.out.println("\ntotal idle time	: "+txIdleTime);
		System.out.println("total collision time	: "+txCollisionTime);
		System.out.println("total tx success time	: "+txSuccessTime);
		
		//mean delay of any packet
		System.out.println("\nmean delay of a packet	: "+meanDelay);
		
		//throughput
		System.out.println("throughput		: "+throughput);
	}
	
	public double getMeanDelay() {
		return meanDelay;
	}
	
	public double getThroughput() {
		return throughput;
	}
}
