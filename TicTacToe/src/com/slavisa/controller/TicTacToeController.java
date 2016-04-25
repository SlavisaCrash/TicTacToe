package com.slavisa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slavisa.model.TicTacToe;

/**
 * Servlet implementation class TicTacToeController
 */
@WebServlet("/TicTacToeController")
public class TicTacToeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TicTacToe game;
	private int userScore = 0;
	private int cpuScore = 0;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicTacToeController() {
        super();
        game = new TicTacToe();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String key = x+","+y;
		request.setAttribute("board", game.getBoard());
		
		if(game.isValid(key)){
			game.playX(key);
			request.setAttribute("board", game.getBoard());
			if(game.numberOfEmptyCell() > 1){
				game.playO();
				request.setAttribute("board", game.getBoard());
			}
			if(game.numberOfEmptyCell() == 0){
				if(!game.checkWin("X") || !game.checkWin("O")){
					request.setAttribute("buttonEnabled", "yes");
					request.setAttribute("message", "It's Draw");
				}
			}
			if(game.checkWin("X")){
				request.setAttribute("board", game.getBoard());
				request.setAttribute("message", "You  Won!");
				request.setAttribute("buttonEnabled", "yes");
				userScore++;
				
			}else if(game.checkWin("O")){
				request.setAttribute("board", game.getBoard());
				request.setAttribute("message", "Computer  Won!");
				request.setAttribute("buttonEnabled", "yes");
				cpuScore++;
			}
			
		}
		if(request.getParameter("action") != null){
			if(request.getParameter("action").equals("new")){
				game = new TicTacToe();
				request.setAttribute("board", game.getBoard());
			}			
		}
		request.setAttribute("userScore", userScore);
		request.setAttribute("cpuScore", cpuScore);
					
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
