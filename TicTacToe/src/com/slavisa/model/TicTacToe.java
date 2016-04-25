package com.slavisa.model;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TicTacToe {

	private Random random;
	private Map<String, String> board;
	
	public TicTacToe(){
		generateBoard();
	}
	
	public int numberOfEmptyCell(){
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board.get(i+","+j) == "?"){
					count++;
				}
			}
		}
		return count;
	}
		
	public void generateBoard(){
		board = new TreeMap<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board.put((String.valueOf(i)+","+String.valueOf(j)), "?");	
			}
		}
	}
	public void playX(String key){
		if(board.get(key) == "?"){
			board.put(key, "X");
		}
	}
	
	public void playO(){
		random = new Random();
		String key="";
		boolean status = true;
		
		while(status){
			int i = random.nextInt(3);
			int j = random.nextInt(3);
			key = String.valueOf(i)+","+String.valueOf(j);
			if(board.get(key) == "?"){
				board.put(key, "O");
				status = false;
			}				
		}	
	}
	public boolean checkWin(String s){
		
		//check horizontal
		for (int i = 0,j = 0; i < 3; i++) {
			
			if((board.get(i+","+j).equals(s)) && 
					(board.get(i+","+(j+1)).equals(s) &&
							(board.get(i+","+(j+2)).equals(s))) ){
				return true;
			}
		}
		//check vertical
		for (int i = 0,j = 0; i < 3; i++) {
			if((board.get(j+","+i).equals(s)) &&
					(board.get((j+1)+","+(i)).equals(s)) &&
					(board.get((j+2)+","+(i)).equals(s))){
				return true;
			}
		}
		//check major diagonal
		if(board.get(0+","+0).equals(s) &&
				(board.get(1+","+1).equals(s)) &&
				(board.get(2+","+2).equals(s))){
			return true;
		}
		//check sedondary diagonal
		if(board.get(0+","+2).equals(s) &&
				(board.get(1+","+1).equals(s)) &&
				(board.get(2+","+0).equals(s))){
			return true;
		}
		return false;
	}
	//return true if value == ?
	public boolean isValid(String key){
		if(board.get(key) == "?"){
			return true;
		}
		return false;
	}
	public Map<String, String> getBoard(){
		return board;
	}
}
