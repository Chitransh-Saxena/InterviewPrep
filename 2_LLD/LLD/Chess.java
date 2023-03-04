package com.DSA.LLD;

import java.util.List;

public class Chess {


    /*
        Requirements
        -> Did not find this game in proper form anywhere, so the requirements are very abstract

        -> Game should support 2 players
            -> Current and Next player
                -> From this we get an idea to use queue data structure
            -> Timer should be implemented when queue moves forward with a new player
            -> Points should be noted somewhere and winner should be declared


        -> Class designs?
            -> ChessBoard class
            -> Player class (2 players)
                -> Do we need abstract class here?
            -> Game class
                -> Has to have the algorithm for the game
            -> We might need to create some account for the users
                -> So, we need to have an account class, which might compose of some Player details


         -> Creational Design Patterns?
            -> Basic inheritence for players
            -> Singleton for board (or we can have just one instance, but in a single application, it is better to have it as singleton for safety)

         -> Structural Design Patterns
            ->

     */

    ChessBoard chessBoard;
    List<Player> players;
    Player currentPlayer;   // CurrentPlayer will be an instance because there are thigns that only current player will do, not the idle player
    List<Move> moveList;    // All the moves that a player made (Just to keep track, nothing fancy here)
    GameStatus gameStatus;  // active, paused, withdrawn, black_win, white_win      // We can have state machines based on this.

    // State is a Behavioural design pattern - Behaviour of the program changes if there is a change in state.

    public boolean playerMove(CellPosition start, CellPosition stop, Piece piece);
    private void changeTurn();


    private class ChessBoard {

        // 2D chessboard
        // APIs to reset the board
        // updateBoard(Move move)       // Will be called by Player, but this API needs to be here because updated board needs to be visible to both players
    }

    private class Move {

        Player turn;
        Piece piece;        // This will be a parent class or an abstract class. In game, we will use real classes for each piece (king, queen, knight etc)
        Piece pieceKilled;  // If there is some piece killed, we update board accordingly and update that player accordingly
        CellPosition start;
        CellPosition end;

        // Can have a moveValidation() API here
    }

    // This is about each cell of the chess board
    private class Cell {


    }
}
