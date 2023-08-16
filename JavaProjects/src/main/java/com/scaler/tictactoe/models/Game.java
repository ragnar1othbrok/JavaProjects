package com.scaler.tictactoe.models;

import com.scaler.tictactoe.exceptions.DuplicateSymbolException;
import com.scaler.tictactoe.exceptions.MoreThanOneBotException;
import com.scaler.tictactoe.exceptions.PlayersCountDimensionMismatchException;
import com.scaler.tictactoe.strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private List<Player> players ;
    private Board board ;
    private List<Move> moves ;
    private Player winner ;
    private GameState gamestate ;
    private int nextMovePlayerIndex ;
    private List<WinningStrategy> winningStrategies ;
    public static Builder getBuilder(){
        return new Builder();
    }

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.nextMovePlayerIndex = 0;
        this.gamestate = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
    }
    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        private Builder(){
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Builder addWinningStrategies(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        private boolean validateBotCounts(){
            int botCount = 0;
            for(Player player: players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount += 1;
                }
                if (botCount > 1) {
                    throw new MoreThanOneBotException();
                }
            }
            return true;
        }
        private boolean validateDimensionsAndPlayerCount() {
            if(players.size() != dimension - 1){
                throw new PlayersCountDimensionMismatchException();
            }
            return true;
        }
        private boolean validate

        private boolean validate(){


                Map<Character, Integer> symbolCounts = new HashMap<>();

                for(Player player: players){
                    if(!symbolCounts.containsKey(player.getSymbol().getaChar())){
                        symbolCounts.put(player.getSymbol().getaChar(), 0);
                    }
                    symbolCounts.put(
                            player.getSymbol().getaChar(),
                            symbolCounts.get(player.getSymbol().getaChar())> + 1
                    );
                    if(symbolCounts.get(player.getSymbol().getaChar()) > 1){
                        throw new DuplicateSymbolException();
                    }
                }
                return true;

        }
        public Game build(){

        }
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }

    public int getNextMovePlyaerIndex() {
        return nextMovePlyaerIndex;
    }

    public void setNextMovePlyaerIndex(int nextMovePlyaerIndex) {
        this.nextMovePlyaerIndex = nextMovePlyaerIndex;
    }

    public List<WinningStrategy> getWinningstrategies() {
        return winningstrategies;
    }

    public void setWinningstrategies(List<WinningStrategy> winningstrategies) {
        this.winningstrategies = winningstrategies;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
